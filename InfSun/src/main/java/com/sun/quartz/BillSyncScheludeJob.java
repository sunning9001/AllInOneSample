package com.sun.quartz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.sun.BillHandleCenter;
import com.sun.bean.UtilMapper;
import com.sun.config.ConfigUtil;
import com.sun.config.HttpUtil;
import com.sun.config.InfConstants;
import com.sun.config.ResponseCode;
import com.sun.entity.autodao.Fs_dwzbMapper;
import com.sun.entity.autodao.Fs_kphzMapper;
import com.sun.entity.autodao.Fs_sfxmMapper;
import com.sun.entity.automodel.Fs_dwzb;
import com.sun.entity.automodel.Fs_dwzbExample;
import com.sun.entity.automodel.Fs_kphz;
import com.sun.entity.automodel.Fs_kphzExample;
import com.sun.entity.automodel.Fs_sfxm;
import com.sun.entity.automodel.Fs_sfxmExample;
import com.sun.msg.BillSyncMessageRequest;
import com.sun.msg.BillSyncMessageResponse;
import com.sun.msg.request.BillSyncRequest;
import com.sun.msg.request.Item;
import com.sun.util.DateUtil;
import com.sun.util.SqlUtil;

public class BillSyncScheludeJob implements Job {

	/**
	 * 打印日志使用
	 */
	private static final Logger logger =LoggerFactory.getLogger(BillSyncScheludeJob.class);
	
	/**
	 *  票据同步
	 */
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		//查询 触发器的保存的缓存 表中
		SqlSession sqlSession = SqlUtil.getInstance().getSqlSession();
		
		try {
			UtilMapper utilMapper = sqlSession.getMapper(UtilMapper.class);
			List<String> pjhList = utilMapper.selectPjh();
			
			if(pjhList != null && pjhList.size() >0) {
				for(int i =0 ;i<pjhList.size() ;i++) {
					
					//创建票据同步请求
					BillSyncMessageRequest request =new BillSyncMessageRequest();
					//行政划分
					request.setZone_code(ConfigUtil.getZoneCode());
					//方法名称
					request.setMethod(InfConstants.BillSync);
					String timestamp = DateUtil.dateToStirngTime(new Date());
					request.setTimestamp(timestamp);
					request.setVersion(ConfigUtil.version);
					BillSyncRequest biz_content =new BillSyncRequest();
					
					String pjh = pjhList.get(i);
					Fs_kphzExample kphzExample = new Fs_kphzExample() ;
					kphzExample.createCriteria().andPjhEqualTo(pjh);
					Fs_kphzMapper kphzMapper = sqlSession.getMapper(Fs_kphzMapper.class);
					List<Fs_kphz> billList = kphzMapper.selectByExample(kphzExample);
					
					Fs_kphz kphz = null ;
					if (billList != null && billList.size() >0 ) {
						kphz = billList.get(0);
					}
					
					//票据号
					biz_content.setBillno(kphz.getPjh());
					
					if (kphz != null) {
						//票据日期
						String billdate = DateUtil.dateToStirng(kphz.getPjrq());
						biz_content.setBilldate(billdate);
					}
					
					BigDecimal total = new BigDecimal("0") ;
					for (Fs_kphz fs: billList) {
						 BigDecimal je = fs.getJe().setScale(2,BigDecimal.ROUND_HALF_UP);
						 total = total.add(je);
					}
					//缴款金额
					biz_content.setPay_amount(total.toString());
					//缴款书金额
					biz_content.setTotal_amount(total.toString());
					biz_content.setDelay_amount(ConfigUtil.delay_amount);
					
					//票据状态
					biz_content.setBillstats(kphz.getPjzt());
					biz_content.setChg_code(kphz.getDwdm());
					
					//根据单位代码获取单位名称
					Fs_dwzbMapper fs_dwzbMapper = sqlSession.getMapper(Fs_dwzbMapper.class);
					Fs_dwzbExample fs_dwzbExample = new Fs_dwzbExample();
					fs_dwzbExample.createCriteria().andDwdmEqualTo(kphz.getDwdm());
					List<Fs_dwzb> dwzbList = fs_dwzbMapper.selectByExample(fs_dwzbExample);
					Fs_dwzb fs_dwzb = null ;
					if(dwzbList!=null && dwzbList.size()>0) {
						fs_dwzb =dwzbList.get(0);
					}
					biz_content.setChg_name(fs_dwzb.getDwmc());
					
					 //交款人名称
					biz_content.setPayer_name(kphz.getWldwkh());
					//收款人账户类型
					biz_content.setRec_acctype(kphz.getDefStr5());  //需商量
					
					//收款人联行号
					biz_content.setRec_bkcode(kphz.getWldwzh());
					biz_content.setPaylistfmt(ConfigUtil.paylistfmt); 
					
					//缴款书内容
					List<Item> itemList =new ArrayList<Item>();
					Fs_sfxmMapper fs_sfxmMapper = sqlSession.getMapper(Fs_sfxmMapper.class);
					
					for(Fs_kphz hz  :billList) {
						String xmdm = hz.getXmdm();
						Fs_sfxmExample fs_sfxmExample = new Fs_sfxmExample();
						fs_sfxmExample.createCriteria().andDmEqualTo(xmdm);
						List<Fs_sfxm> sfxmList = fs_sfxmMapper.selectByExample(fs_sfxmExample);
						Fs_sfxm  sfxm =null;
						
						if(sfxmList!=null &&sfxmList.size()>0) {
							sfxm =sfxmList.get(0);
						}
						Item item =new Item();
						item.setItem_code(sfxm.getDm());
						item.setItem_name(sfxm.getMc());
						item.setItem_amount(hz.getJe().toString());
						item.setUnit(ConfigUtil.unit);                          // 个
						item.setNum(hz.getSl().toString());
						item.setStdtype(ConfigUtil.stdtype);                    //无限制
						item.setStandard(ConfigUtil.standard);          //
						itemList.add(item );
					}
					
					biz_content.setPlaylist(itemList);
					
					request.setBiz_content(biz_content); 
					
					
					//请求参数转换成 String 
					String postBody =JSONObject.toJSONString(request);
					BillSyncMessageResponse response = (BillSyncMessageResponse) HttpUtil.getInstance().httpExecute(postBody , ConfigUtil.getUrl(), BillSyncMessageResponse.class);
					
					//如果 同步成功
					if(response.getCode().equals(ResponseCode.Success)) {
						for(int k =0 ;k< billList.size() ;k++) {
							Fs_kphz fs_kphz = billList.get(k);
							UtilMapper utilMapper2 = sqlSession.getMapper(UtilMapper.class);
							//票据同步表 记录已同步信息
							utilMapper2.insertSync(fs_kphz);
							//缓存 fs_xzpj 表 删除此票据号
							
							sqlSession.commit();
						}
						UtilMapper utilMapper3 = sqlSession.getMapper(UtilMapper.class);
						utilMapper3.deleteByPjh(pjh);
						sqlSession.commit();
					}
				}
			}
		}catch(Exception e) {
			logger.debug("handleBillQueryMessageRequest  exception:{}",e);
			sqlSession.rollback();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		    
	}

}
