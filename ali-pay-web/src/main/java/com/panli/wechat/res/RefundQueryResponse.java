package com.panli.wechat.res;

/**
 * 查询退款响应
 * 
 * @author sunning
 *
 */
public class RefundQueryResponse extends ReturnRes {

	private String transaction_id;// 微信订单号
	private String out_trade_no;// 商户订单号
	private String total_fee;// 订单金额
	private String cash_fee;// 现金支付金额
	private String refund_count;// 退款笔数
	private String out_refund_no;// 商户退款单号
	private String refund_id;// 微信退款单号
	private String refund_fee;// 申请退款金额
	private String refund_status;// 退款状态
	private String refund_recv_accout;// 退款入账账户
	private String refund_success_time;// 退款成功时间

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

	public String getRefund_count() {
		return refund_count;
	}

	public void setRefund_count(String refund_count) {
		this.refund_count = refund_count;
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

	public String getRefund_status() {
		return refund_status;
	}

	public void setRefund_status(String refund_status) {
		this.refund_status = refund_status;
	}

	public String getRefund_recv_accout() {
		return refund_recv_accout;
	}

	public void setRefund_recv_accout(String refund_recv_accout) {
		this.refund_recv_accout = refund_recv_accout;
	}

	public String getRefund_success_time() {
		return refund_success_time;
	}

	public void setRefund_success_time(String refund_success_time) {
		this.refund_success_time = refund_success_time;
	}

	@Override
	public String toString() {
		return "RefundQueryResponse [transaction_id=" + transaction_id + ", out_trade_no=" + out_trade_no
				+ ", total_fee=" + total_fee + ", cash_fee=" + cash_fee + ", refund_count=" + refund_count
				+ ", out_refund_no=" + out_refund_no + ", refund_id=" + refund_id + ", refund_fee=" + refund_fee
				+ ", refund_status=" + refund_status + ", refund_recv_accout=" + refund_recv_accout
				+ ", refund_success_time=" + refund_success_time + "]";
	}

}
