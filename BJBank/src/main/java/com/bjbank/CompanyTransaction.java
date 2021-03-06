package com.bjbank;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * 银行交易流水
 * 
 * @author sunning
 *
 */
public class CompanyTransaction extends BaseRowModel {

	@ExcelProperty(index = 0,value="平台公司名称")
	private String companyName;// 是 string 平台公司名称
	@ExcelProperty(index = 1,value="平台公司统一信用代码")
	private String companyCode;// 是 string 平台公司统一信用代码
	@ExcelProperty(index = 2,value="开户行名称")
	private String bank;// 是 string 开户行名称
	@ExcelProperty(index = 3,value="银行账号")
	private String account;// 是 int 银行账号
	@ExcelProperty(index = 4,value="交易时间")
	private String dealTime;// 是 timestamp 交易时间
	@ExcelProperty(index = 5,value="交易币种")
	private Integer transactionCurrency;// 是 int 交易币种(1.人民币，2.美元，3.欧元，4.日元，5.英镑，6.港币，7.韩元，8.其他)
	@ExcelProperty(index = 6,value="对方账户")
	private String reciprocalAccount;// 是 int 对方账户
	@ExcelProperty(index = 7,value="对方户名")
	private String reciprocalName;// 是 string 对方户名
	@ExcelProperty(index = 8,value="摘要")
	private String content;// 是 string 摘要
	@ExcelProperty(index = 9,value="资金流向")
	private String fundFlow;// 是 int 资金流向1收入2支出
	@ExcelProperty(index = 10,value="交易金额")
	private String transactionAmount;// 是 double 交易金额
	@ExcelProperty(index = 11,value="账户余额")
	private String accountBalance;// 是 double 账户余额（交易卡余额）
	@ExcelProperty(index = 12,value="交易方式")
	private String exchangeType;// 是 varchar 交易方式（字符串格式）
    @ExcelProperty(index =13,value="上报状态")
    private String  errorMsg ="成功";//错误详情
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
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
	public String getDealTime() {
		return dealTime;
	}
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	public Integer getTransactionCurrency() {
		return transactionCurrency;
	}
	public void setTransactionCurrency(Integer transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}
	public String getReciprocalAccount() {
		return reciprocalAccount;
	}
	public void setReciprocalAccount(String reciprocalAccount) {
		this.reciprocalAccount = reciprocalAccount;
	}
	public String getReciprocalName() {
		return reciprocalName;
	}
	public void setReciprocalName(String reciprocalName) {
		this.reciprocalName = reciprocalName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFundFlow() {
		return fundFlow;
	}
	public void setFundFlow(String fundFlow) {
		this.fundFlow = fundFlow;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getExchangeType() {
		return exchangeType;
	}
	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	@Override
	public String toString() {
		return "CompanyTransaction [companyName=" + companyName + ", companyCode=" + companyCode + ", bank=" + bank
				+ ", account=" + account + ", dealTime=" + dealTime + ", transactionCurrency=" + transactionCurrency
				+ ", reciprocalAccount=" + reciprocalAccount + ", reciprocalName=" + reciprocalName + ", content="
				+ content + ", fundFlow=" + fundFlow + ", transactionAmount=" + transactionAmount + ", accountBalance="
				+ accountBalance + ", exchangeType=" + exchangeType + ", errorMsg=" + errorMsg + "]";
	}

	
	

}
