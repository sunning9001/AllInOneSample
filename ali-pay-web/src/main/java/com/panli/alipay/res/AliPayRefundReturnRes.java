package com.panli.alipay.res;

import java.util.Date;

/**
 * https://docs.open.alipay.com/api_1/alipay.trade.query
 * 
 * @author sunning
 *
 */
public class AliPayRefundReturnRes extends AliReturnRes {

	private String trade_no;// 支付宝交易号
	private String out_trade_no;// 商户订单号
	private String buyer_logon_id;// 用户的登录id
	private String fund_change;// 本次退款是否发生了资金变化
	private String refund_fee;// 退款总金额
	private Date gmt_refund_pay;// 退款支付时间
	private String buyer_user_id;// 买家在支付宝的用户id

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getBuyer_logon_id() {
		return buyer_logon_id;
	}

	public void setBuyer_logon_id(String buyer_logon_id) {
		this.buyer_logon_id = buyer_logon_id;
	}

	public String getFund_change() {
		return fund_change;
	}

	public void setFund_change(String fund_change) {
		this.fund_change = fund_change;
	}

	public String getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	}



	public Date getGmt_refund_pay() {
		return gmt_refund_pay;
	}

	public void setGmt_refund_pay(Date gmt_refund_pay) {
		this.gmt_refund_pay = gmt_refund_pay;
	}

	public String getBuyer_user_id() {
		return buyer_user_id;
	}

	public void setBuyer_user_id(String buyer_user_id) {
		this.buyer_user_id = buyer_user_id;
	}

	@Override
	public String toString() {
		return "AliPayRefundReturnRes [trade_no=" + trade_no + ", out_trade_no=" + out_trade_no + ", buyer_logon_id="
				+ buyer_logon_id + ", fund_change=" + fund_change + ", refund_fee=" + refund_fee + ", gmt_refund_pay="
				+ gmt_refund_pay + ", buyer_user_id=" + buyer_user_id + "]";
	}



}
