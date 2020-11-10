/** 
 *  @Copyright:  http://www.wiotplanet.com  尚贤谷物联网科技发展有限公司 Inc. All rights reserved.
 *  @CreateTime: 2020年8月24日上午11:28:07
 *  @CreateUser: sunning 
 *  
 *
*/
package com.bjbank;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 *
 * TODO: 描述这个类用来做什么事情TODO
 *
 * @CreateTime : 2020年8月24日上午11:28:07
 * @CreateAuthor: sunning
 * @Email : sunning9001@126.com
 *
 */
public class ExcludeAccount extends BaseRowModel {

	@ExcelProperty(index = 0, value = "银行账号")
	private String account;// 账号
	@ExcelProperty(index = 1, value = "平台公司名称")
	private String companyName;// 是 string 平台公司名称

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "ExcludeAccount [account=" + account + ", companyName=" + companyName + "]";
	}

}
