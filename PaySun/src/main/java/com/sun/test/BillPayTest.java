package com.sun.test;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.sun.config.ConfigUtil;
import com.sun.config.HttpUtil;
import com.sun.config.InfConstants;
import com.sun.msg.BillPayMessageRequest;
import com.sun.msg.BillPayMessageResponse;
import com.sun.msg.request.BillPayRequest;

public class BillPayTest {

	public static void main(String[] args) {
		BillPayMessageRequest request = new BillPayMessageRequest();
		
		BillPayRequest biz_content = new BillPayRequest();
		biz_content.setBillno("00707375");
		biz_content.setPay_datetime("20170701125801");
		biz_content.setPay_amount("100.0000");
		request.setBiz_content(biz_content);
		request.setMethod(InfConstants.OuterBillPay);
		
		String postBody ="request:"+JSONObject.toJSONString(request);
		
//		String postBody = JSONObject.toJSONString(request);
		BillPayMessageResponse response = (BillPayMessageResponse) HttpUtil.getInstance().httpExecute(postBody , ConfigUtil.getUrl(), BillPayMessageResponse.class);
		
		
		System.out.println(response.toString());
	}
	
	@Test
	public  void testkong() {
		BillPayMessageRequest request = new BillPayMessageRequest();
		
		BillPayRequest biz_content = new BillPayRequest();
		biz_content.setBillno("00707375");
		biz_content.setPay_datetime("20170701125801");
		biz_content.setPay_amount("100.0000000000001");
		request.setBiz_content(biz_content);
		request.setMethod(InfConstants.OuterBillPay);
		
		String postBody ="request:"+JSONObject.toJSONString(request);
		
//		String postBody = JSONObject.toJSONString(request);
		BillPayMessageResponse response = (BillPayMessageResponse) HttpUtil.getInstance().httpExecute(postBody , ConfigUtil.getUrl(), BillPayMessageResponse.class);
		
		
		System.out.println(response.toString());
	}
}
