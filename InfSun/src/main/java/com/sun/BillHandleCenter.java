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
import com.sun.msg.BillPayMessageRequest;
import com.sun.msg.BillPayMessageResponse;
import com.sun.msg.BillQueryMessageRequest;
import com.sun.msg.BillQueryMessageResponse;
import com.sun.msg.BillSyncMessageRequest;
import com.sun.msg.BillSyncMessageResponse;
import com.sun.msg.BillfundResultsMessageRequest;
import com.sun.msg.BillfundResultsMessageResponse;
import com.sun.msg.FundConfirmMessageRequest;
import com.sun.msg.FundConfirmMessageResponse;
import com.sun.msg.request.BillDetails;
import com.sun.msg.request.BillPayQyeryRequest;
import com.sun.msg.request.BillPayRequest;
import com.sun.msg.request.BillSyncRequest;
import com.sun.msg.request.FailDetails;
import com.sun.msg.request.FundConfirmRequest;
import com.sun.msg.request.FundResultsRequest;
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
		if (clazz.equals(BillPayMessageRequest.class)) {
			BillPayMessageRequest request = (BillPayMessageRequest) obj;
			replayMessage = handleBillPayMessageRequest(request);
			replyFlag = true;
		}
		
		/**
		 * 来自支付平台请求消息,票据对账请求消息
		 */
		if (clazz.equals(FundConfirmMessageRequest.class)) {
			FundConfirmMessageRequest request = (FundConfirmMessageRequest) obj;
			replayMessage = handlefundConfirmMessageRequest(request);
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
	 *    票据对账      支付平台 --->  非税系统
	 * @param resuest
	 * @return
	 */
   public static Object handlefundConfirmMessageRequest(FundConfirmMessageRequest resuest) {
	   
	   FundConfirmRequest biz_content = resuest.getBiz_content();
	   //获取总笔数
	   Integer count = biz_content.getCount();
	   //获取到账明细
	   List<BillDetails> translist = biz_content.getTranslist();
	   
	   //创建返回消息
	   FundConfirmMessageResponse response = new FundConfirmMessageResponse();
	   //所有票据 金额 对账不准确的信息
	   String code =ResponseCode.Success ;
	   String msg = "" ; 
	   SqlSession sqlSession = SqlUtil.getInstance().getSqlSession();
	   if(translist != null && translist.size() >0 ) {
		   for(int i=0 ;i<translist.size() ;i++) {
			   BillDetails billDetails = translist.get(i);
			   
			   //请求数据中 票据金额
			   String amount = billDetails.getAmount(); 
			   
			   String billno = billDetails.getBillno() ;
			   Fs_kphzMapper fs_kphzMapper = sqlSession.getMapper(Fs_kphzMapper.class);
			   Fs_kphzExample example = new Fs_kphzExample();
			   example.createCriteria().andPjhEqualTo(billno);
			   //根据票据号 查询票据
			   List<Fs_kphz> billList = fs_kphzMapper.selectByExample(example);
			   
			    //获取到票据
				Fs_kphz  kphz =null;
				if(billList != null && billList.size()>0) {
					kphz =billList.get(0);
				}
				
				if(kphz ==null) {
					//票据查询不到,则告之对方
					code = ResponseCode.fail ;
					if(msg == "") {
						msg += "票据号"+billno+"未查询到" ;
					}else {
						msg += ";票据号"+billno+"未查询到" ;
					}
					
				}
				
				//数据库中 金额总数
				BigDecimal total = new BigDecimal("0") ;
				for (Fs_kphz fs: billList) {
					 BigDecimal je = fs.getJe().setScale(2,BigDecimal.ROUND_HALF_UP);
					 total = total.add(je);
				}
				BigDecimal actualMoney = new BigDecimal(amount) ;
				String sqltotal = total.toString();
				
				//请求参数中的金额 与 数据库中的金额 不相符 则不满足
				if( ! sqltotal.equals(amount) ) {
					code = ResponseCode.fail ;
					if(msg == "") {
						msg += "票据号"+billno +" 金额不相符";
					}else {
						msg += ";票据号"+billno +" 金额不相符";
					}
				}
			   
		   }
	   }
	   response.setCode(code);
	   if(code == ResponseCode.fail) {
		   response.setMsg(msg);
	   }else {
		   response.setMsg(ResponseCode.Success_default_msg);
	   }
	   return response ;
	   
   }
	
		
	/**
	 *  处理票据缴费      支付平台 --->  非税系统
	 * @param request
	 * @return
	 */
	private static Object handleBillPayMessageRequest(BillPayMessageRequest request) {
		
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
			BillPayMessageResponse response = new BillPayMessageResponse();
			
			if(kphz ==null) {
				//票据查询不到,则告之对方
				response.setCode(ResponseCode.fail);
				response.setMsg(ResponseCode.fail_default_msg);
				response.setMsg("票据号未查询到:"+billno);
				
				return response;
			}
			
			//查询票据月份
			UtilMapper utilMapper = sqlSession.getMapper(UtilMapper.class);
			String yuefen = utilMapper.selectMonth(kphz.getPjh());
			UpdateBean bean = new UpdateBean();
			String datetime = biz_content.getPay_datetime();
			
			bean.setJkrq(DateUtil.stringToDate(datetime)); //缴款日期
			bean.setPjh(kphz.getPjh());
			bean.setPjzt(ConfigUtil.paid);
			bean.setTable_name("fs_kp"+yuefen);
			
			//修改票据状态 已缴费 缴费时间
			utilMapper.updateJkztAndJkrq(bean);
			sqlSession.commit();
			
			//查询到票据,成功响应
			response.setCode(ResponseCode.Success);
			response.setMsg(ResponseCode.Success_default_msg);
			
			return response;
			
		}catch (Exception e) {
			logger.debug("handleOuterBillPayMessageRequest  exception:{}",e);
		}finally {
			if( sqlSession!=null) {
				sqlSession.close();
			}
		}
		
		//返回对象
		BillPayMessageResponse response =  new BillPayMessageResponse();
		response.setCode(ResponseCode.fail);
		response.setMsg(ResponseCode.fail_default_msg);
		return response;
	}

	 
	/**
	 * 
	  *  处理 票据查询     支付平台 --->  非税系统
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
			//票据日期
			String billdate = DateUtil.dateToStirng(kphz.getPjrq());
			reponse.setBilldate(billdate);
			
			//金额
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
	 *   执行票据同步    非税系统 --->支付平台
	 *         感觉不准确???????????????????????????????????????????????????????
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
	
	/**
	 *    资金对账结果    非税系统 --->支付平台
	 *        
	 * @param fundConfirmMessageRequest 资金对账请求参数
	 */
	
	public  void  excuteFundConfirmResult(FundConfirmMessageRequest fundConfirmMessageRequest) {
		
		FundResultsRequest biz_content = new FundResultsRequest() ;
		
		//对账请求参数
		FundConfirmRequest fundConfirmRequest = fundConfirmMessageRequest.getBiz_content();
	    //获取总笔数
	    Integer count = fundConfirmRequest.getCount();
	    
		//获取到账明细
		List<BillDetails> translist = fundConfirmRequest.getTranslist();
		SqlSession sqlSession = SqlUtil.getInstance().getSqlSession();
		   
		
		
		//成功笔数
		int succeedcount = 0;
		int failcount = 0 ;
		List<FailDetails> faillist = new ArrayList<FailDetails>();
		if(translist != null && translist.size() >0 ) {
			
			for(int i=0 ;i<translist.size() ;i++) {
				 BillDetails billDetails = translist.get(i);
				   
				   //请求数据中 票据金额
				   String amount = billDetails.getAmount(); 
				   
				   String billno = billDetails.getBillno() ;
				   Fs_kphzMapper fs_kphzMapper = sqlSession.getMapper(Fs_kphzMapper.class);
				   Fs_kphzExample example = new Fs_kphzExample();
				   example.createCriteria().andPjhEqualTo(billno);
				   
				   //根据票据号 查询票据
				   List<Fs_kphz> billList = fs_kphzMapper.selectByExample(example);
				   //此票据对账是否准确，默认准确
				   Boolean isSuccess = true ;
				   
				   //获取到票据
					Fs_kphz  kphz =null;
					if(billList != null && billList.size()>0) {
						kphz =billList.get(0);
					}
					
					//交易流水号
					String trade_no = kphz.getId1() ;
					String code ="" ;
					String msg = "" ; 
					if(kphz == null) {
						//票据查询不到,则告之对方
						isSuccess = false ;
						failcount ++ ;
						//错误码  1101
					    code = ResponseCode.transaction01; 
						msg = ResponseCode.getCodeDesc(code);
					}
					
					//数据库中 金额总数
					BigDecimal total = new BigDecimal("0") ;
					for (Fs_kphz fs: billList) {
						 BigDecimal je = fs.getJe().setScale(2,BigDecimal.ROUND_HALF_UP);
						 total = total.add(je);
					}
					String sqltotal = total.toString();
					
					//请求参数中的金额 != 金额 则不满足
					if( ! sqltotal.equals( amount) ) {
						isSuccess = false ;
						failcount ++ ;
						//收款金额 与财政金额不一致 
						code = ResponseCode.transaction10;
						msg = ResponseCode.getCodeDesc(code);
					}
					
					if( isSuccess) {
						succeedcount ++ ;
					}else {
						FailDetails failDetails = new FailDetails();
						failDetails.setTrade_no(trade_no);
						failDetails.setCode(code);
						failDetails.setMsg(msg);
						faillist.add(failDetails);
					}
				   
			   }
		   }
		
		//业务日期
		biz_content.setDate(DateUtil.dateToStirng(new Date()));          //如 20170629
		//对账流水号
	    biz_content.setAccountfirm_no(fundConfirmRequest.getAccountfirm_no());
		biz_content.setSucceedcount(succeedcount);
		biz_content.setFailcount(failcount);
		biz_content.setFaillist(faillist);
		
		//创建对账结果  请求对象
		BillfundResultsMessageRequest request = new BillfundResultsMessageRequest();
		
		request.setZone_code(ConfigUtil.getZoneCode());
		request.setMethod(InfConstants.AccountBillFundConfirm);
		request.setTimestamp(DateUtil.dateToStirngTime(new Date()));
		String bankindex = fundConfirmMessageRequest.getBankindex() ; 
		request.setBankindex(bankindex);
		request.setBiz_content(biz_content);
				
		//向公共支付平台请求消息
		//转换成JSON String
		String postBody =JSONObject.toJSONString(request);
		BillfundResultsMessageResponse response = (BillfundResultsMessageResponse) HttpUtil.getInstance().httpExecute(postBody , ConfigUtil.getUrl(), BillfundResultsMessageResponse.class);
				
	}
	
	
}
