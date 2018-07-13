package com.sun.msg;

import com.sun.msg.request.BillQueryRequest;

/**
 * 票据查询 请求参数
 * 
 * @author zhuoyvqing
 *
 */
public class BillQueryMessageRequest {

	/**
	 * 公共参数
	 */
	private String method ;//方法名称
	private String timestamp ; // 发送的请求时间，格式"yyyyMMddHHmmss"  如：20140724030750
	private String bankindex ; //银行的编号，由公共支付接口前置机编码 
	private BillQueryRequest biz_content ; // 请求对象

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getBankindex() {
		return bankindex;
	}

	public void setBankindex(String bankindex) {
		this.bankindex = bankindex;
	}

	public BillQueryRequest getBiz_content() {
		return biz_content;
	}

	public void setBiz_content(BillQueryRequest biz_content) {
		this.biz_content = biz_content;
	}

	@Override
	public String toString() {
		return "BillQueryRequest [method=" + method + ", timestamp=" + timestamp + ", bankindex=" + bankindex
				+ ", biz_content=" + biz_content + "]";
	}



	

	

	

	
	
	
	
}
