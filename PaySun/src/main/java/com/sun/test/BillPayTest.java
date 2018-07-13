package com.sun.test;

import com.alibaba.fastjson.JSONObject;
import com.sun.config.ConfigUtil;
import com.sun.config.HttpUtil;
import com.sun.config.InfConstants;
import com.sun.msg.BillPayMessageRequest;
import com.sun.msg.BillPayMessageResponse;
import com.sun.msg.BillQueryMessageRequest;
import com.sun.msg.BillQueryMessageResponse;
import com.sun.msg.request.BillPayRequest;
import com.sun.msg.request.BillQueryRequest;

public class BillPayTest {

	public static void main(String[] args) {
		BillPayMessageRequest request = new BillPayMessageRequest();
		
		BillPayRequest biz_content = new BillPayRequest();
		biz_content.setBillno("00707375");
		biz_content.setPay_datetime("20170701125801");
		
		request.setBiz_content(biz_content);
		request.setMethod(InfConstants.OuterBillPayQuery);
		
		String postBody ="wp_outer_bill_pay_response:"+JSONObject.toJSONString(request);
		
//		String postBody = JSONObject.toJSONString(request);
		BillPayMessageResponse response = (BillPayMessageResponse) HttpUtil.getInstance().httpExecute(postBody , ConfigUtil.getUrl(), BillPayMessageResponse.class);
		
		
		System.out.println(response.toString());
	}
}
