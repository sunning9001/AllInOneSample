package com.sun.msg;

public class BillEducationMessageResponse {

	/**
	 * 公共参数
	 */
	private String code;// 必填,调用结果码
	private String msg; // 内容描述
	private String svr_code;// 业务码 ,见附录1
	private String svr_msg; // 业务返回描述
	
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

	public String getSvr_code() {
		return svr_code;
	}

	public void setSvr_code(String svr_code) {
		this.svr_code = svr_code;
	}

	public String getSvr_msg() {
		return svr_msg;
	}

	public void setSvr_msg(String svr_msg) {
		this.svr_msg = svr_msg;
	}

	public String getTrade_id() {
		return trade_id;
	}

	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}
	
	
}
