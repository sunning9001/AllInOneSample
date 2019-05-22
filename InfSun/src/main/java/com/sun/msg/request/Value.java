package com.sun.msg.request;

/**
 * @author zhuoyuqing
 *
 */
public class Value {

	private String phonenum ;
	private String content ;
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Value [phonenum=" + phonenum + ", content=" + content + "]";
	}
	
	
}
