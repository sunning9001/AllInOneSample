package com.sun.msg;

public class BillInputMessageResponse {

	/**
	 * 公共参数
	 */
	private String code;// 必填,调用结果码
	private String msg; // 内容描述
	
	
	/**
	 * 响应参数
	 * 
	 */
	private String trade_id;// 标识公共支付平台处理的流水号


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getTrade_id() {
		return trade_id;
	}


	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}


	@Override
	public String toString() {
		return "BillInputResponse [code=" + code + ", msg=" + msg + ", trade_id=" + trade_id + "]";
	}
	
	
}
