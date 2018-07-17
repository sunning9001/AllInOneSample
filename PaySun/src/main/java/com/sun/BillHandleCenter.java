/**
 * 
 */
package com.sun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.sun.config.InfConstants;
import com.sun.config.ResponseCode;
import com.sun.httpserver.HttpServerHandler;
import com.sun.msg.BillSyncMessageRequest;
import com.sun.msg.BillSyncMessageResponse;
import com.sun.msg.BillfundResultsMessageRequest;
import com.sun.msg.BillfundResultsMessageResponse;

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
		 * 是否回复非税系统消息,默认不回复
		 */
		boolean replyFlag = false;
		/**
		 * 回复给非税系统的消息对象
		 */
		Object replayMessage = null;
		if (clazz.equals(BillSyncMessageRequest.class)) {
			BillSyncMessageRequest request = (BillSyncMessageRequest) obj;
			replayMessage = handleBillSyncMessageRequest(request);
			replyFlag = true;
		}
		if (clazz.equals(BillfundResultsMessageRequest.class)) {
			BillfundResultsMessageRequest request = (BillfundResultsMessageRequest) obj;
			replayMessage = handleBillfundResultsMessageRequest(request);
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
	 * 处理来自非税系统的票据同步接口
	 * @param request
	 * @return
	 */
	private static Object handleBillSyncMessageRequest(BillSyncMessageRequest request) {
	
//		JSONObject kvObject =new JSONObject();
		
		
		BillSyncMessageResponse reponse =new BillSyncMessageResponse();
		reponse.setCode("00000");
//		kvObject.put("wp_out_bill_pay_query_reponse_xxxxxxxxxxxxxxxxxxxxxxxxxx", reponse);
//		
//		String s = "\"wp_out_bill_pay_query_reponse\":";
//		s += JSONObject.toJSONString(reponse);
		
		return reponse;
	}

	 
	/**
	 * 
	 * 处理来自非税系统的资金对账结果接口
	 * @param request
	 * @return
	 */
	private static Object handleBillfundResultsMessageRequest(BillfundResultsMessageRequest request) {
		BillfundResultsMessageResponse response =new BillfundResultsMessageResponse();
		response.setCode(ResponseCode.Success);
		response.setMsg(ResponseCode.getCodeDesc(ResponseCode.Success));
		return response;
	}


   /****************************************以下是请求接口**********************************************/
	

	
	
	
}
