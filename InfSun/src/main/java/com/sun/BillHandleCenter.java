/**
 * 
 */
package com.sun;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
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
import com.sun.httpserver.HttpServerHandler;
import com.sun.msg.BillQueryMessageRequest;
import com.sun.msg.BillQueryMessageResponse;
import com.sun.msg.BillSyncMessageRequest;
import com.sun.msg.BillSyncMessageResponse;
import com.sun.msg.OuterBillPayMessageRequest;
import com.sun.msg.OuterBillPayMessageResponse;
import com.sun.msg.request.BillPayQyeryRequest;
import com.sun.msg.request.BillPayRequest;
import com.sun.msg.request.BillSyncRequest;
import com.sun.msg.request.Item;
import com.sun.util.DateUtil;
import com.sun.util.SqlUtil;

import io.netty.channel.ChannelHandlerContext;

/**
@Create By  sunning  Time: 2018年7月1日上午10:40:02
   Inc. All rights reserved.

**/
/**
 * 票据业务处理中心,所有的逻辑业务都在这里处理,其他地方都不用动了
 * 
 * @author sunning
 *
 */
public class BillHandleCenter {

	/**
	 * 打印日志使用
	 */
	private static final Logger logger =LoggerFactory.getLogger(BillHandleCenter.class);
	private static final BillHandleCenter instance = new BillHandleCenter();

	private BillHandleCenter() {

		
	}

	public static BillHandleCenter getInstance() {
		return new BillHandleCenter();
	}

