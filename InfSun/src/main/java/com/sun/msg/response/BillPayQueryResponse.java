package com.sun.msg.response;

import java.util.Currency;
import java.util.Date;
import java.util.List;

import com.sun.msg.request.Item;

/**
 * 票据查询返回参数
 * 
 * @author zhuoyvqing
 *
 */
public class BillPayQueryResponse {

	private String zone_code ; //必填    行政区域
	private String billno ; //必填     票据号
	private Date billdate ; //必填   票据日期  例如：20170630
	private Currency pay_amount ;// 必填  缴款金额
	private Currency total_amount ; //必填  缴款书金额
	private Currency delay_amount ; //必填  滞纳金
	private String billstate ; //  必填    状态   0:未缴款   1：已缴款  2：已作废
	private String chg_code ; // 必填  接收单位编码 
	private String payer_name ; // 必填  缴款书上的缴款人名称
	
	private String payer_acct ; //    缴款人账号
	private String payer_opbk ; //    缴款人开户行
	
	private String rec_acctype ; //必填    收款人账户类型  见附录3
	
	private String rec_name ; //收款人全称
	private String rec_acct ; // 收款人账号
	private String rec_opbk ; // 收款人开户行
	
	private String rec_bkcode ;// 必填    收款人联行号
	
	private String rec_real_acct ; //真实账号，当收款人账号为伪账号时填写
	private String interbank ; //是否跨行   0：非跨行  1：跨行
	private String remark ; //备注
	
	private String paylistfmt ="01" ; //必填   缴款书内容格式 固定为01
	
	private List<Item> playlist; //必填  缴费书内容

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

	public String getBillstate() {
		return billstate;
	}

	public void setBillstate(String billstate) {
		this.billstate = billstate;
	}

	public String getChg_code() {
		return chg_code;
	}

	public void setChg_code(String chg_code) {
		this.chg_code = chg_code;
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

	public String getRec_real_acct() {
		return rec_real_acct;
	}

	public void setRec_real_acct(String rec_real_acct) {
		this.rec_real_acct = rec_real_acct;
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

	public List<Item> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<Item> playlist) {
		this.playlist = playlist;
	}

	@Override
	public String toString() {
		return "BillPayQueryResponse [zone_code=" + zone_code + ", billno=" + billno + ", billdate=" + billdate
				+ ", pay_amount=" + pay_amount + ", total_amount=" + total_amount + ", delay_amount=" + delay_amount
				+ ", billstate=" + billstate + ", chg_code=" + chg_code + ", payer_name=" + payer_name + ", payer_acct="
				+ payer_acct + ", payer_opbk=" + payer_opbk + ", rec_acctype=" + rec_acctype + ", rec_name=" + rec_name
				+ ", rec_acct=" + rec_acct + ", rec_opbk=" + rec_opbk + ", rec_bkcode=" + rec_bkcode
				+ ", rec_real_acct=" + rec_real_acct + ", interbank=" + interbank + ", remark=" + remark
				+ ", paylistfmt=" + paylistfmt + ", playlist=" + playlist + "]";
	}
	
	
	
	
}
