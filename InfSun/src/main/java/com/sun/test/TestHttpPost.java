package com.sun.test;

import com.sun.config.HttpUtil;

public class TestHttpPost {

	public static void main(String[] args) {

		//票据同步到公众支付平台
		String postBody ="发送的postString";
		String url ="http://localhost:9999/outxxxxxxxxx";
		HttpUtil.getInstance().httpExecute(postBody , url );
	}
}
