package com.panli.wechat.res;

/**
 * 微信返回状态码
 * 
 * @author sunning
 *
 */
public class ReturnRes {

	private String code; // 返回状态码
	private String msg; // 返回信息

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

	@Override
	public String toString() {
		return "ReturnRes [code=" + code + ", msg=" + msg + "]";
	}

}
