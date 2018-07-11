package com.sun.test;

import com.alibaba.fastjson.JSONObject;
import com.sun.msg.BillSyncMessageResponse;

public class TestReponse {

	public static void main(String[] args) {
		
		JSONObject kvObject =new JSONObject();
		
	
		BillSyncMessageResponse reponse =new BillSyncMessageResponse();
		
		reponse.setCode("code");
		kvObject.put("wp_out_bill_pay_query_reponse", reponse);
		
		System.out.println(kvObject.toString());
	}
}
