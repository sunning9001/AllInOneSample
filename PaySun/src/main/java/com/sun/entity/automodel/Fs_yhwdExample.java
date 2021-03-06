package com.sun.entity.automodel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fs_yhwdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Fs_yhwdExample() {
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

        public Criteria andYhmcIsNull() {
            addCriterion("yhmc is null");
            return (Criteria) this;
        }

        public Criteria andYhmcIsNotNull() {
            addCriterion("yhmc is not null");
            return (Criteria) this;
        }

        public Criteria andYhmcEqualTo(String value) {
            addCriterion("yhmc =", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcNotEqualTo(String value) {
            addCriterion("yhmc <>", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcGreaterThan(String value) {
            addCriterion("yhmc >", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcGreaterThanOrEqualTo(String value) {
            addCriterion("yhmc >=", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcLessThan(String value) {
            addCriterion("yhmc <", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcLessThanOrEqualTo(String value) {
            addCriterion("yhmc <=", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcLike(String value) {
            addCriterion("yhmc like", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcNotLike(String value) {
            addCriterion("yhmc not like", value, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcIn(List<String> values) {
            addCriterion("yhmc in", values, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcNotIn(List<String> values) {
            addCriterion("yhmc not in", values, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcBetween(String value1, String value2) {
            addCriterion("yhmc between", value1, value2, "yhmc");
            return (Criteria) this;
        }

        public Criteria andYhmcNotBetween(String value1, String value2) {
            addCriterion("yhmc not between", value1, value2, "yhmc");
            return (Criteria) this;
        }

        public Criteria andWdmcIsNull() {
            addCriterion("wdmc is null");
            return (Criteria) this;
        }

        public Criteria andWdmcIsNotNull() {
            addCriterion("wdmc is not null");
            return (Criteria) this;
        }

        public Criteria andWdmcEqualTo(String value) {
            addCriterion("wdmc =", value, "wdmc");
            return (Criteria) this;
        }

        public Criteria andWdmcNotEqualTo(String value) {
            addCriterion("wdmc <>", value, "wdmc");
            return (Criteria) this;
        }

        public Criteria andWdmcGreaterThan(String value) {
            addCriterion("wdmc >", value, "wdmc");
            return (Criteria) this;
        }

        public Criteria andWdmcGreaterThanOrEqualTo(String value) {
            addCriterion("wdmc >=", value, "wdmc");
            return (Criteria) this;
        }

        public Criteria andWdmcLessThan(String value) {
            addCriterion("wdmc <", value, "wdmc");
            return (Criteria) this;
        }

        public Criteria andWdmcLessThanOrEqualTo(String value) {
            addCriterion("wdmc <=", value, "wdmc");
            return (Criteria) this;
        }

        public Criteria andWdmcLike(String value) {
            addCriterion("wdmc like", value, "wdmc");
            return (Criteria) this;
        }

        public Criteria andWdmcNotLike(String value) {
            addCriterion("wdmc not like", value, "wdmc");
            return (Criteria) this;
        }

        public Criteria andWdmcIn(List<String> values) {
            addCriterion("wdmc in", values, "wdmc");
            return (Criteria) this;
        }

        public Criteria andWdmcNotIn(List<String> values) {
            addCriterion("wdmc not in", values, "wdmc");
            return (Criteria) this;
        }

        public Criteria andWdmcBetween(String value1, String value2) {
            addCriterion("wdmc between", value1, value2, "wdmc");
            return (Criteria) this;
        }

        public Criteria andWdmcNotBetween(String value1, String value2) {
            addCriterion("wdmc not between", value1, value2, "wdmc");
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

        public Criteria andCzIsNull() {
            addCriterion("cz is null");
            return (Criteria) this;
        }

        public Criteria andCzIsNotNull() {
            addCriterion("cz is not null");
            return (Criteria) this;
        }

        public Criteria andCzEqualTo(String value) {
            addCriterion("cz =", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzNotEqualTo(String value) {
            addCriterion("cz <>", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzGreaterThan(String value) {
            addCriterion("cz >", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzGreaterThanOrEqualTo(String value) {
            addCriterion("cz >=", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzLessThan(String value) {
            addCriterion("cz <", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzLessThanOrEqualTo(String value) {
            addCriterion("cz <=", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzLike(String value) {
            addCriterion("cz like", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzNotLike(String value) {
            addCriterion("cz not like", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzIn(List<String> values) {
            addCriterion("cz in", values, "cz");
            return (Criteria) this;
        }

        public Criteria andCzNotIn(List<String> values) {
            addCriterion("cz not in", values, "cz");
            return (Criteria) this;
        }

        public Criteria andCzBetween(String value1, String value2) {
            addCriterion("cz between", value1, value2, "cz");
            return (Criteria) this;
        }

        public Criteria andCzNotBetween(String value1, String value2) {
            addCriterion("cz not between", value1, value2, "cz");
            return (Criteria) this;
        }

        public Criteria andLxrIsNull() {
            addCriterion("lxr is null");
            return (Criteria) this;
        }

        public Criteria andLxrIsNotNull() {
            addCriterion("lxr is not null");
            return (Criteria) this;
        }

        public Criteria andLxrEqualTo(String value) {
            addCriterion("lxr =", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotEqualTo(String value) {
            addCriterion("lxr <>", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrGreaterThan(String value) {
            addCriterion("lxr >", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrGreaterThanOrEqualTo(String value) {
            addCriterion("lxr >=", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrLessThan(String value) {
            addCriterion("lxr <", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrLessThanOrEqualTo(String value) {
            addCriterion("lxr <=", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrLike(String value) {
            addCriterion("lxr like", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotLike(String value) {
            addCriterion("lxr not like", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrIn(List<String> values) {
            addCriterion("lxr in", values, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotIn(List<String> values) {
            addCriterion("lxr not in", values, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrBetween(String value1, String value2) {
            addCriterion("lxr between", value1, value2, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotBetween(String value1, String value2) {
            addCriterion("lxr not between", value1, value2, "lxr");
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

        public Criteria andZhIsNull() {
            addCriterion("zh is null");
            return (Criteria) this;
        }

        public Criteria andZhIsNotNull() {
            addCriterion("zh is not null");
            return (Criteria) this;
        }

        public Criteria andZhEqualTo(String value) {
            addCriterion("zh =", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhNotEqualTo(String value) {
            addCriterion("zh <>", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhGreaterThan(String value) {
            addCriterion("zh >", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhGreaterThanOrEqualTo(String value) {
            addCriterion("zh >=", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhLessThan(String value) {
            addCriterion("zh <", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhLessThanOrEqualTo(String value) {
            addCriterion("zh <=", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhLike(String value) {
            addCriterion("zh like", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhNotLike(String value) {
            addCriterion("zh not like", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhIn(List<String> values) {
            addCriterion("zh in", values, "zh");
            return (Criteria) this;
        }

        public Criteria andZhNotIn(List<String> values) {
            addCriterion("zh not in", values, "zh");
            return (Criteria) this;
        }

        public Criteria andZhBetween(String value1, String value2) {
            addCriterion("zh between", value1, value2, "zh");
            return (Criteria) this;
        }

        public Criteria andZhNotBetween(String value1, String value2) {
            addCriterion("zh not between", value1, value2, "zh");
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