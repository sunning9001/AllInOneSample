package com.sun.entity.automodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Fs_pjjfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Fs_pjjfExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andBillnoIsNull() {
            addCriterion("billno is null");
            return (Criteria) this;
        }

        public Criteria andBillnoIsNotNull() {
            addCriterion("billno is not null");
            return (Criteria) this;
        }

        public Criteria andBillnoEqualTo(String value) {
            addCriterion("billno =", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotEqualTo(String value) {
            addCriterion("billno <>", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoGreaterThan(String value) {
            addCriterion("billno >", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoGreaterThanOrEqualTo(String value) {
            addCriterion("billno >=", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLessThan(String value) {
            addCriterion("billno <", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLessThanOrEqualTo(String value) {
            addCriterion("billno <=", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoLike(String value) {
            addCriterion("billno like", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotLike(String value) {
            addCriterion("billno not like", value, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoIn(List<String> values) {
            addCriterion("billno in", values, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotIn(List<String> values) {
            addCriterion("billno not in", values, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoBetween(String value1, String value2) {
            addCriterion("billno between", value1, value2, "billno");
            return (Criteria) this;
        }

        public Criteria andBillnoNotBetween(String value1, String value2) {
            addCriterion("billno not between", value1, value2, "billno");
            return (Criteria) this;
        }

        public Criteria andPayDatetimeIsNull() {
            addCriterion("pay_datetime is null");
            return (Criteria) this;
        }

        public Criteria andPayDatetimeIsNotNull() {
            addCriterion("pay_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andPayDatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("pay_datetime =", value, "payDatetime");
            return (Criteria) this;
        }

        public Criteria andPayDatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("pay_datetime <>", value, "payDatetime");
            return (Criteria) this;
        }

        public Criteria andPayDatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("pay_datetime >", value, "payDatetime");
            return (Criteria) this;
        }

        public Criteria andPayDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pay_datetime >=", value, "payDatetime");
            return (Criteria) this;
        }

        public Criteria andPayDatetimeLessThan(Date value) {
            addCriterionForJDBCDate("pay_datetime <", value, "payDatetime");
            return (Criteria) this;
        }

        public Criteria andPayDatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pay_datetime <=", value, "payDatetime");
            return (Criteria) this;
        }

        public Criteria andPayDatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("pay_datetime in", values, "payDatetime");
            return (Criteria) this;
        }

        public Criteria andPayDatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("pay_datetime not in", values, "payDatetime");
            return (Criteria) this;
        }

        public Criteria andPayDatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pay_datetime between", value1, value2, "payDatetime");
            return (Criteria) this;
        }

        public Criteria andPayDatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pay_datetime not between", value1, value2, "payDatetime");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNull() {
            addCriterion("pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(String value) {
            addCriterion("pay_amount =", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(String value) {
            addCriterion("pay_amount <>", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(String value) {
            addCriterion("pay_amount >", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(String value) {
            addCriterion("pay_amount >=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(String value) {
            addCriterion("pay_amount <", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(String value) {
            addCriterion("pay_amount <=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLike(String value) {
            addCriterion("pay_amount like", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotLike(String value) {
            addCriterion("pay_amount not like", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<String> values) {
            addCriterion("pay_amount in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<String> values) {
            addCriterion("pay_amount not in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(String value1, String value2) {
            addCriterion("pay_amount between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(String value1, String value2) {
            addCriterion("pay_amount not between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andBkOutletIsNull() {
            addCriterion("bk_outlet is null");
            return (Criteria) this;
        }

        public Criteria andBkOutletIsNotNull() {
            addCriterion("bk_outlet is not null");
            return (Criteria) this;
        }

        public Criteria andBkOutletEqualTo(String value) {
            addCriterion("bk_outlet =", value, "bkOutlet");
            return (Criteria) this;
        }

        public Criteria andBkOutletNotEqualTo(String value) {
            addCriterion("bk_outlet <>", value, "bkOutlet");
            return (Criteria) this;
        }

        public Criteria andBkOutletGreaterThan(String value) {
            addCriterion("bk_outlet >", value, "bkOutlet");
            return (Criteria) this;
        }

        public Criteria andBkOutletGreaterThanOrEqualTo(String value) {
            addCriterion("bk_outlet >=", value, "bkOutlet");
            return (Criteria) this;
        }

        public Criteria andBkOutletLessThan(String value) {
            addCriterion("bk_outlet <", value, "bkOutlet");
            return (Criteria) this;
        }

        public Criteria andBkOutletLessThanOrEqualTo(String value) {
            addCriterion("bk_outlet <=", value, "bkOutlet");
            return (Criteria) this;
        }

        public Criteria andBkOutletLike(String value) {
            addCriterion("bk_outlet like", value, "bkOutlet");
            return (Criteria) this;
        }

        public Criteria andBkOutletNotLike(String value) {
            addCriterion("bk_outlet not like", value, "bkOutlet");
            return (Criteria) this;
        }

        public Criteria andBkOutletIn(List<String> values) {
            addCriterion("bk_outlet in", values, "bkOutlet");
            return (Criteria) this;
        }

        public Criteria andBkOutletNotIn(List<String> values) {
            addCriterion("bk_outlet not in", values, "bkOutlet");
            return (Criteria) this;
        }

        public Criteria andBkOutletBetween(String value1, String value2) {
            addCriterion("bk_outlet between", value1, value2, "bkOutlet");
            return (Criteria) this;
        }

        public Criteria andBkOutletNotBetween(String value1, String value2) {
            addCriterion("bk_outlet not between", value1, value2, "bkOutlet");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andPaymodeIsNull() {
            addCriterion("paymode is null");
            return (Criteria) this;
        }

        public Criteria andPaymodeIsNotNull() {
            addCriterion("paymode is not null");
            return (Criteria) this;
        }

        public Criteria andPaymodeEqualTo(String value) {
            addCriterion("paymode =", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeNotEqualTo(String value) {
            addCriterion("paymode <>", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeGreaterThan(String value) {
            addCriterion("paymode >", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeGreaterThanOrEqualTo(String value) {
            addCriterion("paymode >=", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeLessThan(String value) {
            addCriterion("paymode <", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeLessThanOrEqualTo(String value) {
            addCriterion("paymode <=", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeLike(String value) {
            addCriterion("paymode like", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeNotLike(String value) {
            addCriterion("paymode not like", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeIn(List<String> values) {
            addCriterion("paymode in", values, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeNotIn(List<String> values) {
            addCriterion("paymode not in", values, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeBetween(String value1, String value2) {
            addCriterion("paymode between", value1, value2, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeNotBetween(String value1, String value2) {
            addCriterion("paymode not between", value1, value2, "paymode");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andPayerNameIsNull() {
            addCriterion("payer_name is null");
            return (Criteria) this;
        }

        public Criteria andPayerNameIsNotNull() {
            addCriterion("payer_name is not null");
            return (Criteria) this;
        }

        public Criteria andPayerNameEqualTo(String value) {
            addCriterion("payer_name =", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameNotEqualTo(String value) {
            addCriterion("payer_name <>", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameGreaterThan(String value) {
            addCriterion("payer_name >", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameGreaterThanOrEqualTo(String value) {
            addCriterion("payer_name >=", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameLessThan(String value) {
            addCriterion("payer_name <", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameLessThanOrEqualTo(String value) {
            addCriterion("payer_name <=", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameLike(String value) {
            addCriterion("payer_name like", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameNotLike(String value) {
            addCriterion("payer_name not like", value, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameIn(List<String> values) {
            addCriterion("payer_name in", values, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameNotIn(List<String> values) {
            addCriterion("payer_name not in", values, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameBetween(String value1, String value2) {
            addCriterion("payer_name between", value1, value2, "payerName");
            return (Criteria) this;
        }

        public Criteria andPayerNameNotBetween(String value1, String value2) {
            addCriterion("payer_name not between", value1, value2, "payerName");
            return (Criteria) this;
        }

        public Criteria andRecAcctypeIsNull() {
            addCriterion("rec_acctype is null");
            return (Criteria) this;
        }

        public Criteria andRecAcctypeIsNotNull() {
            addCriterion("rec_acctype is not null");
            return (Criteria) this;
        }

        public Criteria andRecAcctypeEqualTo(String value) {
            addCriterion("rec_acctype =", value, "recAcctype");
            return (Criteria) this;
        }

        public Criteria andRecAcctypeNotEqualTo(String value) {
            addCriterion("rec_acctype <>", value, "recAcctype");
            return (Criteria) this;
        }

        public Criteria andRecAcctypeGreaterThan(String value) {
            addCriterion("rec_acctype >", value, "recAcctype");
            return (Criteria) this;
        }

        public Criteria andRecAcctypeGreaterThanOrEqualTo(String value) {
            addCriterion("rec_acctype >=", value, "recAcctype");
            return (Criteria) this;
        }

        public Criteria andRecAcctypeLessThan(String value) {
            addCriterion("rec_acctype <", value, "recAcctype");
            return (Criteria) this;
        }

        public Criteria andRecAcctypeLessThanOrEqualTo(String value) {
            addCriterion("rec_acctype <=", value, "recAcctype");
            return (Criteria) this;
        }

        public Criteria andRecAcctypeLike(String value) {
            addCriterion("rec_acctype like", value, "recAcctype");
            return (Criteria) this;
        }

        public Criteria andRecAcctypeNotLike(String value) {
            addCriterion("rec_acctype not like", value, "recAcctype");
            return (Criteria) this;
        }

        public Criteria andRecAcctypeIn(List<String> values) {
            addCriterion("rec_acctype in", values, "recAcctype");
            return (Criteria) this;
        }

        public Criteria andRecAcctypeNotIn(List<String> values) {
            addCriterion("rec_acctype not in", values, "recAcctype");
            return (Criteria) this;
        }

        public Criteria andRecAcctypeBetween(String value1, String value2) {
            addCriterion("rec_acctype between", value1, value2, "recAcctype");
            return (Criteria) this;
        }

        public Criteria andRecAcctypeNotBetween(String value1, String value2) {
            addCriterion("rec_acctype not between", value1, value2, "recAcctype");
            return (Criteria) this;
        }

        public Criteria andPayerAcctIsNull() {
            addCriterion("payer_acct is null");
            return (Criteria) this;
        }

        public Criteria andPayerAcctIsNotNull() {
            addCriterion("payer_acct is not null");
            return (Criteria) this;
        }

        public Criteria andPayerAcctEqualTo(String value) {
            addCriterion("payer_acct =", value, "payerAcct");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNotEqualTo(String value) {
            addCriterion("payer_acct <>", value, "payerAcct");
            return (Criteria) this;
        }

        public Criteria andPayerAcctGreaterThan(String value) {
            addCriterion("payer_acct >", value, "payerAcct");
            return (Criteria) this;
        }

        public Criteria andPayerAcctGreaterThanOrEqualTo(String value) {
            addCriterion("payer_acct >=", value, "payerAcct");
            return (Criteria) this;
        }

        public Criteria andPayerAcctLessThan(String value) {
            addCriterion("payer_acct <", value, "payerAcct");
            return (Criteria) this;
        }

        public Criteria andPayerAcctLessThanOrEqualTo(String value) {
            addCriterion("payer_acct <=", value, "payerAcct");
            return (Criteria) this;
        }

        public Criteria andPayerAcctLike(String value) {
            addCriterion("payer_acct like", value, "payerAcct");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNotLike(String value) {
            addCriterion("payer_acct not like", value, "payerAcct");
            return (Criteria) this;
        }

        public Criteria andPayerAcctIn(List<String> values) {
            addCriterion("payer_acct in", values, "payerAcct");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNotIn(List<String> values) {
            addCriterion("payer_acct not in", values, "payerAcct");
            return (Criteria) this;
        }

        public Criteria andPayerAcctBetween(String value1, String value2) {
            addCriterion("payer_acct between", value1, value2, "payerAcct");
            return (Criteria) this;
        }

        public Criteria andPayerAcctNotBetween(String value1, String value2) {
            addCriterion("payer_acct not between", value1, value2, "payerAcct");
            return (Criteria) this;
        }

        public Criteria andPayerOpbkIsNull() {
            addCriterion("payer_opbk is null");
            return (Criteria) this;
        }

        public Criteria andPayerOpbkIsNotNull() {
            addCriterion("payer_opbk is not null");
            return (Criteria) this;
        }

        public Criteria andPayerOpbkEqualTo(String value) {
            addCriterion("payer_opbk =", value, "payerOpbk");
            return (Criteria) this;
        }

        public Criteria andPayerOpbkNotEqualTo(String value) {
            addCriterion("payer_opbk <>", value, "payerOpbk");
            return (Criteria) this;
        }

        public Criteria andPayerOpbkGreaterThan(String value) {
            addCriterion("payer_opbk >", value, "payerOpbk");
            return (Criteria) this;
        }

        public Criteria andPayerOpbkGreaterThanOrEqualTo(String value) {
            addCriterion("payer_opbk >=", value, "payerOpbk");
            return (Criteria) this;
        }

        public Criteria andPayerOpbkLessThan(String value) {
            addCriterion("payer_opbk <", value, "payerOpbk");
            return (Criteria) this;
        }

        public Criteria andPayerOpbkLessThanOrEqualTo(String value) {
            addCriterion("payer_opbk <=", value, "payerOpbk");
            return (Criteria) this;
        }

        public Criteria andPayerOpbkLike(String value) {
            addCriterion("payer_opbk like", value, "payerOpbk");
            return (Criteria) this;
        }

        public Criteria andPayerOpbkNotLike(String value) {
            addCriterion("payer_opbk not like", value, "payerOpbk");
            return (Criteria) this;
        }

        public Criteria andPayerOpbkIn(List<String> values) {
            addCriterion("payer_opbk in", values, "payerOpbk");
            return (Criteria) this;
        }

        public Criteria andPayerOpbkNotIn(List<String> values) {
            addCriterion("payer_opbk not in", values, "payerOpbk");
            return (Criteria) this;
        }

        public Criteria andPayerOpbkBetween(String value1, String value2) {
            addCriterion("payer_opbk between", value1, value2, "payerOpbk");
            return (Criteria) this;
        }

        public Criteria andPayerOpbkNotBetween(String value1, String value2) {
            addCriterion("payer_opbk not between", value1, value2, "payerOpbk");
            return (Criteria) this;
        }

        public Criteria andPayerOpbknoIsNull() {
            addCriterion("payer_opbkno is null");
            return (Criteria) this;
        }

        public Criteria andPayerOpbknoIsNotNull() {
            addCriterion("payer_opbkno is not null");
            return (Criteria) this;
        }

        public Criteria andPayerOpbknoEqualTo(String value) {
            addCriterion("payer_opbkno =", value, "payerOpbkno");
            return (Criteria) this;
        }

        public Criteria andPayerOpbknoNotEqualTo(String value) {
            addCriterion("payer_opbkno <>", value, "payerOpbkno");
            return (Criteria) this;
        }

        public Criteria andPayerOpbknoGreaterThan(String value) {
            addCriterion("payer_opbkno >", value, "payerOpbkno");
            return (Criteria) this;
        }

        public Criteria andPayerOpbknoGreaterThanOrEqualTo(String value) {
            addCriterion("payer_opbkno >=", value, "payerOpbkno");
            return (Criteria) this;
        }

        public Criteria andPayerOpbknoLessThan(String value) {
            addCriterion("payer_opbkno <", value, "payerOpbkno");
            return (Criteria) this;
        }

        public Criteria andPayerOpbknoLessThanOrEqualTo(String value) {
            addCriterion("payer_opbkno <=", value, "payerOpbkno");
            return (Criteria) this;
        }

        public Criteria andPayerOpbknoLike(String value) {
            addCriterion("payer_opbkno like", value, "payerOpbkno");
            return (Criteria) this;
        }

        public Criteria andPayerOpbknoNotLike(String value) {
            addCriterion("payer_opbkno not like", value, "payerOpbkno");
            return (Criteria) this;
        }

        public Criteria andPayerOpbknoIn(List<String> values) {
            addCriterion("payer_opbkno in", values, "payerOpbkno");
            return (Criteria) this;
        }

        public Criteria andPayerOpbknoNotIn(List<String> values) {
            addCriterion("payer_opbkno not in", values, "payerOpbkno");
            return (Criteria) this;
        }

        public Criteria andPayerOpbknoBetween(String value1, String value2) {
            addCriterion("payer_opbkno between", value1, value2, "payerOpbkno");
            return (Criteria) this;
        }

        public Criteria andPayerOpbknoNotBetween(String value1, String value2) {
            addCriterion("payer_opbkno not between", value1, value2, "payerOpbkno");
            return (Criteria) this;
        }

        public Criteria andRecAcctIsNull() {
            addCriterion("rec_acct is null");
            return (Criteria) this;
        }

        public Criteria andRecAcctIsNotNull() {
            addCriterion("rec_acct is not null");
            return (Criteria) this;
        }

        public Criteria andRecAcctEqualTo(String value) {
            addCriterion("rec_acct =", value, "recAcct");
            return (Criteria) this;
        }

        public Criteria andRecAcctNotEqualTo(String value) {
            addCriterion("rec_acct <>", value, "recAcct");
            return (Criteria) this;
        }

        public Criteria andRecAcctGreaterThan(String value) {
            addCriterion("rec_acct >", value, "recAcct");
            return (Criteria) this;
        }

        public Criteria andRecAcctGreaterThanOrEqualTo(String value) {
            addCriterion("rec_acct >=", value, "recAcct");
            return (Criteria) this;
        }

        public Criteria andRecAcctLessThan(String value) {
            addCriterion("rec_acct <", value, "recAcct");
            return (Criteria) this;
        }

        public Criteria andRecAcctLessThanOrEqualTo(String value) {
            addCriterion("rec_acct <=", value, "recAcct");
            return (Criteria) this;
        }

        public Criteria andRecAcctLike(String value) {
            addCriterion("rec_acct like", value, "recAcct");
            return (Criteria) this;
        }

        public Criteria andRecAcctNotLike(String value) {
            addCriterion("rec_acct not like", value, "recAcct");
            return (Criteria) this;
        }

        public Criteria andRecAcctIn(List<String> values) {
            addCriterion("rec_acct in", values, "recAcct");
            return (Criteria) this;
        }

        public Criteria andRecAcctNotIn(List<String> values) {
            addCriterion("rec_acct not in", values, "recAcct");
            return (Criteria) this;
        }

        public Criteria andRecAcctBetween(String value1, String value2) {
            addCriterion("rec_acct between", value1, value2, "recAcct");
            return (Criteria) this;
        }

        public Criteria andRecAcctNotBetween(String value1, String value2) {
            addCriterion("rec_acct not between", value1, value2, "recAcct");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}