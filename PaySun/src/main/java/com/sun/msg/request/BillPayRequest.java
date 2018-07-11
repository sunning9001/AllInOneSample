package com.sun.msg.request;

import java.util.Currency;

/**
 * 票据缴费请求参数
 * 
 * @author zhuoyvqing
 *
 */
public class BillPayRequest {

	private String billno ; //票据号
	private String pay_datetime ; //交款时间 格式"yyyyMMddHHmmss" 如：20170701125901
	private String pay_amount ;// 缴款金额
	private String bk_outlet ; //银行网点编码
	private String operator ; //经办人
	private String paymode ; //交款渠道 
	private String trade_no ; //交易流水号
	private String payer_name ; //实际缴款人名称
	private String payer_acct ="";// 实际缴款人账号
	private String payer_opbk ="";// 实际缴款人开户行
	private String payer_opbkno ="" ; // 实际缴（付）款人开户行行号
	private String rec_acctype ; //收款人账户类型 见附录3
	private String rec_acct = "" ; //收款人账号
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getPay_datetime() {
		return pay_datetime;
	}
	public void setPay_datetime(String pay_datetime) {
		this.pay_datetime = pay_datetime;
	}
	public String getPay_amount() {
		return pay_amount;
	}
	public void setPay_amount(String pay_amount) {
		this.pay_amount = pay_amount;
	}
	public String getBk_outlet() {
		return bk_outlet;
	}
	public void setBk_outlet(String bk_outlet) {
		this.bk_outlet = bk_outlet;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getPaymode() {
		return paymode;
	}
	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public String getPayer_name() {
		return payer_name;
	}
	public void setPayer_name(String payer_name) {
		this.payer_name = payer_name;
	}
	public String getPayer_acct() {
		return payer_acct;
	}
	public void setPayer_acct(String payer_acct) {
		this.payer_acct = payer_acct;
	}
	public String getPayer_opbk() {
		return payer_opbk;
	}
	public void setPayer_opbk(String payer_opbk) {
		this.payer_opbk = payer_opbk;
	}
	public String getPayer_opbkno() {
		return payer_opbkno;
	}
	public void setPayer_opbkno(String payer_opbkno) {
		this.payer_opbkno = payer_opbkno;
	}
	public String getRec_acctype() {
		return rec_acctype;
	}
	public void setRec_acctype(String rec_acctype) {
		this.rec_acctype = rec_acctype;
	}
	public String getRec_acct() {
		return rec_acct;
	}
	public void setRec_acct(String rec_acct) {
		this.rec_acct = rec_acct;
	}
	@Override
	public String toString() {
		return "BillPayRequest [billno=" + billno + ", pay_datetime=" + pay_datetime + ", pay_amount=" + pay_amount
				+ ", bk_outlet=" + bk_outlet + ", operator=" + operator + ", paymode=" + paymode + ", trade_no="
				+ trade_no + ", payer_name=" + payer_name + ", payer_acct=" + payer_acct + ", payer_opbk=" + payer_opbk
				+ ", payer_opbkno=" + payer_opbkno + ", rec_acctype=" + rec_acctype + ", rec_acct=" + rec_acct + "]";
	}
	
	
	
}
