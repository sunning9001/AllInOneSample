package com.sun.msg.request;

import java.util.Currency;
import java.util.Date;
import java.util.List;

public class BillEduSyncRequest {

	private String billno ; //票据号
	private Date billdate ; // 票据时间  20170630
	private Currency pay_amount ;// 缴款金额         10.01
	private Currency total_amount ;//缴款书金额   10.01
	private Currency delay_amount ; // 滞纳金
	private String billstats ; // 状态   0：未缴款  1：已缴款 2：已作废
	private String chg_code ; // 执收单位编码
	private String chg_name ; //执 收单位名称
	private String payer_name ; //缴款书上的缴款人名称
	private String rec_acctype; //收款人账户类型  见附录3
	private String rec_bkcode ; // 收款人联行号
	private String paylistfmt = "01" ; // 缴款书内容格式  固定01
	private List<Item> paylist ; // 缴款书内容
	
	private List<Education> eduinfo ; // 教育缴款信息

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public Date getBilldate() {
		return billdate;
	}

	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}

	public Currency getPay_amount() {
		return pay_amount;
	}

	public void setPay_amount(Currency pay_amount) {
		this.pay_amount = pay_amount;
	}

	public Currency getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Currency total_amount) {
		this.total_amount = total_amount;
	}

	public Currency getDelay_amount() {
		return delay_amount;
	}

	public void setDelay_amount(Currency delay_amount) {
		this.delay_amount = delay_amount;
	}

	public String getBillstats() {
		return billstats;
	}

	public void setBillstats(String billstats) {
		this.billstats = billstats;
	}

	public String getChg_code() {
		return chg_code;
	}

	public void setChg_code(String chg_code) {
		this.chg_code = chg_code;
	}

	public String getChg_name() {
		return chg_name;
	}

	public void setChg_name(String chg_name) {
		this.chg_name = chg_name;
	}

	public String getPayer_name() {
		return payer_name;
	}

	public void setPayer_name(String payer_name) {
		this.payer_name = payer_name;
	}

	public String getRec_acctype() {
		return rec_acctype;
	}

	public void setRec_acctype(String rec_acctype) {
		this.rec_acctype = rec_acctype;
	}

	public String getRec_bkcode() {
		return rec_bkcode;
	}

	public void setRec_bkcode(String rec_bkcode) {
		this.rec_bkcode = rec_bkcode;
	}

	public String getPaylistfmt() {
		return paylistfmt;
	}

	public void setPaylistfmt(String paylistfmt) {
		this.paylistfmt = paylistfmt;
	}

	public List<Item> getPaylist() {
		return paylist;
	}

	public void setPaylist(List<Item> paylist) {
		this.paylist = paylist;
	}

	public List<Education> getEduinfo() {
		return eduinfo;
	}

	public void setEduinfo(List<Education> eduinfo) {
		this.eduinfo = eduinfo;
	}

	@Override
	public String toString() {
		return "BillEduSyncRequest [billno=" + billno + ", billdate=" + billdate + ", pay_amount=" + pay_amount
				+ ", total_amount=" + total_amount + ", delay_amount=" + delay_amount + ", billstats=" + billstats
				+ ", chg_code=" + chg_code + ", chg_name=" + chg_name + ", payer_name=" + payer_name + ", rec_acctype="
				+ rec_acctype + ", rec_bkcode=" + rec_bkcode + ", paylistfmt=" + paylistfmt + ", paylist=" + paylist
				+ ", eduinfo=" + eduinfo + "]";
	}
	
	
	
	
}
