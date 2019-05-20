package com.bjbank;

import java.math.BigDecimal;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * 银行交易流水
 * 
 * @author sunning
 *
 */
public class CompanyTransaction extends BaseRowModel {

	@ExcelProperty(index = 0)
	private String companyName;// 是 string 平台公司名称
	@ExcelProperty(index = 1)
	private String companyCode;// 是 string 平台公司统一信用代码
	@ExcelProperty(index = 2)
	private String bank;// 是 string 开户行名称
	@ExcelProperty(index = 3)
	private String account;// 是 int 银行账号
	@ExcelProperty(index = 4, format = "yyyy-MM-dd hh:mm:ss")
	private String dealTime;// 是 timestamp 交易时间
	@ExcelProperty(index = 5)
	private Integer transactionCurrency;// 是 int 交易币种(1.人民币，2.美元，3.欧元，4.日元，5.英镑，6.港币，7.韩元，8.其他)
	@ExcelProperty(index = 6)
	private String reciprocalAccount;// 是 int 对方账户
	@ExcelProperty(index = 7)
	private String reciprocalName;// 是 string 对方户名
	@ExcelProperty(index = 8)
	private String content;// 是 string 摘要
	@ExcelProperty(index = 9)
	private String fundFlow;// 是 int 资金流向1收入2支出
	@ExcelProperty(index = 10)
	private BigDecimal transactionAmount;// 是 double 交易金额
	@ExcelProperty(index = 11)
	private BigDecimal accountBalance;// 是 double 账户余额（交易卡余额）
	@ExcelProperty(index = 12)
	private String exchangeType;// 是 varchar 交易方式（字符串格式）

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

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}

	@Override
	public String toString() {
		return "CompanyTransactionExcel [companyName=" + companyName + ", companyCode=" + companyCode + ", bank=" + bank
				+ ", account=" + account + ", dealTime=" + dealTime + ", transactionCurrency=" + transactionCurrency
				+ ", reciprocalAccount=" + reciprocalAccount + ", reciprocalName=" + reciprocalName + ", content="
				+ content + ", fundFlow=" + fundFlow + ", transactionAmount=" + transactionAmount + ", accountBalance="
				+ accountBalance + ", exchangeType=" + exchangeType + "]";
	}

}
