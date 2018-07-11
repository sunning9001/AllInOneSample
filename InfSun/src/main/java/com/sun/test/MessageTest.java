package com.sun.test;

import com.alibaba.fastjson.JSONObject;
import com.sun.config.ConfigUtil;
import com.sun.config.HttpUtil;
import com.sun.config.InfConstants;
import com.sun.msg.BillSyncMessageRequest;
import com.sun.msg.BillSyncMessageResponse;

public class MessageTest {

	public static void main(String[] args) {
		

		//创建票据同步请求
		BillSyncMessageRequest request =new BillSyncMessageRequest();
		
		request.setMethod(InfConstants.BillSync);
		request.setTimestamp(System.currentTimeMillis()+"");
		String postBody =JSONObject.toJSONString(request);
		BillSyncMessageResponse response = (BillSyncMessageResponse) HttpUtil.getInstance().httpExecute(postBody , ConfigUtil.getUrl(), BillSyncMessageResponse.class);
		
		System.out.println(response);
	}
}
