package com.bjbank;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * 平台银行账户
 * 
 * @author sunning
 *
 */
public class CompanyAccount extends BaseRowModel{


    @ExcelProperty(index = 0,value="平台公司统一信用代码")
	private String companyCode;// 是平台公司统一信用代码
    @ExcelProperty(index = 1,value="平台公司名称")
	private String companyName;// 是 string 平台公司名称
    @ExcelProperty(index = 2,value="账户名称")
	private String accountName;// 是 string 账户名称
    @ExcelProperty(index = 3,value="账户类型")
	private Integer accountType;// 是 int 账户类型 1基本、2一般、3临时、4专用、5 其他
    @ExcelProperty(index =4,value="账户状态")
	private String accountStatus;// 是 int 账户状态 1正常、2冻结、3已注销、4 止付
    @ExcelProperty(index = 5,value="开户时间")
	private String accountOpenTime;// 是 timestamp 开户时间
    @ExcelProperty(index =6,value="开户行")
	private String bank;// 是 string 开户行
    @ExcelProperty(index =7,value="银行账号")
	private String account;// 是 int 银行账号
    @ExcelProperty(index =8,value="账户余额（万元）")
	private String accountBalance;// 是 double 账户余额（万元）
    @ExcelProperty(index =9,value="可用余额（万元）")
	private String availableBalance;// 是 double 可用余额（万元）
    @ExcelProperty(index =10,value="上报结果")
    private String  errorMsg ="成功";//错误详情
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getAccountOpenTime() {
		return accountOpenTime;
	}
	public void setAccountOpenTime(String accountOpenTime) {
		this.accountOpenTime = accountOpenTime;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(String availableBalance) {
		this.availableBalance = availableBalance;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	@Override
	public String toString() {
		return "CompanyAccount [companyCode=" + companyCode + ", companyName=" + companyName + ", accountName="
				+ accountName + ", accountType=" + accountType + ", accountStatus=" + accountStatus
				+ ", accountOpenTime=" + accountOpenTime + ", bank=" + bank + ", account=" + account
				+ ", accountBalance=" + accountBalance + ", availableBalance=" + availableBalance + ", errorMsg="
				+ errorMsg + "]";
	}

	
    

	
}
