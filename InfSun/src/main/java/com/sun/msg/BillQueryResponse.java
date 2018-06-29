package com.sun.msg;

/**
 * 返回参数
 * 
 * @author zhuoyvqing
 *
 */
public class BillQueryResponse {

	/**
	 * 公共参数
	 */
	private String code ; // 必填,调用结果码  附录1
	private String msg ; // 必填, 内容描述
	private String trade_id ;//标识非税系统处理的流水号
	
}
