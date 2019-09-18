package com.bjbank;

public class TextCustAcct {
	@TextIndex(index =0)
	private String AGT_NUM;// 1 协议编号(PK)
	@TextIndex(index =3)
	private String BELONG_ORG_NUM;// 5 所属机构号
	@TextIndex(index =5)
	private String CURR_CD;// 7 货币代码
	@TextIndex(index =11)
	private String ACCT_CHAR_CD;// 13账户性质代码
	@TextIndex(index =12)
	private String OPEN_DT;// 14 开户日期
	@TextIndex(index =21)
	private String CURR_BAL;// 23 当前余额
	@TextIndex(index =23)
	private String CUST_NAME;// 25 客户名称
	@TextIndex(index =29)
	private String ORG_ORG_CD;// 31 组织机构代码
	public String getAGT_NUM() {
		return AGT_NUM;
	}
	public void setAGT_NUM(String aGT_NUM) {
		AGT_NUM = aGT_NUM;
	}
	public String getBELONG_ORG_NUM() {
		return BELONG_ORG_NUM;
	}
	public void setBELONG_ORG_NUM(String bELONG_ORG_NUM) {
		BELONG_ORG_NUM = bELONG_ORG_NUM;
	}
	public String getCURR_CD() {
		return CURR_CD;
	}
	public void setCURR_CD(String cURR_CD) {
		CURR_CD = cURR_CD;
	}
	public String getACCT_CHAR_CD() {
		return ACCT_CHAR_CD;
	}
	public void setACCT_CHAR_CD(String aCCT_CHAR_CD) {
		ACCT_CHAR_CD = aCCT_CHAR_CD;
	}
	public String getOPEN_DT() {
		return OPEN_DT;
	}
	public void setOPEN_DT(String oPEN_DT) {
		OPEN_DT = oPEN_DT;
	}
	public String getCURR_BAL() {
		return CURR_BAL;
	}
	public void setCURR_BAL(String cURR_BAL) {
		CURR_BAL = cURR_BAL;
	}
	public String getCUST_NAME() {
		return CUST_NAME;
	}
	public void setCUST_NAME(String cUST_NAME) {
		CUST_NAME = cUST_NAME;
	}
	public String getORG_ORG_CD() {
		return ORG_ORG_CD;
	}
	public void setORG_ORG_CD(String oRG_ORG_CD) {
		ORG_ORG_CD = oRG_ORG_CD;
	}
	@Override
	public String toString() {
		return "TextCustAcct [AGT_NUM=" + AGT_NUM + ", BELONG_ORG_NUM=" + BELONG_ORG_NUM + ", CURR_CD=" + CURR_CD
				+ ", ACCT_CHAR_CD=" + ACCT_CHAR_CD + ", OPEN_DT=" + OPEN_DT + ", CURR_BAL=" + CURR_BAL + ", CUST_NAME="
				+ CUST_NAME + ", ORG_ORG_CD=" + ORG_ORG_CD + "]";
	}
	
	
	/*
	private String AGT_MODIF_NUM;// 2 协议修饰符(PK)
	private String DATA_DT;// 3 数据日期(PK)
	private String CUST_NUM;// 4 客户号
	private String GL_NUM;// 6 科目号
	private String AGT_STATUS_CD;// 8 协议状态代码
	private String CALC_INT_TYPE_CD;// 9 计息种类代码
	private String STL_INT_MODE_CD;// 10 结息方式代码
	private String DPSIT_TERM_PERIOD_TYPE_CD;// 11 存款期限周期种类代码
	private String DPSIT_TERM;// 12 存款期限
	private String CLOSE_DT;// 15 销户日期
	private String START_INT_DT;// 16 起息日期
	private String MATURE_DT;// 17 到期日期
	private String NEXT_RESET_PRICE_DT;// 18 下次重定价日期
	private String INT_RATE_PERIOD_TYPE_CD;// 19 利率周期种类代码
	private String INT_RATE_UNIT_CD;// 20 利率单位代码
	private String EXEC_INT_RATE;// 21执行利率
	private String CURR_BAL_DIR_CD;// 22 当前余额方向代码
	private String ACCRUED_INT;// 24 应计利息

	private String NEXT_PAY_INT_DT;// 26 下次付息日期
	private String TIME_TRAN_DPSIT_IND;// 27 定期转存标志
	private String INT_RATE_ATTR_CD;// 28 利率属性代码
	private String RESET_PRICE_FREQ_CD;// 29 重定价频次代码
	private String ACTL_MATURE_DT;// 30 实际到期日期

	private String NEW_CORP_SIZE_CD;// 32 新企业规模代码
	private String PROD_NUM;// 33 产品编号
	private String BASE_INT_RATE;// 34 基准利率
	private String FLOAT_RATIO;// 35 浮动比例
	private String FLOAT_SPREAD_RATE;// 36 浮动点差
	private String INT_RATE_TYPE_CD;// 37 利率类型代码
	private String BANK_INT_REF_INT_RATE;// 38 行内参考利率
	private String REF_INT_RATE_FLOAT_RATIO;// 39 参考利率浮动比例
	private String REF_INT_RATE_FLOAT_SPREAD_RATE;// 40 参考利率浮动点差
	private String YEAR_DPSIT_ACCUM;// 41 年存款积数
	private String QUAR_DPSIT_ACCUM;// 42季存款积数
	private String MONTH_DPSIT_ACCUM;// 43 月存款积数
	private String YEAR_DAYAVG_BAL;// 44 年日均余额
	private String QUAR_DAYAVG_BAL;// 45 季日均余额
	private String MONTH_DAYAVG_BAL;// 46 月日均余额
	private String CURR_YEAR_ACTL_PAY_INT;// 47当年实付利息
	private String INT_EXPNS;// 48 利息支出
	private String ACTL_PAY_INT;// 49 实付利息
	private String CURR_BAL_DISCNT_RMB;// 50当前余额折人民币
	private String ACCRUED_INT_DISCNT_RMB;// 51 应计利息折人民币
	private String CURR_YEAR_ACTL_PAY_INT_DISCNT_RMB;// 52 当年实付利息折人民币
	private String INT_EXPNS_DISCNT_RMB;// 53利息支出折人民币
	private String ACTL_PAY_INT_DISCNT_RMB;// 54 实付利息折人民币
	private String COLLBL_PAYBL_INT_REMAIN_TERM;// 55 应收应付息剩余期限
	private String INT_RATE_CALC_RULE_CD;// 56 利率计算规则代码
	private String TODAY_PAYBL_INT;// 57 当日应付利息
	private String TODAY_PAYBL_AGT_INT;// 58 当日应付协定利息
	private String PAYBL_AGT_INT;// 59 应付协定利息
	private String PAYBL_AGT_INT_DISCNT_RMB;// 60 应付协定利息折人民币
	private String ACTL_PAY_AGT_INT;// 61 实付协定利息
	private String TODAY_PAYBL_INT_DISCNT_RMB;// 62 当日应付利息折人民币
	private String TODAY_PAYBL_AGT_INT_DISCNT_RMB;// 63 当日应付协定利息折人民币
	private String ACTL_PAY_AGT_INT_DISCNT_RMB;// 64实付协定利息折人民币
	private String RESV_IND;// 65 备付金标志
	private String RESV_ACCT_CHAR_CD;// 66 备付金账户性质代码
	private String RESV_ACCT_TYPE_CD;// 67 备付金账户种类代码
	private String RESV_SIGN_DT;// 68备付金签订日期
	private String CORP_SINGLE_ACCT_IND;// 69 是否对公一户通标志

	private String ACCT_NAME;// 70 账户名称
    */
	
	
	
	
	

}
