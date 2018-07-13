package com.sun.test;

import com.alibaba.fastjson.JSONObject;
import com.sun.config.ConfigUtil;
import com.sun.config.HttpUtil;
import com.sun.config.InfConstants;
import com.sun.msg.BillQueryMessageRequest;
import com.sun.msg.BillQueryMessageResponse;
import com.sun.msg.request.BillQueryRequest;

public class BillQueryTest {

	public static void main(String[] args) {
		BillQueryMessageRequest request = new BillQueryMessageRequest();
		
		BillQueryRequest biz_content = new BillQueryRequest();
		biz_content.setBillno("00707375");
		request.setBiz_content(biz_content);
		request.setMethod(InfConstants.OuterBillPayQuery);
		
		String postBody ="wp_outer_bill_pay_query_response:"+JSONObject.toJSONString(request);
		
//		String postBody = JSONObject.toJSONString(request);
		BillQueryMessageResponse response = (BillQueryMessageResponse) HttpUtil.getInstance().httpExecute(postBody , ConfigUtil.getUrl(), BillQueryMessageResponse.class);
		
		
		System.out.println(response.toString());
	}
}
