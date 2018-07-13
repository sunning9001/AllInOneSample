package com.sun.msg;

/**
 * 返回消息
 * 
 * @author zhuoyvqing
 *
 */
public class BillPayMessageResponse {

	/**
	 * 公共参数
	 */
	private String code ; // 必填,调用结果码  附录1
	private String msg ; // 必填, 内容描述
	private String trade_id ;//标识非税系统处理的流水号
	
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
	public String getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}
	@Override
	public String toString() {
		return "OuterBillPayResponse [code=" + code + ", msg=" + msg + ", trade_id=" + trade_id + "]";
	}
	
	
	
	
	
	
}
