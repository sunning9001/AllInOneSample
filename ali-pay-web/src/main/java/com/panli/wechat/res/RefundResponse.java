package com.panli.wechat.res;

/**
 * 申请退款响应
 * 
 * @author sunning
 *
 */
public class RefundResponse extends ReturnRes {

	private String transaction_id;// 微信订单号 是
	private String out_trade_no;// 商户订单号 是
	private String out_refund_no;// 商户退款单号 是
	private String refund_id;// 微信退款单号 是
	private String refund_fee;// 退款金额 是
	private String total_fee;// 标价金额 是
	private String cash_fee;// 现金支付金额 是

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getOut_refund_no() {
		return out_refund_no;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public String getRefund_id() {
		return refund_id;
	}

	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}

	public String getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}

	@Override
	public String toString() {
		return "RefundResponse [transaction_id=" + transaction_id + ", out_trade_no=" + out_trade_no
				+ ", out_refund_no=" + out_refund_no + ", refund_id=" + refund_id + ", refund_fee=" + refund_fee
				+ ", total_fee=" + total_fee + ", cash_fee=" + cash_fee + "]";
	}

}
