package com.sun.msg;


/**
 * 请求信息
 * @author zhuoyvqing
 *
 */
public class AccountBillfundRequest {

	private String method ;  //方法名称
	private String timestamp ; //发送请求的时间 ，格式"yyyyMMddHHmmss" 如:201407224030750
	private String bankindex ; //银行的编号， 由公共支付接口前置机编码  
	private Object biz_content ; //
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
	public Object getBiz_content() {
		return biz_content;
	}
	public void setBiz_content(Object biz_content) {
		this.biz_content = biz_content;
	}
	@Override
	public String toString() {
		return "AccountBillfundRequest [method=" + method + ", timestamp=" + timestamp + ", bankindex=" + bankindex
				+ ", biz_content=" + biz_content + "]";
	}
	
	
}
