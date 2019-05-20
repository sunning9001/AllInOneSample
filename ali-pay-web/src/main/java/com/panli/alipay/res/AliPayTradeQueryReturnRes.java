package com.panli.alipay.res;

/**
 * https://docs.open.alipay.com/api_1/alipay.trade.query
 * 
 * @author sunning
 *
 */
public class AliPayTradeQueryReturnRes extends AliReturnRes {

	private String trade_no;// 支付宝交易号
	private String out_trade_no;// 商家订单号
	private String buyer_logon_id;// 买家支付宝账号
	private String trade_status;// 交易状态
	private String total_amount;// 交易的订单金额，单位为元，两位小数

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

	public String getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	@Override
	public String toString() {
		return "AliTradeResponse [trade_no=" + trade_no + ", out_trade_no=" + out_trade_no + ", buyer_logon_id="
				+ buyer_logon_id + ", trade_status=" + trade_status + ", total_amount=" + total_amount + "]";
	}

}
