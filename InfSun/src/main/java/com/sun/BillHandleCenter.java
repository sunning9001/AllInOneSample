/**
 * 
 */
package com.sun;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.sun.config.ConfigUtil;
import com.sun.config.HttpUtil;
import com.sun.config.InfConstants;
import com.sun.config.ResponseCode;
import com.sun.entity.autodao.Fs_kphzMapper;
import com.sun.entity.automodel.Fs_kphz;
import com.sun.entity.automodel.Fs_kphzExample;
import com.sun.httpserver.HttpServerHandler;
import com.sun.msg.BillQueryMessageRequest;
import com.sun.msg.BillQueryMessageResponse;
import com.sun.msg.BillSyncMessageRequest;
import com.sun.msg.BillSyncMessageResponse;
import com.sun.msg.OuterBillPayMessageRequest;
import com.sun.msg.OuterBillPayMessageResponse;
import com.sun.msg.request.BillPayQyeryRequest;
import com.sun.msg.request.BillSyncRequest;
import com.sun.msg.request.Item;
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
		
		//返回对象
		
		OuterBillPayMessageResponse reponse =new OuterBillPayMessageResponse();
		return reponse;
	}

	/**
	 * 
	 * 处理 票据查询接口
	 * @param request
	 * @return
	 */
	private static Object handleBillQueryMessageRequest(BillQueryMessageRequest request) {
		// TODO 处理业务
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
			//reponse.setBilldate(kphz.getPjrq());
			//金额  TODO
			//reponse.setPay_amount(kphz.getJe());
		    //缴款金额
			//reponse.setTotal_amount(kphz.getJe());
			
			//缴款书内容
			List<Item> itemList =new ArrayList();
			reponse.setPlaylist(itemList);
			Item item =new Item();
			itemList.add(item );
			
			String xmdm = kphz.getXmdm();
			item.setItem_code(xmdm);
			
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
	 *  执行票据同步
	 * @param pj  
	 */
	public  void  excuteBillSync(Fs_kphz pj) {
		//创建票据同步请求
		BillSyncMessageRequest request =new BillSyncMessageRequest();
		//行政划分
		request.setZone_code(ConfigUtil.getZoneCode());
		//方法名称
		request.setMethod(InfConstants.BillSync);
		//TODO 
		//request.setTimestamp(timestamp);
		request.setVersion(ConfigUtil.version);
		
		BillSyncRequest biz_content =new BillSyncRequest();
		request.setBiz_content(biz_content );
		
		
		//设置请求对象
		//票据号
		biz_content.setBillno(pj.getPjh());
		
		//票据日期
		//biz_content.setBilldate(pj.getPjrq());
		
		
		
		//票据状态 转换---》
		//String billstats = pj.getPjzt();
		//biz_content.setBillstats(billstats );
		
		
		
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
					 Fs_kphzMapper Fs_kphzMapper = sqlSession.getMapper(Fs_kphzMapper.class);
					 
					 Fs_kphzExample example =new Fs_kphzExample();
					 example.createCriteria().andPjhEqualTo(pj.getPjh());
					 
					 pj.setPjzt("已缴费");
					Fs_kphzMapper.updateByExample(pj, example );
				} catch (Exception e) {
					// TODO: handle exception
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
