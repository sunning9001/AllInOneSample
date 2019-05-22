package com.sun.test;

import com.alibaba.fastjson.JSONObject;
import com.sun.msg.request.Attach_info;
import com.sun.msg.request.BillSyncRequest;
import com.sun.msg.request.Value;

public class ReturnMessageTest {

	public static void main(String[] args) {
		BillSyncRequest request = new BillSyncRequest() ;
		Attach_info attach_info = new Attach_info();
		Value value = new Value();
		attach_info.setValue(value);
		String jsonString = JSONObject.toJSONString(attach_info);
		request.setAttach_info(jsonString);
		
		System.out.println(request.toString());
		String json = JSONObject.toJSONString(request);
		System.out.println(json);
	}
}
