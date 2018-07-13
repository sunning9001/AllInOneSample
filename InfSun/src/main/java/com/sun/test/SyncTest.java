package com.sun.test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.sun.BillHandleCenter;
import com.sun.bean.UpdateBean;
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

public class SyncTest {


	/**
	 * 打印日志使用
	 */
	private static final Logger logger =LoggerFactory.getLogger(BillHandleCenter.class);
	
	public static void main(String[] args) {
		
		SqlSession sqlSession9 = SqlUtil.getInstance().getSqlSession();
		
		Fs_kphzMapper mapper9 = sqlSession9.getMapper(Fs_kphzMapper.class);
		Fs_kphzExample ex9 = new Fs_kphzExample() ;
		ex9.createCriteria().andPjhEqualTo("00707375");
		List<Fs_kphz> billList = mapper9.selectByExample(ex9);
		
		//创建票据同步请求
				BillSyncMessageRequest request =new BillSyncMessageRequest();
				//行政划分
				request.setZone_code(ConfigUtil.getZoneCode());
				//方法名称
				request.setMethod(InfConstants.BillSync);
				//TODO 
				String timestamp = DateUtil.dateToStirngTime(new Date());
				request.setTimestamp(timestamp);
				request.setVersion(ConfigUtil.version);
				
				BillSyncRequest biz_content =new BillSyncRequest();
				
				
				Fs_kphz kphz = null ;
				if (billList != null && billList.size() >0 ) {
					kphz = billList.get(0);
				}
				
				//票据号
				biz_content.setBillno(kphz.getPjh());
				
				//票据日期
				String billdate = DateUtil.dateToStirng(kphz.getPjrq());
				biz_content.setBilldate(billdate);
				
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
				biz_content.setBillstats(kphz.getPjzt());//有问题
				biz_content.setChg_code(kphz.getDwdm());
				
				//根据单位代码查询名称
				SqlSession session = SqlUtil.getInstance().getSqlSession();
				Fs_dwzbMapper fs_dwzbMapper = session.getMapper(Fs_dwzbMapper.class);
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
				List<Item> itemList =new ArrayList();
				Fs_sfxmMapper fs_sfxmMapper = session.getMapper(Fs_sfxmMapper.class);
				
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
				
				//添加请求参数集合
				request.setBiz_content(biz_content); 
				
				//向公共支付平台请求消息
				//转换成JSON String
				String postBody =JSONObject.toJSONString(request);
				BillSyncMessageResponse response = (BillSyncMessageResponse) HttpUtil.getInstance().httpExecute(postBody , ConfigUtil.getUrl(), BillSyncMessageResponse.class);
				logger.debug("================================response======={}",response);
				if(response!=null) {
					//判断响应码
					String code = response.getCode();
					if(code!=null && code.equals(ResponseCode.Success)) {
						//同步成功，更新数据库
						SqlSession sqlSession =null;
						try {
							 sqlSession = SqlUtil.getInstance().getSqlSession();
							 
							 UtilMapper utilMapper = sqlSession.getMapper(UtilMapper.class);
							 String yuefen = utilMapper.selectMonth(kphz.getPjh());
							 
							 logger.debug("=================================yuefen======={}",yuefen);
							 String table_name = "fs_kp"+yuefen ;
							 logger.debug("=================================yuefen======={}",table_name);
							
							 UpdateBean bean = new UpdateBean();
							 bean.setTable_name(table_name);
							 bean.setJkrq(new Date());
							 bean.setPjh(kphz.getPjh());
							 bean.setPjzt(ConfigUtil.cancel);
							 
							 utilMapper.updateJkztAndJkrq(bean);
							 sqlSession.commit();
							 
						} catch (Exception e) {
							// TODO: handle exception
							logger.debug("excuteBillSync  exception:{}",e);
						}
						finally {
						   if(sqlSession!=null ) {
							   sqlSession.close();
						   }
						}
						
					}
				}
		
		
	}
}
