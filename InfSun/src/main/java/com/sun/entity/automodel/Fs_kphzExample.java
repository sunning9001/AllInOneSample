package com.sun.entity.automodel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fs_kphzExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Fs_kphzExample() {
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

        public Criteria andId1IsNull() {
            addCriterion("id1 is null");
            return (Criteria) this;
        }

        public Criteria andId1IsNotNull() {
            addCriterion("id1 is not null");
            return (Criteria) this;
        }

        public Criteria andId1EqualTo(String value) {
            addCriterion("id1 =", value, "id1");
            return (Criteria) this;
        }

        public Criteria andId1NotEqualTo(String value) {
            addCriterion("id1 <>", value, "id1");
            return (Criteria) this;
        }

        public Criteria andId1GreaterThan(String value) {
            addCriterion("id1 >", value, "id1");
            return (Criteria) this;
        }

        public Criteria andId1GreaterThanOrEqualTo(String value) {
            addCriterion("id1 >=", value, "id1");
            return (Criteria) this;
        }

        public Criteria andId1LessThan(String value) {
            addCriterion("id1 <", value, "id1");
            return (Criteria) this;
        }

        public Criteria andId1LessThanOrEqualTo(String value) {
            addCriterion("id1 <=", value, "id1");
            return (Criteria) this;
        }

        public Criteria andId1Like(String value) {
            addCriterion("id1 like", value, "id1");
            return (Criteria) this;
        }

        public Criteria andId1NotLike(String value) {
            addCriterion("id1 not like", value, "id1");
            return (Criteria) this;
        }

        public Criteria andId1In(List<String> values) {
            addCriterion("id1 in", values, "id1");
            return (Criteria) this;
        }

        public Criteria andId1NotIn(List<String> values) {
            addCriterion("id1 not in", values, "id1");
            return (Criteria) this;
        }

        public Criteria andId1Between(String value1, String value2) {
            addCriterion("id1 between", value1, value2, "id1");
            return (Criteria) this;
        }

        public Criteria andId1NotBetween(String value1, String value2) {
            addCriterion("id1 not between", value1, value2, "id1");
            return (Criteria) this;
        }

        public Criteria andId2IsNull() {
            addCriterion("id2 is null");
            return (Criteria) this;
        }

        public Criteria andId2IsNotNull() {
            addCriterion("id2 is not null");
            return (Criteria) this;
        }

        public Criteria andId2EqualTo(int value) {
            addCriterion("id2 =", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2NotEqualTo(int value) {
            addCriterion("id2 <>", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2GreaterThan(int value) {
            addCriterion("id2 >", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2GreaterThanOrEqualTo(int value) {
            addCriterion("id2 >=", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2LessThan(int value) {
            addCriterion("id2 <", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2LessThanOrEqualTo(int value) {
            addCriterion("id2 <=", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2In(List<Integer> values) {
            addCriterion("id2 in", values, "id2");
            return (Criteria) this;
        }

        public Criteria andId2NotIn(List<Integer> values) {
            addCriterion("id2 not in", values, "id2");
            return (Criteria) this;
        }

        public Criteria andId2Between(int value1, int value2) {
            addCriterion("id2 between", value1, value2, "id2");
            return (Criteria) this;
        }

        public Criteria andId2NotBetween(int value1, int value2) {
            addCriterion("id2 not between", value1, value2, "id2");
            return (Criteria) this;
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

        public Criteria andYhdmIsNull() {
            addCriterion("yhdm is null");
            return (Criteria) this;
        }

        public Criteria andYhdmIsNotNull() {
            addCriterion("yhdm is not null");
            return (Criteria) this;
        }

        public Criteria andYhdmEqualTo(String value) {
            addCriterion("yhdm =", value, "yhdm");
            return (Criteria) this;
        }

        public Criteria andYhdmNotEqualTo(String value) {
            addCriterion("yhdm <>", value, "yhdm");
            return (Criteria) this;
        }

        public Criteria andYhdmGreaterThan(String value) {
            addCriterion("yhdm >", value, "yhdm");
            return (Criteria) this;
        }

        public Criteria andYhdmGreaterThanOrEqualTo(String value) {
            addCriterion("yhdm >=", value, "yhdm");
            return (Criteria) this;
        }

        public Criteria andYhdmLessThan(String value) {
            addCriterion("yhdm <", value, "yhdm");
            return (Criteria) this;
        }

        public Criteria andYhdmLessThanOrEqualTo(String value) {
            addCriterion("yhdm <=", value, "yhdm");
            return (Criteria) this;
        }

        public Criteria andYhdmLike(String value) {
            addCriterion("yhdm like", value, "yhdm");
            return (Criteria) this;
        }

        public Criteria andYhdmNotLike(String value) {
            addCriterion("yhdm not like", value, "yhdm");
            return (Criteria) this;
        }

        public Criteria andYhdmIn(List<String> values) {
            addCriterion("yhdm in", values, "yhdm");
            return (Criteria) this;
        }

        public Criteria andYhdmNotIn(List<String> values) {
            addCriterion("yhdm not in", values, "yhdm");
            return (Criteria) this;
        }

        public Criteria andYhdmBetween(String value1, String value2) {
            addCriterion("yhdm between", value1, value2, "yhdm");
            return (Criteria) this;
        }

        public Criteria andYhdmNotBetween(String value1, String value2) {
            addCriterion("yhdm not between", value1, value2, "yhdm");
            return (Criteria) this;
        }

        public Criteria andWddmIsNull() {
            addCriterion("wddm is null");
            return (Criteria) this;
        }

        public Criteria andWddmIsNotNull() {
            addCriterion("wddm is not null");
            return (Criteria) this;
        }

        public Criteria andWddmEqualTo(String value) {
            addCriterion("wddm =", value, "wddm");
            return (Criteria) this;
        }

        public Criteria andWddmNotEqualTo(String value) {
            addCriterion("wddm <>", value, "wddm");
            return (Criteria) this;
        }

        public Criteria andWddmGreaterThan(String value) {
            addCriterion("wddm >", value, "wddm");
            return (Criteria) this;
        }

        public Criteria andWddmGreaterThanOrEqualTo(String value) {
            addCriterion("wddm >=", value, "wddm");
            return (Criteria) this;
        }

        public Criteria andWddmLessThan(String value) {
            addCriterion("wddm <", value, "wddm");
            return (Criteria) this;
        }

        public Criteria andWddmLessThanOrEqualTo(String value) {
            addCriterion("wddm <=", value, "wddm");
            return (Criteria) this;
        }

        public Criteria andWddmLike(String value) {
            addCriterion("wddm like", value, "wddm");
            return (Criteria) this;
        }

        public Criteria andWddmNotLike(String value) {
            addCriterion("wddm not like", value, "wddm");
            return (Criteria) this;
        }

        public Criteria andWddmIn(List<String> values) {
            addCriterion("wddm in", values, "wddm");
            return (Criteria) this;
        }

        public Criteria andWddmNotIn(List<String> values) {
            addCriterion("wddm not in", values, "wddm");
            return (Criteria) this;
        }

        public Criteria andWddmBetween(String value1, String value2) {
            addCriterion("wddm between", value1, value2, "wddm");
            return (Criteria) this;
        }

        public Criteria andWddmNotBetween(String value1, String value2) {
            addCriterion("wddm not between", value1, value2, "wddm");
            return (Criteria) this;
        }

        public Criteria andPjrqIsNull() {
            addCriterion("pjrq is null");
            return (Criteria) this;
        }

        public Criteria andPjrqIsNotNull() {
            addCriterion("pjrq is not null");
            return (Criteria) this;
        }

        public Criteria andPjrqEqualTo(Date value) {
            addCriterion("pjrq =", value, "pjrq");
            return (Criteria) this;
        }

        public Criteria andPjrqNotEqualTo(Date value) {
            addCriterion("pjrq <>", value, "pjrq");
            return (Criteria) this;
        }

        public Criteria andPjrqGreaterThan(Date value) {
            addCriterion("pjrq >", value, "pjrq");
            return (Criteria) this;
        }

        public Criteria andPjrqGreaterThanOrEqualTo(Date value) {
            addCriterion("pjrq >=", value, "pjrq");
            return (Criteria) this;
        }

        public Criteria andPjrqLessThan(Date value) {
            addCriterion("pjrq <", value, "pjrq");
            return (Criteria) this;
        }

        public Criteria andPjrqLessThanOrEqualTo(Date value) {
            addCriterion("pjrq <=", value, "pjrq");
            return (Criteria) this;
        }

        public Criteria andPjrqIn(List<Date> values) {
            addCriterion("pjrq in", values, "pjrq");
            return (Criteria) this;
        }

        public Criteria andPjrqNotIn(List<Date> values) {
            addCriterion("pjrq not in", values, "pjrq");
            return (Criteria) this;
        }

        public Criteria andPjrqBetween(Date value1, Date value2) {
            addCriterion("pjrq between", value1, value2, "pjrq");
            return (Criteria) this;
        }

        public Criteria andPjrqNotBetween(Date value1, Date value2) {
            addCriterion("pjrq not between", value1, value2, "pjrq");
            return (Criteria) this;
        }

        public Criteria andPjlxIsNull() {
            addCriterion("pjlx is null");
            return (Criteria) this;
        }

        public Criteria andPjlxIsNotNull() {
            addCriterion("pjlx is not null");
            return (Criteria) this;
        }

        public Criteria andPjlxEqualTo(String value) {
            addCriterion("pjlx =", value, "pjlx");
            return (Criteria) this;
        }

        public Criteria andPjlxNotEqualTo(String value) {
            addCriterion("pjlx <>", value, "pjlx");
            return (Criteria) this;
        }

        public Criteria andPjlxGreaterThan(String value) {
            addCriterion("pjlx >", value, "pjlx");
            return (Criteria) this;
        }

        public Criteria andPjlxGreaterThanOrEqualTo(String value) {
            addCriterion("pjlx >=", value, "pjlx");
            return (Criteria) this;
        }

        public Criteria andPjlxLessThan(String value) {
            addCriterion("pjlx <", value, "pjlx");
            return (Criteria) this;
        }

        public Criteria andPjlxLessThanOrEqualTo(String value) {
            addCriterion("pjlx <=", value, "pjlx");
            return (Criteria) this;
        }

        public Criteria andPjlxLike(String value) {
            addCriterion("pjlx like", value, "pjlx");
            return (Criteria) this;
        }

        public Criteria andPjlxNotLike(String value) {
            addCriterion("pjlx not like", value, "pjlx");
            return (Criteria) this;
        }

        public Criteria andPjlxIn(List<String> values) {
            addCriterion("pjlx in", values, "pjlx");
            return (Criteria) this;
        }

        public Criteria andPjlxNotIn(List<String> values) {
            addCriterion("pjlx not in", values, "pjlx");
            return (Criteria) this;
        }

        public Criteria andPjlxBetween(String value1, String value2) {
            addCriterion("pjlx between", value1, value2, "pjlx");
            return (Criteria) this;
        }

        public Criteria andPjlxNotBetween(String value1, String value2) {
            addCriterion("pjlx not between", value1, value2, "pjlx");
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

        public Criteria andPjhIsNull() {
            addCriterion("pjh is null");
            return (Criteria) this;
        }

        public Criteria andPjhIsNotNull() {
            addCriterion("pjh is not null");
            return (Criteria) this;
        }

        public Criteria andPjhEqualTo(String value) {
            addCriterion("pjh =", value, "pjh");
            return (Criteria) this;
        }

        public Criteria andPjhNotEqualTo(String value) {
            addCriterion("pjh <>", value, "pjh");
            return (Criteria) this;
        }

        public Criteria andPjhGreaterThan(String value) {
            addCriterion("pjh >", value, "pjh");
            return (Criteria) this;
        }

        public Criteria andPjhGreaterThanOrEqualTo(String value) {
            addCriterion("pjh >=", value, "pjh");
            return (Criteria) this;
        }

        public Criteria andPjhLessThan(String value) {
            addCriterion("pjh <", value, "pjh");
            return (Criteria) this;
        }

        public Criteria andPjhLessThanOrEqualTo(String value) {
            addCriterion("pjh <=", value, "pjh");
            return (Criteria) this;
        }

        public Criteria andPjhLike(String value) {
            addCriterion("pjh like", value, "pjh");
            return (Criteria) this;
        }

        public Criteria andPjhNotLike(String value) {
            addCriterion("pjh not like", value, "pjh");
            return (Criteria) this;
        }

        public Criteria andPjhIn(List<String> values) {
            addCriterion("pjh in", values, "pjh");
            return (Criteria) this;
        }

        public Criteria andPjhNotIn(List<String> values) {
            addCriterion("pjh not in", values, "pjh");
            return (Criteria) this;
        }

        public Criteria andPjhBetween(String value1, String value2) {
            addCriterion("pjh between", value1, value2, "pjh");
            return (Criteria) this;
        }

        public Criteria andPjhNotBetween(String value1, String value2) {
            addCriterion("pjh not between", value1, value2, "pjh");
            return (Criteria) this;
        }

        public Criteria andJkshIsNull() {
            addCriterion("jksh is null");
            return (Criteria) this;
        }

        public Criteria andJkshIsNotNull() {
            addCriterion("jksh is not null");
            return (Criteria) this;
        }

        public Criteria andJkshEqualTo(String value) {
            addCriterion("jksh =", value, "jksh");
            return (Criteria) this;
        }

        public Criteria andJkshNotEqualTo(String value) {
            addCriterion("jksh <>", value, "jksh");
            return (Criteria) this;
        }

        public Criteria andJkshGreaterThan(String value) {
            addCriterion("jksh >", value, "jksh");
            return (Criteria) this;
        }

        public Criteria andJkshGreaterThanOrEqualTo(String value) {
            addCriterion("jksh >=", value, "jksh");
            return (Criteria) this;
        }

        public Criteria andJkshLessThan(String value) {
            addCriterion("jksh <", value, "jksh");
            return (Criteria) this;
        }

        public Criteria andJkshLessThanOrEqualTo(String value) {
            addCriterion("jksh <=", value, "jksh");
            return (Criteria) this;
        }

        public Criteria andJkshLike(String value) {
            addCriterion("jksh like", value, "jksh");
            return (Criteria) this;
        }

        public Criteria andJkshNotLike(String value) {
            addCriterion("jksh not like", value, "jksh");
            return (Criteria) this;
        }

        public Criteria andJkshIn(List<String> values) {
            addCriterion("jksh in", values, "jksh");
            return (Criteria) this;
        }

        public Criteria andJkshNotIn(List<String> values) {
            addCriterion("jksh not in", values, "jksh");
            return (Criteria) this;
        }

        public Criteria andJkshBetween(String value1, String value2) {
            addCriterion("jksh between", value1, value2, "jksh");
            return (Criteria) this;
        }

        public Criteria andJkshNotBetween(String value1, String value2) {
            addCriterion("jksh not between", value1, value2, "jksh");
            return (Criteria) this;
        }

        public Criteria andJkrqIsNull() {
            addCriterion("jkrq is null");
            return (Criteria) this;
        }

        public Criteria andJkrqIsNotNull() {
            addCriterion("jkrq is not null");
            return (Criteria) this;
        }

        public Criteria andJkrqEqualTo(Date value) {
            addCriterion("jkrq =", value, "jkrq");
            return (Criteria) this;
        }

        public Criteria andJkrqNotEqualTo(Date value) {
            addCriterion("jkrq <>", value, "jkrq");
            return (Criteria) this;
        }

        public Criteria andJkrqGreaterThan(Date value) {
            addCriterion("jkrq >", value, "jkrq");
            return (Criteria) this;
        }

        public Criteria andJkrqGreaterThanOrEqualTo(Date value) {
            addCriterion("jkrq >=", value, "jkrq");
            return (Criteria) this;
        }

        public Criteria andJkrqLessThan(Date value) {
            addCriterion("jkrq <", value, "jkrq");
            return (Criteria) this;
        }

        public Criteria andJkrqLessThanOrEqualTo(Date value) {
            addCriterion("jkrq <=", value, "jkrq");
            return (Criteria) this;
        }

        public Criteria andJkrqIn(List<Date> values) {
            addCriterion("jkrq in", values, "jkrq");
            return (Criteria) this;
        }

        public Criteria andJkrqNotIn(List<Date> values) {
            addCriterion("jkrq not in", values, "jkrq");
            return (Criteria) this;
        }

        public Criteria andJkrqBetween(Date value1, Date value2) {
            addCriterion("jkrq between", value1, value2, "jkrq");
            return (Criteria) this;
        }

        public Criteria andJkrqNotBetween(Date value1, Date value2) {
            addCriterion("jkrq not between", value1, value2, "jkrq");
            return (Criteria) this;
        }

        public Criteria andJkrIsNull() {
            addCriterion("jkr is null");
            return (Criteria) this;
        }

        public Criteria andJkrIsNotNull() {
            addCriterion("jkr is not null");
            return (Criteria) this;
        }

        public Criteria andJkrEqualTo(String value) {
            addCriterion("jkr =", value, "jkr");
            return (Criteria) this;
        }

        public Criteria andJkrNotEqualTo(String value) {
            addCriterion("jkr <>", value, "jkr");
            return (Criteria) this;
        }

        public Criteria andJkrGreaterThan(String value) {
            addCriterion("jkr >", value, "jkr");
            return (Criteria) this;
        }

        public Criteria andJkrGreaterThanOrEqualTo(String value) {
            addCriterion("jkr >=", value, "jkr");
            return (Criteria) this;
        }

        public Criteria andJkrLessThan(String value) {
            addCriterion("jkr <", value, "jkr");
            return (Criteria) this;
        }

        public Criteria andJkrLessThanOrEqualTo(String value) {
            addCriterion("jkr <=", value, "jkr");
            return (Criteria) this;
        }

        public Criteria andJkrLike(String value) {
            addCriterion("jkr like", value, "jkr");
            return (Criteria) this;
        }

        public Criteria andJkrNotLike(String value) {
            addCriterion("jkr not like", value, "jkr");
            return (Criteria) this;
        }

        public Criteria andJkrIn(List<String> values) {
            addCriterion("jkr in", values, "jkr");
            return (Criteria) this;
        }

        public Criteria andJkrNotIn(List<String> values) {
            addCriterion("jkr not in", values, "jkr");
            return (Criteria) this;
        }

        public Criteria andJkrBetween(String value1, String value2) {
            addCriterion("jkr between", value1, value2, "jkr");
            return (Criteria) this;
        }

        public Criteria andJkrNotBetween(String value1, String value2) {
            addCriterion("jkr not between", value1, value2, "jkr");
            return (Criteria) this;
        }

        public Criteria andXmdmIsNull() {
            addCriterion("xmdm is null");
            return (Criteria) this;
        }

        public Criteria andXmdmIsNotNull() {
            addCriterion("xmdm is not null");
            return (Criteria) this;
        }

        public Criteria andXmdmEqualTo(String value) {
            addCriterion("xmdm =", value, "xmdm");
            return (Criteria) this;
        }

        public Criteria andXmdmNotEqualTo(String value) {
            addCriterion("xmdm <>", value, "xmdm");
            return (Criteria) this;
        }

        public Criteria andXmdmGreaterThan(String value) {
            addCriterion("xmdm >", value, "xmdm");
            return (Criteria) this;
        }

        public Criteria andXmdmGreaterThanOrEqualTo(String value) {
            addCriterion("xmdm >=", value, "xmdm");
            return (Criteria) this;
        }

        public Criteria andXmdmLessThan(String value) {
            addCriterion("xmdm <", value, "xmdm");
            return (Criteria) this;
        }

        public Criteria andXmdmLessThanOrEqualTo(String value) {
            addCriterion("xmdm <=", value, "xmdm");
            return (Criteria) this;
        }

        public Criteria andXmdmLike(String value) {
            addCriterion("xmdm like", value, "xmdm");
            return (Criteria) this;
        }

        public Criteria andXmdmNotLike(String value) {
            addCriterion("xmdm not like", value, "xmdm");
            return (Criteria) this;
        }

        public Criteria andXmdmIn(List<String> values) {
            addCriterion("xmdm in", values, "xmdm");
            return (Criteria) this;
        }

        public Criteria andXmdmNotIn(List<String> values) {
            addCriterion("xmdm not in", values, "xmdm");
            return (Criteria) this;
        }

        public Criteria andXmdmBetween(String value1, String value2) {
            addCriterion("xmdm between", value1, value2, "xmdm");
            return (Criteria) this;
        }

        public Criteria andXmdmNotBetween(String value1, String value2) {
            addCriterion("xmdm not between", value1, value2, "xmdm");
            return (Criteria) this;
        }

        public Criteria andZyIsNull() {
            addCriterion("zy is null");
            return (Criteria) this;
        }

        public Criteria andZyIsNotNull() {
            addCriterion("zy is not null");
            return (Criteria) this;
        }

        public Criteria andZyEqualTo(String value) {
            addCriterion("zy =", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotEqualTo(String value) {
            addCriterion("zy <>", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyGreaterThan(String value) {
            addCriterion("zy >", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyGreaterThanOrEqualTo(String value) {
            addCriterion("zy >=", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyLessThan(String value) {
            addCriterion("zy <", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyLessThanOrEqualTo(String value) {
            addCriterion("zy <=", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyLike(String value) {
            addCriterion("zy like", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotLike(String value) {
            addCriterion("zy not like", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyIn(List<String> values) {
            addCriterion("zy in", values, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotIn(List<String> values) {
            addCriterion("zy not in", values, "zy");
            return (Criteria) this;
        }

        public Criteria andZyBetween(String value1, String value2) {
            addCriterion("zy between", value1, value2, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotBetween(String value1, String value2) {
            addCriterion("zy not between", value1, value2, "zy");
            return (Criteria) this;
        }

        public Criteria andJeIsNull() {
            addCriterion("je is null");
            return (Criteria) this;
        }

        public Criteria andJeIsNotNull() {
            addCriterion("je is not null");
            return (Criteria) this;
        }

        public Criteria andJeEqualTo(BigDecimal value) {
            addCriterion("je =", value, "je");
            return (Criteria) this;
        }

        public Criteria andJeNotEqualTo(BigDecimal value) {
            addCriterion("je <>", value, "je");
            return (Criteria) this;
        }

        public Criteria andJeGreaterThan(BigDecimal value) {
            addCriterion("je >", value, "je");
            return (Criteria) this;
        }

        public Criteria andJeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("je >=", value, "je");
            return (Criteria) this;
        }

        public Criteria andJeLessThan(BigDecimal value) {
            addCriterion("je <", value, "je");
            return (Criteria) this;
        }

        public Criteria andJeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("je <=", value, "je");
            return (Criteria) this;
        }

        public Criteria andJeIn(List<BigDecimal> values) {
            addCriterion("je in", values, "je");
            return (Criteria) this;
        }

        public Criteria andJeNotIn(List<BigDecimal> values) {
            addCriterion("je not in", values, "je");
            return (Criteria) this;
        }

        public Criteria andJeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("je between", value1, value2, "je");
            return (Criteria) this;
        }

        public Criteria andJeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("je not between", value1, value2, "je");
            return (Criteria) this;
        }

        public Criteria andDwIsNull() {
            addCriterion("dw is null");
            return (Criteria) this;
        }

        public Criteria andDwIsNotNull() {
            addCriterion("dw is not null");
            return (Criteria) this;
        }

        public Criteria andDwEqualTo(String value) {
            addCriterion("dw =", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotEqualTo(String value) {
            addCriterion("dw <>", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwGreaterThan(String value) {
            addCriterion("dw >", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwGreaterThanOrEqualTo(String value) {
            addCriterion("dw >=", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwLessThan(String value) {
            addCriterion("dw <", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwLessThanOrEqualTo(String value) {
            addCriterion("dw <=", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwLike(String value) {
            addCriterion("dw like", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotLike(String value) {
            addCriterion("dw not like", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwIn(List<String> values) {
            addCriterion("dw in", values, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotIn(List<String> values) {
            addCriterion("dw not in", values, "dw");
            return (Criteria) this;
        }

        public Criteria andDwBetween(String value1, String value2) {
            addCriterion("dw between", value1, value2, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotBetween(String value1, String value2) {
            addCriterion("dw not between", value1, value2, "dw");
            return (Criteria) this;
        }

        public Criteria andSlIsNull() {
            addCriterion("sl is null");
            return (Criteria) this;
        }

        public Criteria andSlIsNotNull() {
            addCriterion("sl is not null");
            return (Criteria) this;
        }

        public Criteria andSlEqualTo(BigDecimal value) {
            addCriterion("sl =", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotEqualTo(BigDecimal value) {
            addCriterion("sl <>", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlGreaterThan(BigDecimal value) {
            addCriterion("sl >", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sl >=", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlLessThan(BigDecimal value) {
            addCriterion("sl <", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sl <=", value, "sl");
            return (Criteria) this;
        }

        public Criteria andSlIn(List<BigDecimal> values) {
            addCriterion("sl in", values, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotIn(List<BigDecimal> values) {
            addCriterion("sl not in", values, "sl");
            return (Criteria) this;
        }

        public Criteria andSlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sl between", value1, value2, "sl");
            return (Criteria) this;
        }

        public Criteria andSlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sl not between", value1, value2, "sl");
            return (Criteria) this;
        }

        public Criteria andSfbzIsNull() {
            addCriterion("sfbz is null");
            return (Criteria) this;
        }

        public Criteria andSfbzIsNotNull() {
            addCriterion("sfbz is not null");
            return (Criteria) this;
        }

        public Criteria andSfbzEqualTo(BigDecimal value) {
            addCriterion("sfbz =", value, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzNotEqualTo(BigDecimal value) {
            addCriterion("sfbz <>", value, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzGreaterThan(BigDecimal value) {
            addCriterion("sfbz >", value, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sfbz >=", value, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzLessThan(BigDecimal value) {
            addCriterion("sfbz <", value, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sfbz <=", value, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzIn(List<BigDecimal> values) {
            addCriterion("sfbz in", values, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzNotIn(List<BigDecimal> values) {
            addCriterion("sfbz not in", values, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sfbz between", value1, value2, "sfbz");
            return (Criteria) this;
        }

        public Criteria andSfbzNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sfbz not between", value1, value2, "sfbz");
            return (Criteria) this;
        }

        public Criteria andKprIsNull() {
            addCriterion("kpr is null");
            return (Criteria) this;
        }

        public Criteria andKprIsNotNull() {
            addCriterion("kpr is not null");
            return (Criteria) this;
        }

        public Criteria andKprEqualTo(String value) {
            addCriterion("kpr =", value, "kpr");
            return (Criteria) this;
        }

        public Criteria andKprNotEqualTo(String value) {
            addCriterion("kpr <>", value, "kpr");
            return (Criteria) this;
        }

        public Criteria andKprGreaterThan(String value) {
            addCriterion("kpr >", value, "kpr");
            return (Criteria) this;
        }

        public Criteria andKprGreaterThanOrEqualTo(String value) {
            addCriterion("kpr >=", value, "kpr");
            return (Criteria) this;
        }

        public Criteria andKprLessThan(String value) {
            addCriterion("kpr <", value, "kpr");
            return (Criteria) this;
        }

        public Criteria andKprLessThanOrEqualTo(String value) {
            addCriterion("kpr <=", value, "kpr");
            return (Criteria) this;
        }

        public Criteria andKprLike(String value) {
            addCriterion("kpr like", value, "kpr");
            return (Criteria) this;
        }

        public Criteria andKprNotLike(String value) {
            addCriterion("kpr not like", value, "kpr");
            return (Criteria) this;
        }

        public Criteria andKprIn(List<String> values) {
            addCriterion("kpr in", values, "kpr");
            return (Criteria) this;
        }

        public Criteria andKprNotIn(List<String> values) {
            addCriterion("kpr not in", values, "kpr");
            return (Criteria) this;
        }

        public Criteria andKprBetween(String value1, String value2) {
            addCriterion("kpr between", value1, value2, "kpr");
            return (Criteria) this;
        }

        public Criteria andKprNotBetween(String value1, String value2) {
            addCriterion("kpr not between", value1, value2, "kpr");
            return (Criteria) this;
        }

        public Criteria andJsrIsNull() {
            addCriterion("jsr is null");
            return (Criteria) this;
        }

        public Criteria andJsrIsNotNull() {
            addCriterion("jsr is not null");
            return (Criteria) this;
        }

        public Criteria andJsrEqualTo(String value) {
            addCriterion("jsr =", value, "jsr");
            return (Criteria) this;
        }

        public Criteria andJsrNotEqualTo(String value) {
            addCriterion("jsr <>", value, "jsr");
            return (Criteria) this;
        }

        public Criteria andJsrGreaterThan(String value) {
            addCriterion("jsr >", value, "jsr");
            return (Criteria) this;
        }

        public Criteria andJsrGreaterThanOrEqualTo(String value) {
            addCriterion("jsr >=", value, "jsr");
            return (Criteria) this;
        }

        public Criteria andJsrLessThan(String value) {
            addCriterion("jsr <", value, "jsr");
            return (Criteria) this;
        }

        public Criteria andJsrLessThanOrEqualTo(String value) {
            addCriterion("jsr <=", value, "jsr");
            return (Criteria) this;
        }

        public Criteria andJsrLike(String value) {
            addCriterion("jsr like", value, "jsr");
            return (Criteria) this;
        }

        public Criteria andJsrNotLike(String value) {
            addCriterion("jsr not like", value, "jsr");
            return (Criteria) this;
        }

        public Criteria andJsrIn(List<String> values) {
            addCriterion("jsr in", values, "jsr");
            return (Criteria) this;
        }

        public Criteria andJsrNotIn(List<String> values) {
            addCriterion("jsr not in", values, "jsr");
            return (Criteria) this;
        }

        public Criteria andJsrBetween(String value1, String value2) {
            addCriterion("jsr between", value1, value2, "jsr");
            return (Criteria) this;
        }

        public Criteria andJsrNotBetween(String value1, String value2) {
            addCriterion("jsr not between", value1, value2, "jsr");
            return (Criteria) this;
        }

        public Criteria andShrIsNull() {
            addCriterion("shr is null");
            return (Criteria) this;
        }

        public Criteria andShrIsNotNull() {
            addCriterion("shr is not null");
            return (Criteria) this;
        }

        public Criteria andShrEqualTo(String value) {
            addCriterion("shr =", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrNotEqualTo(String value) {
            addCriterion("shr <>", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrGreaterThan(String value) {
            addCriterion("shr >", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrGreaterThanOrEqualTo(String value) {
            addCriterion("shr >=", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrLessThan(String value) {
            addCriterion("shr <", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrLessThanOrEqualTo(String value) {
            addCriterion("shr <=", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrLike(String value) {
            addCriterion("shr like", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrNotLike(String value) {
            addCriterion("shr not like", value, "shr");
            return (Criteria) this;
        }

        public Criteria andShrIn(List<String> values) {
            addCriterion("shr in", values, "shr");
            return (Criteria) this;
        }

        public Criteria andShrNotIn(List<String> values) {
            addCriterion("shr not in", values, "shr");
            return (Criteria) this;
        }

        public Criteria andShrBetween(String value1, String value2) {
            addCriterion("shr between", value1, value2, "shr");
            return (Criteria) this;
        }

        public Criteria andShrNotBetween(String value1, String value2) {
            addCriterion("shr not between", value1, value2, "shr");
            return (Criteria) this;
        }

        public Criteria andHxrIsNull() {
            addCriterion("hxr is null");
            return (Criteria) this;
        }

        public Criteria andHxrIsNotNull() {
            addCriterion("hxr is not null");
            return (Criteria) this;
        }

        public Criteria andHxrEqualTo(String value) {
            addCriterion("hxr =", value, "hxr");
            return (Criteria) this;
        }

        public Criteria andHxrNotEqualTo(String value) {
            addCriterion("hxr <>", value, "hxr");
            return (Criteria) this;
        }

        public Criteria andHxrGreaterThan(String value) {
            addCriterion("hxr >", value, "hxr");
            return (Criteria) this;
        }

        public Criteria andHxrGreaterThanOrEqualTo(String value) {
            addCriterion("hxr >=", value, "hxr");
            return (Criteria) this;
        }

        public Criteria andHxrLessThan(String value) {
            addCriterion("hxr <", value, "hxr");
            return (Criteria) this;
        }

        public Criteria andHxrLessThanOrEqualTo(String value) {
            addCriterion("hxr <=", value, "hxr");
            return (Criteria) this;
        }

        public Criteria andHxrLike(String value) {
            addCriterion("hxr like", value, "hxr");
            return (Criteria) this;
        }

        public Criteria andHxrNotLike(String value) {
            addCriterion("hxr not like", value, "hxr");
            return (Criteria) this;
        }

        public Criteria andHxrIn(List<String> values) {
            addCriterion("hxr in", values, "hxr");
            return (Criteria) this;
        }

        public Criteria andHxrNotIn(List<String> values) {
            addCriterion("hxr not in", values, "hxr");
            return (Criteria) this;
        }

        public Criteria andHxrBetween(String value1, String value2) {
            addCriterion("hxr between", value1, value2, "hxr");
            return (Criteria) this;
        }

        public Criteria andHxrNotBetween(String value1, String value2) {
            addCriterion("hxr not between", value1, value2, "hxr");
            return (Criteria) this;
        }

        public Criteria andJsfsIsNull() {
            addCriterion("jsfs is null");
            return (Criteria) this;
        }

        public Criteria andJsfsIsNotNull() {
            addCriterion("jsfs is not null");
            return (Criteria) this;
        }

        public Criteria andJsfsEqualTo(int value) {
            addCriterion("jsfs =", value, "jsfs");
            return (Criteria) this;
        }

        public Criteria andJsfsNotEqualTo(int value) {
            addCriterion("jsfs <>", value, "jsfs");
            return (Criteria) this;
        }

        public Criteria andJsfsGreaterThan(int value) {
            addCriterion("jsfs >", value, "jsfs");
            return (Criteria) this;
        }

        public Criteria andJsfsGreaterThanOrEqualTo(int value) {
            addCriterion("jsfs >=", value, "jsfs");
            return (Criteria) this;
        }

        public Criteria andJsfsLessThan(int value) {
            addCriterion("jsfs <", value, "jsfs");
            return (Criteria) this;
        }

        public Criteria andJsfsLessThanOrEqualTo(int value) {
            addCriterion("jsfs <=", value, "jsfs");
            return (Criteria) this;
        }

        public Criteria andJsfsIn(List<Integer> values) {
            addCriterion("jsfs in", values, "jsfs");
            return (Criteria) this;
        }

        public Criteria andJsfsNotIn(List<Integer> values) {
            addCriterion("jsfs not in", values, "jsfs");
            return (Criteria) this;
        }

        public Criteria andJsfsBetween(int value1, int value2) {
            addCriterion("jsfs between", value1, value2, "jsfs");
            return (Criteria) this;
        }

        public Criteria andJsfsNotBetween(int value1, int value2) {
            addCriterion("jsfs not between", value1, value2, "jsfs");
            return (Criteria) this;
        }

        public Criteria andJspjhIsNull() {
            addCriterion("jspjh is null");
            return (Criteria) this;
        }

        public Criteria andJspjhIsNotNull() {
            addCriterion("jspjh is not null");
            return (Criteria) this;
        }

        public Criteria andJspjhEqualTo(String value) {
            addCriterion("jspjh =", value, "jspjh");
            return (Criteria) this;
        }

        public Criteria andJspjhNotEqualTo(String value) {
            addCriterion("jspjh <>", value, "jspjh");
            return (Criteria) this;
        }

        public Criteria andJspjhGreaterThan(String value) {
            addCriterion("jspjh >", value, "jspjh");
            return (Criteria) this;
        }

        public Criteria andJspjhGreaterThanOrEqualTo(String value) {
            addCriterion("jspjh >=", value, "jspjh");
            return (Criteria) this;
        }

        public Criteria andJspjhLessThan(String value) {
            addCriterion("jspjh <", value, "jspjh");
            return (Criteria) this;
        }

        public Criteria andJspjhLessThanOrEqualTo(String value) {
            addCriterion("jspjh <=", value, "jspjh");
            return (Criteria) this;
        }

        public Criteria andJspjhLike(String value) {
            addCriterion("jspjh like", value, "jspjh");
            return (Criteria) this;
        }

        public Criteria andJspjhNotLike(String value) {
            addCriterion("jspjh not like", value, "jspjh");
            return (Criteria) this;
        }

        public Criteria andJspjhIn(List<String> values) {
            addCriterion("jspjh in", values, "jspjh");
            return (Criteria) this;
        }

        public Criteria andJspjhNotIn(List<String> values) {
            addCriterion("jspjh not in", values, "jspjh");
            return (Criteria) this;
        }

        public Criteria andJspjhBetween(String value1, String value2) {
            addCriterion("jspjh between", value1, value2, "jspjh");
            return (Criteria) this;
        }

        public Criteria andJspjhNotBetween(String value1, String value2) {
            addCriterion("jspjh not between", value1, value2, "jspjh");
            return (Criteria) this;
        }

        public Criteria andJsyhIsNull() {
            addCriterion("jsyh is null");
            return (Criteria) this;
        }

        public Criteria andJsyhIsNotNull() {
            addCriterion("jsyh is not null");
            return (Criteria) this;
        }

        public Criteria andJsyhEqualTo(String value) {
            addCriterion("jsyh =", value, "jsyh");
            return (Criteria) this;
        }

        public Criteria andJsyhNotEqualTo(String value) {
            addCriterion("jsyh <>", value, "jsyh");
            return (Criteria) this;
        }

        public Criteria andJsyhGreaterThan(String value) {
            addCriterion("jsyh >", value, "jsyh");
            return (Criteria) this;
        }

        public Criteria andJsyhGreaterThanOrEqualTo(String value) {
            addCriterion("jsyh >=", value, "jsyh");
            return (Criteria) this;
        }

        public Criteria andJsyhLessThan(String value) {
            addCriterion("jsyh <", value, "jsyh");
            return (Criteria) this;
        }

        public Criteria andJsyhLessThanOrEqualTo(String value) {
            addCriterion("jsyh <=", value, "jsyh");
            return (Criteria) this;
        }

        public Criteria andJsyhLike(String value) {
            addCriterion("jsyh like", value, "jsyh");
            return (Criteria) this;
        }

        public Criteria andJsyhNotLike(String value) {
            addCriterion("jsyh not like", value, "jsyh");
            return (Criteria) this;
        }

        public Criteria andJsyhIn(List<String> values) {
            addCriterion("jsyh in", values, "jsyh");
            return (Criteria) this;
        }

        public Criteria andJsyhNotIn(List<String> values) {
            addCriterion("jsyh not in", values, "jsyh");
            return (Criteria) this;
        }

        public Criteria andJsyhBetween(String value1, String value2) {
            addCriterion("jsyh between", value1, value2, "jsyh");
            return (Criteria) this;
        }

        public Criteria andJsyhNotBetween(String value1, String value2) {
            addCriterion("jsyh not between", value1, value2, "jsyh");
            return (Criteria) this;
        }

        public Criteria andWldwdmIsNull() {
            addCriterion("wldwdm is null");
            return (Criteria) this;
        }

        public Criteria andWldwdmIsNotNull() {
            addCriterion("wldwdm is not null");
            return (Criteria) this;
        }

        public Criteria andWldwdmEqualTo(String value) {
            addCriterion("wldwdm =", value, "wldwdm");
            return (Criteria) this;
        }

        public Criteria andWldwdmNotEqualTo(String value) {
            addCriterion("wldwdm <>", value, "wldwdm");
            return (Criteria) this;
        }

        public Criteria andWldwdmGreaterThan(String value) {
            addCriterion("wldwdm >", value, "wldwdm");
            return (Criteria) this;
        }

        public Criteria andWldwdmGreaterThanOrEqualTo(String value) {
            addCriterion("wldwdm >=", value, "wldwdm");
            return (Criteria) this;
        }

        public Criteria andWldwdmLessThan(String value) {
            addCriterion("wldwdm <", value, "wldwdm");
            return (Criteria) this;
        }

        public Criteria andWldwdmLessThanOrEqualTo(String value) {
            addCriterion("wldwdm <=", value, "wldwdm");
            return (Criteria) this;
        }

        public Criteria andWldwdmLike(String value) {
            addCriterion("wldwdm like", value, "wldwdm");
            return (Criteria) this;
        }

        public Criteria andWldwdmNotLike(String value) {
            addCriterion("wldwdm not like", value, "wldwdm");
            return (Criteria) this;
        }

        public Criteria andWldwdmIn(List<String> values) {
            addCriterion("wldwdm in", values, "wldwdm");
            return (Criteria) this;
        }

        public Criteria andWldwdmNotIn(List<String> values) {
            addCriterion("wldwdm not in", values, "wldwdm");
            return (Criteria) this;
        }

        public Criteria andWldwdmBetween(String value1, String value2) {
            addCriterion("wldwdm between", value1, value2, "wldwdm");
            return (Criteria) this;
        }

        public Criteria andWldwdmNotBetween(String value1, String value2) {
            addCriterion("wldwdm not between", value1, value2, "wldwdm");
            return (Criteria) this;
        }

        public Criteria andWldwmcIsNull() {
            addCriterion("wldwmc is null");
            return (Criteria) this;
        }

        public Criteria andWldwmcIsNotNull() {
            addCriterion("wldwmc is not null");
            return (Criteria) this;
        }

        public Criteria andWldwmcEqualTo(String value) {
            addCriterion("wldwmc =", value, "wldwmc");
            return (Criteria) this;
        }

        public Criteria andWldwmcNotEqualTo(String value) {
            addCriterion("wldwmc <>", value, "wldwmc");
            return (Criteria) this;
        }

        public Criteria andWldwmcGreaterThan(String value) {
            addCriterion("wldwmc >", value, "wldwmc");
            return (Criteria) this;
        }

        public Criteria andWldwmcGreaterThanOrEqualTo(String value) {
            addCriterion("wldwmc >=", value, "wldwmc");
            return (Criteria) this;
        }

        public Criteria andWldwmcLessThan(String value) {
            addCriterion("wldwmc <", value, "wldwmc");
            return (Criteria) this;
        }

        public Criteria andWldwmcLessThanOrEqualTo(String value) {
            addCriterion("wldwmc <=", value, "wldwmc");
            return (Criteria) this;
        }

        public Criteria andWldwmcLike(String value) {
            addCriterion("wldwmc like", value, "wldwmc");
            return (Criteria) this;
        }

        public Criteria andWldwmcNotLike(String value) {
            addCriterion("wldwmc not like", value, "wldwmc");
            return (Criteria) this;
        }

        public Criteria andWldwmcIn(List<String> values) {
            addCriterion("wldwmc in", values, "wldwmc");
            return (Criteria) this;
        }

        public Criteria andWldwmcNotIn(List<String> values) {
            addCriterion("wldwmc not in", values, "wldwmc");
            return (Criteria) this;
        }

        public Criteria andWldwmcBetween(String value1, String value2) {
            addCriterion("wldwmc between", value1, value2, "wldwmc");
            return (Criteria) this;
        }

        public Criteria andWldwmcNotBetween(String value1, String value2) {
            addCriterion("wldwmc not between", value1, value2, "wldwmc");
            return (Criteria) this;
        }

        public Criteria andWldwkhIsNull() {
            addCriterion("wldwkh is null");
            return (Criteria) this;
        }

        public Criteria andWldwkhIsNotNull() {
            addCriterion("wldwkh is not null");
            return (Criteria) this;
        }

        public Criteria andWldwkhEqualTo(String value) {
            addCriterion("wldwkh =", value, "wldwkh");
            return (Criteria) this;
        }

        public Criteria andWldwkhNotEqualTo(String value) {
            addCriterion("wldwkh <>", value, "wldwkh");
            return (Criteria) this;
        }

        public Criteria andWldwkhGreaterThan(String value) {
            addCriterion("wldwkh >", value, "wldwkh");
            return (Criteria) this;
        }

        public Criteria andWldwkhGreaterThanOrEqualTo(String value) {
            addCriterion("wldwkh >=", value, "wldwkh");
            return (Criteria) this;
        }

        public Criteria andWldwkhLessThan(String value) {
            addCriterion("wldwkh <", value, "wldwkh");
            return (Criteria) this;
        }

        public Criteria andWldwkhLessThanOrEqualTo(String value) {
            addCriterion("wldwkh <=", value, "wldwkh");
            return (Criteria) this;
        }

        public Criteria andWldwkhLike(String value) {
            addCriterion("wldwkh like", value, "wldwkh");
            return (Criteria) this;
        }

        public Criteria andWldwkhNotLike(String value) {
            addCriterion("wldwkh not like", value, "wldwkh");
            return (Criteria) this;
        }

        public Criteria andWldwkhIn(List<String> values) {
            addCriterion("wldwkh in", values, "wldwkh");
            return (Criteria) this;
        }

        public Criteria andWldwkhNotIn(List<String> values) {
            addCriterion("wldwkh not in", values, "wldwkh");
            return (Criteria) this;
        }

        public Criteria andWldwkhBetween(String value1, String value2) {
            addCriterion("wldwkh between", value1, value2, "wldwkh");
            return (Criteria) this;
        }

        public Criteria andWldwkhNotBetween(String value1, String value2) {
            addCriterion("wldwkh not between", value1, value2, "wldwkh");
            return (Criteria) this;
        }

        public Criteria andWldwzhIsNull() {
            addCriterion("wldwzh is null");
            return (Criteria) this;
        }

        public Criteria andWldwzhIsNotNull() {
            addCriterion("wldwzh is not null");
            return (Criteria) this;
        }

        public Criteria andWldwzhEqualTo(String value) {
            addCriterion("wldwzh =", value, "wldwzh");
            return (Criteria) this;
        }

        public Criteria andWldwzhNotEqualTo(String value) {
            addCriterion("wldwzh <>", value, "wldwzh");
            return (Criteria) this;
        }

        public Criteria andWldwzhGreaterThan(String value) {
            addCriterion("wldwzh >", value, "wldwzh");
            return (Criteria) this;
        }

        public Criteria andWldwzhGreaterThanOrEqualTo(String value) {
            addCriterion("wldwzh >=", value, "wldwzh");
            return (Criteria) this;
        }

        public Criteria andWldwzhLessThan(String value) {
            addCriterion("wldwzh <", value, "wldwzh");
            return (Criteria) this;
        }

        public Criteria andWldwzhLessThanOrEqualTo(String value) {
            addCriterion("wldwzh <=", value, "wldwzh");
            return (Criteria) this;
        }

        public Criteria andWldwzhLike(String value) {
            addCriterion("wldwzh like", value, "wldwzh");
            return (Criteria) this;
        }

        public Criteria andWldwzhNotLike(String value) {
            addCriterion("wldwzh not like", value, "wldwzh");
            return (Criteria) this;
        }

        public Criteria andWldwzhIn(List<String> values) {
            addCriterion("wldwzh in", values, "wldwzh");
            return (Criteria) this;
        }

        public Criteria andWldwzhNotIn(List<String> values) {
            addCriterion("wldwzh not in", values, "wldwzh");
            return (Criteria) this;
        }

        public Criteria andWldwzhBetween(String value1, String value2) {
            addCriterion("wldwzh between", value1, value2, "wldwzh");
            return (Criteria) this;
        }

        public Criteria andWldwzhNotBetween(String value1, String value2) {
            addCriterion("wldwzh not between", value1, value2, "wldwzh");
            return (Criteria) this;
        }

        public Criteria andPjztIsNull() {
            addCriterion("pjzt is null");
            return (Criteria) this;
        }

        public Criteria andPjztIsNotNull() {
            addCriterion("pjzt is not null");
            return (Criteria) this;
        }

        public Criteria andPjztEqualTo(String value) {
            addCriterion("pjzt =", value, "pjzt");
            return (Criteria) this;
        }

        public Criteria andPjztNotEqualTo(String value) {
            addCriterion("pjzt <>", value, "pjzt");
            return (Criteria) this;
        }

        public Criteria andPjztGreaterThan(String value) {
            addCriterion("pjzt >", value, "pjzt");
            return (Criteria) this;
        }

        public Criteria andPjztGreaterThanOrEqualTo(String value) {
            addCriterion("pjzt >=", value, "pjzt");
            return (Criteria) this;
        }

        public Criteria andPjztLessThan(String value) {
            addCriterion("pjzt <", value, "pjzt");
            return (Criteria) this;
        }

        public Criteria andPjztLessThanOrEqualTo(String value) {
            addCriterion("pjzt <=", value, "pjzt");
            return (Criteria) this;
        }

        public Criteria andPjztLike(String value) {
            addCriterion("pjzt like", value, "pjzt");
            return (Criteria) this;
        }

        public Criteria andPjztNotLike(String value) {
            addCriterion("pjzt not like", value, "pjzt");
            return (Criteria) this;
        }

        public Criteria andPjztIn(List<String> values) {
            addCriterion("pjzt in", values, "pjzt");
            return (Criteria) this;
        }

        public Criteria andPjztNotIn(List<String> values) {
            addCriterion("pjzt not in", values, "pjzt");
            return (Criteria) this;
        }

        public Criteria andPjztBetween(String value1, String value2) {
            addCriterion("pjzt between", value1, value2, "pjzt");
            return (Criteria) this;
        }

        public Criteria andPjztNotBetween(String value1, String value2) {
            addCriterion("pjzt not between", value1, value2, "pjzt");
            return (Criteria) this;
        }

        public Criteria andTgPzlxIsNull() {
            addCriterion("tg_pzlx is null");
            return (Criteria) this;
        }

        public Criteria andTgPzlxIsNotNull() {
            addCriterion("tg_pzlx is not null");
            return (Criteria) this;
        }

        public Criteria andTgPzlxEqualTo(String value) {
            addCriterion("tg_pzlx =", value, "tgPzlx");
            return (Criteria) this;
        }

        public Criteria andTgPzlxNotEqualTo(String value) {
            addCriterion("tg_pzlx <>", value, "tgPzlx");
            return (Criteria) this;
        }

        public Criteria andTgPzlxGreaterThan(String value) {
            addCriterion("tg_pzlx >", value, "tgPzlx");
            return (Criteria) this;
        }

        public Criteria andTgPzlxGreaterThanOrEqualTo(String value) {
            addCriterion("tg_pzlx >=", value, "tgPzlx");
            return (Criteria) this;
        }

        public Criteria andTgPzlxLessThan(String value) {
            addCriterion("tg_pzlx <", value, "tgPzlx");
            return (Criteria) this;
        }

        public Criteria andTgPzlxLessThanOrEqualTo(String value) {
            addCriterion("tg_pzlx <=", value, "tgPzlx");
            return (Criteria) this;
        }

        public Criteria andTgPzlxLike(String value) {
            addCriterion("tg_pzlx like", value, "tgPzlx");
            return (Criteria) this;
        }

        public Criteria andTgPzlxNotLike(String value) {
            addCriterion("tg_pzlx not like", value, "tgPzlx");
            return (Criteria) this;
        }

        public Criteria andTgPzlxIn(List<String> values) {
            addCriterion("tg_pzlx in", values, "tgPzlx");
            return (Criteria) this;
        }

        public Criteria andTgPzlxNotIn(List<String> values) {
            addCriterion("tg_pzlx not in", values, "tgPzlx");
            return (Criteria) this;
        }

        public Criteria andTgPzlxBetween(String value1, String value2) {
            addCriterion("tg_pzlx between", value1, value2, "tgPzlx");
            return (Criteria) this;
        }

        public Criteria andTgPzlxNotBetween(String value1, String value2) {
            addCriterion("tg_pzlx not between", value1, value2, "tgPzlx");
            return (Criteria) this;
        }

        public Criteria andTgPzhIsNull() {
            addCriterion("tg_pzh is null");
            return (Criteria) this;
        }

        public Criteria andTgPzhIsNotNull() {
            addCriterion("tg_pzh is not null");
            return (Criteria) this;
        }

        public Criteria andTgPzhEqualTo(String value) {
            addCriterion("tg_pzh =", value, "tgPzh");
            return (Criteria) this;
        }

        public Criteria andTgPzhNotEqualTo(String value) {
            addCriterion("tg_pzh <>", value, "tgPzh");
            return (Criteria) this;
        }

        public Criteria andTgPzhGreaterThan(String value) {
            addCriterion("tg_pzh >", value, "tgPzh");
            return (Criteria) this;
        }

        public Criteria andTgPzhGreaterThanOrEqualTo(String value) {
            addCriterion("tg_pzh >=", value, "tgPzh");
            return (Criteria) this;
        }

        public Criteria andTgPzhLessThan(String value) {
            addCriterion("tg_pzh <", value, "tgPzh");
            return (Criteria) this;
        }

        public Criteria andTgPzhLessThanOrEqualTo(String value) {
            addCriterion("tg_pzh <=", value, "tgPzh");
            return (Criteria) this;
        }

        public Criteria andTgPzhLike(String value) {
            addCriterion("tg_pzh like", value, "tgPzh");
            return (Criteria) this;
        }

        public Criteria andTgPzhNotLike(String value) {
            addCriterion("tg_pzh not like", value, "tgPzh");
            return (Criteria) this;
        }

        public Criteria andTgPzhIn(List<String> values) {
            addCriterion("tg_pzh in", values, "tgPzh");
            return (Criteria) this;
        }

        public Criteria andTgPzhNotIn(List<String> values) {
            addCriterion("tg_pzh not in", values, "tgPzh");
            return (Criteria) this;
        }

        public Criteria andTgPzhBetween(String value1, String value2) {
            addCriterion("tg_pzh between", value1, value2, "tgPzh");
            return (Criteria) this;
        }

        public Criteria andTgPzhNotBetween(String value1, String value2) {
            addCriterion("tg_pzh not between", value1, value2, "tgPzh");
            return (Criteria) this;
        }

        public Criteria andTgPzrqIsNull() {
            addCriterion("tg_pzrq is null");
            return (Criteria) this;
        }

        public Criteria andTgPzrqIsNotNull() {
            addCriterion("tg_pzrq is not null");
            return (Criteria) this;
        }

        public Criteria andTgPzrqEqualTo(Date value) {
            addCriterion("tg_pzrq =", value, "tgPzrq");
            return (Criteria) this;
        }

        public Criteria andTgPzrqNotEqualTo(Date value) {
            addCriterion("tg_pzrq <>", value, "tgPzrq");
            return (Criteria) this;
        }

        public Criteria andTgPzrqGreaterThan(Date value) {
            addCriterion("tg_pzrq >", value, "tgPzrq");
            return (Criteria) this;
        }

        public Criteria andTgPzrqGreaterThanOrEqualTo(Date value) {
            addCriterion("tg_pzrq >=", value, "tgPzrq");
            return (Criteria) this;
        }

        public Criteria andTgPzrqLessThan(Date value) {
            addCriterion("tg_pzrq <", value, "tgPzrq");
            return (Criteria) this;
        }

        public Criteria andTgPzrqLessThanOrEqualTo(Date value) {
            addCriterion("tg_pzrq <=", value, "tgPzrq");
            return (Criteria) this;
        }

        public Criteria andTgPzrqIn(List<Date> values) {
            addCriterion("tg_pzrq in", values, "tgPzrq");
            return (Criteria) this;
        }

        public Criteria andTgPzrqNotIn(List<Date> values) {
            addCriterion("tg_pzrq not in", values, "tgPzrq");
            return (Criteria) this;
        }

        public Criteria andTgPzrqBetween(Date value1, Date value2) {
            addCriterion("tg_pzrq between", value1, value2, "tgPzrq");
            return (Criteria) this;
        }

        public Criteria andTgPzrqNotBetween(Date value1, Date value2) {
            addCriterion("tg_pzrq not between", value1, value2, "tgPzrq");
            return (Criteria) this;
        }

        public Criteria andStPzlxIsNull() {
            addCriterion("st_pzlx is null");
            return (Criteria) this;
        }

        public Criteria andStPzlxIsNotNull() {
            addCriterion("st_pzlx is not null");
            return (Criteria) this;
        }

        public Criteria andStPzlxEqualTo(String value) {
            addCriterion("st_pzlx =", value, "stPzlx");
            return (Criteria) this;
        }

        public Criteria andStPzlxNotEqualTo(String value) {
            addCriterion("st_pzlx <>", value, "stPzlx");
            return (Criteria) this;
        }

        public Criteria andStPzlxGreaterThan(String value) {
            addCriterion("st_pzlx >", value, "stPzlx");
            return (Criteria) this;
        }

        public Criteria andStPzlxGreaterThanOrEqualTo(String value) {
            addCriterion("st_pzlx >=", value, "stPzlx");
            return (Criteria) this;
        }

        public Criteria andStPzlxLessThan(String value) {
            addCriterion("st_pzlx <", value, "stPzlx");
            return (Criteria) this;
        }

        public Criteria andStPzlxLessThanOrEqualTo(String value) {
            addCriterion("st_pzlx <=", value, "stPzlx");
            return (Criteria) this;
        }

        public Criteria andStPzlxLike(String value) {
            addCriterion("st_pzlx like", value, "stPzlx");
            return (Criteria) this;
        }

        public Criteria andStPzlxNotLike(String value) {
            addCriterion("st_pzlx not like", value, "stPzlx");
            return (Criteria) this;
        }

        public Criteria andStPzlxIn(List<String> values) {
            addCriterion("st_pzlx in", values, "stPzlx");
            return (Criteria) this;
        }

        public Criteria andStPzlxNotIn(List<String> values) {
            addCriterion("st_pzlx not in", values, "stPzlx");
            return (Criteria) this;
        }

        public Criteria andStPzlxBetween(String value1, String value2) {
            addCriterion("st_pzlx between", value1, value2, "stPzlx");
            return (Criteria) this;
        }

        public Criteria andStPzlxNotBetween(String value1, String value2) {
            addCriterion("st_pzlx not between", value1, value2, "stPzlx");
            return (Criteria) this;
        }

        public Criteria andStPzhIsNull() {
            addCriterion("st_pzh is null");
            return (Criteria) this;
        }

        public Criteria andStPzhIsNotNull() {
            addCriterion("st_pzh is not null");
            return (Criteria) this;
        }

        public Criteria andStPzhEqualTo(String value) {
            addCriterion("st_pzh =", value, "stPzh");
            return (Criteria) this;
        }

        public Criteria andStPzhNotEqualTo(String value) {
            addCriterion("st_pzh <>", value, "stPzh");
            return (Criteria) this;
        }

        public Criteria andStPzhGreaterThan(String value) {
            addCriterion("st_pzh >", value, "stPzh");
            return (Criteria) this;
        }

        public Criteria andStPzhGreaterThanOrEqualTo(String value) {
            addCriterion("st_pzh >=", value, "stPzh");
            return (Criteria) this;
        }

        public Criteria andStPzhLessThan(String value) {
            addCriterion("st_pzh <", value, "stPzh");
            return (Criteria) this;
        }

        public Criteria andStPzhLessThanOrEqualTo(String value) {
            addCriterion("st_pzh <=", value, "stPzh");
            return (Criteria) this;
        }

        public Criteria andStPzhLike(String value) {
            addCriterion("st_pzh like", value, "stPzh");
            return (Criteria) this;
        }

        public Criteria andStPzhNotLike(String value) {
            addCriterion("st_pzh not like", value, "stPzh");
            return (Criteria) this;
        }

        public Criteria andStPzhIn(List<String> values) {
            addCriterion("st_pzh in", values, "stPzh");
            return (Criteria) this;
        }

        public Criteria andStPzhNotIn(List<String> values) {
            addCriterion("st_pzh not in", values, "stPzh");
            return (Criteria) this;
        }

        public Criteria andStPzhBetween(String value1, String value2) {
            addCriterion("st_pzh between", value1, value2, "stPzh");
            return (Criteria) this;
        }

        public Criteria andStPzhNotBetween(String value1, String value2) {
            addCriterion("st_pzh not between", value1, value2, "stPzh");
            return (Criteria) this;
        }

        public Criteria andStPzrqIsNull() {
            addCriterion("st_pzrq is null");
            return (Criteria) this;
        }

        public Criteria andStPzrqIsNotNull() {
            addCriterion("st_pzrq is not null");
            return (Criteria) this;
        }

        public Criteria andStPzrqEqualTo(Date value) {
            addCriterion("st_pzrq =", value, "stPzrq");
            return (Criteria) this;
        }

        public Criteria andStPzrqNotEqualTo(Date value) {
            addCriterion("st_pzrq <>", value, "stPzrq");
            return (Criteria) this;
        }

        public Criteria andStPzrqGreaterThan(Date value) {
            addCriterion("st_pzrq >", value, "stPzrq");
            return (Criteria) this;
        }

        public Criteria andStPzrqGreaterThanOrEqualTo(Date value) {
            addCriterion("st_pzrq >=", value, "stPzrq");
            return (Criteria) this;
        }

        public Criteria andStPzrqLessThan(Date value) {
            addCriterion("st_pzrq <", value, "stPzrq");
            return (Criteria) this;
        }

        public Criteria andStPzrqLessThanOrEqualTo(Date value) {
            addCriterion("st_pzrq <=", value, "stPzrq");
            return (Criteria) this;
        }

        public Criteria andStPzrqIn(List<Date> values) {
            addCriterion("st_pzrq in", values, "stPzrq");
            return (Criteria) this;
        }

        public Criteria andStPzrqNotIn(List<Date> values) {
            addCriterion("st_pzrq not in", values, "stPzrq");
            return (Criteria) this;
        }

        public Criteria andStPzrqBetween(Date value1, Date value2) {
            addCriterion("st_pzrq between", value1, value2, "stPzrq");
            return (Criteria) this;
        }

        public Criteria andStPzrqNotBetween(Date value1, Date value2) {
            addCriterion("st_pzrq not between", value1, value2, "stPzrq");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("bz is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("bz is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("bz =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("bz <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("bz >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("bz >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("bz <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("bz <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("bz like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("bz not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("bz in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("bz not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("bz between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("bz not between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andIszhIsNull() {
            addCriterion("iszh is null");
            return (Criteria) this;
        }

        public Criteria andIszhIsNotNull() {
            addCriterion("iszh is not null");
            return (Criteria) this;
        }

        public Criteria andIszhEqualTo(String value) {
            addCriterion("iszh =", value, "iszh");
            return (Criteria) this;
        }

        public Criteria andIszhNotEqualTo(String value) {
            addCriterion("iszh <>", value, "iszh");
            return (Criteria) this;
        }

        public Criteria andIszhGreaterThan(String value) {
            addCriterion("iszh >", value, "iszh");
            return (Criteria) this;
        }

        public Criteria andIszhGreaterThanOrEqualTo(String value) {
            addCriterion("iszh >=", value, "iszh");
            return (Criteria) this;
        }

        public Criteria andIszhLessThan(String value) {
            addCriterion("iszh <", value, "iszh");
            return (Criteria) this;
        }

        public Criteria andIszhLessThanOrEqualTo(String value) {
            addCriterion("iszh <=", value, "iszh");
            return (Criteria) this;
        }

        public Criteria andIszhLike(String value) {
            addCriterion("iszh like", value, "iszh");
            return (Criteria) this;
        }

        public Criteria andIszhNotLike(String value) {
            addCriterion("iszh not like", value, "iszh");
            return (Criteria) this;
        }

        public Criteria andIszhIn(List<String> values) {
            addCriterion("iszh in", values, "iszh");
            return (Criteria) this;
        }

        public Criteria andIszhNotIn(List<String> values) {
            addCriterion("iszh not in", values, "iszh");
            return (Criteria) this;
        }

        public Criteria andIszhBetween(String value1, String value2) {
            addCriterion("iszh between", value1, value2, "iszh");
            return (Criteria) this;
        }

        public Criteria andIszhNotBetween(String value1, String value2) {
            addCriterion("iszh not between", value1, value2, "iszh");
            return (Criteria) this;
        }

        public Criteria andIsprintIsNull() {
            addCriterion("isprint is null");
            return (Criteria) this;
        }

        public Criteria andIsprintIsNotNull() {
            addCriterion("isprint is not null");
            return (Criteria) this;
        }

        public Criteria andIsprintEqualTo(String value) {
            addCriterion("isprint =", value, "isprint");
            return (Criteria) this;
        }

        public Criteria andIsprintNotEqualTo(String value) {
            addCriterion("isprint <>", value, "isprint");
            return (Criteria) this;
        }

        public Criteria andIsprintGreaterThan(String value) {
            addCriterion("isprint >", value, "isprint");
            return (Criteria) this;
        }

        public Criteria andIsprintGreaterThanOrEqualTo(String value) {
            addCriterion("isprint >=", value, "isprint");
            return (Criteria) this;
        }

        public Criteria andIsprintLessThan(String value) {
            addCriterion("isprint <", value, "isprint");
            return (Criteria) this;
        }

        public Criteria andIsprintLessThanOrEqualTo(String value) {
            addCriterion("isprint <=", value, "isprint");
            return (Criteria) this;
        }

        public Criteria andIsprintLike(String value) {
            addCriterion("isprint like", value, "isprint");
            return (Criteria) this;
        }

        public Criteria andIsprintNotLike(String value) {
            addCriterion("isprint not like", value, "isprint");
            return (Criteria) this;
        }

        public Criteria andIsprintIn(List<String> values) {
            addCriterion("isprint in", values, "isprint");
            return (Criteria) this;
        }

        public Criteria andIsprintNotIn(List<String> values) {
            addCriterion("isprint not in", values, "isprint");
            return (Criteria) this;
        }

        public Criteria andIsprintBetween(String value1, String value2) {
            addCriterion("isprint between", value1, value2, "isprint");
            return (Criteria) this;
        }

        public Criteria andIsprintNotBetween(String value1, String value2) {
            addCriterion("isprint not between", value1, value2, "isprint");
            return (Criteria) this;
        }

        public Criteria andIsdwkpIsNull() {
            addCriterion("isdwkp is null");
            return (Criteria) this;
        }

        public Criteria andIsdwkpIsNotNull() {
            addCriterion("isdwkp is not null");
            return (Criteria) this;
        }

        public Criteria andIsdwkpEqualTo(String value) {
            addCriterion("isdwkp =", value, "isdwkp");
            return (Criteria) this;
        }

        public Criteria andIsdwkpNotEqualTo(String value) {
            addCriterion("isdwkp <>", value, "isdwkp");
            return (Criteria) this;
        }

        public Criteria andIsdwkpGreaterThan(String value) {
            addCriterion("isdwkp >", value, "isdwkp");
            return (Criteria) this;
        }

        public Criteria andIsdwkpGreaterThanOrEqualTo(String value) {
            addCriterion("isdwkp >=", value, "isdwkp");
            return (Criteria) this;
        }

        public Criteria andIsdwkpLessThan(String value) {
            addCriterion("isdwkp <", value, "isdwkp");
            return (Criteria) this;
        }

        public Criteria andIsdwkpLessThanOrEqualTo(String value) {
            addCriterion("isdwkp <=", value, "isdwkp");
            return (Criteria) this;
        }

        public Criteria andIsdwkpLike(String value) {
            addCriterion("isdwkp like", value, "isdwkp");
            return (Criteria) this;
        }

        public Criteria andIsdwkpNotLike(String value) {
            addCriterion("isdwkp not like", value, "isdwkp");
            return (Criteria) this;
        }

        public Criteria andIsdwkpIn(List<String> values) {
            addCriterion("isdwkp in", values, "isdwkp");
            return (Criteria) this;
        }

        public Criteria andIsdwkpNotIn(List<String> values) {
            addCriterion("isdwkp not in", values, "isdwkp");
            return (Criteria) this;
        }

        public Criteria andIsdwkpBetween(String value1, String value2) {
            addCriterion("isdwkp between", value1, value2, "isdwkp");
            return (Criteria) this;
        }

        public Criteria andIsdwkpNotBetween(String value1, String value2) {
            addCriterion("isdwkp not between", value1, value2, "isdwkp");
            return (Criteria) this;
        }

        public Criteria andIsyhkpIsNull() {
            addCriterion("isyhkp is null");
            return (Criteria) this;
        }

        public Criteria andIsyhkpIsNotNull() {
            addCriterion("isyhkp is not null");
            return (Criteria) this;
        }

        public Criteria andIsyhkpEqualTo(String value) {
            addCriterion("isyhkp =", value, "isyhkp");
            return (Criteria) this;
        }

        public Criteria andIsyhkpNotEqualTo(String value) {
            addCriterion("isyhkp <>", value, "isyhkp");
            return (Criteria) this;
        }

        public Criteria andIsyhkpGreaterThan(String value) {
            addCriterion("isyhkp >", value, "isyhkp");
            return (Criteria) this;
        }

        public Criteria andIsyhkpGreaterThanOrEqualTo(String value) {
            addCriterion("isyhkp >=", value, "isyhkp");
            return (Criteria) this;
        }

        public Criteria andIsyhkpLessThan(String value) {
            addCriterion("isyhkp <", value, "isyhkp");
            return (Criteria) this;
        }

        public Criteria andIsyhkpLessThanOrEqualTo(String value) {
            addCriterion("isyhkp <=", value, "isyhkp");
            return (Criteria) this;
        }

        public Criteria andIsyhkpLike(String value) {
            addCriterion("isyhkp like", value, "isyhkp");
            return (Criteria) this;
        }

        public Criteria andIsyhkpNotLike(String value) {
            addCriterion("isyhkp not like", value, "isyhkp");
            return (Criteria) this;
        }

        public Criteria andIsyhkpIn(List<String> values) {
            addCriterion("isyhkp in", values, "isyhkp");
            return (Criteria) this;
        }

        public Criteria andIsyhkpNotIn(List<String> values) {
            addCriterion("isyhkp not in", values, "isyhkp");
            return (Criteria) this;
        }

        public Criteria andIsyhkpBetween(String value1, String value2) {
            addCriterion("isyhkp between", value1, value2, "isyhkp");
            return (Criteria) this;
        }

        public Criteria andIsyhkpNotBetween(String value1, String value2) {
            addCriterion("isyhkp not between", value1, value2, "isyhkp");
            return (Criteria) this;
        }

        public Criteria andIsdwjkIsNull() {
            addCriterion("isdwjk is null");
            return (Criteria) this;
        }

        public Criteria andIsdwjkIsNotNull() {
            addCriterion("isdwjk is not null");
            return (Criteria) this;
        }

        public Criteria andIsdwjkEqualTo(String value) {
            addCriterion("isdwjk =", value, "isdwjk");
            return (Criteria) this;
        }

        public Criteria andIsdwjkNotEqualTo(String value) {
            addCriterion("isdwjk <>", value, "isdwjk");
            return (Criteria) this;
        }

        public Criteria andIsdwjkGreaterThan(String value) {
            addCriterion("isdwjk >", value, "isdwjk");
            return (Criteria) this;
        }

        public Criteria andIsdwjkGreaterThanOrEqualTo(String value) {
            addCriterion("isdwjk >=", value, "isdwjk");
            return (Criteria) this;
        }

        public Criteria andIsdwjkLessThan(String value) {
            addCriterion("isdwjk <", value, "isdwjk");
            return (Criteria) this;
        }

        public Criteria andIsdwjkLessThanOrEqualTo(String value) {
            addCriterion("isdwjk <=", value, "isdwjk");
            return (Criteria) this;
        }

        public Criteria andIsdwjkLike(String value) {
            addCriterion("isdwjk like", value, "isdwjk");
            return (Criteria) this;
        }

        public Criteria andIsdwjkNotLike(String value) {
            addCriterion("isdwjk not like", value, "isdwjk");
            return (Criteria) this;
        }

        public Criteria andIsdwjkIn(List<String> values) {
            addCriterion("isdwjk in", values, "isdwjk");
            return (Criteria) this;
        }

        public Criteria andIsdwjkNotIn(List<String> values) {
            addCriterion("isdwjk not in", values, "isdwjk");
            return (Criteria) this;
        }

        public Criteria andIsdwjkBetween(String value1, String value2) {
            addCriterion("isdwjk between", value1, value2, "isdwjk");
            return (Criteria) this;
        }

        public Criteria andIsdwjkNotBetween(String value1, String value2) {
            addCriterion("isdwjk not between", value1, value2, "isdwjk");
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

        public Criteria andDefNum3IsNull() {
            addCriterion("def_num3 is null");
            return (Criteria) this;
        }

        public Criteria andDefNum3IsNotNull() {
            addCriterion("def_num3 is not null");
            return (Criteria) this;
        }

        public Criteria andDefNum3EqualTo(BigDecimal value) {
            addCriterion("def_num3 =", value, "defNum3");
            return (Criteria) this;
        }

        public Criteria andDefNum3NotEqualTo(BigDecimal value) {
            addCriterion("def_num3 <>", value, "defNum3");
            return (Criteria) this;
        }

        public Criteria andDefNum3GreaterThan(BigDecimal value) {
            addCriterion("def_num3 >", value, "defNum3");
            return (Criteria) this;
        }

        public Criteria andDefNum3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("def_num3 >=", value, "defNum3");
            return (Criteria) this;
        }

        public Criteria andDefNum3LessThan(BigDecimal value) {
            addCriterion("def_num3 <", value, "defNum3");
            return (Criteria) this;
        }

        public Criteria andDefNum3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("def_num3 <=", value, "defNum3");
            return (Criteria) this;
        }

        public Criteria andDefNum3In(List<BigDecimal> values) {
            addCriterion("def_num3 in", values, "defNum3");
            return (Criteria) this;
        }

        public Criteria andDefNum3NotIn(List<BigDecimal> values) {
            addCriterion("def_num3 not in", values, "defNum3");
            return (Criteria) this;
        }

        public Criteria andDefNum3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("def_num3 between", value1, value2, "defNum3");
            return (Criteria) this;
        }

        public Criteria andDefNum3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("def_num3 not between", value1, value2, "defNum3");
            return (Criteria) this;
        }

        public Criteria andDefNum4IsNull() {
            addCriterion("def_num4 is null");
            return (Criteria) this;
        }

        public Criteria andDefNum4IsNotNull() {
            addCriterion("def_num4 is not null");
            return (Criteria) this;
        }

        public Criteria andDefNum4EqualTo(BigDecimal value) {
            addCriterion("def_num4 =", value, "defNum4");
            return (Criteria) this;
        }

        public Criteria andDefNum4NotEqualTo(BigDecimal value) {
            addCriterion("def_num4 <>", value, "defNum4");
            return (Criteria) this;
        }

        public Criteria andDefNum4GreaterThan(BigDecimal value) {
            addCriterion("def_num4 >", value, "defNum4");
            return (Criteria) this;
        }

        public Criteria andDefNum4GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("def_num4 >=", value, "defNum4");
            return (Criteria) this;
        }

        public Criteria andDefNum4LessThan(BigDecimal value) {
            addCriterion("def_num4 <", value, "defNum4");
            return (Criteria) this;
        }

        public Criteria andDefNum4LessThanOrEqualTo(BigDecimal value) {
            addCriterion("def_num4 <=", value, "defNum4");
            return (Criteria) this;
        }

        public Criteria andDefNum4In(List<BigDecimal> values) {
            addCriterion("def_num4 in", values, "defNum4");
            return (Criteria) this;
        }

        public Criteria andDefNum4NotIn(List<BigDecimal> values) {
            addCriterion("def_num4 not in", values, "defNum4");
            return (Criteria) this;
        }

        public Criteria andDefNum4Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("def_num4 between", value1, value2, "defNum4");
            return (Criteria) this;
        }

        public Criteria andDefNum4NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("def_num4 not between", value1, value2, "defNum4");
            return (Criteria) this;
        }

        public Criteria andDefNum5IsNull() {
            addCriterion("def_num5 is null");
            return (Criteria) this;
        }

        public Criteria andDefNum5IsNotNull() {
            addCriterion("def_num5 is not null");
            return (Criteria) this;
        }

        public Criteria andDefNum5EqualTo(BigDecimal value) {
            addCriterion("def_num5 =", value, "defNum5");
            return (Criteria) this;
        }

        public Criteria andDefNum5NotEqualTo(BigDecimal value) {
            addCriterion("def_num5 <>", value, "defNum5");
            return (Criteria) this;
        }

        public Criteria andDefNum5GreaterThan(BigDecimal value) {
            addCriterion("def_num5 >", value, "defNum5");
            return (Criteria) this;
        }

        public Criteria andDefNum5GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("def_num5 >=", value, "defNum5");
            return (Criteria) this;
        }

        public Criteria andDefNum5LessThan(BigDecimal value) {
            addCriterion("def_num5 <", value, "defNum5");
            return (Criteria) this;
        }

        public Criteria andDefNum5LessThanOrEqualTo(BigDecimal value) {
            addCriterion("def_num5 <=", value, "defNum5");
            return (Criteria) this;
        }

        public Criteria andDefNum5In(List<BigDecimal> values) {
            addCriterion("def_num5 in", values, "defNum5");
            return (Criteria) this;
        }

        public Criteria andDefNum5NotIn(List<BigDecimal> values) {
            addCriterion("def_num5 not in", values, "defNum5");
            return (Criteria) this;
        }

        public Criteria andDefNum5Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("def_num5 between", value1, value2, "defNum5");
            return (Criteria) this;
        }

        public Criteria andDefNum5NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("def_num5 not between", value1, value2, "defNum5");
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
            addCriterion("def_dt1 =", value, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1NotEqualTo(Date value) {
            addCriterion("def_dt1 <>", value, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1GreaterThan(Date value) {
            addCriterion("def_dt1 >", value, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1GreaterThanOrEqualTo(Date value) {
            addCriterion("def_dt1 >=", value, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1LessThan(Date value) {
            addCriterion("def_dt1 <", value, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1LessThanOrEqualTo(Date value) {
            addCriterion("def_dt1 <=", value, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1In(List<Date> values) {
            addCriterion("def_dt1 in", values, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1NotIn(List<Date> values) {
            addCriterion("def_dt1 not in", values, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1Between(Date value1, Date value2) {
            addCriterion("def_dt1 between", value1, value2, "defDt1");
            return (Criteria) this;
        }

        public Criteria andDefDt1NotBetween(Date value1, Date value2) {
            addCriterion("def_dt1 not between", value1, value2, "defDt1");
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
            addCriterion("def_dt2 =", value, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2NotEqualTo(Date value) {
            addCriterion("def_dt2 <>", value, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2GreaterThan(Date value) {
            addCriterion("def_dt2 >", value, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2GreaterThanOrEqualTo(Date value) {
            addCriterion("def_dt2 >=", value, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2LessThan(Date value) {
            addCriterion("def_dt2 <", value, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2LessThanOrEqualTo(Date value) {
            addCriterion("def_dt2 <=", value, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2In(List<Date> values) {
            addCriterion("def_dt2 in", values, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2NotIn(List<Date> values) {
            addCriterion("def_dt2 not in", values, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2Between(Date value1, Date value2) {
            addCriterion("def_dt2 between", value1, value2, "defDt2");
            return (Criteria) this;
        }

        public Criteria andDefDt2NotBetween(Date value1, Date value2) {
            addCriterion("def_dt2 not between", value1, value2, "defDt2");
            return (Criteria) this;
        }

        public Criteria andIshzIsNull() {
            addCriterion("ishz is null");
            return (Criteria) this;
        }

        public Criteria andIshzIsNotNull() {
            addCriterion("ishz is not null");
            return (Criteria) this;
        }

        public Criteria andIshzEqualTo(String value) {
            addCriterion("ishz =", value, "ishz");
            return (Criteria) this;
        }

        public Criteria andIshzNotEqualTo(String value) {
            addCriterion("ishz <>", value, "ishz");
            return (Criteria) this;
        }

        public Criteria andIshzGreaterThan(String value) {
            addCriterion("ishz >", value, "ishz");
            return (Criteria) this;
        }

        public Criteria andIshzGreaterThanOrEqualTo(String value) {
            addCriterion("ishz >=", value, "ishz");
            return (Criteria) this;
        }

        public Criteria andIshzLessThan(String value) {
            addCriterion("ishz <", value, "ishz");
            return (Criteria) this;
        }

        public Criteria andIshzLessThanOrEqualTo(String value) {
            addCriterion("ishz <=", value, "ishz");
            return (Criteria) this;
        }

        public Criteria andIshzLike(String value) {
            addCriterion("ishz like", value, "ishz");
            return (Criteria) this;
        }

        public Criteria andIshzNotLike(String value) {
            addCriterion("ishz not like", value, "ishz");
            return (Criteria) this;
        }

        public Criteria andIshzIn(List<String> values) {
            addCriterion("ishz in", values, "ishz");
            return (Criteria) this;
        }

        public Criteria andIshzNotIn(List<String> values) {
            addCriterion("ishz not in", values, "ishz");
            return (Criteria) this;
        }

        public Criteria andIshzBetween(String value1, String value2) {
            addCriterion("ishz between", value1, value2, "ishz");
            return (Criteria) this;
        }

        public Criteria andIshzNotBetween(String value1, String value2) {
            addCriterion("ishz not between", value1, value2, "ishz");
            return (Criteria) this;
        }

        public Criteria andCpdwIsNull() {
            addCriterion("cpdw is null");
            return (Criteria) this;
        }

        public Criteria andCpdwIsNotNull() {
            addCriterion("cpdw is not null");
            return (Criteria) this;
        }

        public Criteria andCpdwEqualTo(String value) {
            addCriterion("cpdw =", value, "cpdw");
            return (Criteria) this;
        }

        public Criteria andCpdwNotEqualTo(String value) {
            addCriterion("cpdw <>", value, "cpdw");
            return (Criteria) this;
        }

        public Criteria andCpdwGreaterThan(String value) {
            addCriterion("cpdw >", value, "cpdw");
            return (Criteria) this;
        }

        public Criteria andCpdwGreaterThanOrEqualTo(String value) {
            addCriterion("cpdw >=", value, "cpdw");
            return (Criteria) this;
        }

        public Criteria andCpdwLessThan(String value) {
            addCriterion("cpdw <", value, "cpdw");
            return (Criteria) this;
        }

        public Criteria andCpdwLessThanOrEqualTo(String value) {
            addCriterion("cpdw <=", value, "cpdw");
            return (Criteria) this;
        }

        public Criteria andCpdwLike(String value) {
            addCriterion("cpdw like", value, "cpdw");
            return (Criteria) this;
        }

        public Criteria andCpdwNotLike(String value) {
            addCriterion("cpdw not like", value, "cpdw");
            return (Criteria) this;
        }

        public Criteria andCpdwIn(List<String> values) {
            addCriterion("cpdw in", values, "cpdw");
            return (Criteria) this;
        }

        public Criteria andCpdwNotIn(List<String> values) {
            addCriterion("cpdw not in", values, "cpdw");
            return (Criteria) this;
        }

        public Criteria andCpdwBetween(String value1, String value2) {
            addCriterion("cpdw between", value1, value2, "cpdw");
            return (Criteria) this;
        }

        public Criteria andCpdwNotBetween(String value1, String value2) {
            addCriterion("cpdw not between", value1, value2, "cpdw");
            return (Criteria) this;
        }

        public Criteria andFyhdmIsNull() {
            addCriterion("fyhdm is null");
            return (Criteria) this;
        }

        public Criteria andFyhdmIsNotNull() {
            addCriterion("fyhdm is not null");
            return (Criteria) this;
        }

        public Criteria andFyhdmEqualTo(String value) {
            addCriterion("fyhdm =", value, "fyhdm");
            return (Criteria) this;
        }

        public Criteria andFyhdmNotEqualTo(String value) {
            addCriterion("fyhdm <>", value, "fyhdm");
            return (Criteria) this;
        }

        public Criteria andFyhdmGreaterThan(String value) {
            addCriterion("fyhdm >", value, "fyhdm");
            return (Criteria) this;
        }

        public Criteria andFyhdmGreaterThanOrEqualTo(String value) {
            addCriterion("fyhdm >=", value, "fyhdm");
            return (Criteria) this;
        }

        public Criteria andFyhdmLessThan(String value) {
            addCriterion("fyhdm <", value, "fyhdm");
            return (Criteria) this;
        }

        public Criteria andFyhdmLessThanOrEqualTo(String value) {
            addCriterion("fyhdm <=", value, "fyhdm");
            return (Criteria) this;
        }

        public Criteria andFyhdmLike(String value) {
            addCriterion("fyhdm like", value, "fyhdm");
            return (Criteria) this;
        }

        public Criteria andFyhdmNotLike(String value) {
            addCriterion("fyhdm not like", value, "fyhdm");
            return (Criteria) this;
        }

        public Criteria andFyhdmIn(List<String> values) {
            addCriterion("fyhdm in", values, "fyhdm");
            return (Criteria) this;
        }

        public Criteria andFyhdmNotIn(List<String> values) {
            addCriterion("fyhdm not in", values, "fyhdm");
            return (Criteria) this;
        }

        public Criteria andFyhdmBetween(String value1, String value2) {
            addCriterion("fyhdm between", value1, value2, "fyhdm");
            return (Criteria) this;
        }

        public Criteria andFyhdmNotBetween(String value1, String value2) {
            addCriterion("fyhdm not between", value1, value2, "fyhdm");
            return (Criteria) this;
        }

        public Criteria andFyhzhIsNull() {
            addCriterion("fyhzh is null");
            return (Criteria) this;
        }

        public Criteria andFyhzhIsNotNull() {
            addCriterion("fyhzh is not null");
            return (Criteria) this;
        }

        public Criteria andFyhzhEqualTo(String value) {
            addCriterion("fyhzh =", value, "fyhzh");
            return (Criteria) this;
        }

        public Criteria andFyhzhNotEqualTo(String value) {
            addCriterion("fyhzh <>", value, "fyhzh");
            return (Criteria) this;
        }

        public Criteria andFyhzhGreaterThan(String value) {
            addCriterion("fyhzh >", value, "fyhzh");
            return (Criteria) this;
        }

        public Criteria andFyhzhGreaterThanOrEqualTo(String value) {
            addCriterion("fyhzh >=", value, "fyhzh");
            return (Criteria) this;
        }

        public Criteria andFyhzhLessThan(String value) {
            addCriterion("fyhzh <", value, "fyhzh");
            return (Criteria) this;
        }

        public Criteria andFyhzhLessThanOrEqualTo(String value) {
            addCriterion("fyhzh <=", value, "fyhzh");
            return (Criteria) this;
        }

        public Criteria andFyhzhLike(String value) {
            addCriterion("fyhzh like", value, "fyhzh");
            return (Criteria) this;
        }

        public Criteria andFyhzhNotLike(String value) {
            addCriterion("fyhzh not like", value, "fyhzh");
            return (Criteria) this;
        }

        public Criteria andFyhzhIn(List<String> values) {
            addCriterion("fyhzh in", values, "fyhzh");
            return (Criteria) this;
        }

        public Criteria andFyhzhNotIn(List<String> values) {
            addCriterion("fyhzh not in", values, "fyhzh");
            return (Criteria) this;
        }

        public Criteria andFyhzhBetween(String value1, String value2) {
            addCriterion("fyhzh between", value1, value2, "fyhzh");
            return (Criteria) this;
        }

        public Criteria andFyhzhNotBetween(String value1, String value2) {
            addCriterion("fyhzh not between", value1, value2, "fyhzh");
            return (Criteria) this;
        }

        public Criteria andIstfIsNull() {
            addCriterion("istf is null");
            return (Criteria) this;
        }

        public Criteria andIstfIsNotNull() {
            addCriterion("istf is not null");
            return (Criteria) this;
        }

        public Criteria andIstfEqualTo(String value) {
            addCriterion("istf =", value, "istf");
            return (Criteria) this;
        }

        public Criteria andIstfNotEqualTo(String value) {
            addCriterion("istf <>", value, "istf");
            return (Criteria) this;
        }

        public Criteria andIstfGreaterThan(String value) {
            addCriterion("istf >", value, "istf");
            return (Criteria) this;
        }

        public Criteria andIstfGreaterThanOrEqualTo(String value) {
            addCriterion("istf >=", value, "istf");
            return (Criteria) this;
        }

        public Criteria andIstfLessThan(String value) {
            addCriterion("istf <", value, "istf");
            return (Criteria) this;
        }

        public Criteria andIstfLessThanOrEqualTo(String value) {
            addCriterion("istf <=", value, "istf");
            return (Criteria) this;
        }

        public Criteria andIstfLike(String value) {
            addCriterion("istf like", value, "istf");
            return (Criteria) this;
        }

        public Criteria andIstfNotLike(String value) {
            addCriterion("istf not like", value, "istf");
            return (Criteria) this;
        }

        public Criteria andIstfIn(List<String> values) {
            addCriterion("istf in", values, "istf");
            return (Criteria) this;
        }

        public Criteria andIstfNotIn(List<String> values) {
            addCriterion("istf not in", values, "istf");
            return (Criteria) this;
        }

        public Criteria andIstfBetween(String value1, String value2) {
            addCriterion("istf between", value1, value2, "istf");
            return (Criteria) this;
        }

        public Criteria andIstfNotBetween(String value1, String value2) {
            addCriterion("istf not between", value1, value2, "istf");
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