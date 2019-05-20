package com.panli.wechat.res;

/**
 * https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_2 退款查询响应
 * 
 * @author sunning
 *
 */
public class OrderqueryResponse extends ReturnRes {

	private String openid;// 用户标识是
	private String is_subscribe;// 是否关注公众账号是
	private String trade_type;// 交易类型 是
	private String trade_state;// 交易状态是
	private String bank_type;// 付款银行 是
	private String total_fee;// 标价金额是
	private String cash_fee;// 现金支付金额是
	private String transaction_id;// 微信支付订单号是
	private String out_trade_no;// 商户订单号是
	private String time_end;// 支付完成时间是
	private String trade_state_desc;// 交易状态描述是

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIs_subscribe() {
		return is_subscribe;
	}

	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getTrade_state() {
		return trade_state;
	}

	public void setTrade_state(String trade_state) {
		this.trade_state = trade_state;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
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

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	public String getTrade_state_desc() {
		return trade_state_desc;
	}

	public void setTrade_state_desc(String trade_state_desc) {
		this.trade_state_desc = trade_state_desc;
	}

	@Override
	public String toString() {
		return "OrderqueryResponse [openid=" + openid + ", is_subscribe=" + is_subscribe + ", trade_type=" + trade_type
				+ ", trade_state=" + trade_state + ", bank_type=" + bank_type + ", total_fee=" + total_fee
				+ ", cash_fee=" + cash_fee + ", transaction_id=" + transaction_id + ", out_trade_no=" + out_trade_no
				+ ", time_end=" + time_end + ", trade_state_desc=" + trade_state_desc + "]";
	}
}
