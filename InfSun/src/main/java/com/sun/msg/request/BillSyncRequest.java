package com.sun.msg.request;

import java.util.List;

/**
 * 票据同步请求参数,只发送必填数据
 * 
 * @author sunning
 *
 */
public class BillSyncRequest {

	private String billno; // 票据号,最大长度20,例如:32000098039382
	private String billdate;// 票据日期,例如:20180626
	private String pay_amount;// 缴费金额,单位元 例如:10.01元
	private String total_amount;// 缴费书金额,单位元 例如:10.01元
	private String delay_amount;// 滞纳金,单位元 例如:0.00元
	private String billstats; // 状态 0-未缴费 1-已缴费 2-已作废
	private String chg_code; // 执收单位编码
	private String chg_name; // 执收单位名称
	private String payer_name; // 缴款书上的缴款人名称
	private String rec_aacctype;// 收款人账号类型,见附录
	private String rec_bkcode;// 收款人联行号
	private String paylistfmt = "01"; // 缴款书内容格式 固定为01

	private List<Item> playlist; // 缴费书内容

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public String getBilldate() {
		return billdate;
	}

	public void setBilldate(String billdate) {
		this.billdate = billdate;
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

	public String getRec_aacctype() {
		return rec_aacctype;
	}

	public void setRec_aacctype(String rec_aacctype) {
		this.rec_aacctype = rec_aacctype;
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

	public List<Item> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<Item> playlist) {
		this.playlist = playlist;
	}

	@Override
	public String toString() {
		return "BillSyncRequest [billno=" + billno + ", billdate=" + billdate + ", pay_amount=" + pay_amount
				+ ", total_amount=" + total_amount + ", delay_amount=" + delay_amount + ", billstats=" + billstats
				+ ", chg_code=" + chg_code + ", chg_name=" + chg_name + ", payer_name=" + payer_name + ", rec_aacctype="
				+ rec_aacctype + ", rec_bkcode=" + rec_bkcode + ", paylistfmt=" + paylistfmt + ", playlist=" + playlist
				+ "]";
	}

}
