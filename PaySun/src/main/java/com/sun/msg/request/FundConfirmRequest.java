package com.sun.msg.request;

import java.util.Date;
import java.util.List;

/**
 * 资金对账请求参数
 * 
 * @author zhuoyvqing
 *
 */
public class FundConfirmRequest {

	private String date ;//业务日期 如：20170629 
	private String accountfirm_no ; //对账流水号， 标识唯一一次对账 ，
	private String rec_acctype ; // 收款人账户类型  见附录3
	private String rec_acct = ""; // 收款人账号
	private Integer count ; // 总笔数
	
	private List<BillDetails> translist ; //到账明细

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAccountfirm_no() {
		return accountfirm_no;
	}

	public void setAccountfirm_no(String accountfirm_no) {
		this.accountfirm_no = accountfirm_no;
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<BillDetails> getTranslist() {
		return translist;
	}

	public void setTranslist(List<BillDetails> translist) {
		this.translist = translist;
	}

	@Override
	public String toString() {
		return "BillfundRequest [date=" + date + ", accountfirm_no=" + accountfirm_no + ", rec_acctype=" + rec_acctype
				+ ", rec_acct=" + rec_acct + ", count=" + count + ", translist=" + translist + "]";
	}

	
	
	
	
}
