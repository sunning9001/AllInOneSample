package com.panli.alipay.res;
/**
 *   公共响应消息头
 * @author sunning
 *
 */
public class AliReturnRes {
	private String code; // 网关返回码
	private String msg; // 网关返回码描述

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
		return "AliReturnRes [code=" + code + ", msg=" + msg + "]";
	}

}
