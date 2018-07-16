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
import com.sun.entity.autodao.Fs_pjdzMapper;
import com.sun.entity.autodao.Fs_pjjfMapper;
import com.sun.entity.autodao.Fs_sfxmMapper;
import com.sun.entity.automodel.Fs_dwzb;
import com.sun.entity.automodel.Fs_dwzbExample;
import com.sun.entity.automodel.Fs_kphz;
import com.sun.entity.automodel.Fs_kphzExample;
import com.sun.entity.automodel.Fs_pjdz;
import com.sun.entity.automodel.Fs_pjdzExample;
import com.sun.entity.automodel.Fs_pjjf;
import com.sun.entity.automodel.Fs_pjjfExample;
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
import com.sun.util.StatusConvertUtil;

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
	   
	   //业务日期
	   String date = biz_content.getDate();
	   //对账流水号
	   String accountfirm_no = biz_content.getAccountfirm_no();
	   //收款人账户类型
	   String rec_acctype = biz_content.getRec_acctype();
	   //收款人账号
	   String rec_acct = biz_content.getRec_acct();
	   //获取总笔数
	   Integer count = biz_content.getCount();
	  
	   //获取到账明细
	   List<BillDetails> translist = biz_content.getTranslist();
	   
	   //创建返回消息
	   FundConfirmMessageResponse response = new FundConfirmMessageResponse();
	  
	   SqlSession sqlSession = SqlUtil.getInstance().getSqlSession();
	   if(translist != null && translist.size() >0 ) {
		   for(int i=0 ;i<translist.size() ;i++) {
			   BillDetails billDetails = translist.get(i);
			   
			   //请求数据中 票据金额
			   String amount = billDetails.getAmount(); 
			   String billno = billDetails.getBillno() ;
			   Fs_pjdz pjdz = new Fs_pjdz();
			   pjdz.setDate(date);
			   pjdz.setAccconfirmNo(accountfirm_no);
			   pjdz.setRecAcctype(rec_acctype);
			   pjdz.setRecAcct(rec_acct);
			   pjdz.setCount(count.toString());
			   pjdz.setPaymode(billDetails.getPaymode());
			   pjdz.setRecSubacct(billDetails.getRec_subacct());
			   pjdz.setTradeNo(billDetails.getTrade_no());
			   pjdz.setBillno(billno);
			   pjdz.setBatchno(billDetails.getBatchno());
			   pjdz.setAmount(amount);
			   pjdz.setAddword(billDetails.getAddWord());
			   
			   //向票 据对账表 fs_pjdz中 添加对账记录
			   Fs_pjdzMapper pjdzMapper = sqlSession.getMapper(Fs_pjdzMapper.class);
			   pjdzMapper.insert(pjdz);
			   sqlSession.commit();
			   
			   
			    //根据票据号查询 缴费记录表 pjjf
				Fs_pjjfMapper jfmapper = sqlSession.getMapper(Fs_pjjfMapper.class);
				Fs_pjjfExample pjjfExample = new Fs_pjjfExample() ;
				pjjfExample.createCriteria().andBillnoEqualTo(billno);
				List<Fs_pjjf> pjjfList = jfmapper.selectByExample(pjjfExample);
				
				Fs_pjjf pjjf = null ;
				if(pjjfList != null && pjjfList.size() > 0) {
					pjjf =pjjfList.get(0);
				}
				//票据缴费 表中无记录，则修改票据状态后，添加票据缴费记录
				if( pjjf == null ) {
					//********** 获取票据金额，比较*********************
					Fs_kphzMapper kpViewMapper = sqlSession.getMapper(Fs_kphzMapper.class);
					Fs_kphzExample example =new Fs_kphzExample();
					example.createCriteria().andPjhEqualTo(billno);
					List<Fs_kphz> billList = kpViewMapper.selectByExample(example );
					
					//获取到票据
					Fs_kphz  kphz =null;
					if(billList!=null && billList.size()>0) {
						kphz =billList.get(0);
					}
					
					if(kphz ==null) {
						//票据查询不到,则告之对方
						response.setCode(ResponseCode.fail);
						response.setMsg(ResponseCode.fail_default_msg);
						return response;
					}
					
					//判断金额是否足够, 金额之和 大于非税系统金额  
					BigDecimal total = new BigDecimal("0") ;
					for (Fs_kphz fs: billList) {
						 BigDecimal je = fs.getJe().setScale(2,BigDecimal.ROUND_HALF_UP);
						 total = total.add(je);
					}
					BigDecimal actualAmount = new BigDecimal(amount) ;
					if(actualAmount.compareTo(total) < 0) {
						response.setCode(ResponseCode.fail);
						response.setMsg(ResponseCode.fail_default_msg);
						return response;
					}
					
					
					//********** 修改票据状态和缴费日期*********************
					UtilMapper utilMapper = sqlSession.getMapper(UtilMapper.class);
					String yuefen = utilMapper.selectMonth(billno);
					
					if( yuefen == null || yuefen =="") {
						response.setCode(ResponseCode.fail);
						response.setMsg(ResponseCode.fail_default_msg);
						return response;
					}
					
					UpdateBean bean = new UpdateBean();
					bean.setJkrq(new Date()); //缴款日期 设立为此时日期
					bean.setPjh(billno);
					bean.setPjzt(ConfigUtil.paid);
					bean.setTable_name("fs_kp"+yuefen);
					
					//修改票据状态 已缴费 缴费时间
					utilMapper.updateJkztAndJkrq(bean);
					sqlSession.commit();
					
				
					//*********************添加缴费记录 到 票据缴费表 fs_pjjf**********
					Fs_pjjf pjjf9 = new Fs_pjjf() ;
					pjjf9.setBillno(billno);
					pjjf9.setPayDatetime(new Date());
					pjjf9.setPayAmount(amount);
//					pjjf9.setBkOutlet(biz_content.getBk_outlet());  银行网点编码
//					pjjf9.setOperator(biz_content.getOperator());   经办人
					pjjf9.setPaymode(billDetails.getPaymode());
					pjjf9.setTradeNo(billDetails.getTrade_no());
//					pjjf9.setPayerName(biz_content.getPayer_name());   实际缴款人名称
					pjjf9.setRecAcctype(biz_content.getRec_acctype());
					
					jfmapper.insert(pjjf);
					sqlSession.commit();
					
					
			   }
			   
		   }
	   }
	   
	   response.setCode(ResponseCode.Success) ;
	   response.setMsg(ResponseCode.Success_default_msg);
	   
	   return response ;
	   
   }
	
		
	/**
	 *  处理票据缴费      支付平台 --->  非税系统
	 * @param request
	 * @return
	 */
	private static Object handleBillPayMessageRequest(BillPayMessageRequest request) {
		
		BillPayRequest biz_content = request.getBiz_content();
		
		//创建返回消息
		BillPayMessageResponse response = new BillPayMessageResponse();
		
		//票据号
		String billno = biz_content.getBillno();
		SqlSession sqlSession = SqlUtil.getInstance().getSqlSession();
		try {
			
			//根据票据号查询 缴费记录表 fs_pjjf
			Fs_pjjfMapper jfmapper = sqlSession.getMapper(Fs_pjjfMapper.class);
			Fs_pjjfExample pjjfExample = new Fs_pjjfExample() ;
			pjjfExample.createCriteria().andBillnoEqualTo(billno);
			pjjfExample.createCriteria().andPayAmountEqualTo(biz_content.getPay_amount());
			pjjfExample.createCriteria().andPaymodeEqualTo(biz_content.getPaymode());
			pjjfExample.createCriteria().andTradeNoEqualTo(biz_content.getTrade_no());
			List<Fs_pjjf> pjjfList = jfmapper.selectByExample(pjjfExample);
			
			//如果查到记录，直接返回成功
			if(pjjfList != null && pjjfList.size() >0) {
				response.setCode(ResponseCode.Success);
				response.setMsg(ResponseCode.Success_default_msg);
				return response ;
			}else { 
				//未查询到缴费记录的，查询表修改缴费状态，添加缴费记录 到 pjjf
				Fs_kphzMapper kpViewMapper = sqlSession.getMapper(Fs_kphzMapper.class);
				Fs_kphzExample example =new Fs_kphzExample();
				example.createCriteria().andPjhEqualTo(billno);
				List<Fs_kphz> billList = kpViewMapper.selectByExample(example );
				
				//获取到票据
				Fs_kphz  kphz =null;
				if(billList!=null && billList.size()>0) {
					kphz =billList.get(0);
				}
				
				if(kphz ==null) {
					//票据查询不到,则告之对方
					response.setCode(ResponseCode.fail);
					response.setMsg(ResponseCode.fail_default_msg);
					return response;
				}
				
				//判断金额是否足够, 实际金额大于库中金额，为满足情况
				BigDecimal total = new BigDecimal("0") ;
				for (Fs_kphz fs: billList) {
					 BigDecimal je = fs.getJe().setScale(2,BigDecimal.ROUND_HALF_UP);
					 total = total.add(je);
				}
				BigDecimal actualAmount = new BigDecimal(biz_content.getPay_amount()) ;
				if(actualAmount.compareTo(total) < 0) {
					response.setCode(ResponseCode.fail);
					response.setMsg(ResponseCode.fail_default_msg);
					return response ;
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
				
				//添加缴费记录 到 票据缴费表 fs_pjjf, 
				Fs_pjjf pjjf = new Fs_pjjf() ;
				pjjf.setBillno(billno);
				pjjf.setPayDatetime(DateUtil.stringToDate(datetime));
				pjjf.setPayAmount(biz_content.getPay_amount());
				pjjf.setBkOutlet(biz_content.getBk_outlet());
				pjjf.setOperator(biz_content.getOperator());
				pjjf.setPaymode(biz_content.getPaymode());
				pjjf.setTradeNo(biz_content.getTrade_no());
				pjjf.setPayerName(biz_content.getPayer_name());
				pjjf.setRecAcctype(biz_content.getRec_acctype());
				
				jfmapper.insert(pjjf);
				sqlSession.commit();
				
				//成功响应
				response.setCode(ResponseCode.Success);
				response.setMsg(ResponseCode.Success_default_msg);
				
				return response;
			}
			
			
			
		}catch (Exception e) {
			logger.debug("handleOuterBillPayMessageRequest  exception:{}",e);
			sqlSession.rollback();

		}finally { 
			if( sqlSession!=null) {
				sqlSession.close();
			}
		}
		
		//返回对象
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
			
			//票据状态   根据表中状态转换成返回的状态
			reponse.setBillstats(StatusConvertUtil.getPayPlatformStatus(kphz.getPjzt()));
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
			List<Item> itemList =new ArrayList<Item>();
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
		List<Item> itemList =new ArrayList<Item>();
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
	 * 	    资金对账结果    非税系统 --->支付平台
	 *        
	 * @param tradeDay  业务日期
	 * @param tradeNo   对账请求中的流水号    
	 */
	
	public  void  excuteFundConfirmResult(String tradeDay,String accountfirm_no,String bankindex) {
		
		//创建对账结果  请求对象
		BillfundResultsMessageRequest request = new BillfundResultsMessageRequest();
		
		SqlSession sqlSession = SqlUtil.getInstance().getSqlSession();
		
		//根据业务日期 和流水号查询 票据对账表
		Fs_pjdzMapper pjdzMapper = sqlSession.getMapper(Fs_pjdzMapper.class);
		Fs_pjdzExample fs_pjdzExample = new Fs_pjdzExample() ;
		fs_pjdzExample.createCriteria().andDateEqualTo(tradeDay);
		fs_pjdzExample.createCriteria().andAccconfirmNoEqualTo(accountfirm_no);
		List<Fs_pjdz> pjdzList = pjdzMapper.selectByExample(fs_pjdzExample);
		
		Fs_pjdz fs_pjdz = null;
		if( pjdzList != null &&  pjdzList.size()>0) {
			fs_pjdz = pjdzList.get(0);
		}
		if(fs_pjdz == null) {
			//根据业务日期和流水号未查询到 票据对账记录 
			//todo---------------------------------------------------------------------------如果当天没有接收到对账请求 ，会出现这种情况   商量修改
		}
		
		request.setZone_code(ConfigUtil.getZoneCode());
		request.setMethod(InfConstants.AccountBillFundConfirm);
		request.setTimestamp(DateUtil.dateToStirngTime(new Date()));
		//银行编号
		request.setBankindex(bankindex); 
		
		FundResultsRequest biz_content = new FundResultsRequest() ;
		biz_content.setDate(tradeDay);
		biz_content.setAccountfirm_no(accountfirm_no);
		List<FailDetails> faillist = new ArrayList<FailDetails>();
		int success = 0;
		int fail = 0 ;
		for(int i=0 ;i<pjdzList.size() ;i++) {
			Fs_pjdz pjdz = pjdzList.get(i);
			String billno = pjdz.getBillno();
			
			Fs_pjjfMapper jfmapper = sqlSession.getMapper(Fs_pjjfMapper.class);
			Fs_pjjfExample pjjfExample = new Fs_pjjfExample() ;
			pjjfExample.createCriteria().andBillnoEqualTo(billno);
			List<Fs_pjjf> pjjfList = jfmapper.selectByExample(pjjfExample);
			
			Fs_pjjf pjjf =null ;
			if(pjjfList != null && pjjfList.size() >0) {
				pjjf = pjjfList.get(0);
			}
			
			if(pjjf != null) {
				success ++ ;
				
			}else {
				fail ++ ;
				FailDetails failDetails = new FailDetails() ;
				//交易流水号
				String trade_no = pjdz.getTradeNo();
				
				//根据票据号查询
				Fs_kphzMapper kpViewMapper = sqlSession.getMapper(Fs_kphzMapper.class);
				Fs_kphzExample example =new Fs_kphzExample();
				example.createCriteria().andPjhEqualTo(billno);
				List<Fs_kphz> billList = kpViewMapper.selectByExample(example );
				
				//判断金额是否足够, 对账金额 小于 库中金额，则不满足情况
				BigDecimal total = new BigDecimal("0") ;
				for (Fs_kphz hz: billList) {
					 BigDecimal je = hz.getJe().setScale(2,BigDecimal.ROUND_HALF_UP);
					 total = total.add(je);
				}
				BigDecimal actualAmount = new BigDecimal(pjdz.getAmount()) ;
				//错误码 。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。如果金额也满足，code 可能为 空,需要解决
				String code = "" ;
				String msg = "" ;
				if(actualAmount.compareTo(total) < 0) {
					code = ResponseCode.confirm01 ;
					msg = ResponseCode.getCodeDesc(code);
				}
				
				failDetails.setTrade_no(trade_no);
				failDetails.setCode(code);
				failDetails.setMsg(msg);
				
				faillist.add(failDetails);
				
			}
			
			biz_content.setSucceedcount(success);
			biz_content.setFailcount(fail);
			biz_content.setFaillist(faillist);
			
			
		}
		
		request.setBiz_content(biz_content);
		
		//向公共支付平台请求消息
		//转换成JSON String
		String postBody =JSONObject.toJSONString(request);
		BillfundResultsMessageResponse response = (BillfundResultsMessageResponse) HttpUtil.getInstance().httpExecute(postBody , ConfigUtil.getUrl(), BillfundResultsMessageResponse.class);
		
		System.out.println(response.toString());
	}
	
	
}
