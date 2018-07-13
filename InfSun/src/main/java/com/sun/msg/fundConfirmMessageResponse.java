package com.sun.msg;

/**
 * 资金对账 响应	
 * @author zhuoyvqing
 *
 */
public class fundConfirmMessageResponse {

	/**
	 * 公共参数
	 */
	private String code;// 必填,调用结果码
	private String msg; // 内容描述
	
	/**
	 * 响应参数 
	 * 无
	 */
	
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
	
	
}
