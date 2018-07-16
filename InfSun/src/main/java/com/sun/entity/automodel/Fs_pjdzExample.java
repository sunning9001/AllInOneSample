package com.sun.entity.automodel;

import java.util.ArrayList;
import java.util.List;

public class Fs_pjdzExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Fs_pjdzExample() {
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

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("date like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("date not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andAccconfirmNoIsNull() {
            addCriterion("accconfirm_no is null");
            return (Criteria) this;
        }

        public Criteria andAccconfirmNoIsNotNull() {
            addCriterion("accconfirm_no is not null");
            return (Criteria) this;
        }

        public Criteria andAccconfirmNoEqualTo(String value) {
            addCriterion("accconfirm_no =", value, "accconfirmNo");
            return (Criteria) this;
        }

        public Criteria andAccconfirmNoNotEqualTo(String value) {
            addCriterion("accconfirm_no <>", value, "accconfirmNo");
            return (Criteria) this;
        }

        public Criteria andAccconfirmNoGreaterThan(String value) {
            addCriterion("accconfirm_no >", value, "accconfirmNo");
            return (Criteria) this;
        }

        public Criteria andAccconfirmNoGreaterThanOrEqualTo(String value) {
            addCriterion("accconfirm_no >=", value, "accconfirmNo");
            return (Criteria) this;
        }

        public Criteria andAccconfirmNoLessThan(String value) {
            addCriterion("accconfirm_no <", value, "accconfirmNo");
            return (Criteria) this;
        }

        public Criteria andAccconfirmNoLessThanOrEqualTo(String value) {
            addCriterion("accconfirm_no <=", value, "accconfirmNo");
            return (Criteria) this;
        }

        public Criteria andAccconfirmNoLike(String value) {
            addCriterion("accconfirm_no like", value, "accconfirmNo");
            return (Criteria) this;
        }

        public Criteria andAccconfirmNoNotLike(String value) {
            addCriterion("accconfirm_no not like", value, "accconfirmNo");
            return (Criteria) this;
        }

        public Criteria andAccconfirmNoIn(List<String> values) {
            addCriterion("accconfirm_no in", values, "accconfirmNo");
            return (Criteria) this;
        }

        public Criteria andAccconfirmNoNotIn(List<String> values) {
            addCriterion("accconfirm_no not in", values, "accconfirmNo");
            return (Criteria) this;
        }

        public Criteria andAccconfirmNoBetween(String value1, String value2) {
            addCriterion("accconfirm_no between", value1, value2, "accconfirmNo");
            return (Criteria) this;
        }

        public Criteria andAccconfirmNoNotBetween(String value1, String value2) {
            addCriterion("accconfirm_no not between", value1, value2, "accconfirmNo");
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

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(String value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(String value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(String value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(String value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(String value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(String value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLike(String value) {
            addCriterion("count like", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotLike(String value) {
            addCriterion("count not like", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<String> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<String> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(String value1, String value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(String value1, String value2) {
            addCriterion("count not between", value1, value2, "count");
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

        public Criteria andRecSubacctIsNull() {
            addCriterion("rec_subacct is null");
            return (Criteria) this;
        }

        public Criteria andRecSubacctIsNotNull() {
            addCriterion("rec_subacct is not null");
            return (Criteria) this;
        }

        public Criteria andRecSubacctEqualTo(String value) {
            addCriterion("rec_subacct =", value, "recSubacct");
            return (Criteria) this;
        }

        public Criteria andRecSubacctNotEqualTo(String value) {
            addCriterion("rec_subacct <>", value, "recSubacct");
            return (Criteria) this;
        }

        public Criteria andRecSubacctGreaterThan(String value) {
            addCriterion("rec_subacct >", value, "recSubacct");
            return (Criteria) this;
        }

        public Criteria andRecSubacctGreaterThanOrEqualTo(String value) {
            addCriterion("rec_subacct >=", value, "recSubacct");
            return (Criteria) this;
        }

        public Criteria andRecSubacctLessThan(String value) {
            addCriterion("rec_subacct <", value, "recSubacct");
            return (Criteria) this;
        }

        public Criteria andRecSubacctLessThanOrEqualTo(String value) {
            addCriterion("rec_subacct <=", value, "recSubacct");
            return (Criteria) this;
        }

        public Criteria andRecSubacctLike(String value) {
            addCriterion("rec_subacct like", value, "recSubacct");
            return (Criteria) this;
        }

        public Criteria andRecSubacctNotLike(String value) {
            addCriterion("rec_subacct not like", value, "recSubacct");
            return (Criteria) this;
        }

        public Criteria andRecSubacctIn(List<String> values) {
            addCriterion("rec_subacct in", values, "recSubacct");
            return (Criteria) this;
        }

        public Criteria andRecSubacctNotIn(List<String> values) {
            addCriterion("rec_subacct not in", values, "recSubacct");
            return (Criteria) this;
        }

        public Criteria andRecSubacctBetween(String value1, String value2) {
            addCriterion("rec_subacct between", value1, value2, "recSubacct");
            return (Criteria) this;
        }

        public Criteria andRecSubacctNotBetween(String value1, String value2) {
            addCriterion("rec_subacct not between", value1, value2, "recSubacct");
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

        public Criteria andBatchnoIsNull() {
            addCriterion("batchno is null");
            return (Criteria) this;
        }

        public Criteria andBatchnoIsNotNull() {
            addCriterion("batchno is not null");
            return (Criteria) this;
        }

        public Criteria andBatchnoEqualTo(String value) {
            addCriterion("batchno =", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoNotEqualTo(String value) {
            addCriterion("batchno <>", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoGreaterThan(String value) {
            addCriterion("batchno >", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoGreaterThanOrEqualTo(String value) {
            addCriterion("batchno >=", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoLessThan(String value) {
            addCriterion("batchno <", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoLessThanOrEqualTo(String value) {
            addCriterion("batchno <=", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoLike(String value) {
            addCriterion("batchno like", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoNotLike(String value) {
            addCriterion("batchno not like", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoIn(List<String> values) {
            addCriterion("batchno in", values, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoNotIn(List<String> values) {
            addCriterion("batchno not in", values, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoBetween(String value1, String value2) {
            addCriterion("batchno between", value1, value2, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoNotBetween(String value1, String value2) {
            addCriterion("batchno not between", value1, value2, "batchno");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(String value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(String value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(String value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(String value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(String value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(String value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLike(String value) {
            addCriterion("amount like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotLike(String value) {
            addCriterion("amount not like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<String> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<String> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(String value1, String value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(String value1, String value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAddwordIsNull() {
            addCriterion("addWord is null");
            return (Criteria) this;
        }

        public Criteria andAddwordIsNotNull() {
            addCriterion("addWord is not null");
            return (Criteria) this;
        }

        public Criteria andAddwordEqualTo(String value) {
            addCriterion("addWord =", value, "addword");
            return (Criteria) this;
        }

        public Criteria andAddwordNotEqualTo(String value) {
            addCriterion("addWord <>", value, "addword");
            return (Criteria) this;
        }

        public Criteria andAddwordGreaterThan(String value) {
            addCriterion("addWord >", value, "addword");
            return (Criteria) this;
        }

        public Criteria andAddwordGreaterThanOrEqualTo(String value) {
            addCriterion("addWord >=", value, "addword");
            return (Criteria) this;
        }

        public Criteria andAddwordLessThan(String value) {
            addCriterion("addWord <", value, "addword");
            return (Criteria) this;
        }

        public Criteria andAddwordLessThanOrEqualTo(String value) {
            addCriterion("addWord <=", value, "addword");
            return (Criteria) this;
        }

        public Criteria andAddwordLike(String value) {
            addCriterion("addWord like", value, "addword");
            return (Criteria) this;
        }

        public Criteria andAddwordNotLike(String value) {
            addCriterion("addWord not like", value, "addword");
            return (Criteria) this;
        }

        public Criteria andAddwordIn(List<String> values) {
            addCriterion("addWord in", values, "addword");
            return (Criteria) this;
        }

        public Criteria andAddwordNotIn(List<String> values) {
            addCriterion("addWord not in", values, "addword");
            return (Criteria) this;
        }

        public Criteria andAddwordBetween(String value1, String value2) {
            addCriterion("addWord between", value1, value2, "addword");
            return (Criteria) this;
        }

        public Criteria andAddwordNotBetween(String value1, String value2) {
            addCriterion("addWord not between", value1, value2, "addword");
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