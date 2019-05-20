package com.bjbank;

/**
 * 公司账号信息
 * 
 * @author sunning
 *
 */
public class Company {

	private String companyCode;// 是平台公司统一信用代码
	private String companyName;// 是 string 平台公司名称

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

	@Override
	public String toString() {
		return "Company [companyCode=" + companyCode + ", companyName=" + companyName + "]";
	}

}
