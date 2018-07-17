package com.sun.msg;

import com.sun.msg.request.FundResultsRequest;

/**
 * 资金对账结果 请求
 * @author zhuoy
 *
 */
public class BillfundResultsMessageRequest {

	private String zone_code ; //
	private String method ;  //方法名称
	private String timestamp ; //发送请求的时间 ，格式"yyyyMMddHHmmss" 如:201407224030750
	private String bankindex ; //银行的编号， 由公共支付接口前置机编码  
	private FundResultsRequest biz_content ; //
	
	
	public String getZone_code() {
		return zone_code;
	}
	public void setZone_code(String zone_code) {
		this.zone_code = zone_code;
	}
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
	public FundResultsRequest getBiz_content() {
		return biz_content;
	}
	public void setBiz_content(FundResultsRequest biz_content) {
		this.biz_content = biz_content;
	}
	@Override
	public String toString() {
		return "BillfundResultsRequest [zone_code=" + zone_code + ", method=" + method + ", timestamp=" + timestamp
				+ ", bankindex=" + bankindex + ", biz_content=" + biz_content + "]";
	}
	
	
	
	
}
