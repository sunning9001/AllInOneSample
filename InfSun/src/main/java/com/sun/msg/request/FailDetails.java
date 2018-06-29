package com.sun.msg.request;

public class FailDetails {

	private String trade_no ; //交易流水号
	private String code ; //错误码   附录1
	private String msg  ; // 错误描述
	private String remark ;// 备注
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "FailDetails [trade_no=" + trade_no + ", code=" + code + ", msg=" + msg + ", remark=" + remark + "]";
	}

	
}
