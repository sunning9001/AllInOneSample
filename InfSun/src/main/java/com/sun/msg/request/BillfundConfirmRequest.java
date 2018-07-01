package com.sun.msg.request;

import java.util.Date;
import java.util.List;

/**
 * 请求参数
 * @author zhuoyvqing
 *
 */
public class BillfundConfirmRequest {

	private String date ; //业务日期  如20170629O
	private String accountfirm_no ; //对账流水号， 标识唯一一次对账 ，
	private int succeedcount ; //成功笔款
	private int failcount ; //失败笔款
	
	
	private List<FailDetails> faillist ; //到账明细


	
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



	public int getSucceedcount() {
		return succeedcount;
	}



	public void setSucceedcount(int succeedcount) {
		this.succeedcount = succeedcount;
	}



	public int getFailcount() {
		return failcount;
	}



	public void setFailcount(int failcount) {
		this.failcount = failcount;
	}



	public List<FailDetails> getFaillist() {
		return faillist;
	}



	public void setFaillist(List<FailDetails> faillist) {
		this.faillist = faillist;
	}



	@Override
	public String toString() {
		return "BillfundConfirmRequest [date=" + date + ", accountfirm_no=" + accountfirm_no + ", succeedcount="
				+ succeedcount + ", failcount=" + failcount + ", faillist=" + faillist + "]";
	}


	

	
	
	
}
