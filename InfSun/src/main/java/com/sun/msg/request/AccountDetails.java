package com.sun.msg.request;

import java.util.Currency;

/**
 * 
 * @author zhuoyvqing
 *
 */
public class AccountDetails {
	
	private String paymode ; //缴款渠道  附录2
	private String rec_subacct ;//虚拟账号   选填
	private String trade_no ; //资金交易流水号
	private String billno ; //票据号
	private String batchno ; // 如果是跨行资金到账时填对应的批次号   选填
	private Currency amount ; // 金额
	private String  addWord ; // 到账附言  选填
	public String getPaymode() {
		return paymode;
	}
	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}
	public String getRec_subacct() {
		return rec_subacct;
	}
	public void setRec_subacct(String rec_subacct) {
		this.rec_subacct = rec_subacct;
	}
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getBatchno() {
		return batchno;
	}
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
	public Currency getAmount() {
		return amount;
	}
	public void setAmount(Currency amount) {
		this.amount = amount;
	}
	public String getAddWord() {
		return addWord;
	}
	public void setAddWord(String addWord) {
		this.addWord = addWord;
	}
	@Override
	public String toString() {
		return "AccountDetails [paymode=" + paymode + ", rec_subacct=" + rec_subacct + ", trade_no=" + trade_no
				+ ", billno=" + billno + ", batchno=" + batchno + ", amount=" + amount + ", addWord=" + addWord + "]";
	}
	
	
	
}