	/**
	 * 这里处理具体来自支付平台的业务
	 * 
	 * @param obj  消息对象
	 * @param Clazz 消息对象对应的Class
	 * @param ctx
	 */
	public static void handle(Object obj, Class clazz, ChannelHandlerContext ctx) {

		/**
		 * 是否回复支付平台消息,默认不回复
		 */
		boolean replyFlag = false;
		/**
		 * 回复给支付平台的消息对象
		 */
		Object replayMessage = null;
		/**
		 * 来自支付平台请求消息,票据查询请求消息
		 */
		if (clazz.equals(BillQueryMessageRequest.class)) {
			BillQueryMessageRequest request = (BillQueryMessageRequest) obj;
			replayMessage = handleBillQueryMessageRequest(request);
			replyFlag = true;
		}
		/**
		 * 来自支付平台请求消息,票据缴费请求消息
		 */
		if (clazz.equals(OuterBillPayMessageRequest.class)) {
			OuterBillPayMessageRequest request = (OuterBillPayMessageRequest) obj;
			replayMessage = handleOuterBillPayMessageRequest(request);
			replyFlag = true;
		}
		
		// 有响应消息时,回复支付平台
		if (replyFlag && replayMessage != null) {
			HttpServerHandler.writeAndClose(ctx, replayMessage);
		} else {
			// 如果没有消息直接关闭
			ctx.close();
		}
	}

   
	
		
	/**
	 * 处理票据缴费接口
	 * @param request
	 * @return
	 */
	private static Object handleOuterBillPayMessageRequest(OuterBillPayMessageRequest request) {
		// TODO 处理业务
		BillPayRequest biz_content = request.getBiz_content();
		
		//票据号
		String billno = biz_content.getBillno();
		SqlSession sqlSession = SqlUtil.getInstance().getSqlSession();
		try {
			
			//根据票据号查询
			Fs_kphzMapper kpViewMapper = sqlSession.getMapper(Fs_kphzMapper.class);
			Fs_kphzExample example =new Fs_kphzExample();
			example.createCriteria().andPjhEqualTo(billno);
			List<Fs_kphz> billList = kpViewMapper.selectByExample(example );
			
			
			//获取到票据
			Fs_kphz  kphz =null;
			if(billList!=null && billList.size()>0) {
				kphz =billList.get(0);
			}
			
			//创建返回消息
			OuterBillPayMessageResponse response = new OuterBillPayMessageResponse();
			
			if(kphz ==null) {
				//票据查询不到,则告之对方
				response.setCode(ResponseCode.fail);
				response.setMsg(ResponseCode.fail_default_msg);
				response.setMsg("票据号未查询到:"+billno);
				
				return response;
			}
			
			//修改票据状态 已缴费
			kphz.setPjzt(ConfigUtil.paid); 
			kpViewMapper.updateByExampleSelective(kphz, example);
			
			//查询到票据,成功响应
			response.setCode(ResponseCode.Success);
			response.setMsg(ResponseCode.Success_default_msg);
			
//			String postBody =JSONObject.toJSONString(response);
			return response;
			
		}catch (Exception e) {
			logger.debug("handleOuterBillPayMessageRequest  exception:{}",e);
		}finally {
			if( sqlSession!=null) {
				sqlSession.close();
			}
		}
//		//返回对象
		
		OuterBillPayMessageResponse response =  new OuterBillPayMessageResponse();
		response.setCode(ResponseCode.fail);
		response.setMsg(ResponseCode.fail_default_msg);
		return response;
	}

	 
	/**
	 * 
	  *  处理 票据查询
	 * @param request
	 * @return
	 */
	private static Object handleBillQueryMessageRequest(BillQueryMessageRequest request) {
		//根据票据号,查询到票据
		BillPayQyeryRequest billPayRequest = request.getBiz_content();
		
	    //票据号
		String billno = billPayRequest.getBillno();
		
		SqlSession session = SqlUtil.getInstance().getSqlSession();
		try {
			
			//根据票据号查询
			Fs_kphzMapper kpViewMapper = session.getMapper(Fs_kphzMapper.class);
			Fs_kphzExample example =new Fs_kphzExample();
			example.createCriteria().andPjhEqualTo(billno);
			List<Fs_kphz> billList = kpViewMapper.selectByExample(example );
			
			
			//获取到票据
			Fs_kphz  kphz =null;
			if(billList!=null &&billList.size()>0) {
				kphz =billList.get(0);
			}
			
			//创建返回消息
			BillQueryMessageResponse reponse =new BillQueryMessageResponse();
			reponse.setCode(ResponseCode.fail);
			reponse.setMsg(ResponseCode.fail_default_msg);
			if(kphz ==null) {
				//票据查询不到,则告之对方
				reponse.setMsg("票据号未查询到:"+billno);
				return reponse;
			}
			
			
			//票据可以查询到,返回消息
			//行政划分
			String zone_code =ConfigUtil.getZoneCode();
			reponse.setZone_code(zone_code);
			//票据号
			reponse.setBillno(kphz.getPjh());
			//票据日期  TODO 
			String billdate = DateUtil.dateToStirng(kphz.getPjrq());
			reponse.setBilldate(billdate);
			
			//金额  TODO
			BigDecimal total = new BigDecimal("0") ;
			for (Fs_kphz fs: billList) {
				 BigDecimal je = fs.getJe().setScale(2,BigDecimal.ROUND_HALF_UP);
				 total = total.add(je);
			}
			//缴款金额
			reponse.setPay_amount(total.toString());
			//缴款书金额
			reponse.setTotal_amount(total.toString());
			reponse.setDelay_amount(ConfigUtil.delay_amount);
			reponse.setBillstats(kphz.getPjzt());
			reponse.setChg_code(kphz.getDwdm());
			
			//根据单位代码查询名称
			Fs_dwzbMapper fs_dwzbMapper = session.getMapper(Fs_dwzbMapper.class);
			Fs_dwzbExample fs_dwzbExample = new Fs_dwzbExample();
			fs_dwzbExample.createCriteria().andDwdmEqualTo(kphz.getDwdm());
			List<Fs_dwzb> dwzbList = fs_dwzbMapper.selectByExample(fs_dwzbExample);
			
			Fs_dwzb fs_dwzb = null ;
			if(dwzbList!=null && dwzbList.size()>0) {
				fs_dwzb =dwzbList.get(0);
			}
			reponse.setChg_name(fs_dwzb.getDwmc());
			 //交款人名称
			reponse.setPayer_name(kphz.getWldwkh());
			//收款人账户类型
			reponse.setRec_acctype(kphz.getDefStr5());  //需商量
			
			//收款人联行号
			reponse.setRec_bkcode(kphz.getWldwzh());
			//固定格式 01
			reponse.setPaylistfmt(ConfigUtil.paylistfmt); 
			
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
			
			reponse.setPlaylist(itemList);
			//查询到票据,成功响应
			reponse.setCode(ResponseCode.Success);
			reponse.setMsg(ResponseCode.Success_default_msg);
			return reponse;
			
		} catch (Exception e) {
			logger.debug("handleBillQueryMessageRequest  exception:{}",e);
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		//创建返回消息
		BillQueryMessageResponse reponse =new BillQueryMessageResponse();
		reponse.setCode(ResponseCode.fail);
		reponse.setMsg(ResponseCode.fail_default_msg);
		return reponse;
	}


   /****************************************以下是请求接口**********************************************/
	
	/**
	 *   执行票据同步  感觉不准确???????????????????????????????????????????????????????
	 * @param pj  
	 */
	public  void  excuteBillSync(List<Fs_kphz> billList) {
		
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
		biz_content.setBillstats(kphz.getPjzt());
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
					 logger.debug("=================================表名======={}",table_name);
					
					 UpdateBean bean = new UpdateBean();
					 bean.setTable_name(table_name);
					 bean.setJkrq(new Date());
					 bean.setPjh(kphz.getPjh());
					 bean.setPjzt(ConfigUtil.paid);
					 
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
