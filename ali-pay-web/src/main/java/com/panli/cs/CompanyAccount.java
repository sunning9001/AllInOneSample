package com.panli.cs;

/**
 * 平台银行账户
 * 
 * @author sunning
 *
 */
public class CompanyAccount {

	private String companyCode;// 是平台公司统一信用代码
	private String companyName;// 是 string 平台公司名称
	private String accountName;// 是 string 账户名称
	private String accountType;// 是 int 账户类型 1基本、2一般、3临时、4专用、5 其他
	private String accountStatus;// 是 int 账户状态 1正常、2冻结、3已注销、4 止付
	private String accountOpenTime;// 是 timestamp 开户时间
	private String bank;// 是 string 开户行
	private String account;// 是 int 银行账号
	private String accountBalance;// 是 double 账户余额（万元）
	private String availableBalance;// 是 double 可用余额（万元）
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
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
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
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	@Override
	public String toString() {
		return "CompanyAccount [companyCode=" + companyCode + ", companyName=" + companyName + ", accountName="
				+ accountName + ", accountType=" + accountType + ", accountStatus=" + accountStatus
				+ ", accountOpenTime=" + accountOpenTime + ", bank=" + bank + ", account=" + account
				+ ", accountBalance=" + accountBalance + ", availableBalance=" + availableBalance + "]";
	}


}
