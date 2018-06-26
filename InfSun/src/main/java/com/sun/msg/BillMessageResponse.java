package com.sun.msg;

/**
 * 票据请求消息
 * 
 * @author sunning
 *
 */
public class BillMessageResponse {

	/**
	 * 公共参数
	 */
	private String code;// 必填,调用结果码
	private String msg; // 内容描述
	private String srv_code;// 业务码 ,见附录1
	private String srv_msg; // 业务返回描述

}
