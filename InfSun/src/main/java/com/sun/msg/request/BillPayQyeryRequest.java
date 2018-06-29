package com.sun.msg.request;

/**
 * 票据查询参数
 * 
 * @author zhuoyvqing
 *
 */
public class BillPayQyeryRequest {

	private String billno ; //票据号
	private String paymode ; // 缴款渠道
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getPaymode() {
		return paymode;
	}
	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}
	@Override
	public String toString() {
		return "BillPayQyeryRequest [billno=" + billno + ", paymode=" + paymode + "]";
	}
	
	
}
