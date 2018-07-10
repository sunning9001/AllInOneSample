package com.sun.entity.automodel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Fs_dwzbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Fs_dwzbExample() {
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

        public Criteria andDwdmIsNull() {
            addCriterion("dwdm is null");
            return (Criteria) this;
        }

        public Criteria andDwdmIsNotNull() {
            addCriterion("dwdm is not null");
            return (Criteria) this;
        }

        public Criteria andDwdmEqualTo(String value) {
            addCriterion("dwdm =", value, "dwdm");
            return (Criteria) this;
        }

        public Criteria andDwdmNotEqualTo(String value) {
            addCriterion("dwdm <>", value, "dwdm");
            return (Criteria) this;
        }

        public Criteria andDwdmGreaterThan(String value) {
            addCriterion("dwdm >", value, "dwdm");
            return (Criteria) this;
        }

        public Criteria andDwdmGreaterThanOrEqualTo(String value) {
            addCriterion("dwdm >=", value, "dwdm");
            return (Criteria) this;
        }

        public Criteria andDwdmLessThan(String value) {
            addCriterion("dwdm <", value, "dwdm");
            return (Criteria) this;
        }

        public Criteria andDwdmLessThanOrEqualTo(String value) {
            addCriterion("dwdm <=", value, "dwdm");
            return (Criteria) this;
        }

        public Criteria andDwdmLike(String value) {
            addCriterion("dwdm like", value, "dwdm");
            return (Criteria) this;
        }

        public Criteria andDwdmNotLike(String value) {
            addCriterion("dwdm not like", value, "dwdm");
            return (Criteria) this;
        }

        public Criteria andDwdmIn(List<String> values) {
            addCriterion("dwdm in", values, "dwdm");
            return (Criteria) this;
        }

        public Criteria andDwdmNotIn(List<String> values) {
            addCriterion("dwdm not in", values, "dwdm");
            return (Criteria) this;
        }

        public Criteria andDwdmBetween(String value1, String value2) {
            addCriterion("dwdm between", value1, value2, "dwdm");
            return (Criteria) this;
        }

        public Criteria andDwdmNotBetween(String value1, String value2) {
            addCriterion("dwdm not between", value1, value2, "dwdm");
            return (Criteria) this;
        }

        public Criteria andDwmcIsNull() {
            addCriterion("dwmc is null");
            return (Criteria) this;
        }

        public Criteria andDwmcIsNotNull() {
            addCriterion("dwmc is not null");
            return (Criteria) this;
        }

        public Criteria andDwmcEqualTo(String value) {
            addCriterion("dwmc =", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcNotEqualTo(String value) {
            addCriterion("dwmc <>", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcGreaterThan(String value) {
            addCriterion("dwmc >", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcGreaterThanOrEqualTo(String value) {
            addCriterion("dwmc >=", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcLessThan(String value) {
            addCriterion("dwmc <", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcLessThanOrEqualTo(String value) {
            addCriterion("dwmc <=", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcLike(String value) {
            addCriterion("dwmc like", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcNotLike(String value) {
            addCriterion("dwmc not like", value, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcIn(List<String> values) {
            addCriterion("dwmc in", values, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcNotIn(List<String> values) {
            addCriterion("dwmc not in", values, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcBetween(String value1, String value2) {
            addCriterion("dwmc between", value1, value2, "dwmc");
            return (Criteria) this;
        }

        public Criteria andDwmcNotBetween(String value1, String value2) {
            addCriterion("dwmc not between", value1, value2, "dwmc");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andFzrIsNull() {
            addCriterion("fzr is null");
            return (Criteria) this;
        }

        public Criteria andFzrIsNotNull() {
            addCriterion("fzr is not null");
            return (Criteria) this;
        }

        public Criteria andFzrEqualTo(String value) {
            addCriterion("fzr =", value, "fzr");
            return (Criteria) this;
        }

        public Criteria andFzrNotEqualTo(String value) {
            addCriterion("fzr <>", value, "fzr");
            return (Criteria) this;
        }

        public Criteria andFzrGreaterThan(String value) {
            addCriterion("fzr >", value, "fzr");
            return (Criteria) this;
        }

        public Criteria andFzrGreaterThanOrEqualTo(String value) {
            addCriterion("fzr >=", value, "fzr");
            return (Criteria) this;
        }

        public Criteria andFzrLessThan(String value) {
            addCriterion("fzr <", value, "fzr");
            return (Criteria) this;
        }

        public Criteria andFzrLessThanOrEqualTo(String value) {
            addCriterion("fzr <=", value, "fzr");
            return (Criteria) this;
        }

        public Criteria andFzrLike(String value) {
            addCriterion("fzr like", value, "fzr");
            return (Criteria) this;
        }

        public Criteria andFzrNotLike(String value) {
            addCriterion("fzr not like", value, "fzr");
            return (Criteria) this;
        }

        public Criteria andFzrIn(List<String> values) {
            addCriterion("fzr in", values, "fzr");
            return (Criteria) this;
        }

        public Criteria andFzrNotIn(List<String> values) {
            addCriterion("fzr not in", values, "fzr");
            return (Criteria) this;
        }

        public Criteria andFzrBetween(String value1, String value2) {
            addCriterion("fzr between", value1, value2, "fzr");
            return (Criteria) this;
        }

        public Criteria andFzrNotBetween(String value1, String value2) {
            addCriterion("fzr not between", value1, value2, "fzr");
            return (Criteria) this;
        }

        public Criteria andSsxtIsNull() {
            addCriterion("ssxt is null");
            return (Criteria) this;
        }

        public Criteria andSsxtIsNotNull() {
            addCriterion("ssxt is not null");
            return (Criteria) this;
        }

        public Criteria andSsxtEqualTo(String value) {
            addCriterion("ssxt =", value, "ssxt");
            return (Criteria) this;
        }

        public Criteria andSsxtNotEqualTo(String value) {
            addCriterion("ssxt <>", value, "ssxt");
            return (Criteria) this;
        }

        public Criteria andSsxtGreaterThan(String value) {
            addCriterion("ssxt >", value, "ssxt");
            return (Criteria) this;
        }

        public Criteria andSsxtGreaterThanOrEqualTo(String value) {
            addCriterion("ssxt >=", value, "ssxt");
            return (Criteria) this;
        }

        public Criteria andSsxtLessThan(String value) {
            addCriterion("ssxt <", value, "ssxt");
            return (Criteria) this;
        }

        public Criteria andSsxtLessThanOrEqualTo(String value) {
            addCriterion("ssxt <=", value, "ssxt");
            return (Criteria) this;
        }

        public Criteria andSsxtLike(String value) {
            addCriterion("ssxt like", value, "ssxt");
            return (Criteria) this;
        }

        public Criteria andSsxtNotLike(String value) {
            addCriterion("ssxt not like", value, "ssxt");
            return (Criteria) this;
        }

        public Criteria andSsxtIn(List<String> values) {
            addCriterion("ssxt in", values, "ssxt");
            return (Criteria) this;
        }

        public Criteria andSsxtNotIn(List<String> values) {
            addCriterion("ssxt not in", values, "ssxt");
            return (Criteria) this;
        }

        public Criteria andSsxtBetween(String value1, String value2) {
            addCriterion("ssxt between", value1, value2, "ssxt");
            return (Criteria) this;
        }

        public Criteria andSsxtNotBetween(String value1, String value2) {
            addCriterion("ssxt not between", value1, value2, "ssxt");
            return (Criteria) this;
        }

        public Criteria andZgbmIsNull() {
            addCriterion("zgbm is null");
            return (Criteria) this;
        }

        public Criteria andZgbmIsNotNull() {
            addCriterion("zgbm is not null");
            return (Criteria) this;
        }

        public Criteria andZgbmEqualTo(String value) {
            addCriterion("zgbm =", value, "zgbm");
            return (Criteria) this;
        }

        public Criteria andZgbmNotEqualTo(String value) {
            addCriterion("zgbm <>", value, "zgbm");
            return (Criteria) this;
        }

        public Criteria andZgbmGreaterThan(String value) {
            addCriterion("zgbm >", value, "zgbm");
            return (Criteria) this;
        }

        public Criteria andZgbmGreaterThanOrEqualTo(String value) {
            addCriterion("zgbm >=", value, "zgbm");
            return (Criteria) this;
        }

        public Criteria andZgbmLessThan(String value) {
            addCriterion("zgbm <", value, "zgbm");
            return (Criteria) this;
        }

        public Criteria andZgbmLessThanOrEqualTo(String value) {
            addCriterion("zgbm <=", value, "zgbm");
            return (Criteria) this;
        }

        public Criteria andZgbmLike(String value) {
            addCriterion("zgbm like", value, "zgbm");
            return (Criteria) this;
        }

        public Criteria andZgbmNotLike(String value) {
            addCriterion("zgbm not like", value, "zgbm");
            return (Criteria) this;
        }

        public Criteria andZgbmIn(List<String> values) {
            addCriterion("zgbm in", values, "zgbm");
            return (Criteria) this;
        }

        public Criteria andZgbmNotIn(List<String> values) {
            addCriterion("zgbm not in", values, "zgbm");
            return (Criteria) this;
        }

        public Criteria andZgbmBetween(String value1, String value2) {
            addCriterion("zgbm between", value1, value2, "zgbm");
            return (Criteria) this;
        }

        public Criteria andZgbmNotBetween(String value1, String value2) {
            addCriterion("zgbm not between", value1, value2, "zgbm");
            return (Criteria) this;
        }

        public Criteria andDwxzIsNull() {
            addCriterion("dwxz is null");
            return (Criteria) this;
        }

        public Criteria andDwxzIsNotNull() {
            addCriterion("dwxz is not null");
            return (Criteria) this;
        }

        public Criteria andDwxzEqualTo(String value) {
            addCriterion("dwxz =", value, "dwxz");
            return (Criteria) this;
        }

        public Criteria andDwxzNotEqualTo(String value) {
            addCriterion("dwxz <>", value, "dwxz");
            return (Criteria) this;
        }

        public Criteria andDwxzGreaterThan(String value) {
            addCriterion("dwxz >", value, "dwxz");
            return (Criteria) this;
        }

        public Criteria andDwxzGreaterThanOrEqualTo(String value) {
            addCriterion("dwxz >=", value, "dwxz");
            return (Criteria) this;
        }

        public Criteria andDwxzLessThan(String value) {
            addCriterion("dwxz <", value, "dwxz");
            return (Criteria) this;
        }

        public Criteria andDwxzLessThanOrEqualTo(String value) {
            addCriterion("dwxz <=", value, "dwxz");
            return (Criteria) this;
        }

        public Criteria andDwxzLike(String value) {
            addCriterion("dwxz like", value, "dwxz");
            return (Criteria) this;
        }

        public Criteria andDwxzNotLike(String value) {
            addCriterion("dwxz not like", value, "dwxz");
            return (Criteria) this;
        }

        public Criteria andDwxzIn(List<String> values) {
            addCriterion("dwxz in", values, "dwxz");
            return (Criteria) this;
        }

        public Criteria andDwxzNotIn(List<String> values) {
            addCriterion("dwxz not in", values, "dwxz");
            return (Criteria) this;
        }

        public Criteria andDwxzBetween(String value1, String value2) {
            addCriterion("dwxz between", value1, value2, "dwxz");
            return (Criteria) this;
        }

        public Criteria andDwxzNotBetween(String value1, String value2) {
            addCriterion("dwxz not between", value1, value2, "dwxz");
            return (Criteria) this;
        }

        public Criteria andYzbmIsNull() {
            addCriterion("yzbm is null");
            return (Criteria) this;
        }

        public Criteria andYzbmIsNotNull() {
            addCriterion("yzbm is not null");
            return (Criteria) this;
        }

        public Criteria andYzbmEqualTo(String value) {
            addCriterion("yzbm =", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmNotEqualTo(String value) {
            addCriterion("yzbm <>", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmGreaterThan(String value) {
            addCriterion("yzbm >", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmGreaterThanOrEqualTo(String value) {
            addCriterion("yzbm >=", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmLessThan(String value) {
            addCriterion("yzbm <", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmLessThanOrEqualTo(String value) {
            addCriterion("yzbm <=", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmLike(String value) {
            addCriterion("yzbm like", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmNotLike(String value) {
            addCriterion("yzbm not like", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmIn(List<String> values) {
            addCriterion("yzbm in", values, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmNotIn(List<String> values) {
            addCriterion("yzbm not in", values, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmBetween(String value1, String value2) {
            addCriterion("yzbm between", value1, value2, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmNotBetween(String value1, String value2) {
            addCriterion("yzbm not between", value1, value2, "yzbm");
            return (Criteria) this;
        }

        public Criteria andPgyIsNull() {
            addCriterion("pgy is null");
            return (Criteria) this;
        }

        public Criteria andPgyIsNotNull() {
            addCriterion("pgy is not null");
            return (Criteria) this;
        }

        public Criteria andPgyEqualTo(String value) {
            addCriterion("pgy =", value, "pgy");
            return (Criteria) this;
        }

        public Criteria andPgyNotEqualTo(String value) {
            addCriterion("pgy <>", value, "pgy");
            return (Criteria) this;
        }

        public Criteria andPgyGreaterThan(String value) {
            addCriterion("pgy >", value, "pgy");
            return (Criteria) this;
        }

        public Criteria andPgyGreaterThanOrEqualTo(String value) {
            addCriterion("pgy >=", value, "pgy");
            return (Criteria) this;
        }

        public Criteria andPgyLessThan(String value) {
            addCriterion("pgy <", value, "pgy");
            return (Criteria) this;
        }

        public Criteria andPgyLessThanOrEqualTo(String value) {
            addCriterion("pgy <=", value, "pgy");
            return (Criteria) this;
        }

        public Criteria andPgyLike(String value) {
            addCriterion("pgy like", value, "pgy");
            return (Criteria) this;
        }

        public Criteria andPgyNotLike(String value) {
            addCriterion("pgy not like", value, "pgy");
            return (Criteria) this;
        }

        public Criteria andPgyIn(List<String> values) {
            addCriterion("pgy in", values, "pgy");
            return (Criteria) this;
        }

        public Criteria andPgyNotIn(List<String> values) {
            addCriterion("pgy not in", values, "pgy");
            return (Criteria) this;
        }

        public Criteria andPgyBetween(String value1, String value2) {
            addCriterion("pgy between", value1, value2, "pgy");
            return (Criteria) this;
        }

        public Criteria andPgyNotBetween(String value1, String value2) {
            addCriterion("pgy not between", value1, value2, "pgy");
            return (Criteria) this;
        }

        public Criteria andPgysfzIsNull() {
            addCriterion("pgysfz is null");
            return (Criteria) this;
        }

        public Criteria andPgysfzIsNotNull() {
            addCriterion("pgysfz is not null");
            return (Criteria) this;
        }

        public Criteria andPgysfzEqualTo(String value) {
            addCriterion("pgysfz =", value, "pgysfz");
            return (Criteria) this;
        }

        public Criteria andPgysfzNotEqualTo(String value) {
            addCriterion("pgysfz <>", value, "pgysfz");
            return (Criteria) this;
        }

        public Criteria andPgysfzGreaterThan(String value) {
            addCriterion("pgysfz >", value, "pgysfz");
            return (Criteria) this;
        }

        public Criteria andPgysfzGreaterThanOrEqualTo(String value) {
            addCriterion("pgysfz >=", value, "pgysfz");
            return (Criteria) this;
        }

        public Criteria andPgysfzLessThan(String value) {
            addCriterion("pgysfz <", value, "pgysfz");
            return (Criteria) this;
        }

        public Criteria andPgysfzLessThanOrEqualTo(String value) {
            addCriterion("pgysfz <=", value, "pgysfz");
            return (Criteria) this;
        }

        public Criteria andPgysfzLike(String value) {
            addCriterion("pgysfz like", value, "pgysfz");
            return (Criteria) this;
        }

        public Criteria andPgysfzNotLike(String value) {
            addCriterion("pgysfz not like", value, "pgysfz");
            return (Criteria) this;
        }

        public Criteria andPgysfzIn(List<String> values) {
            addCriterion("pgysfz in", values, "pgysfz");
            return (Criteria) this;
        }

        public Criteria andPgysfzNotIn(List<String> values) {
            addCriterion("pgysfz not in", values, "pgysfz");
            return (Criteria) this;
        }

        public Criteria andPgysfzBetween(String value1, String value2) {
            addCriterion("pgysfz between", value1, value2, "pgysfz");
            return (Criteria) this;
        }

        public Criteria andPgysfzNotBetween(String value1, String value2) {
            addCriterion("pgysfz not between", value1, value2, "pgysfz");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andBzrsIsNull() {
            addCriterion("bzrs is null");
            return (Criteria) this;
        }

        public Criteria andBzrsIsNotNull() {
            addCriterion("bzrs is not null");
            return (Criteria) this;
        }

        public Criteria andBzrsEqualTo(int value) {
            addCriterion("bzrs =", value, "bzrs");
            return (Criteria) this;
        }

        public Criteria andBzrsNotEqualTo(int value) {
            addCriterion("bzrs <>", value, "bzrs");
            return (Criteria) this;
        }

        public Criteria andBzrsGreaterThan(int value) {
            addCriterion("bzrs >", value, "bzrs");
            return (Criteria) this;
        }

        public Criteria andBzrsGreaterThanOrEqualTo(int value) {
            addCriterion("bzrs >=", value, "bzrs");
            return (Criteria) this;
        }

        public Criteria andBzrsLessThan(int value) {
            addCriterion("bzrs <", value, "bzrs");
            return (Criteria) this;
        }

        public Criteria andBzrsLessThanOrEqualTo(int value) {
            addCriterion("bzrs <=", value, "bzrs");
            return (Criteria) this;
        }

        public Criteria andBzrsIn(List<Integer> values) {
            addCriterion("bzrs in", values, "bzrs");
            return (Criteria) this;
        }

        public Criteria andBzrsNotIn(List<Integer> values) {
            addCriterion("bzrs not in", values, "bzrs");
            return (Criteria) this;
        }

        public Criteria andBzrsBetween(int value1, int value2) {
            addCriterion("bzrs between", value1, value2, "bzrs");
            return (Criteria) this;
        }

        public Criteria andBzrsNotBetween(int value1, int value2) {
            addCriterion("bzrs not between", value1, value2, "bzrs");
            return (Criteria) this;
        }

        public Criteria andZzrsIsNull() {
            addCriterion("zzrs is null");
            return (Criteria) this;
        }

        public Criteria andZzrsIsNotNull() {
            addCriterion("zzrs is not null");
            return (Criteria) this;
        }

        public Criteria andZzrsEqualTo(int value) {
            addCriterion("zzrs =", value, "zzrs");
            return (Criteria) this;
        }

        public Criteria andZzrsNotEqualTo(int value) {
            addCriterion("zzrs <>", value, "zzrs");
            return (Criteria) this;
        }

        public Criteria andZzrsGreaterThan(int value) {
            addCriterion("zzrs >", value, "zzrs");
            return (Criteria) this;
        }

        public Criteria andZzrsGreaterThanOrEqualTo(int value) {
            addCriterion("zzrs >=", value, "zzrs");
            return (Criteria) this;
        }

        public Criteria andZzrsLessThan(int value) {
            addCriterion("zzrs <", value, "zzrs");
            return (Criteria) this;
        }

        public Criteria andZzrsLessThanOrEqualTo(int value) {
            addCriterion("zzrs <=", value, "zzrs");
            return (Criteria) this;
        }

        public Criteria andZzrsIn(List<Integer> values) {
            addCriterion("zzrs in", values, "zzrs");
            return (Criteria) this;
        }

        public Criteria andZzrsNotIn(List<Integer> values) {
            addCriterion("zzrs not in", values, "zzrs");
            return (Criteria) this;
        }

        public Criteria andZzrsBetween(int value1, int value2) {
            addCriterion("zzrs between", value1, value2, "zzrs");
            return (Criteria) this;
        }

        public Criteria andZzrsNotBetween(int value1, int value2) {
            addCriterion("zzrs not between", value1, value2, "zzrs");
            return (Criteria) this;
        }

        public Criteria andLtxrsIsNull() {
            addCriterion("ltxrs is null");
            return (Criteria) this;
        }

        public Criteria andLtxrsIsNotNull() {
            addCriterion("ltxrs is not null");
            return (Criteria) this;
        }

        public Criteria andLtxrsEqualTo(int value) {
            addCriterion("ltxrs =", value, "ltxrs");
            return (Criteria) this;
        }

        public Criteria andLtxrsNotEqualTo(int value) {
            addCriterion("ltxrs <>", value, "ltxrs");
            return (Criteria) this;
        }

        public Criteria andLtxrsGreaterThan(int value) {
            addCriterion("ltxrs >", value, "ltxrs");
            return (Criteria) this;
        }

        public Criteria andLtxrsGreaterThanOrEqualTo(int value) {
            addCriterion("ltxrs >=", value, "ltxrs");
            return (Criteria) this;
        }

        public Criteria andLtxrsLessThan(int value) {
            addCriterion("ltxrs <", value, "ltxrs");
            return (Criteria) this;
        }

        public Criteria andLtxrsLessThanOrEqualTo(int value) {
            addCriterion("ltxrs <=", value, "ltxrs");
            return (Criteria) this;
        }

        public Criteria andLtxrsIn(List<Integer> values) {
            addCriterion("ltxrs in", values, "ltxrs");
            return (Criteria) this;
        }

        public Criteria andLtxrsNotIn(List<Integer> values) {
            addCriterion("ltxrs not in", values, "ltxrs");
            return (Criteria) this;
        }

        public Criteria andLtxrsBetween(int value1, int value2) {
            addCriterion("ltxrs between", value1, value2, "ltxrs");
            return (Criteria) this;
        }

        public Criteria andLtxrsNotBetween(int value1, int value2) {
            addCriterion("ltxrs not between", value1, value2, "ltxrs");
            return (Criteria) this;
        }

        public Criteria andLsrsIsNull() {
            addCriterion("lsrs is null");
            return (Criteria) this;
        }

        public Criteria andLsrsIsNotNull() {
            addCriterion("lsrs is not null");
            return (Criteria) this;
        }

        public Criteria andLsrsEqualTo(int value) {
            addCriterion("lsrs =", value, "lsrs");
            return (Criteria) this;
        }

        public Criteria andLsrsNotEqualTo(int value) {
            addCriterion("lsrs <>", value, "lsrs");
            return (Criteria) this;
        }

        public Criteria andLsrsGreaterThan(int value) {
            addCriterion("lsrs >", value, "lsrs");
            return (Criteria) this;
        }

        public Criteria andLsrsGreaterThanOrEqualTo(int value) {
            addCriterion("lsrs >=", value, "lsrs");
            return (Criteria) this;
        }

        public Criteria andLsrsLessThan(int value) {
            addCriterion("lsrs <", value, "lsrs");
            return (Criteria) this;
        }

        public Criteria andLsrsLessThanOrEqualTo(int value) {
            addCriterion("lsrs <=", value, "lsrs");
            return (Criteria) this;
        }

        public Criteria andLsrsIn(List<Integer> values) {
            addCriterion("lsrs in", values, "lsrs");
            return (Criteria) this;
        }

        public Criteria andLsrsNotIn(List<Integer> values) {
            addCriterion("lsrs not in", values, "lsrs");
            return (Criteria) this;
        }

        public Criteria andLsrsBetween(int value1, int value2) {
            addCriterion("lsrs between", value1, value2, "lsrs");
            return (Criteria) this;
        }

        public Criteria andLsrsNotBetween(int value1, int value2) {
            addCriterion("lsrs not between", value1, value2, "lsrs");
            return (Criteria) this;
        }

        public Criteria andDwjbIsNull() {
            addCriterion("dwjb is null");
            return (Criteria) this;
        }

        public Criteria andDwjbIsNotNull() {
            addCriterion("dwjb is not null");
            return (Criteria) this;
        }

        public Criteria andDwjbEqualTo(String value) {
            addCriterion("dwjb =", value, "dwjb");
            return (Criteria) this;
        }

        public Criteria andDwjbNotEqualTo(String value) {
            addCriterion("dwjb <>", value, "dwjb");
            return (Criteria) this;
        }

        public Criteria andDwjbGreaterThan(String value) {
            addCriterion("dwjb >", value, "dwjb");
            return (Criteria) this;
        }

        public Criteria andDwjbGreaterThanOrEqualTo(String value) {
            addCriterion("dwjb >=", value, "dwjb");
            return (Criteria) this;
        }

        public Criteria andDwjbLessThan(String value) {
            addCriterion("dwjb <", value, "dwjb");
            return (Criteria) this;
        }

        public Criteria andDwjbLessThanOrEqualTo(String value) {
            addCriterion("dwjb <=", value, "dwjb");
            return (Criteria) this;
        }

        public Criteria andDwjbLike(String value) {
            addCriterion("dwjb like", value, "dwjb");
            return (Criteria) this;
        }

        public Criteria andDwjbNotLike(String value) {
            addCriterion("dwjb not like", value, "dwjb");
            return (Criteria) this;
        }

        public Criteria andDwjbIn(List<String> values) {
            addCriterion("dwjb in", values, "dwjb");
            return (Criteria) this;
        }

        public Criteria andDwjbNotIn(List<String> values) {
            addCriterion("dwjb not in", values, "dwjb");
            return (Criteria) this;
        }

        public Criteria andDwjbBetween(String value1, String value2) {
            addCriterion("dwjb between", value1, value2, "dwjb");
            return (Criteria) this;
        }

        public Criteria andDwjbNotBetween(String value1, String value2) {
            addCriterion("dwjb not between", value1, value2, "dwjb");
            return (Criteria) this;
        }

        public Criteria andKpfsIsNull() {
            addCriterion("kpfs is null");
            return (Criteria) this;
        }

        public Criteria andKpfsIsNotNull() {
            addCriterion("kpfs is not null");
            return (Criteria) this;
        }

        public Criteria andKpfsEqualTo(String value) {
            addCriterion("kpfs =", value, "kpfs");
            return (Criteria) this;
        }

        public Criteria andKpfsNotEqualTo(String value) {
            addCriterion("kpfs <>", value, "kpfs");
            return (Criteria) this;
        }

        public Criteria andKpfsGreaterThan(String value) {
            addCriterion("kpfs >", value, "kpfs");
            return (Criteria) this;
        }

        public Criteria andKpfsGreaterThanOrEqualTo(String value) {
            addCriterion("kpfs >=", value, "kpfs");
            return (Criteria) this;
        }

        public Criteria andKpfsLessThan(String value) {
            addCriterion("kpfs <", value, "kpfs");
            return (Criteria) this;
        }

        public Criteria andKpfsLessThanOrEqualTo(String value) {
            addCriterion("kpfs <=", value, "kpfs");
            return (Criteria) this;
        }

        public Criteria andKpfsLike(String value) {
            addCriterion("kpfs like", value, "kpfs");
            return (Criteria) this;
        }

        public Criteria andKpfsNotLike(String value) {
            addCriterion("kpfs not like", value, "kpfs");
            return (Criteria) this;
        }

        public Criteria andKpfsIn(List<String> values) {
            addCriterion("kpfs in", values, "kpfs");
            return (Criteria) this;
        }

        public Criteria andKpfsNotIn(List<String> values) {
            addCriterion("kpfs not in", values, "kpfs");
            return (Criteria) this;
        }

        public Criteria andKpfsBetween(String value1, String value2) {
            addCriterion("kpfs between", value1, value2, "kpfs");
            return (Criteria) this;
        }

        public Criteria andKpfsNotBetween(String value1, String value2) {
            addCriterion("kpfs not between", value1, value2, "kpfs");
            return (Criteria) this;
        }

        public Criteria andDwtpIsNull() {
            addCriterion("dwtp is null");
            return (Criteria) this;
        }

        public Criteria andDwtpIsNotNull() {
            addCriterion("dwtp is not null");
            return (Criteria) this;
        }

        public Criteria andDwtpEqualTo(String value) {
            addCriterion("dwtp =", value, "dwtp");
            return (Criteria) this;
        }

        public Criteria andDwtpNotEqualTo(String value) {
            addCriterion("dwtp <>", value, "dwtp");
            return (Criteria) this;
        }

        public Criteria andDwtpGreaterThan(String value) {
            addCriterion("dwtp >", value, "dwtp");
            return (Criteria) this;
        }

        public Criteria andDwtpGreaterThanOrEqualTo(String value) {
            addCriterion("dwtp >=", value, "dwtp");
            return (Criteria) this;
        }

        public Criteria andDwtpLessThan(String value) {
            addCriterion("dwtp <", value, "dwtp");
            return (Criteria) this;
        }

        public Criteria andDwtpLessThanOrEqualTo(String value) {
            addCriterion("dwtp <=", value, "dwtp");
            return (Criteria) this;
        }

        public Criteria andDwtpLike(String value) {
            addCriterion("dwtp like", value, "dwtp");
            return (Criteria) this;
        }

        public Criteria andDwtpNotLike(String value) {
            addCriterion("dwtp not like", value, "dwtp");
            return (Criteria) this;
        }

        public Criteria andDwtpIn(List<String> values) {
            addCriterion("dwtp in", values, "dwtp");
            return (Criteria) this;
        }

        public Criteria andDwtpNotIn(List<String> values) {
            addCriterion("dwtp not in", values, "dwtp");
            return (Criteria) this;
        }

        public Criteria andDwtpBetween(String value1, String value2) {
            addCriterion("dwtp between", value1, value2, "dwtp");
            return (Criteria) this;
        }

        public Criteria andDwtpNotBetween(String value1, String value2) {
            addCriterion("dwtp not between", value1, value2, "dwtp");
            return (Criteria) this;
        }

        public Criteria andCwzgIsNull() {
            addCriterion("cwzg is null");
            return (Criteria) this;
        }

        public Criteria andCwzgIsNotNull() {
            addCriterion("cwzg is not null");
            return (Criteria) this;
        }

        public Criteria andCwzgEqualTo(String value) {
            addCriterion("cwzg =", value, "cwzg");
            return (Criteria) this;
        }

        public Criteria andCwzgNotEqualTo(String value) {
            addCriterion("cwzg <>", value, "cwzg");
            return (Criteria) this;
        }

        public Criteria andCwzgGreaterThan(String value) {
            addCriterion("cwzg >", value, "cwzg");
            return (Criteria) this;
        }

        public Criteria andCwzgGreaterThanOrEqualTo(String value) {
            addCriterion("cwzg >=", value, "cwzg");
            return (Criteria) this;
        }

        public Criteria andCwzgLessThan(String value) {
            addCriterion("cwzg <", value, "cwzg");
            return (Criteria) this;
        }

        public Criteria andCwzgLessThanOrEqualTo(String value) {
            addCriterion("cwzg <=", value, "cwzg");
            return (Criteria) this;
        }

        public Criteria andCwzgLike(String value) {
            addCriterion("cwzg like", value, "cwzg");
            return (Criteria) this;
        }

        public Criteria andCwzgNotLike(String value) {
            addCriterion("cwzg not like", value, "cwzg");
            return (Criteria) this;
        }

        public Criteria andCwzgIn(List<String> values) {
            addCriterion("cwzg in", values, "cwzg");
            return (Criteria) this;
        }

        public Criteria andCwzgNotIn(List<String> values) {
            addCriterion("cwzg not in", values, "cwzg");
            return (Criteria) this;
        }

        public Criteria andCwzgBetween(String value1, String value2) {
            addCriterion("cwzg between", value1, value2, "cwzg");
            return (Criteria) this;
        }

        public Criteria andCwzgNotBetween(String value1, String value2) {
            addCriterion("cwzg not between", value1, value2, "cwzg");
            return (Criteria) this;
        }

        public Criteria andDyzthIsNull() {
            addCriterion("dyzth is null");
            return (Criteria) this;
        }

        public Criteria andDyzthIsNotNull() {
            addCriterion("dyzth is not null");
            return (Criteria) this;
        }

        public Criteria andDyzthEqualTo(String value) {
            addCriterion("dyzth =", value, "dyzth");
            return (Criteria) this;
        }

        public Criteria andDyzthNotEqualTo(String value) {
            addCriterion("dyzth <>", value, "dyzth");
            return (Criteria) this;
        }

        public Criteria andDyzthGreaterThan(String value) {
            addCriterion("dyzth >", value, "dyzth");
            return (Criteria) this;
        }

        public Criteria andDyzthGreaterThanOrEqualTo(String value) {
            addCriterion("dyzth >=", value, "dyzth");
            return (Criteria) this;
        }

        public Criteria andDyzthLessThan(String value) {
            addCriterion("dyzth <", value, "dyzth");
            return (Criteria) this;
        }

        public Criteria andDyzthLessThanOrEqualTo(String value) {
            addCriterion("dyzth <=", value, "dyzth");
            return (Criteria) this;
        }

        public Criteria andDyzthLike(String value) {
            addCriterion("dyzth like", value, "dyzth");
            return (Criteria) this;
        }

        public Criteria andDyzthNotLike(String value) {
            addCriterion("dyzth not like", value, "dyzth");
            return (Criteria) this;
        }

        public Criteria andDyzthIn(List<String> values) {
            addCriterion("dyzth in", values, "dyzth");
            return (Criteria) this;
        }

        public Criteria andDyzthNotIn(List<String> values) {
            addCriterion("dyzth not in", values, "dyzth");
            return (Criteria) this;
        }

        public Criteria andDyzthBetween(String value1, String value2) {
            addCriterion("dyzth between", value1, value2, "dyzth");
            return (Criteria) this;
        }

        public Criteria andDyzthNotBetween(String value1, String value2) {
            addCriterion("dyzth not between", value1, value2, "dyzth");
            return (Criteria) this;
        }

        public Criteria andKhhIsNull() {
            addCriterion("khh is null");
            return (Criteria) this;
        }

        public Criteria andKhhIsNotNull() {
            addCriterion("khh is not null");
            return (Criteria) this;
        }

        public Criteria andKhhEqualTo(String value) {
            addCriterion("khh =", value, "khh");
            return (Criteria) this;
        }

        public Criteria andKhhNotEqualTo(String value) {
            addCriterion("khh <>", value, "khh");
            return (Criteria) this;
        }

        public Criteria andKhhGreaterThan(String value) {
            addCriterion("khh >", value, "khh");
            return (Criteria) this;
        }

        public Criteria andKhhGreaterThanOrEqualTo(String value) {
            addCriterion("khh >=", value, "khh");
            return (Criteria) this;
        }

        public Criteria andKhhLessThan(String value) {
            addCriterion("khh <", value, "khh");
            return (Criteria) this;
        }

        public Criteria andKhhLessThanOrEqualTo(String value) {
            addCriterion("khh <=", value, "khh");
            return (Criteria) this;
        }

        public Criteria andKhhLike(String value) {
            addCriterion("khh like", value, "khh");
            return (Criteria) this;
        }

        public Criteria andKhhNotLike(String value) {
            addCriterion("khh not like", value, "khh");
            return (Criteria) this;
        }

        public Criteria andKhhIn(List<String> values) {
            addCriterion("khh in", values, "khh");
            return (Criteria) this;
        }

        public Criteria andKhhNotIn(List<String> values) {
            addCriterion("khh not in", values, "khh");
            return (Criteria) this;
        }

        public Criteria andKhhBetween(String value1, String value2) {
            addCriterion("khh between", value1, value2, "khh");
            return (Criteria) this;
        }

        public Criteria andKhhNotBetween(String value1, String value2) {
            addCriterion("khh not between", value1, value2, "khh");
            return (Criteria) this;
        }

        public Criteria andSrhzhIsNull() {
            addCriterion("srhzh is null");
            return (Criteria) this;
        }

        public Criteria andSrhzhIsNotNull() {
            addCriterion("srhzh is not null");
            return (Criteria) this;
        }

        public Criteria andSrhzhEqualTo(String value) {
            addCriterion("srhzh =", value, "srhzh");
            return (Criteria) this;
        }

        public Criteria andSrhzhNotEqualTo(String value) {
            addCriterion("srhzh <>", value, "srhzh");
            return (Criteria) this;
        }

        public Criteria andSrhzhGreaterThan(String value) {
            addCriterion("srhzh >", value, "srhzh");
            return (Criteria) this;
        }

        public Criteria andSrhzhGreaterThanOrEqualTo(String value) {
            addCriterion("srhzh >=", value, "srhzh");
            return (Criteria) this;
        }

        public Criteria andSrhzhLessThan(String value) {
            addCriterion("srhzh <", value, "srhzh");
            return (Criteria) this;
        }

        public Criteria andSrhzhLessThanOrEqualTo(String value) {
            addCriterion("srhzh <=", value, "srhzh");
            return (Criteria) this;
        }

        public Criteria andSrhzhLike(String value) {
            addCriterion("srhzh like", value, "srhzh");
            return (Criteria) this;
        }

        public Criteria andSrhzhNotLike(String value) {
            addCriterion("srhzh not like", value, "srhzh");
            return (Criteria) this;
        }

        public Criteria andSrhzhIn(List<String> values) {
            addCriterion("srhzh in", values, "srhzh");
            return (Criteria) this;
        }

        public Criteria andSrhzhNotIn(List<String> values) {
            addCriterion("srhzh not in", values, "srhzh");
            return (Criteria) this;
        }

        public Criteria andSrhzhBetween(String value1, String value2) {
            addCriterion("srhzh between", value1, value2, "srhzh");
            return (Criteria) this;
        }

        public Criteria andSrhzhNotBetween(String value1, String value2) {
            addCriterion("srhzh not between", value1, value2, "srhzh");
            return (Criteria) this;
        }

        public Criteria andZchzhIsNull() {
            addCriterion("zchzh is null");
            return (Criteria) this;
        }

        public Criteria andZchzhIsNotNull() {
            addCriterion("zchzh is not null");
            return (Criteria) this;
        }

        public Criteria andZchzhEqualTo(String value) {
            addCriterion("zchzh =", value, "zchzh");
            return (Criteria) this;
        }

        public Criteria andZchzhNotEqualTo(String value) {
            addCriterion("zchzh <>", value, "zchzh");
            return (Criteria) this;
        }

        public Criteria andZchzhGreaterThan(String value) {
            addCriterion("zchzh >", value, "zchzh");
            return (Criteria) this;
        }

        public Criteria andZchzhGreaterThanOrEqualTo(String value) {
            addCriterion("zchzh >=", value, "zchzh");
            return (Criteria) this;
        }

        public Criteria andZchzhLessThan(String value) {
            addCriterion("zchzh <", value, "zchzh");
            return (Criteria) this;
        }

        public Criteria andZchzhLessThanOrEqualTo(String value) {
            addCriterion("zchzh <=", value, "zchzh");
            return (Criteria) this;
        }

        public Criteria andZchzhLike(String value) {
            addCriterion("zchzh like", value, "zchzh");
            return (Criteria) this;
        }

        public Criteria andZchzhNotLike(String value) {
            addCriterion("zchzh not like", value, "zchzh");
            return (Criteria) this;
        }

        public Criteria andZchzhIn(List<String> values) {
            addCriterion("zchzh in", values, "zchzh");
            return (Criteria) this;
        }

        public Criteria andZchzhNotIn(List<String> values) {
            addCriterion("zchzh not in", values, "zchzh");
            return (Criteria) this;
        }

        public Criteria andZchzhBetween(String value1, String value2) {
            addCriterion("zchzh between", value1, value2, "zchzh");
            return (Criteria) this;
        }

        public Criteria andZchzhNotBetween(String value1, String value2) {
            addCriterion("zchzh not between", value1, value2, "zchzh");
            return (Criteria) this;
        }

        public Criteria andZgzbhIsNull() {
            addCriterion("zgzbh is null");
            return (Criteria) this;
        }

        public Criteria andZgzbhIsNotNull() {
            addCriterion("zgzbh is not null");
            return (Criteria) this;
        }

        public Criteria andZgzbhEqualTo(String value) {
            addCriterion("zgzbh =", value, "zgzbh");
            return (Criteria) this;
        }

        public Criteria andZgzbhNotEqualTo(String value) {
            addCriterion("zgzbh <>", value, "zgzbh");
            return (Criteria) this;
        }

        public Criteria andZgzbhGreaterThan(String value) {
            addCriterion("zgzbh >", value, "zgzbh");
            return (Criteria) this;
        }

        public Criteria andZgzbhGreaterThanOrEqualTo(String value) {
            addCriterion("zgzbh >=", value, "zgzbh");
            return (Criteria) this;
        }

        public Criteria andZgzbhLessThan(String value) {
            addCriterion("zgzbh <", value, "zgzbh");
            return (Criteria) this;
        }

        public Criteria andZgzbhLessThanOrEqualTo(String value) {
            addCriterion("zgzbh <=", value, "zgzbh");
            return (Criteria) this;
        }

        public Criteria andZgzbhLike(String value) {
            addCriterion("zgzbh like", value, "zgzbh");
            return (Criteria) this;
        }

        public Criteria andZgzbhNotLike(String value) {
            addCriterion("zgzbh not like", value, "zgzbh");
            return (Criteria) this;
        }

        public Criteria andZgzbhIn(List<String> values) {
            addCriterion("zgzbh in", values, "zgzbh");
            return (Criteria) this;
        }

        public Criteria andZgzbhNotIn(List<String> values) {
            addCriterion("zgzbh not in", values, "zgzbh");
            return (Criteria) this;
        }

        public Criteria andZgzbhBetween(String value1, String value2) {
            addCriterion("zgzbh between", value1, value2, "zgzbh");
            return (Criteria) this;
        }

        public Criteria andZgzbhNotBetween(String value1, String value2) {
            addCriterion("zgzbh not between", value1, value2, "zgzbh");
            return (Criteria) this;
        }

        public Criteria andSfxkzhIsNull() {
            addCriterion("sfxkzh is null");
            return (Criteria) this;
        }

        public Criteria andSfxkzhIsNotNull() {
            addCriterion("sfxkzh is not null");
            return (Criteria) this;
        }

        public Criteria andSfxkzhEqualTo(String value) {
            addCriterion("sfxkzh =", value, "sfxkzh");
            return (Criteria) this;
        }

        public Criteria andSfxkzhNotEqualTo(String value) {
            addCriterion("sfxkzh <>", value, "sfxkzh");
            return (Criteria) this;
        }

        public Criteria andSfxkzhGreaterThan(String value) {
            addCriterion("sfxkzh >", value, "sfxkzh");
            return (Criteria) this;
        }

        public Criteria andSfxkzhGreaterThanOrEqualTo(String value) {
            addCriterion("sfxkzh >=", value, "sfxkzh");
            return (Criteria) this;
        }

        public Criteria andSfxkzhLessThan(String value) {
            addCriterion("sfxkzh <", value, "sfxkzh");
            return (Criteria) this;
        }

        public Criteria andSfxkzhLessThanOrEqualTo(String value) {
            addCriterion("sfxkzh <=", value, "sfxkzh");
            return (Criteria) this;
        }

        public Criteria andSfxkzhLike(String value) {
            addCriterion("sfxkzh like", value, "sfxkzh");
            return (Criteria) this;
        }

        public Criteria andSfxkzhNotLike(String value) {
            addCriterion("sfxkzh not like", value, "sfxkzh");
            return (Criteria) this;
        }

        public Criteria andSfxkzhIn(List<String> values) {
            addCriterion("sfxkzh in", values, "sfxkzh");
            return (Criteria) this;
        }

        public Criteria andSfxkzhNotIn(List<String> values) {
            addCriterion("sfxkzh not in", values, "sfxkzh");
            return (Criteria) this;
        }

        public Criteria andSfxkzhBetween(String value1, String value2) {
            addCriterion("sfxkzh between", value1, value2, "sfxkzh");
            return (Criteria) this;
        }

        public Criteria andSfxkzhNotBetween(String value1, String value2) {
            addCriterion("sfxkzh not between", value1, value2, "sfxkzh");
            return (Criteria) this;
        }

        public Criteria andDefStr1IsNull() {
            addCriterion("def_str1 is null");
            return (Criteria) this;
        }

        public Criteria andDefStr1IsNotNull() {
            addCriterion("def_str1 is not null");
            return (Criteria) this;
        }

        public Criteria andDefStr1EqualTo(String value) {
            addCriterion("def_str1 =", value, "defStr1");
            return (Criteria) this;
        }

        public Criteria andDefStr1NotEqualTo(String value) {
            addCriterion("def_str1 <>", value, "defStr1");
            return (Criteria) this;
        }

        public Criteria andDefStr1GreaterThan(String value) {
            addCriterion("def_str1 >", value, "defStr1");
            return (Criteria) this;
        }

        public Criteria andDefStr1GreaterThanOrEqualTo(String value) {
            addCriterion("def_str1 >=", value, "defStr1");
            return (Criteria) this;
        }

        public Criteria andDefStr1LessThan(String value) {
            addCriterion("def_str1 <", value, "defStr1");
            return (Criteria) this;
        }

        public Criteria andDefStr1LessThanOrEqualTo(String value) {
            addCriterion("def_str1 <=", value, "defStr1");
            return (Criteria) this;
        }

        public Criteria andDefStr1Like(String value) {
            addCriterion("def_str1 like", value, "defStr1");
            return (Criteria) this;
        }

        public Criteria andDefStr1NotLike(String value) {
            addCriterion("def_str1 not like", value, "defStr1");
            return (Criteria) this;
        }

        public Criteria andDefStr1In(List<String> values) {
            addCriterion("def_str1 in", values, "defStr1");
            return (Criteria) this;
        }

        public Criteria andDefStr1NotIn(List<String> values) {
            addCriterion("def_str1 not in", values, "defStr1");
            return (Criteria) this;
        }

        public Criteria andDefStr1Between(String value1, String value2) {
            addCriterion("def_str1 between", value1, value2, "defStr1");
            return (Criteria) this;
        }

        public Criteria andDefStr1NotBetween(String value1, String value2) {
            addCriterion("def_str1 not between", value1, value2, "defStr1");
            return (Criteria) this;
        }

        public Criteria andDefStr2IsNull() {
            addCriterion("def_str2 is null");
            return (Criteria) this;
        }

        public Criteria andDefStr2IsNotNull() {
            addCriterion("def_str2 is not null");
            return (Criteria) this;
        }

        public Criteria andDefStr2EqualTo(String value) {
            addCriterion("def_str2 =", value, "defStr2");
            return (Criteria) this;
        }

        public Criteria andDefStr2NotEqualTo(String value) {
            addCriterion("def_str2 <>", value, "defStr2");
            return (Criteria) this;
        }

        public Criteria andDefStr2GreaterThan(String value) {
            addCriterion("def_str2 >", value, "defStr2");
            return (Criteria) this;
        }

        public Criteria andDefStr2GreaterThanOrEqualTo(String value) {
            addCriterion("def_str2 >=", value, "defStr2");
            return (Criteria) this;
        }

        public Criteria andDefStr2LessThan(String value) {
            addCriterion("def_str2 <", value, "defStr2");
            return (Criteria) this;
        }

        public Criteria andDefStr2LessThanOrEqualTo(String value) {
            addCriterion("def_str2 <=", value, "defStr2");
            return (Criteria) this;
        }

        public Criteria andDefStr2Like(String value) {
            addCriterion("def_str2 like", value, "defStr2");
            return (Criteria) this;
        }

        public Criteria andDefStr2NotLike(String value) {
            addCriterion("def_str2 not like", value, "defStr2");
            return (Criteria) this;
        }

        public Criteria andDefStr2In(List<String> values) {
            addCriterion("def_str2 in", values, "defStr2");
            return (Criteria) this;
        }

        public Criteria andDefStr2NotIn(List<String> values) {
            addCriterion("def_str2 not in", values, "defStr2");
            return (Criteria) this;
        }

        public Criteria andDefStr2Between(String value1, String value2) {
            addCriterion("def_str2 between", value1, value2, "defStr2");
            return (Criteria) this;
        }

        public Criteria andDefStr2NotBetween(String value1, String value2) {
            addCriterion("def_str2 not between", value1, value2, "defStr2");
            return (Criteria) this;
        }

        public Criteria andDefStr3IsNull() {
            addCriterion("def_str3 is null");
            return (Criteria) this;
        }

        public Criteria andDefStr3IsNotNull() {
            addCriterion("def_str3 is not null");
            return (Criteria) this;
        }

        public Criteria andDefStr3EqualTo(String value) {
            addCriterion("def_str3 =", value, "defStr3");
            return (Criteria) this;
        }

        public Criteria andDefStr3NotEqualTo(String value) {
            addCriterion("def_str3 <>", value, "defStr3");
            return (Criteria) this;
        }

        public Criteria andDefStr3GreaterThan(String value) {
            addCriterion("def_str3 >", value, "defStr3");
            return (Criteria) this;
        }

        public Criteria andDefStr3GreaterThanOrEqualTo(String value) {
            addCriterion("def_str3 >=", value, "defStr3");
            return (Criteria) this;
        }

        public Criteria andDefStr3LessThan(String value) {
            addCriterion("def_str3 <", value, "defStr3");
            return (Criteria) this;
        }

        public Criteria andDefStr3LessThanOrEqualTo(String value) {
            addCriterion("def_str3 <=", value, "defStr3");
            return (Criteria) this;
        }

        public Criteria andDefStr3Like(String value) {
            addCriterion("def_str3 like", value, "defStr3");
            return (Criteria) this;
        }

        public Criteria andDefStr3NotLike(String value) {
            addCriterion("def_str3 not like", value, "defStr3");
            return (Criteria) this;
        }

        public Criteria andDefStr3In(List<String> values) {
            addCriterion("def_str3 in", values, "defStr3");
            return (Criteria) this;
        }

        public Criteria andDefStr3NotIn(List<String> values) {
            addCriterion("def_str3 not in", values, "defStr3");
            return (Criteria) this;
        }

        public Criteria andDefStr3Between(String value1, String value2) {
            addCriterion("def_str3 between", value1, value2, "defStr3");
            return (Criteria) this;
        }

        public Criteria andDefStr3NotBetween(String value1, String value2) {
            addCriterion("def_str3 not between", value1, value2, "defStr3");
            return (Criteria) this;
        }

        public Criteria andDefStr4IsNull() {
            addCriterion("def_str4 is null");
            return (Criteria) this;
        }

        public Criteria andDefStr4IsNotNull() {
            addCriterion("def_str4 is not null");
            return (Criteria) this;
        }

        public Criteria andDefStr4EqualTo(String value) {
            addCriterion("def_str4 =", value, "defStr4");
            return (Criteria) this;
        }

        public Criteria andDefStr4NotEqualTo(String value) {
            addCriterion("def_str4 <>", value, "defStr4");
            return (Criteria) this;
        }

        public Criteria andDefStr4GreaterThan(String value) {
            addCriterion("def_str4 >", value, "defStr4");
            return (Criteria) this;
        }

        public Criteria andDefStr4GreaterThanOrEqualTo(String value) {
            addCriterion("def_str4 >=", value, "defStr4");
            return (Criteria) this;
        }

        public Criteria andDefStr4LessThan(String value) {
            addCriterion("def_str4 <", value, "defStr4");
            return (Criteria) this;
        }

        public Criteria andDefStr4LessThanOrEqualTo(String value) {
            addCriterion("def_str4 <=", value, "defStr4");
            return (Criteria) this;
        }

        public Criteria andDefStr4Like(String value) {
            addCriterion("def_str4 like", value, "defStr4");
            return (Criteria) this;
        }

        public Criteria andDefStr4NotLike(String value) {
            addCriterion("def_str4 not like", value, "defStr4");
            return (Criteria) this;
        }

        public Criteria andDefStr4In(List<String> values) {
            addCriterion("def_str4 in", values, "defStr4");
            return (Criteria) this;
        }

        public Criteria andDefStr4NotIn(List<String> values) {
            addCriterion("def_str4 not in", values, "defStr4");
            return (Criteria) this;
        }

        public Criteria andDefStr4Between(String value1, String value2) {
            addCriterion("def_str4 between", value1, value2, "defStr4");
            return (Criteria) this;
        }

        public Criteria andDefStr4NotBetween(String value1, String value2) {
            addCriterion("def_str4 not between", value1, value2, "defStr4");
            return (Criteria) this;
        }

        public Criteria andDefStr5IsNull() {
            addCriterion("def_str5 is null");
            return (Criteria) this;
        }

        public Criteria andDefStr5IsNotNull() {
            addCriterion("def_str5 is not null");
            return (Criteria) this;
        }

        public Criteria andDefStr5EqualTo(String value) {
            addCriterion("def_str5 =", value, "defStr5");
            return (Criteria) this;
        }

        public Criteria andDefStr5NotEqualTo(String value) {
            addCriterion("def_str5 <>", value, "defStr5");
            return (Criteria) this;
        }

        public Criteria andDefStr5GreaterThan(String value) {
            addCriterion("def_str5 >", value, "defStr5");
            return (Criteria) this;
        }

        public Criteria andDefStr5GreaterThanOrEqualTo(String value) {
            addCriterion("def_str5 >=", value, "defStr5");
            return (Criteria) this;
        }

        public Criteria andDefStr5LessThan(String value) {
            addCriterion("def_str5 <", value, "defStr5");
            return (Criteria) this;
        }

        public Criteria andDefStr5LessThanOrEqualTo(String value) {
            addCriterion("def_str5 <=", value, "defStr5");
            return (Criteria) this;
        }

        public Criteria andDefStr5Like(String value) {
            addCriterion("def_str5 like", value, "defStr5");
            return (Criteria) this;
        }

        public Criteria andDefStr5NotLike(String value) {
            addCriterion("def_str5 not like", value, "defStr5");
            return (Criteria) this;
        }

        public Criteria andDefStr5In(List<String> values) {
            addCriterion("def_str5 in", values, "defStr5");
            return (Criteria) this;
        }

        public Criteria andDefStr5NotIn(List<String> values) {
            addCriterion("def_str5 not in", values, "defStr5");
            return (Criteria) this;
        }

        public Criteria andDefStr5Between(String value1, String value2) {
            addCriterion("def_str5 between", value1, value2, "defStr5");
            return (Criteria) this;
        }

        public Criteria andDefStr5NotBetween(String value1, String value2) {
            addCriterion("def_str5 not between", value1, value2, "defStr5");
            return (Criteria) this;
        }

        public Criteria andDefInt1IsNull() {
            addCriterion("def_int1 is null");
            return (Criteria) this;
        }

        public Criteria andDefInt1IsNotNull() {
            addCriterion("def_int1 is not null");
            return (Criteria) this;
        }

        public Criteria andDefInt1EqualTo(int value) {
            addCriterion("def_int1 =", value, "defInt1");
            return (Criteria) this;
        }

        public Criteria andDefInt1NotEqualTo(int value) {
            addCriterion("def_int1 <>", value, "defInt1");
            return (Criteria) this;
        }

        public Criteria andDefInt1GreaterThan(int value) {
            addCriterion("def_int1 >", value, "defInt1");
            return (Criteria) this;
        }

        public Criteria andDefInt1GreaterThanOrEqualTo(int value) {
            addCriterion("def_int1 >=", value, "defInt1");
            return (Criteria) this;
        }

        public Criteria andDefInt1LessThan(int value) {
            addCriterion("def_int1 <", value, "defInt1");
            return (Criteria) this;
        }

        public Criteria andDefInt1LessThanOrEqualTo(int value) {
            addCriterion("def_int1 <=", value, "defInt1");
            return (Criteria) this;
        }

        public Criteria andDefInt1In(List<Integer> values) {
            addCriterion("def_int1 in", values, "defInt1");
            return (Criteria) this;
        }

        public Criteria andDefInt1NotIn(List<Integer> values) {
            addCriterion("def_int1 not in", values, "defInt1");
            return (Criteria) this;
        }

        public Criteria andDefInt1Between(int value1, int value2) {
            addCriterion("def_int1 between", value1, value2, "defInt1");
            return (Criteria) this;
        }

        public Criteria andDefInt1NotBetween(int value1, int value2) {
            addCriterion("def_int1 not between", value1, value2, "defInt1");
            return (Criteria) this;
        }

        public Criteria andDefInt2IsNull() {
            addCriterion("def_int2 is null");
            return (Criteria) this;
        }

        public Criteria andDefInt2IsNotNull() {
            addCriterion("def_int2 is not null");
            return (Criteria) this;
        }

        public Criteria andDefInt2EqualTo(int value) {
            addCriterion("def_int2 =", value, "defInt2");
            return (Criteria) this;
        }

        public Criteria andDefInt2NotEqualTo(int value) {
            addCriterion("def_int2 <>", value, "defInt2");
            return (Criteria) this;
        }

        public Criteria andDefInt2GreaterThan(int value) {
            addCriterion("def_int2 >", value, "defInt2");
            return (Criteria) this;
        }

        public Criteria andDefInt2GreaterThanOrEqualTo(int value) {
            addCriterion("def_int2 >=", value, "defInt2");
            return (Criteria) this;
        }

        public Criteria andDefInt2LessThan(int value) {
            addCriterion("def_int2 <", value, "defInt2");
            return (Criteria) this;
        }

        public Criteria andDefInt2LessThanOrEqualTo(int value) {
            addCriterion("def_int2 <=", value, "defInt2");
            return (Criteria) this;
        }

        public Criteria andDefInt2In(List<Integer> values) {
            addCriterion("def_int2 in", values, "defInt2");
            return (Criteria) this;
        }

        public Criteria andDefInt2NotIn(List<Integer> values) {
            addCriterion("def_int2 not in", values, "defInt2");
            return (Criteria) this;
        }

        public Criteria andDefInt2Between(int value1, int value2) {
            addCriterion("def_int2 between", value1, value2, "defInt2");
            return (Criteria) this;
        }

        public Criteria andDefInt2NotBetween(int value1, int value2) {
            addCriterion("def_int2 not between", value1, value2, "defInt2");
            return (Criteria) this;
        }

        public Criteria andDefInt3IsNull() {
            addCriterion("def_int3 is null");
            return (Criteria) this;
        }

        public Criteria andDefInt3IsNotNull() {
            addCriterion("def_int3 is not null");
            return (Criteria) this;
        }

        public Criteria andDefInt3EqualTo(int value) {
            addCriterion("def_int3 =", value, "defInt3");
            return (Criteria) this;
        }

        public Criteria andDefInt3NotEqualTo(int value) {
            addCriterion("def_int3 <>", value, "defInt3");
            return (Criteria) this;
        }

        public Criteria andDefInt3GreaterThan(int value) {
            addCriterion("def_int3 >", value, "defInt3");
            return (Criteria) this;
        }

        public Criteria andDefInt3GreaterThanOrEqualTo(int value) {
            addCriterion("def_int3 >=", value, "defInt3");
            return (Criteria) this;
        }

        public Criteria andDefInt3LessThan(int value) {
            addCriterion("def_int3 <", value, "defInt3");
            return (Criteria) this;
        }

        public Criteria andDefInt3LessThanOrEqualTo(int value) {
            addCriterion("def_int3 <=", value, "defInt3");
            return (Criteria) this;
        }

        public Criteria andDefInt3In(List<Integer> values) {
            addCriterion("def_int3 in", values, "defInt3");
            return (Criteria) this;
        }

        public Criteria andDefInt3NotIn(List<Integer> values) {
            addCriterion("def_int3 not in", values, "defInt3");
            return (Criteria) this;
        }

        public Criteria andDefInt3Between(int value1, int value2) {
            addCriterion("def_int3 between", value1, value2, "defInt3");
            return (Criteria) this;
        }

        public Criteria andDefInt3NotBetween(int value1, int value2) {
            addCriterion("def_int3 not between", value1, value2, "defInt3");
            return (Criteria) this;
        }

        public Criteria andDefInt4IsNull() {
            addCriterion("def_int4 is null");
            return (Criteria) this;
        }

        public Criteria andDefInt4IsNotNull() {
            addCriterion("def_int4 is not null");
            return (Criteria) this;
        }

        public Criteria andDefInt4EqualTo(int value) {
            addCriterion("def_int4 =", value, "defInt4");
            return (Criteria) this;
        }

        public Criteria andDefInt4NotEqualTo(int value) {
            addCriterion("def_int4 <>", value, "defInt4");
            return (Criteria) this;
        }

        public Criteria andDefInt4GreaterThan(int value) {
            addCriterion("def_int4 >", value, "defInt4");
            return (Criteria) this;
        }

        public Criteria andDefInt4GreaterThanOrEqualTo(int value) {
            addCriterion("def_int4 >=", value, "defInt4");
            return (Criteria) this;
        }

        public Criteria andDefInt4LessThan(int value) {
            addCriterion("def_int4 <", value, "defInt4");
            return (Criteria) this;
        }

        public Criteria andDefInt4LessThanOrEqualTo(int value) {
            addCriterion("def_int4 <=", value, "defInt4");
            return (Criteria) this;
        }

        public Criteria andDefInt4In(List<Integer> values) {
            addCriterion("def_int4 in", values, "defInt4");
            return (Criteria) this;
        }

        public Criteria andDefInt4NotIn(List<Integer> values) {
            addCriterion("def_int4 not in", values, "defInt4");
            return (Criteria) this;
        }

        public Criteria andDefInt4Between(int value1, int value2) {
            addCriterion("def_int4 between", value1, value2, "defInt4");
            return (Criteria) this;
        }

        public Criteria andDefInt4NotBetween(int value1, int value2) {
            addCriterion("def_int4 not between", value1, value2, "defInt4");
            return (Criteria) this;
        }

        public Criteria andDefInt5IsNull() {
            addCriterion("def_int5 is null");
            return (Criteria) this;
        }

        public Criteria andDefInt5IsNotNull() {
            addCriterion("def_int5 is not null");
            return (Criteria) this;
        }

        public Criteria andDefInt5EqualTo(int value) {
            addCriterion("def_int5 =", value, "defInt5");
            return (Criteria) this;
        }

        public Criteria andDefInt5NotEqualTo(int value) {
            addCriterion("def_int5 <>", value, "defInt5");
            return (Criteria) this;
        }

        public Criteria andDefInt5GreaterThan(int value) {
            addCriterion("def_int5 >", value, "defInt5");
            return (Criteria) this;
        }

        public Criteria andDefInt5GreaterThanOrEqualTo(int value) {
            addCriterion("def_int5 >=", value, "defInt5");
            return (Criteria) this;
        }

        public Criteria andDefInt5LessThan(int value) {
            addCriterion("def_int5 <", value, "defInt5");
            return (Criteria) this;
        }

        public Criteria andDefInt5LessThanOrEqualTo(int value) {
            addCriterion("def_int5 <=", value, "defInt5");
            return (Criteria) this;
        }

        public Criteria andDefInt5In(List<Integer> values) {
            addCriterion("def_int5 in", values, "defInt5");
            return (Criteria) this;
        }

        public Criteria andDefInt5NotIn(List<Integer> values) {
            addCriterion("def_int5 not in", values, "defInt5");
            return (Criteria) this;
        }

        public Criteria andDefInt5Between(int value1, int value2) {
            addCriterion("def_int5 between", value1, value2, "defInt5");
            return (Criteria) this;
        }

        public Criteria andDefInt5NotBetween(int value1, int value2) {
            addCriterion("def_int5 not between", value1, value2, "defInt5");
            return (Criteria) this;
        }

        public Criteria andDefNum1IsNull() {
            addCriterion("def_num1 is null");
            return (Criteria) this;
        }

        public Criteria andDefNum1IsNotNull() {
            addCriterion("def_num1 is not null");
            return (Criteria) this;
        }

        public Criteria andDefNum1EqualTo(BigDecimal value) {
            addCriterion("def_num1 =", value, "defNum1");
            return (Criteria) this;
        }

        public Criteria andDefNum1NotEqualTo(BigDecimal value) {
            addCriterion("def_num1 <>", value, "defNum1");
            return (Criteria) this;
        }

        public Criteria andDefNum1GreaterThan(BigDecimal value) {
            addCriterion("def_num1 >", value, "defNum1");
            return (Criteria) this;
        }

        public Criteria andDefNum1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("def_num1 >=", value, "defNum1");
            return (Criteria) this;
        }

        public Criteria andDefNum1LessThan(BigDecimal value) {
            addCriterion("def_num1 <", value, "defNum1");
            return (Criteria) this;
        }

        public Criteria andDefNum1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("def_num1 <=", value, "defNum1");
            return (Criteria) this;
        }

        public Criteria andDefNum1In(List<BigDecimal> values) {
            addCriterion("def_num1 in", values, "defNum1");
            return (Criteria) this;
        }

        public Criteria andDefNum1NotIn(List<BigDecimal> values) {
            addCriterion("def_num1 not in", values, "defNum1");
            return (Criteria) this;
        }

        public Criteria andDefNum1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("def_num1 between", value1, value2, "defNum1");
            return (Criteria) this;
        }

        public Criteria andDefNum1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("def_num1 not between", value1, value2, "defNum1");
            return (Criteria) this;
        }

        public Criteria andDefNum2IsNull() {
            addCriterion("def_num2 is null");
            return (Criteria) this;
        }

        public Criteria andDefNum2IsNotNull() {
            addCriterion("def_num2 is not null");
            return (Criteria) this;
        }

        public Criteria andDefNum2EqualTo(BigDecimal value) {
            addCriterion("def_num2 =", value, "defNum2");
            return (Criteria) this;
        }

        public Criteria andDefNum2NotEqualTo(BigDecimal value) {
            addCriterion("def_num2 <>", value, "defNum2");
            return (Criteria) this;
        }

        public Criteria andDefNum2GreaterThan(BigDecimal value) {
            addCriterion("def_num2 >", value, "defNum2");
            return (Criteria) this;
        }

        public Criteria andDefNum2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("def_num2 >=", value, "defNum2");
            return (Criteria) this;
        }

        public Criteria andDefNum2LessThan(BigDecimal value) {
            addCriterion("def_num2 <", value, "defNum2");
            return (Criteria) this;
        }

        public Criteria andDefNum2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("def_num2 <=", value, "defNum2");
            return (Criteria) this;
        }

        public Criteria andDefNum2In(List<BigDecimal> values) {
            addCriterion("def_num2 in", values, "defNum2");
            return (Criteria) this;
        }

        public Criteria andDefNum2NotIn(List<BigDecimal> values) {
            addCriterion("def_num2 not in", values, "defNum2");
            return (Criteria) this;
        }

        public Criteria andDefNum2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("def_num2 between", value1, value2, "defNum2");
            return (Criteria) this;
        }

        public Criteria andDefNum2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("def_num2 not between", value1, value2, "defNum2");
            return (Criteria) this;
        }

        public Criteria andDefDt1IsNull() {
            addCriterion("def_dt1 is null");
            return (Criteria) this;
        }

        public Criteria andDefDt1IsNotNull() {
            addCriterion("def_dt1 is not null");
            return (Criteria) this;
        }

        public Criteria andDefDt1EqualTo(Date value) {
            addCriterionForJDBCDate("def_dt1 =", value, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1NotEqualTo(Date value) {
            addCriterionForJDBCDate("def_dt1 <>", value, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1GreaterThan(Date value) {
            addCriterionForJDBCDate("def_dt1 >", value, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("def_dt1 >=", value, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1LessThan(Date value) {
            addCriterionForJDBCDate("def_dt1 <", value, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1LessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("def_dt1 <=", value, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1In(List<Date> values) {
            addCriterionForJDBCDate("def_dt1 in", values, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1NotIn(List<Date> values) {
            addCriterionForJDBCDate("def_dt1 not in", values, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1Between(Date value1, Date value2) {
            addCriterionForJDBCDate("def_dt1 between", value1, value2, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1NotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("def_dt1 not between", value1, value2, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt2IsNull() {
            addCriterion("def_dt2 is null");
            return (Criteria) this;
        }

        public Criteria andDefDt2IsNotNull() {
            addCriterion("def_dt2 is not null");
            return (Criteria) this;
        }

        public Criteria andDefDt2EqualTo(Date value) {
            addCriterionForJDBCDate("def_dt2 =", value, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2NotEqualTo(Date value) {
            addCriterionForJDBCDate("def_dt2 <>", value, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2GreaterThan(Date value) {
            addCriterionForJDBCDate("def_dt2 >", value, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("def_dt2 >=", value, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2LessThan(Date value) {
            addCriterionForJDBCDate("def_dt2 <", value, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2LessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("def_dt2 <=", value, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2In(List<Date> values) {
            addCriterionForJDBCDate("def_dt2 in", values, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2NotIn(List<Date> values) {
            addCriterionForJDBCDate("def_dt2 not in", values, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2Between(Date value1, Date value2) {
            addCriterionForJDBCDate("def_dt2 between", value1, value2, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2NotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("def_dt2 not between", value1, value2, "defDt2");
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