package com.sun.msg.request;

public class Education {

	private String grade ; //年级
	private String clazz ; //班级  class 为关键字
	private String name ; // 学生姓名
	private String idcard ; // 学生身份证号码（与家长手机号二选一必填）
	private String phone ; // 家长手机号 （与学生身份证号二选一必填） 13900000000
	private String expire_date ;// 缴费截止日期 20170905
	private String school_name ; //学习名称
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getExpire_date() {
		return expire_date;
	}
	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	@Override
	public String toString() {
		return "Education [grade=" + grade + ", clazz=" + clazz + ", name=" + name + ", idcard=" + idcard + ", phone="
				+ phone + ", expire_date=" + expire_date + ", school_name=" + school_name + "]";
	}
	
	
	
}
