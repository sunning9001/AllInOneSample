package com.sun.msg;

/**
 * 返回消息
 * 
 * @author sunning
 *
 */
public class BillSyncMessageResponse {

	/**
	 * 公共相应参数
	 */
	private String code;// 必填,调用结果码
	private String msg; // 内容描述
	private String srv_code;// 业务码 ,见附录1
	private String srv_msg; // 业务返回描述
    
	/**
	 * 相应参数
	 */
	
	private String trade_id; //支付平台流水号

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

	public String getSrv_code() {
		return srv_code;
	}

	public void setSrv_code(String srv_code) {
		this.srv_code = srv_code;
	}

	public String getSrv_msg() {
		return srv_msg;
	}

	public void setSrv_msg(String srv_msg) {
		this.srv_msg = srv_msg;
	}

	public String getTrade_id() {
		return trade_id;
	}

	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}

	@Override
	public String toString() {
		return "BillSyncMessageResponse [code=" + code + ", msg=" + msg + ", srv_code=" + srv_code + ", srv_msg="
				+ srv_msg + ", trade_id=" + trade_id + "]";
	}
	
	
}
