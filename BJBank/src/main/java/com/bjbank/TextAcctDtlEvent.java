package com.bjbank;
/**
 * 对应WX_CORP_CUST_ACCT_DTL_EVENT	对公客户账明细事件	增量	流水表	每天	无

 * @author sunning
 *
 */
public class TextAcctDtlEvent {

	@TextIndex(index = 0)
	private String EVENT_ID;// 1 事件编号
	@TextIndex(index = 1)
	private String ACCT_AGT_NUM;// 2 账号协议编号
	@TextIndex(index = 2)
	private String BOOKENTRY_DT;// 3 记账日期
	@TextIndex(index = 3)
	private String BOOK_ENTRY_TIME;// 4记账时间
	@TextIndex(index = 4)
	private String CNTPTY_ACCT;// 5对手账号
	@TextIndex(index = 5)
	private String CNTPTY_USER_NAME;// 6 对手户名
	@TextIndex(index = 6)
	private String CORP_MEMO_CD;// 7对公摘要代码
	@TextIndex(index = 7)
	private String CORP_MEMO_DESC;// 8 对公摘要描述
	@TextIndex(index = 8)
	private String DEBIT_CRDT_DIR_CD;// 9借贷方向代码
	@TextIndex(index = 9)
	private String DEBIT_CRDT_DIR_DESC;// 10借贷方向描述
	@TextIndex(index = 10)
	private String EVENT_AMT;// 11事件金额
	@TextIndex(index = 11)
	private String ACCT_BAL;// 12账户余额
	public String getEVENT_ID() {
		return EVENT_ID;
	}
	public void setEVENT_ID(String eVENT_ID) {
		EVENT_ID = eVENT_ID;
	}
	public String getACCT_AGT_NUM() {
		return ACCT_AGT_NUM;
	}
	public void setACCT_AGT_NUM(String aCCT_AGT_NUM) {
		ACCT_AGT_NUM = aCCT_AGT_NUM;
	}
	public String getBOOKENTRY_DT() {
		return BOOKENTRY_DT;
	}
	public void setBOOKENTRY_DT(String bOOKENTRY_DT) {
		BOOKENTRY_DT = bOOKENTRY_DT;
	}
	public String getBOOK_ENTRY_TIME() {
		return BOOK_ENTRY_TIME;
	}
	public void setBOOK_ENTRY_TIME(String bOOK_ENTRY_TIME) {
		BOOK_ENTRY_TIME = bOOK_ENTRY_TIME;
	}
	public String getCNTPTY_ACCT() {
		return CNTPTY_ACCT;
	}
	public void setCNTPTY_ACCT(String cNTPTY_ACCT) {
		CNTPTY_ACCT = cNTPTY_ACCT;
	}
	public String getCNTPTY_USER_NAME() {
		return CNTPTY_USER_NAME;
	}
	public void setCNTPTY_USER_NAME(String cNTPTY_USER_NAME) {
		CNTPTY_USER_NAME = cNTPTY_USER_NAME;
	}
	public String getCORP_MEMO_CD() {
		return CORP_MEMO_CD;
	}
	public void setCORP_MEMO_CD(String cORP_MEMO_CD) {
		CORP_MEMO_CD = cORP_MEMO_CD;
	}
	public String getCORP_MEMO_DESC() {
		return CORP_MEMO_DESC;
	}
	public void setCORP_MEMO_DESC(String cORP_MEMO_DESC) {
		CORP_MEMO_DESC = cORP_MEMO_DESC;
	}
	public String getDEBIT_CRDT_DIR_CD() {
		return DEBIT_CRDT_DIR_CD;
	}
	public void setDEBIT_CRDT_DIR_CD(String dEBIT_CRDT_DIR_CD) {
		DEBIT_CRDT_DIR_CD = dEBIT_CRDT_DIR_CD;
	}
	public String getDEBIT_CRDT_DIR_DESC() {
		return DEBIT_CRDT_DIR_DESC;
	}
	public void setDEBIT_CRDT_DIR_DESC(String dEBIT_CRDT_DIR_DESC) {
		DEBIT_CRDT_DIR_DESC = dEBIT_CRDT_DIR_DESC;
	}
	public String getEVENT_AMT() {
		return EVENT_AMT;
	}
	public void setEVENT_AMT(String eVENT_AMT) {
		EVENT_AMT = eVENT_AMT;
	}
	public String getACCT_BAL() {
		return ACCT_BAL;
	}
	public void setACCT_BAL(String aCCT_BAL) {
		ACCT_BAL = aCCT_BAL;
	}
	
	

}
