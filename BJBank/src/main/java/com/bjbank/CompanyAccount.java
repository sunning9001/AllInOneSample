package com.bjbank;

import java.math.BigDecimal;

import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.fastjson.JSONObject;

/**
 * 平台银行账户
 * 
 * @author sunning
 *
 */
public class CompanyAccount extends BaseRowModel{


    @ExcelProperty(index = 0)
	private String companyCode;// 是平台公司统一信用代码
    @ExcelProperty(index = 1)
	private String companyName;// 是 string 平台公司名称
    @ExcelProperty(index = 2)
	private String accountName;// 是 string 账户名称
    @ExcelProperty(index = 3)
	private Integer accountType;// 是 int 账户类型 1基本、2一般、3临时、4专用、5 其他
    @ExcelProperty(index =4)
	private String accountStatus;// 是 int 账户状态 1正常、2冻结、3已注销、4 止付
    @ExcelProperty(index = 5,format = "yyyy-MM-dd hh:mm:ss")
	private String accountOpenTime;// 是 timestamp 开户时间
    @ExcelProperty(index =6)
	private String bank;// 是 string 开户行
    @ExcelProperty(index =7)
	private String account;// 是 int 银行账号
    @ExcelProperty(index =8)
	private BigDecimal accountBalance;// 是 double 账户余额（万元）
    @ExcelProperty(index =9)
	private BigDecimal availableBalance;// 是 double 可用余额（万元）
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
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}
	@Override
	public String toString() {
		return "CompanyAccountExcel [companyCode=" + companyCode + ", companyName=" + companyName + ", accountName="
				+ accountName + ", accountType=" + accountType + ", accountStatus=" + accountStatus
				+ ", accountOpenTime=" + accountOpenTime + ", bank=" + bank + ", account=" + account
				+ ", accountBalance=" + accountBalance + ", availableBalance=" + availableBalance + "]";
	}
    
    
    
    
	
}
