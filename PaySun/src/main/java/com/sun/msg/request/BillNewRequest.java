package com.sun.msg.request;

import java.util.Currency;
import java.util.Date;
import java.util.List;

public class BillNewRequest {

	private String zone_code ;// 
	private String billno ; //票据号
	private String crccode =""; //校验码
	private String billdate ; // 票据时间  20170630
	private String bill_typecode; //票据类型代码
	private String bill_typename; //票据类型名称
	private String bill_vercode ; // 票据版本代码
	private String bill_vername ; // 票据版本名称
	private String pay_amount ;// 缴款金额
	private String total_amount ;//缴款书金额
	private String delay_amount ; // 滞纳金
	private String billstats ="0" ; // 状态   0：未缴款 ，不能填其他值
	
	private String chg_code ; // 执收单位编码
	private String chg_name ; //执 收单位名称
	private String payer_name ; //缴款书上的缴款人名称
	private String payer_acct ="" ; //收款人账号
	private String payer_opbk ="" ; //缴款人开户行
	
	private String rec_acctype; //收款人账户类型  见附录3
	private String rec_name ="" ; //收款人全称
	private String rec_acct ="";// 收款人账号
	private String rec_real_acct ="" ; //如果票据上的收款人是伪账号，这里填写真实账号
	private String rec_opbk ;// 收款人开户行
	
	private String rec_bkcode ; // 收款人联行号
	private String interbank = ""; //是否跨行  0非跨行 1跨行
	private String remark ="" ; // 备注
	
	
	private String paylistfmt ; // 缴款书内容格式
	
	private List<Item> paylist ; // 缴费书内容

	public String getZone_code() {
		return zone_code;
	}

	public void setZone_code(String zone_code) {
		this.zone_code = zone_code;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public String getCrccode() {
		return crccode;
	}

	public void setCrccode(String crccode) {
		this.crccode = crccode;
	}

	public String getBilldate() {
		return billdate;
	}

	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}

	public String getBill_typecode() {
		return bill_typecode;
	}

	public void setBill_typecode(String bill_typecode) {
		this.bill_typecode = bill_typecode;
	}

	public String getBill_typename() {
		return bill_typename;
	}

	public void setBill_typename(String bill_typename) {
		this.bill_typename = bill_typename;
	}

	public String getBill_vercode() {
		return bill_vercode;
	}

	public void setBill_vercode(String bill_vercode) {
		this.bill_vercode = bill_vercode;
	}

	public String getBill_vername() {
		return bill_vername;
	}

	public void setBill_vername(String bill_vername) {
		this.bill_vername = bill_vername;
	}

	public String getPay_amount() {
		return pay_amount;
	}

	public void setPay_amount(String pay_amount) {
		this.pay_amount = pay_amount;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public String getDelay_amount() {
		return delay_amount;
	}

	public void setDelay_amount(String delay_amount) {
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

	public String getRec_acctype() {
		return rec_acctype;
	}

	public void setRec_acctype(String rec_acctype) {
		this.rec_acctype = rec_acctype;
	}

	public String getRec_name() {
		return rec_name;
	}

	public void setRec_name(String rec_name) {
		this.rec_name = rec_name;
	}

	public String getRec_acct() {
		return rec_acct;
	}

	public void setRec_acct(String rec_acct) {
		this.rec_acct = rec_acct;
	}

	public String getRec_real_acct() {
		return rec_real_acct;
	}

	public void setRec_real_acct(String rec_real_acct) {
		this.rec_real_acct = rec_real_acct;
	}

	public String getRec_opbk() {
		return rec_opbk;
	}

	public void setRec_opbk(String rec_opbk) {
		this.rec_opbk = rec_opbk;
	}

	public String getRec_bkcode() {
		return rec_bkcode;
	}

	public void setRec_bkcode(String rec_bkcode) {
		this.rec_bkcode = rec_bkcode;
	}

	public String getInterbank() {
		return interbank;
	}

	public void setInterbank(String interbank) {
		this.interbank = interbank;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	@Override
	public String toString() {
		return "BillNewRequest [zone_code=" + zone_code + ", billno=" + billno + ", crccode=" + crccode + ", billdate="
				+ billdate + ", bill_typecode=" + bill_typecode + ", bill_typename=" + bill_typename + ", bill_vercode="
				+ bill_vercode + ", bill_vername=" + bill_vername + ", pay_amount=" + pay_amount + ", total_amount="
				+ total_amount + ", delay_amount=" + delay_amount + ", billstats=" + billstats + ", chg_code="
				+ chg_code + ", chg_name=" + chg_name + ", payer_name=" + payer_name + ", payer_acct=" + payer_acct
				+ ", payer_opbk=" + payer_opbk + ", rec_acctype=" + rec_acctype + ", rec_name=" + rec_name
				+ ", rec_acct=" + rec_acct + ", rec_real_acct=" + rec_real_acct + ", rec_opbk=" + rec_opbk
				+ ", rec_bkcode=" + rec_bkcode + ", interbank=" + interbank + ", remark=" + remark + ", paylistfmt="
				+ paylistfmt + ", paylist=" + paylist + "]";
	}

	
	
	
}
