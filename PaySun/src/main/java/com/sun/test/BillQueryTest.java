
package com.sun.test;

import java.util.Date;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.sun.config.ConfigUtil;
import com.sun.config.HttpUtil;
import com.sun.config.InfConstants;
import com.sun.msg.BillQueryMessageRequest;
import com.sun.msg.BillQueryMessageResponse;
import com.sun.msg.request.BillQueryRequest;
import com.sun.util.DateUtil;

public class BillQueryTest {

	public static void main(String[] args) {
		BillQueryMessageRequest request = new BillQueryMessageRequest();
		
		BillQueryRequest biz_content = new BillQueryRequest();
		biz_content.setBillno("00707375");
		request.setBiz_content(biz_content);
		request.setMethod(InfConstants.OuterBillPayQuery);
		request.setTimestamp(DateUtil.dateToStirngTime(new Date()));
		String postBody ="request:"+JSONObject.toJSONString(request);
		
//		String postBody = JSONObject.toJSONString(request);
		BillQueryMessageResponse response = (BillQueryMessageResponse) HttpUtil.getInstance().httpExecute(postBody , ConfigUtil.getUrl(), BillQueryMessageResponse.class);
		
		
		System.out.println(response.toString());
	}
	
	@Test
	public void testNullPjh() {
		
		BillQueryMessageRequest request = new BillQueryMessageRequest();
		
		BillQueryRequest biz_content = new BillQueryRequest();
		biz_content.setBillno("123");
		request.setBiz_content(biz_content);
		request.setMethod(InfConstants.OuterBillPayQuery);
		request.setTimestamp(DateUtil.dateToStirngTime(new Date()));
		String postBody ="request:"+JSONObject.toJSONString(request);
		
//		String postBody = JSONObject.toJSONString(request);
		BillQueryMessageResponse response = (BillQueryMessageResponse) HttpUtil.getInstance().httpExecute(postBody , ConfigUtil.getUrl(), BillQueryMessageResponse.class);
		
		
		System.out.println(response.toString());
	}
}
