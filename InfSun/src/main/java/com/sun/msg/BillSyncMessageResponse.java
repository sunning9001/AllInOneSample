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
	private String svr_code;// 业务码 ,见附录1
	private String svr_msg; // 业务返回描述
    
	/**
	 * 响应参数
	 */
	
	private String trade_id; //支付平台流水号
	//新加字段
	private String qrcode_url ; //公共支付返回给非税的二维码
	

	public String getQrcode_url() {
		return qrcode_url;
	}

	public void setQrcode_url(String qrcode_url) {
		this.qrcode_url = qrcode_url;
	}

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

	@Override
	public String toString() {
		return "BillSyncMessageResponse [code=" + code + ", msg=" + msg + ", svr_code=" + svr_code + ", svr_msg="
				+ svr_msg + ", trade_id=" + trade_id + ", qrcode_url=" + qrcode_url + "]";
	}

	

	
	
}
