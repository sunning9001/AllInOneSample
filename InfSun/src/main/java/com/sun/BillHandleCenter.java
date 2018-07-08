/**
 * 
 */
package com.sun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.httpserver.HttpServerHandler;
import com.sun.msg.BillQueryMessageRequest;
import com.sun.msg.BillQueryMessageResponse;
import com.sun.msg.OuterBillPayMessageRequest;
import com.sun.msg.OuterBillPayMessageResponse;

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
	 * @param request
	 * @return
	 */
	private static Object handleBillQueryMessageRequest(BillQueryMessageRequest request) {
		// TODO 处理业务
		
		//返回消息对象
		BillQueryMessageResponse response =new BillQueryMessageResponse();
		return response;
	}



	
}
