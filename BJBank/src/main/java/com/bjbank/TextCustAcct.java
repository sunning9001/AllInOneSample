package com.bjbank;

public class TextCustAcct {
	@TextIndex(index = 0)
	private String AGT_NUM;// 1 协议编号(PK)
	@TextIndex(index = 1)
	private String AGT_MODIF_NUM;// 2 协议修饰符(PK)
	@TextIndex(index = 2)
	private String DATA_DT;// 3 数据日期(PK)
	@TextIndex(index = 3)
	private String CUST_NUM;// 4 客户号
	@TextIndex(index = 4)
	private String BELONG_ORG_NUM;// 5 所属机构号
	@TextIndex(index = 5)
	private String GL_NUM;// 6 科目号
	@TextIndex(index = 6)
	private String CURR_CD;// 7 货币代码
	@TextIndex(index = 7)
	private String AGT_STATUS_CD;// 8 协议状态代码
	@TextIndex(index = 8)
	private String CALC_INT_TYPE_CD;// 9 计息种类代码
	@TextIndex(index = 9)
	private String STL_INT_MODE_CD;// 10 结息方式代码
	@TextIndex(index = 10)
	private String DPSIT_TERM_PERIOD_TYPE_CD;// 11 存款期限周期种类代码
	@TextIndex(index = 11)
	private String DPSIT_TERM;// 12 存款期限
	@TextIndex(index = 12)
	private String ACCT_CHAR_CD;// 13账户性质代码
	@TextIndex(index = 13)
	private String OPEN_DT;// 14 开户日期
	@TextIndex(index = 14)
	private String CLOSE_DT;// 15 销户日期
	@TextIndex(index = 15)
	private String START_INT_DT;// 16 起息日期
	@TextIndex(index = 16)
	private String MATURE_DT;// 17 到期日期
	@TextIndex(index = 17)
	private String NEXT_RESET_PRICE_DT;// 18 下次重定价日期
	@TextIndex(index = 18)
	private String INT_RATE_PERIOD_TYPE_CD;// 19 利率周期种类代码
	@TextIndex(index = 19)
	private String INT_RATE_UNIT_CD;// 20 利率单位代码
	@TextIndex(index = 20)
	private String EXEC_INT_RATE;// 21执行利率
	@TextIndex(index = 21)
	private String CURR_BAL_DIR_CD;// 22 当前余额方向代码
	@TextIndex(index = 22)
	private String CURR_BAL;// 23 当前余额
	@TextIndex(index = 23)
	private String ACCRUED_INT;// 24 应计利息
	@TextIndex(index = 24)
	private String CUST_NAME;// 25 客户名称
	@TextIndex(index = 25)
	private String NEXT_PAY_INT_DT;// 26 下次付息日期
	@TextIndex(index = 26)
	private String TIME_TRAN_DPSIT_IND;// 27 定期转存标志
	@TextIndex(index = 27)
	private String INT_RATE_ATTR_CD;// 28 利率属性代码
	@TextIndex(index = 28)
	private String RESET_PRICE_FREQ_CD;// 29 重定价频次代码
	@TextIndex(index = 29)
	private String ACTL_MATURE_DT;// 30 实际到期日期
	@TextIndex(index = 30)
	private String ORG_ORG_CD;// 31 组织机构代码
	@TextIndex(index = 31)
	private String NEW_CORP_SIZE_CD;// 32 新企业规模代码
	@TextIndex(index = 32)
	private String PROD_NUM;// 33 产品编号
	@TextIndex(index = 33)
	private String BASE_INT_RATE;// 34 基准利率
	@TextIndex(index = 34)
	private String FLOAT_RATIO;// 35 浮动比例
	@TextIndex(index = 35)
	private String FLOAT_SPREAD_RATE;// 36 浮动点差
	@TextIndex(index = 36)
	private String INT_RATE_TYPE_CD;// 37 利率类型代码
	@TextIndex(index = 37)
	private String BANK_INT_REF_INT_RATE;// 38 行内参考利率
	@TextIndex(index = 38)
	private String REF_INT_RATE_FLOAT_RATIO;// 39 参考利率浮动比例
	@TextIndex(index = 39)
	private String REF_INT_RATE_FLOAT_SPREAD_RATE;// 40 参考利率浮动点差
	@TextIndex(index = 40)
	private String YEAR_DPSIT_ACCUM;// 41 年存款积数
	@TextIndex(index = 41)
	private String QUAR_DPSIT_ACCUM;// 42季存款积数
	@TextIndex(index = 42)
	private String MONTH_DPSIT_ACCUM;// 43 月存款积数
	@TextIndex(index = 43)
	private String YEAR_DAYAVG_BAL;// 44 年日均余额
	@TextIndex(index = 44)
	private String QUAR_DAYAVG_BAL;// 45 季日均余额
	@TextIndex(index = 45)
	private String MONTH_DAYAVG_BAL;// 46 月日均余额
	@TextIndex(index = 46)
	private String CURR_YEAR_ACTL_PAY_INT;// 47当年实付利息
	@TextIndex(index = 47)
	private String INT_EXPNS;// 48 利息支出
	@TextIndex(index = 48)
	private String ACTL_PAY_INT;// 49 实付利息
	@TextIndex(index = 49)
	private String CURR_BAL_DISCNT_RMB;// 50当前余额折人民币
	@TextIndex(index = 50)
	private String ACCRUED_INT_DISCNT_RMB;// 51 应计利息折人民币
	@TextIndex(index = 51)
	private String CURR_YEAR_ACTL_PAY_INT_DISCNT_RMB;// 52 当年实付利息折人民币
	@TextIndex(index = 52)
	private String INT_EXPNS_DISCNT_RMB;// 53利息支出折人民币
	@TextIndex(index = 53)
	private String ACTL_PAY_INT_DISCNT_RMB;// 54 实付利息折人民币
	@TextIndex(index = 54)
	private String COLLBL_PAYBL_INT_REMAIN_TERM;// 55 应收应付息剩余期限
	@TextIndex(index = 55)
	private String INT_RATE_CALC_RULE_CD;// 56 利率计算规则代码
	@TextIndex(index = 56)
	private String TODAY_PAYBL_INT;// 57 当日应付利息
	@TextIndex(index = 57)
	private String TODAY_PAYBL_AGT_INT;// 58 当日应付协定利息
	@TextIndex(index = 58)
	private String PAYBL_AGT_INT;// 59 应付协定利息
	@TextIndex(index = 59)
	private String PAYBL_AGT_INT_DISCNT_RMB;// 60 应付协定利息折人民币
	@TextIndex(index = 60)
	private String ACTL_PAY_AGT_INT;// 61 实付协定利息
	@TextIndex(index = 61)
	private String TODAY_PAYBL_INT_DISCNT_RMB;// 62 当日应付利息折人民币
	@TextIndex(index = 62)
	private String TODAY_PAYBL_AGT_INT_DISCNT_RMB;// 63 当日应付协定利息折人民币
	@TextIndex(index = 63)
	private String ACTL_PAY_AGT_INT_DISCNT_RMB;// 64实付协定利息折人民币
	@TextIndex(index = 64)
	private String RESV_IND;// 65 备付金标志
	@TextIndex(index = 65)
	private String RESV_ACCT_CHAR_CD;// 66 备付金账户性质代码
	@TextIndex(index = 66)
	private String RESV_ACCT_TYPE_CD;// 67 备付金账户种类代码
	@TextIndex(index = 67)
	private String RESV_SIGN_DT;// 68备付金签订日期
	@TextIndex(index = 68)
	private String CORP_SINGLE_ACCT_IND;// 69 是否对公一户通标志
	@TextIndex(index = 69)
	private String ACCT_NAME;// 70 账户名称
	public String getAGT_NUM() {
		return AGT_NUM;
	}
	public void setAGT_NUM(String aGT_NUM) {
		AGT_NUM = aGT_NUM;
	}
	public String getAGT_MODIF_NUM() {
		return AGT_MODIF_NUM;
	}
	public void setAGT_MODIF_NUM(String aGT_MODIF_NUM) {
		AGT_MODIF_NUM = aGT_MODIF_NUM;
	}
	public String getDATA_DT() {
		return DATA_DT;
	}
	public void setDATA_DT(String dATA_DT) {
		DATA_DT = dATA_DT;
	}
	public String getCUST_NUM() {
		return CUST_NUM;
	}
	public void setCUST_NUM(String cUST_NUM) {
		CUST_NUM = cUST_NUM;
	}
	public String getBELONG_ORG_NUM() {
		return BELONG_ORG_NUM;
	}
	public void setBELONG_ORG_NUM(String bELONG_ORG_NUM) {
		BELONG_ORG_NUM = bELONG_ORG_NUM;
	}
	public String getGL_NUM() {
		return GL_NUM;
	}
	public void setGL_NUM(String gL_NUM) {
		GL_NUM = gL_NUM;
	}
	public String getCURR_CD() {
		return CURR_CD;
	}
	public void setCURR_CD(String cURR_CD) {
		CURR_CD = cURR_CD;
	}
	public String getAGT_STATUS_CD() {
		return AGT_STATUS_CD;
	}
	public void setAGT_STATUS_CD(String aGT_STATUS_CD) {
		AGT_STATUS_CD = aGT_STATUS_CD;
	}
	public String getCALC_INT_TYPE_CD() {
		return CALC_INT_TYPE_CD;
	}
	public void setCALC_INT_TYPE_CD(String cALC_INT_TYPE_CD) {
		CALC_INT_TYPE_CD = cALC_INT_TYPE_CD;
	}
	public String getSTL_INT_MODE_CD() {
		return STL_INT_MODE_CD;
	}
	public void setSTL_INT_MODE_CD(String sTL_INT_MODE_CD) {
		STL_INT_MODE_CD = sTL_INT_MODE_CD;
	}
	public String getDPSIT_TERM_PERIOD_TYPE_CD() {
		return DPSIT_TERM_PERIOD_TYPE_CD;
	}
	public void setDPSIT_TERM_PERIOD_TYPE_CD(String dPSIT_TERM_PERIOD_TYPE_CD) {
		DPSIT_TERM_PERIOD_TYPE_CD = dPSIT_TERM_PERIOD_TYPE_CD;
	}
	public String getDPSIT_TERM() {
		return DPSIT_TERM;
	}
	public void setDPSIT_TERM(String dPSIT_TERM) {
		DPSIT_TERM = dPSIT_TERM;
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
	public String getCLOSE_DT() {
		return CLOSE_DT;
	}
	public void setCLOSE_DT(String cLOSE_DT) {
		CLOSE_DT = cLOSE_DT;
	}
	public String getSTART_INT_DT() {
		return START_INT_DT;
	}
	public void setSTART_INT_DT(String sTART_INT_DT) {
		START_INT_DT = sTART_INT_DT;
	}
	public String getMATURE_DT() {
		return MATURE_DT;
	}
	public void setMATURE_DT(String mATURE_DT) {
		MATURE_DT = mATURE_DT;
	}
	public String getNEXT_RESET_PRICE_DT() {
		return NEXT_RESET_PRICE_DT;
	}
	public void setNEXT_RESET_PRICE_DT(String nEXT_RESET_PRICE_DT) {
		NEXT_RESET_PRICE_DT = nEXT_RESET_PRICE_DT;
	}
	public String getINT_RATE_PERIOD_TYPE_CD() {
		return INT_RATE_PERIOD_TYPE_CD;
	}
	public void setINT_RATE_PERIOD_TYPE_CD(String iNT_RATE_PERIOD_TYPE_CD) {
		INT_RATE_PERIOD_TYPE_CD = iNT_RATE_PERIOD_TYPE_CD;
	}
	public String getINT_RATE_UNIT_CD() {
		return INT_RATE_UNIT_CD;
	}
	public void setINT_RATE_UNIT_CD(String iNT_RATE_UNIT_CD) {
		INT_RATE_UNIT_CD = iNT_RATE_UNIT_CD;
	}
	public String getEXEC_INT_RATE() {
		return EXEC_INT_RATE;
	}
	public void setEXEC_INT_RATE(String eXEC_INT_RATE) {
		EXEC_INT_RATE = eXEC_INT_RATE;
	}
	public String getCURR_BAL_DIR_CD() {
		return CURR_BAL_DIR_CD;
	}
	public void setCURR_BAL_DIR_CD(String cURR_BAL_DIR_CD) {
		CURR_BAL_DIR_CD = cURR_BAL_DIR_CD;
	}
	public String getCURR_BAL() {
		return CURR_BAL;
	}
	public void setCURR_BAL(String cURR_BAL) {
		CURR_BAL = cURR_BAL;
	}
	public String getACCRUED_INT() {
		return ACCRUED_INT;
	}
	public void setACCRUED_INT(String aCCRUED_INT) {
		ACCRUED_INT = aCCRUED_INT;
	}
	public String getCUST_NAME() {
		return CUST_NAME;
	}
	public void setCUST_NAME(String cUST_NAME) {
		CUST_NAME = cUST_NAME;
	}
	public String getNEXT_PAY_INT_DT() {
		return NEXT_PAY_INT_DT;
	}
	public void setNEXT_PAY_INT_DT(String nEXT_PAY_INT_DT) {
		NEXT_PAY_INT_DT = nEXT_PAY_INT_DT;
	}
	public String getTIME_TRAN_DPSIT_IND() {
		return TIME_TRAN_DPSIT_IND;
	}
	public void setTIME_TRAN_DPSIT_IND(String tIME_TRAN_DPSIT_IND) {
		TIME_TRAN_DPSIT_IND = tIME_TRAN_DPSIT_IND;
	}
	public String getINT_RATE_ATTR_CD() {
		return INT_RATE_ATTR_CD;
	}
	public void setINT_RATE_ATTR_CD(String iNT_RATE_ATTR_CD) {
		INT_RATE_ATTR_CD = iNT_RATE_ATTR_CD;
	}
	public String getRESET_PRICE_FREQ_CD() {
		return RESET_PRICE_FREQ_CD;
	}
	public void setRESET_PRICE_FREQ_CD(String rESET_PRICE_FREQ_CD) {
		RESET_PRICE_FREQ_CD = rESET_PRICE_FREQ_CD;
	}
	public String getACTL_MATURE_DT() {
		return ACTL_MATURE_DT;
	}
	public void setACTL_MATURE_DT(String aCTL_MATURE_DT) {
		ACTL_MATURE_DT = aCTL_MATURE_DT;
	}
	public String getORG_ORG_CD() {
		return ORG_ORG_CD;
	}
	public void setORG_ORG_CD(String oRG_ORG_CD) {
		ORG_ORG_CD = oRG_ORG_CD;
	}
	public String getNEW_CORP_SIZE_CD() {
		return NEW_CORP_SIZE_CD;
	}
	public void setNEW_CORP_SIZE_CD(String nEW_CORP_SIZE_CD) {
		NEW_CORP_SIZE_CD = nEW_CORP_SIZE_CD;
	}
	public String getPROD_NUM() {
		return PROD_NUM;
	}
	public void setPROD_NUM(String pROD_NUM) {
		PROD_NUM = pROD_NUM;
	}
	public String getBASE_INT_RATE() {
		return BASE_INT_RATE;
	}
	public void setBASE_INT_RATE(String bASE_INT_RATE) {
		BASE_INT_RATE = bASE_INT_RATE;
	}
	public String getFLOAT_RATIO() {
		return FLOAT_RATIO;
	}
	public void setFLOAT_RATIO(String fLOAT_RATIO) {
		FLOAT_RATIO = fLOAT_RATIO;
	}
	public String getFLOAT_SPREAD_RATE() {
		return FLOAT_SPREAD_RATE;
	}
	public void setFLOAT_SPREAD_RATE(String fLOAT_SPREAD_RATE) {
		FLOAT_SPREAD_RATE = fLOAT_SPREAD_RATE;
	}
	public String getINT_RATE_TYPE_CD() {
		return INT_RATE_TYPE_CD;
	}
	public void setINT_RATE_TYPE_CD(String iNT_RATE_TYPE_CD) {
		INT_RATE_TYPE_CD = iNT_RATE_TYPE_CD;
	}
	public String getBANK_INT_REF_INT_RATE() {
		return BANK_INT_REF_INT_RATE;
	}
	public void setBANK_INT_REF_INT_RATE(String bANK_INT_REF_INT_RATE) {
		BANK_INT_REF_INT_RATE = bANK_INT_REF_INT_RATE;
	}
	public String getREF_INT_RATE_FLOAT_RATIO() {
		return REF_INT_RATE_FLOAT_RATIO;
	}
	public void setREF_INT_RATE_FLOAT_RATIO(String rEF_INT_RATE_FLOAT_RATIO) {
		REF_INT_RATE_FLOAT_RATIO = rEF_INT_RATE_FLOAT_RATIO;
	}
	public String getREF_INT_RATE_FLOAT_SPREAD_RATE() {
		return REF_INT_RATE_FLOAT_SPREAD_RATE;
	}
	public void setREF_INT_RATE_FLOAT_SPREAD_RATE(String rEF_INT_RATE_FLOAT_SPREAD_RATE) {
		REF_INT_RATE_FLOAT_SPREAD_RATE = rEF_INT_RATE_FLOAT_SPREAD_RATE;
	}
	public String getYEAR_DPSIT_ACCUM() {
		return YEAR_DPSIT_ACCUM;
	}
	public void setYEAR_DPSIT_ACCUM(String yEAR_DPSIT_ACCUM) {
		YEAR_DPSIT_ACCUM = yEAR_DPSIT_ACCUM;
	}
	public String getQUAR_DPSIT_ACCUM() {
		return QUAR_DPSIT_ACCUM;
	}
	public void setQUAR_DPSIT_ACCUM(String qUAR_DPSIT_ACCUM) {
		QUAR_DPSIT_ACCUM = qUAR_DPSIT_ACCUM;
	}
	public String getMONTH_DPSIT_ACCUM() {
		return MONTH_DPSIT_ACCUM;
	}
	public void setMONTH_DPSIT_ACCUM(String mONTH_DPSIT_ACCUM) {
		MONTH_DPSIT_ACCUM = mONTH_DPSIT_ACCUM;
	}
	public String getYEAR_DAYAVG_BAL() {
		return YEAR_DAYAVG_BAL;
	}
	public void setYEAR_DAYAVG_BAL(String yEAR_DAYAVG_BAL) {
		YEAR_DAYAVG_BAL = yEAR_DAYAVG_BAL;
	}
	public String getQUAR_DAYAVG_BAL() {
		return QUAR_DAYAVG_BAL;
	}
	public void setQUAR_DAYAVG_BAL(String qUAR_DAYAVG_BAL) {
		QUAR_DAYAVG_BAL = qUAR_DAYAVG_BAL;
	}
	public String getMONTH_DAYAVG_BAL() {
		return MONTH_DAYAVG_BAL;
	}
	public void setMONTH_DAYAVG_BAL(String mONTH_DAYAVG_BAL) {
		MONTH_DAYAVG_BAL = mONTH_DAYAVG_BAL;
	}
	public String getCURR_YEAR_ACTL_PAY_INT() {
		return CURR_YEAR_ACTL_PAY_INT;
	}
	public void setCURR_YEAR_ACTL_PAY_INT(String cURR_YEAR_ACTL_PAY_INT) {
		CURR_YEAR_ACTL_PAY_INT = cURR_YEAR_ACTL_PAY_INT;
	}
	public String getINT_EXPNS() {
		return INT_EXPNS;
	}
	public void setINT_EXPNS(String iNT_EXPNS) {
		INT_EXPNS = iNT_EXPNS;
	}
	public String getACTL_PAY_INT() {
		return ACTL_PAY_INT;
	}
	public void setACTL_PAY_INT(String aCTL_PAY_INT) {
		ACTL_PAY_INT = aCTL_PAY_INT;
	}
	public String getCURR_BAL_DISCNT_RMB() {
		return CURR_BAL_DISCNT_RMB;
	}
	public void setCURR_BAL_DISCNT_RMB(String cURR_BAL_DISCNT_RMB) {
		CURR_BAL_DISCNT_RMB = cURR_BAL_DISCNT_RMB;
	}
	public String getACCRUED_INT_DISCNT_RMB() {
		return ACCRUED_INT_DISCNT_RMB;
	}
	public void setACCRUED_INT_DISCNT_RMB(String aCCRUED_INT_DISCNT_RMB) {
		ACCRUED_INT_DISCNT_RMB = aCCRUED_INT_DISCNT_RMB;
	}
	public String getCURR_YEAR_ACTL_PAY_INT_DISCNT_RMB() {
		return CURR_YEAR_ACTL_PAY_INT_DISCNT_RMB;
	}
	public void setCURR_YEAR_ACTL_PAY_INT_DISCNT_RMB(String cURR_YEAR_ACTL_PAY_INT_DISCNT_RMB) {
		CURR_YEAR_ACTL_PAY_INT_DISCNT_RMB = cURR_YEAR_ACTL_PAY_INT_DISCNT_RMB;
	}
	public String getINT_EXPNS_DISCNT_RMB() {
		return INT_EXPNS_DISCNT_RMB;
	}
	public void setINT_EXPNS_DISCNT_RMB(String iNT_EXPNS_DISCNT_RMB) {
		INT_EXPNS_DISCNT_RMB = iNT_EXPNS_DISCNT_RMB;
	}
	public String getACTL_PAY_INT_DISCNT_RMB() {
		return ACTL_PAY_INT_DISCNT_RMB;
	}
	public void setACTL_PAY_INT_DISCNT_RMB(String aCTL_PAY_INT_DISCNT_RMB) {
		ACTL_PAY_INT_DISCNT_RMB = aCTL_PAY_INT_DISCNT_RMB;
	}
	public String getCOLLBL_PAYBL_INT_REMAIN_TERM() {
		return COLLBL_PAYBL_INT_REMAIN_TERM;
	}
	public void setCOLLBL_PAYBL_INT_REMAIN_TERM(String cOLLBL_PAYBL_INT_REMAIN_TERM) {
		COLLBL_PAYBL_INT_REMAIN_TERM = cOLLBL_PAYBL_INT_REMAIN_TERM;
	}
	public String getINT_RATE_CALC_RULE_CD() {
		return INT_RATE_CALC_RULE_CD;
	}
	public void setINT_RATE_CALC_RULE_CD(String iNT_RATE_CALC_RULE_CD) {
		INT_RATE_CALC_RULE_CD = iNT_RATE_CALC_RULE_CD;
	}
	public String getTODAY_PAYBL_INT() {
		return TODAY_PAYBL_INT;
	}
	public void setTODAY_PAYBL_INT(String tODAY_PAYBL_INT) {
		TODAY_PAYBL_INT = tODAY_PAYBL_INT;
	}
	public String getTODAY_PAYBL_AGT_INT() {
		return TODAY_PAYBL_AGT_INT;
	}
	public void setTODAY_PAYBL_AGT_INT(String tODAY_PAYBL_AGT_INT) {
		TODAY_PAYBL_AGT_INT = tODAY_PAYBL_AGT_INT;
	}
	public String getPAYBL_AGT_INT() {
		return PAYBL_AGT_INT;
	}
	public void setPAYBL_AGT_INT(String pAYBL_AGT_INT) {
		PAYBL_AGT_INT = pAYBL_AGT_INT;
	}
	public String getPAYBL_AGT_INT_DISCNT_RMB() {
		return PAYBL_AGT_INT_DISCNT_RMB;
	}
	public void setPAYBL_AGT_INT_DISCNT_RMB(String pAYBL_AGT_INT_DISCNT_RMB) {
		PAYBL_AGT_INT_DISCNT_RMB = pAYBL_AGT_INT_DISCNT_RMB;
	}
	public String getACTL_PAY_AGT_INT() {
		return ACTL_PAY_AGT_INT;
	}
	public void setACTL_PAY_AGT_INT(String aCTL_PAY_AGT_INT) {
		ACTL_PAY_AGT_INT = aCTL_PAY_AGT_INT;
	}
	public String getTODAY_PAYBL_INT_DISCNT_RMB() {
		return TODAY_PAYBL_INT_DISCNT_RMB;
	}
	public void setTODAY_PAYBL_INT_DISCNT_RMB(String tODAY_PAYBL_INT_DISCNT_RMB) {
		TODAY_PAYBL_INT_DISCNT_RMB = tODAY_PAYBL_INT_DISCNT_RMB;
	}
	public String getTODAY_PAYBL_AGT_INT_DISCNT_RMB() {
		return TODAY_PAYBL_AGT_INT_DISCNT_RMB;
	}
	public void setTODAY_PAYBL_AGT_INT_DISCNT_RMB(String tODAY_PAYBL_AGT_INT_DISCNT_RMB) {
		TODAY_PAYBL_AGT_INT_DISCNT_RMB = tODAY_PAYBL_AGT_INT_DISCNT_RMB;
	}
	public String getACTL_PAY_AGT_INT_DISCNT_RMB() {
		return ACTL_PAY_AGT_INT_DISCNT_RMB;
	}
	public void setACTL_PAY_AGT_INT_DISCNT_RMB(String aCTL_PAY_AGT_INT_DISCNT_RMB) {
		ACTL_PAY_AGT_INT_DISCNT_RMB = aCTL_PAY_AGT_INT_DISCNT_RMB;
	}
	public String getRESV_IND() {
		return RESV_IND;
	}
	public void setRESV_IND(String rESV_IND) {
		RESV_IND = rESV_IND;
	}
	public String getRESV_ACCT_CHAR_CD() {
		return RESV_ACCT_CHAR_CD;
	}
	public void setRESV_ACCT_CHAR_CD(String rESV_ACCT_CHAR_CD) {
		RESV_ACCT_CHAR_CD = rESV_ACCT_CHAR_CD;
	}
	public String getRESV_ACCT_TYPE_CD() {
		return RESV_ACCT_TYPE_CD;
	}
	public void setRESV_ACCT_TYPE_CD(String rESV_ACCT_TYPE_CD) {
		RESV_ACCT_TYPE_CD = rESV_ACCT_TYPE_CD;
	}
	public String getRESV_SIGN_DT() {
		return RESV_SIGN_DT;
	}
	public void setRESV_SIGN_DT(String rESV_SIGN_DT) {
		RESV_SIGN_DT = rESV_SIGN_DT;
	}
	public String getCORP_SINGLE_ACCT_IND() {
		return CORP_SINGLE_ACCT_IND;
	}
	public void setCORP_SINGLE_ACCT_IND(String cORP_SINGLE_ACCT_IND) {
		CORP_SINGLE_ACCT_IND = cORP_SINGLE_ACCT_IND;
	}
	public String getACCT_NAME() {
		return ACCT_NAME;
	}
	public void setACCT_NAME(String aCCT_NAME) {
		ACCT_NAME = aCCT_NAME;
	}
	@Override
	public String toString() {
		return "TextCustAcct [AGT_NUM=" + AGT_NUM + ", AGT_MODIF_NUM=" + AGT_MODIF_NUM + ", DATA_DT=" + DATA_DT
				+ ", CUST_NUM=" + CUST_NUM + ", BELONG_ORG_NUM=" + BELONG_ORG_NUM + ", GL_NUM=" + GL_NUM + ", CURR_CD="
				+ CURR_CD + ", AGT_STATUS_CD=" + AGT_STATUS_CD + ", CALC_INT_TYPE_CD=" + CALC_INT_TYPE_CD
				+ ", STL_INT_MODE_CD=" + STL_INT_MODE_CD + ", DPSIT_TERM_PERIOD_TYPE_CD=" + DPSIT_TERM_PERIOD_TYPE_CD
				+ ", DPSIT_TERM=" + DPSIT_TERM + ", ACCT_CHAR_CD=" + ACCT_CHAR_CD + ", OPEN_DT=" + OPEN_DT
				+ ", CLOSE_DT=" + CLOSE_DT + ", START_INT_DT=" + START_INT_DT + ", MATURE_DT=" + MATURE_DT
				+ ", NEXT_RESET_PRICE_DT=" + NEXT_RESET_PRICE_DT + ", INT_RATE_PERIOD_TYPE_CD="
				+ INT_RATE_PERIOD_TYPE_CD + ", INT_RATE_UNIT_CD=" + INT_RATE_UNIT_CD + ", EXEC_INT_RATE="
				+ EXEC_INT_RATE + ", CURR_BAL_DIR_CD=" + CURR_BAL_DIR_CD + ", CURR_BAL=" + CURR_BAL + ", ACCRUED_INT="
				+ ACCRUED_INT + ", CUST_NAME=" + CUST_NAME + ", NEXT_PAY_INT_DT=" + NEXT_PAY_INT_DT
				+ ", TIME_TRAN_DPSIT_IND=" + TIME_TRAN_DPSIT_IND + ", INT_RATE_ATTR_CD=" + INT_RATE_ATTR_CD
				+ ", RESET_PRICE_FREQ_CD=" + RESET_PRICE_FREQ_CD + ", ACTL_MATURE_DT=" + ACTL_MATURE_DT
				+ ", ORG_ORG_CD=" + ORG_ORG_CD + ", NEW_CORP_SIZE_CD=" + NEW_CORP_SIZE_CD + ", PROD_NUM=" + PROD_NUM
				+ ", BASE_INT_RATE=" + BASE_INT_RATE + ", FLOAT_RATIO=" + FLOAT_RATIO + ", FLOAT_SPREAD_RATE="
				+ FLOAT_SPREAD_RATE + ", INT_RATE_TYPE_CD=" + INT_RATE_TYPE_CD + ", BANK_INT_REF_INT_RATE="
				+ BANK_INT_REF_INT_RATE + ", REF_INT_RATE_FLOAT_RATIO=" + REF_INT_RATE_FLOAT_RATIO
				+ ", REF_INT_RATE_FLOAT_SPREAD_RATE=" + REF_INT_RATE_FLOAT_SPREAD_RATE + ", YEAR_DPSIT_ACCUM="
				+ YEAR_DPSIT_ACCUM + ", QUAR_DPSIT_ACCUM=" + QUAR_DPSIT_ACCUM + ", MONTH_DPSIT_ACCUM="
				+ MONTH_DPSIT_ACCUM + ", YEAR_DAYAVG_BAL=" + YEAR_DAYAVG_BAL + ", QUAR_DAYAVG_BAL=" + QUAR_DAYAVG_BAL
				+ ", MONTH_DAYAVG_BAL=" + MONTH_DAYAVG_BAL + ", CURR_YEAR_ACTL_PAY_INT=" + CURR_YEAR_ACTL_PAY_INT
				+ ", INT_EXPNS=" + INT_EXPNS + ", ACTL_PAY_INT=" + ACTL_PAY_INT + ", CURR_BAL_DISCNT_RMB="
				+ CURR_BAL_DISCNT_RMB + ", ACCRUED_INT_DISCNT_RMB=" + ACCRUED_INT_DISCNT_RMB
				+ ", CURR_YEAR_ACTL_PAY_INT_DISCNT_RMB=" + CURR_YEAR_ACTL_PAY_INT_DISCNT_RMB + ", INT_EXPNS_DISCNT_RMB="
				+ INT_EXPNS_DISCNT_RMB + ", ACTL_PAY_INT_DISCNT_RMB=" + ACTL_PAY_INT_DISCNT_RMB
				+ ", COLLBL_PAYBL_INT_REMAIN_TERM=" + COLLBL_PAYBL_INT_REMAIN_TERM + ", INT_RATE_CALC_RULE_CD="
				+ INT_RATE_CALC_RULE_CD + ", TODAY_PAYBL_INT=" + TODAY_PAYBL_INT + ", TODAY_PAYBL_AGT_INT="
				+ TODAY_PAYBL_AGT_INT + ", PAYBL_AGT_INT=" + PAYBL_AGT_INT + ", PAYBL_AGT_INT_DISCNT_RMB="
				+ PAYBL_AGT_INT_DISCNT_RMB + ", ACTL_PAY_AGT_INT=" + ACTL_PAY_AGT_INT + ", TODAY_PAYBL_INT_DISCNT_RMB="
				+ TODAY_PAYBL_INT_DISCNT_RMB + ", TODAY_PAYBL_AGT_INT_DISCNT_RMB=" + TODAY_PAYBL_AGT_INT_DISCNT_RMB
				+ ", ACTL_PAY_AGT_INT_DISCNT_RMB=" + ACTL_PAY_AGT_INT_DISCNT_RMB + ", RESV_IND=" + RESV_IND
				+ ", RESV_ACCT_CHAR_CD=" + RESV_ACCT_CHAR_CD + ", RESV_ACCT_TYPE_CD=" + RESV_ACCT_TYPE_CD
				+ ", RESV_SIGN_DT=" + RESV_SIGN_DT + ", CORP_SINGLE_ACCT_IND=" + CORP_SINGLE_ACCT_IND + ", ACCT_NAME="
				+ ACCT_NAME + "]";
	}
	
	

}
