package com.sun.entity.automodel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fs_sfxmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Fs_sfxmExample() {
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

        public Criteria andDmIsNull() {
            addCriterion("dm is null");
            return (Criteria) this;
        }

        public Criteria andDmIsNotNull() {
            addCriterion("dm is not null");
            return (Criteria) this;
        }

        public Criteria andDmEqualTo(String value) {
            addCriterion("dm =", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmNotEqualTo(String value) {
            addCriterion("dm <>", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmGreaterThan(String value) {
            addCriterion("dm >", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmGreaterThanOrEqualTo(String value) {
            addCriterion("dm >=", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmLessThan(String value) {
            addCriterion("dm <", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmLessThanOrEqualTo(String value) {
            addCriterion("dm <=", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmLike(String value) {
            addCriterion("dm like", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmNotLike(String value) {
            addCriterion("dm not like", value, "dm");
            return (Criteria) this;
        }

        public Criteria andDmIn(List<String> values) {
            addCriterion("dm in", values, "dm");
            return (Criteria) this;
        }

        public Criteria andDmNotIn(List<String> values) {
            addCriterion("dm not in", values, "dm");
            return (Criteria) this;
        }

        public Criteria andDmBetween(String value1, String value2) {
            addCriterion("dm between", value1, value2, "dm");
            return (Criteria) this;
        }

        public Criteria andDmNotBetween(String value1, String value2) {
            addCriterion("dm not between", value1, value2, "dm");
            return (Criteria) this;
        }

        public Criteria andMcIsNull() {
            addCriterion("mc is null");
            return (Criteria) this;
        }

        public Criteria andMcIsNotNull() {
            addCriterion("mc is not null");
            return (Criteria) this;
        }

        public Criteria andMcEqualTo(String value) {
            addCriterion("mc =", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotEqualTo(String value) {
            addCriterion("mc <>", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcGreaterThan(String value) {
            addCriterion("mc >", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcGreaterThanOrEqualTo(String value) {
            addCriterion("mc >=", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLessThan(String value) {
            addCriterion("mc <", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLessThanOrEqualTo(String value) {
            addCriterion("mc <=", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLike(String value) {
            addCriterion("mc like", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotLike(String value) {
            addCriterion("mc not like", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcIn(List<String> values) {
            addCriterion("mc in", values, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotIn(List<String> values) {
            addCriterion("mc not in", values, "mc");
            return (Criteria) this;
        }

        public Criteria andMcBetween(String value1, String value2) {
            addCriterion("mc between", value1, value2, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotBetween(String value1, String value2) {
            addCriterion("mc not between", value1, value2, "mc");
            return (Criteria) this;
        }

        public Criteria andSfdmIsNull() {
            addCriterion("sfdm is null");
            return (Criteria) this;
        }

        public Criteria andSfdmIsNotNull() {
            addCriterion("sfdm is not null");
            return (Criteria) this;
        }

        public Criteria andSfdmEqualTo(String value) {
            addCriterion("sfdm =", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmNotEqualTo(String value) {
            addCriterion("sfdm <>", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmGreaterThan(String value) {
            addCriterion("sfdm >", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmGreaterThanOrEqualTo(String value) {
            addCriterion("sfdm >=", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmLessThan(String value) {
            addCriterion("sfdm <", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmLessThanOrEqualTo(String value) {
            addCriterion("sfdm <=", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmLike(String value) {
            addCriterion("sfdm like", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmNotLike(String value) {
            addCriterion("sfdm not like", value, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmIn(List<String> values) {
            addCriterion("sfdm in", values, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmNotIn(List<String> values) {
            addCriterion("sfdm not in", values, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmBetween(String value1, String value2) {
            addCriterion("sfdm between", value1, value2, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfdmNotBetween(String value1, String value2) {
            addCriterion("sfdm not between", value1, value2, "sfdm");
            return (Criteria) this;
        }

        public Criteria andSfyjIsNull() {
            addCriterion("sfyj is null");
            return (Criteria) this;
        }

        public Criteria andSfyjIsNotNull() {
            addCriterion("sfyj is not null");
            return (Criteria) this;
        }

        public Criteria andSfyjEqualTo(String value) {
            addCriterion("sfyj =", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjNotEqualTo(String value) {
            addCriterion("sfyj <>", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjGreaterThan(String value) {
            addCriterion("sfyj >", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjGreaterThanOrEqualTo(String value) {
            addCriterion("sfyj >=", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjLessThan(String value) {
            addCriterion("sfyj <", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjLessThanOrEqualTo(String value) {
            addCriterion("sfyj <=", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjLike(String value) {
            addCriterion("sfyj like", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjNotLike(String value) {
            addCriterion("sfyj not like", value, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjIn(List<String> values) {
            addCriterion("sfyj in", values, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjNotIn(List<String> values) {
            addCriterion("sfyj not in", values, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjBetween(String value1, String value2) {
            addCriterion("sfyj between", value1, value2, "sfyj");
            return (Criteria) this;
        }

        public Criteria andSfyjNotBetween(String value1, String value2) {
            addCriterion("sfyj not between", value1, value2, "sfyj");
            return (Criteria) this;
        }

        public Criteria andIstcIsNull() {
            addCriterion("istc is null");
            return (Criteria) this;
        }

        public Criteria andIstcIsNotNull() {
            addCriterion("istc is not null");
            return (Criteria) this;
        }

        public Criteria andIstcEqualTo(String value) {
            addCriterion("istc =", value, "istc");
            return (Criteria) this;
        }

        public Criteria andIstcNotEqualTo(String value) {
            addCriterion("istc <>", value, "istc");
            return (Criteria) this;
        }

        public Criteria andIstcGreaterThan(String value) {
            addCriterion("istc >", value, "istc");
            return (Criteria) this;
        }

        public Criteria andIstcGreaterThanOrEqualTo(String value) {
            addCriterion("istc >=", value, "istc");
            return (Criteria) this;
        }

        public Criteria andIstcLessThan(String value) {
            addCriterion("istc <", value, "istc");
            return (Criteria) this;
        }

        public Criteria andIstcLessThanOrEqualTo(String value) {
            addCriterion("istc <=", value, "istc");
            return (Criteria) this;
        }

        public Criteria andIstcLike(String value) {
            addCriterion("istc like", value, "istc");
            return (Criteria) this;
        }

        public Criteria andIstcNotLike(String value) {
            addCriterion("istc not like", value, "istc");
            return (Criteria) this;
        }

        public Criteria andIstcIn(List<String> values) {
            addCriterion("istc in", values, "istc");
            return (Criteria) this;
        }

        public Criteria andIstcNotIn(List<String> values) {
            addCriterion("istc not in", values, "istc");
            return (Criteria) this;
        }

        public Criteria andIstcBetween(String value1, String value2) {
            addCriterion("istc between", value1, value2, "istc");
            return (Criteria) this;
        }

        public Criteria andIstcNotBetween(String value1, String value2) {
            addCriterion("istc not between", value1, value2, "istc");
            return (Criteria) this;
        }

        public Criteria andTlblIsNull() {
            addCriterion("tlbl is null");
            return (Criteria) this;
        }

        public Criteria andTlblIsNotNull() {
            addCriterion("tlbl is not null");
            return (Criteria) this;
        }

        public Criteria andTlblEqualTo(BigDecimal value) {
            addCriterion("tlbl =", value, "tlbl");
            return (Criteria) this;
        }

        public Criteria andTlblNotEqualTo(BigDecimal value) {
            addCriterion("tlbl <>", value, "tlbl");
            return (Criteria) this;
        }

        public Criteria andTlblGreaterThan(BigDecimal value) {
            addCriterion("tlbl >", value, "tlbl");
            return (Criteria) this;
        }

        public Criteria andTlblGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tlbl >=", value, "tlbl");
            return (Criteria) this;
        }

        public Criteria andTlblLessThan(BigDecimal value) {
            addCriterion("tlbl <", value, "tlbl");
            return (Criteria) this;
        }

        public Criteria andTlblLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tlbl <=", value, "tlbl");
            return (Criteria) this;
        }

        public Criteria andTlblIn(List<BigDecimal> values) {
            addCriterion("tlbl in", values, "tlbl");
            return (Criteria) this;
        }

        public Criteria andTlblNotIn(List<BigDecimal> values) {
            addCriterion("tlbl not in", values, "tlbl");
            return (Criteria) this;
        }

        public Criteria andTlblBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tlbl between", value1, value2, "tlbl");
            return (Criteria) this;
        }

        public Criteria andTlblNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tlbl not between", value1, value2, "tlbl");
            return (Criteria) this;
        }

        public Criteria andZjxzIsNull() {
            addCriterion("zjxz is null");
            return (Criteria) this;
        }

        public Criteria andZjxzIsNotNull() {
            addCriterion("zjxz is not null");
            return (Criteria) this;
        }

        public Criteria andZjxzEqualTo(String value) {
            addCriterion("zjxz =", value, "zjxz");
            return (Criteria) this;
        }

        public Criteria andZjxzNotEqualTo(String value) {
            addCriterion("zjxz <>", value, "zjxz");
            return (Criteria) this;
        }

        public Criteria andZjxzGreaterThan(String value) {
            addCriterion("zjxz >", value, "zjxz");
            return (Criteria) this;
        }

        public Criteria andZjxzGreaterThanOrEqualTo(String value) {
            addCriterion("zjxz >=", value, "zjxz");
            return (Criteria) this;
        }

        public Criteria andZjxzLessThan(String value) {
            addCriterion("zjxz <", value, "zjxz");
            return (Criteria) this;
        }

        public Criteria andZjxzLessThanOrEqualTo(String value) {
            addCriterion("zjxz <=", value, "zjxz");
            return (Criteria) this;
        }

        public Criteria andZjxzLike(String value) {
            addCriterion("zjxz like", value, "zjxz");
            return (Criteria) this;
        }

        public Criteria andZjxzNotLike(String value) {
            addCriterion("zjxz not like", value, "zjxz");
            return (Criteria) this;
        }

        public Criteria andZjxzIn(List<String> values) {
            addCriterion("zjxz in", values, "zjxz");
            return (Criteria) this;
        }

        public Criteria andZjxzNotIn(List<String> values) {
            addCriterion("zjxz not in", values, "zjxz");
            return (Criteria) this;
        }

        public Criteria andZjxzBetween(String value1, String value2) {
            addCriterion("zjxz between", value1, value2, "zjxz");
            return (Criteria) this;
        }

        public Criteria andZjxzNotBetween(String value1, String value2) {
            addCriterion("zjxz not between", value1, value2, "zjxz");
            return (Criteria) this;
        }

        public Criteria andXmlbIsNull() {
            addCriterion("xmlb is null");
            return (Criteria) this;
        }

        public Criteria andXmlbIsNotNull() {
            addCriterion("xmlb is not null");
            return (Criteria) this;
        }

        public Criteria andXmlbEqualTo(String value) {
            addCriterion("xmlb =", value, "xmlb");
            return (Criteria) this;
        }

        public Criteria andXmlbNotEqualTo(String value) {
            addCriterion("xmlb <>", value, "xmlb");
            return (Criteria) this;
        }

        public Criteria andXmlbGreaterThan(String value) {
            addCriterion("xmlb >", value, "xmlb");
            return (Criteria) this;
        }

        public Criteria andXmlbGreaterThanOrEqualTo(String value) {
            addCriterion("xmlb >=", value, "xmlb");
            return (Criteria) this;
        }

        public Criteria andXmlbLessThan(String value) {
            addCriterion("xmlb <", value, "xmlb");
            return (Criteria) this;
        }

        public Criteria andXmlbLessThanOrEqualTo(String value) {
            addCriterion("xmlb <=", value, "xmlb");
            return (Criteria) this;
        }

        public Criteria andXmlbLike(String value) {
            addCriterion("xmlb like", value, "xmlb");
            return (Criteria) this;
        }

        public Criteria andXmlbNotLike(String value) {
            addCriterion("xmlb not like", value, "xmlb");
            return (Criteria) this;
        }

        public Criteria andXmlbIn(List<String> values) {
            addCriterion("xmlb in", values, "xmlb");
            return (Criteria) this;
        }

        public Criteria andXmlbNotIn(List<String> values) {
            addCriterion("xmlb not in", values, "xmlb");
            return (Criteria) this;
        }

        public Criteria andXmlbBetween(String value1, String value2) {
            addCriterion("xmlb between", value1, value2, "xmlb");
            return (Criteria) this;
        }

        public Criteria andXmlbNotBetween(String value1, String value2) {
            addCriterion("xmlb not between", value1, value2, "xmlb");
            return (Criteria) this;
        }

        public Criteria andIsysIsNull() {
            addCriterion("isys is null");
            return (Criteria) this;
        }

        public Criteria andIsysIsNotNull() {
            addCriterion("isys is not null");
            return (Criteria) this;
        }

        public Criteria andIsysEqualTo(String value) {
            addCriterion("isys =", value, "isys");
            return (Criteria) this;
        }

        public Criteria andIsysNotEqualTo(String value) {
            addCriterion("isys <>", value, "isys");
            return (Criteria) this;
        }

        public Criteria andIsysGreaterThan(String value) {
            addCriterion("isys >", value, "isys");
            return (Criteria) this;
        }

        public Criteria andIsysGreaterThanOrEqualTo(String value) {
            addCriterion("isys >=", value, "isys");
            return (Criteria) this;
        }

        public Criteria andIsysLessThan(String value) {
            addCriterion("isys <", value, "isys");
            return (Criteria) this;
        }

        public Criteria andIsysLessThanOrEqualTo(String value) {
            addCriterion("isys <=", value, "isys");
            return (Criteria) this;
        }

        public Criteria andIsysLike(String value) {
            addCriterion("isys like", value, "isys");
            return (Criteria) this;
        }

        public Criteria andIsysNotLike(String value) {
            addCriterion("isys not like", value, "isys");
            return (Criteria) this;
        }

        public Criteria andIsysIn(List<String> values) {
            addCriterion("isys in", values, "isys");
            return (Criteria) this;
        }

        public Criteria andIsysNotIn(List<String> values) {
            addCriterion("isys not in", values, "isys");
            return (Criteria) this;
        }

        public Criteria andIsysBetween(String value1, String value2) {
            addCriterion("isys between", value1, value2, "isys");
            return (Criteria) this;
        }

        public Criteria andIsysNotBetween(String value1, String value2) {
            addCriterion("isys not between", value1, value2, "isys");
            return (Criteria) this;
        }

        public Criteria andXmspIsNull() {
            addCriterion("xmsp is null");
            return (Criteria) this;
        }

        public Criteria andXmspIsNotNull() {
            addCriterion("xmsp is not null");
            return (Criteria) this;
        }

        public Criteria andXmspEqualTo(String value) {
            addCriterion("xmsp =", value, "xmsp");
            return (Criteria) this;
        }

        public Criteria andXmspNotEqualTo(String value) {
            addCriterion("xmsp <>", value, "xmsp");
            return (Criteria) this;
        }

        public Criteria andXmspGreaterThan(String value) {
            addCriterion("xmsp >", value, "xmsp");
            return (Criteria) this;
        }

        public Criteria andXmspGreaterThanOrEqualTo(String value) {
            addCriterion("xmsp >=", value, "xmsp");
            return (Criteria) this;
        }

        public Criteria andXmspLessThan(String value) {
            addCriterion("xmsp <", value, "xmsp");
            return (Criteria) this;
        }

        public Criteria andXmspLessThanOrEqualTo(String value) {
            addCriterion("xmsp <=", value, "xmsp");
            return (Criteria) this;
        }

        public Criteria andXmspLike(String value) {
            addCriterion("xmsp like", value, "xmsp");
            return (Criteria) this;
        }

        public Criteria andXmspNotLike(String value) {
            addCriterion("xmsp not like", value, "xmsp");
            return (Criteria) this;
        }

        public Criteria andXmspIn(List<String> values) {
            addCriterion("xmsp in", values, "xmsp");
            return (Criteria) this;
        }

        public Criteria andXmspNotIn(List<String> values) {
            addCriterion("xmsp not in", values, "xmsp");
            return (Criteria) this;
        }

        public Criteria andXmspBetween(String value1, String value2) {
            addCriterion("xmsp between", value1, value2, "xmsp");
            return (Criteria) this;
        }

        public Criteria andXmspNotBetween(String value1, String value2) {
            addCriterion("xmsp not between", value1, value2, "xmsp");
            return (Criteria) this;
        }

        public Criteria andSrjcIsNull() {
            addCriterion("srjc is null");
            return (Criteria) this;
        }

        public Criteria andSrjcIsNotNull() {
            addCriterion("srjc is not null");
            return (Criteria) this;
        }

        public Criteria andSrjcEqualTo(String value) {
            addCriterion("srjc =", value, "srjc");
            return (Criteria) this;
        }

        public Criteria andSrjcNotEqualTo(String value) {
            addCriterion("srjc <>", value, "srjc");
            return (Criteria) this;
        }

        public Criteria andSrjcGreaterThan(String value) {
            addCriterion("srjc >", value, "srjc");
            return (Criteria) this;
        }

        public Criteria andSrjcGreaterThanOrEqualTo(String value) {
            addCriterion("srjc >=", value, "srjc");
            return (Criteria) this;
        }

        public Criteria andSrjcLessThan(String value) {
            addCriterion("srjc <", value, "srjc");
            return (Criteria) this;
        }

        public Criteria andSrjcLessThanOrEqualTo(String value) {
            addCriterion("srjc <=", value, "srjc");
            return (Criteria) this;
        }

        public Criteria andSrjcLike(String value) {
            addCriterion("srjc like", value, "srjc");
            return (Criteria) this;
        }

        public Criteria andSrjcNotLike(String value) {
            addCriterion("srjc not like", value, "srjc");
            return (Criteria) this;
        }

        public Criteria andSrjcIn(List<String> values) {
            addCriterion("srjc in", values, "srjc");
            return (Criteria) this;
        }

        public Criteria andSrjcNotIn(List<String> values) {
            addCriterion("srjc not in", values, "srjc");
            return (Criteria) this;
        }

        public Criteria andSrjcBetween(String value1, String value2) {
            addCriterion("srjc between", value1, value2, "srjc");
            return (Criteria) this;
        }

        public Criteria andSrjcNotBetween(String value1, String value2) {
            addCriterion("srjc not between", value1, value2, "srjc");
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

        public Criteria andPzjgIsNull() {
            addCriterion("pzjg is null");
            return (Criteria) this;
        }

        public Criteria andPzjgIsNotNull() {
            addCriterion("pzjg is not null");
            return (Criteria) this;
        }

        public Criteria andPzjgEqualTo(String value) {
            addCriterion("pzjg =", value, "pzjg");
            return (Criteria) this;
        }

        public Criteria andPzjgNotEqualTo(String value) {
            addCriterion("pzjg <>", value, "pzjg");
            return (Criteria) this;
        }

        public Criteria andPzjgGreaterThan(String value) {
            addCriterion("pzjg >", value, "pzjg");
            return (Criteria) this;
        }

        public Criteria andPzjgGreaterThanOrEqualTo(String value) {
            addCriterion("pzjg >=", value, "pzjg");
            return (Criteria) this;
        }

        public Criteria andPzjgLessThan(String value) {
            addCriterion("pzjg <", value, "pzjg");
            return (Criteria) this;
        }

        public Criteria andPzjgLessThanOrEqualTo(String value) {
            addCriterion("pzjg <=", value, "pzjg");
            return (Criteria) this;
        }

        public Criteria andPzjgLike(String value) {
            addCriterion("pzjg like", value, "pzjg");
            return (Criteria) this;
        }

        public Criteria andPzjgNotLike(String value) {
            addCriterion("pzjg not like", value, "pzjg");
            return (Criteria) this;
        }

        public Criteria andPzjgIn(List<String> values) {
            addCriterion("pzjg in", values, "pzjg");
            return (Criteria) this;
        }

        public Criteria andPzjgNotIn(List<String> values) {
            addCriterion("pzjg not in", values, "pzjg");
            return (Criteria) this;
        }

        public Criteria andPzjgBetween(String value1, String value2) {
            addCriterion("pzjg between", value1, value2, "pzjg");
            return (Criteria) this;
        }

        public Criteria andPzjgNotBetween(String value1, String value2) {
            addCriterion("pzjg not between", value1, value2, "pzjg");
            return (Criteria) this;
        }

        public Criteria andPzwhIsNull() {
            addCriterion("pzwh is null");
            return (Criteria) this;
        }

        public Criteria andPzwhIsNotNull() {
            addCriterion("pzwh is not null");
            return (Criteria) this;
        }

        public Criteria andPzwhEqualTo(String value) {
            addCriterion("pzwh =", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhNotEqualTo(String value) {
            addCriterion("pzwh <>", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhGreaterThan(String value) {
            addCriterion("pzwh >", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhGreaterThanOrEqualTo(String value) {
            addCriterion("pzwh >=", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhLessThan(String value) {
            addCriterion("pzwh <", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhLessThanOrEqualTo(String value) {
            addCriterion("pzwh <=", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhLike(String value) {
            addCriterion("pzwh like", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhNotLike(String value) {
            addCriterion("pzwh not like", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhIn(List<String> values) {
            addCriterion("pzwh in", values, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhNotIn(List<String> values) {
            addCriterion("pzwh not in", values, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhBetween(String value1, String value2) {
            addCriterion("pzwh between", value1, value2, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhNotBetween(String value1, String value2) {
            addCriterion("pzwh not between", value1, value2, "pzwh");
            return (Criteria) this;
        }

        public Criteria andIsqxIsNull() {
            addCriterion("isqx is null");
            return (Criteria) this;
        }

        public Criteria andIsqxIsNotNull() {
            addCriterion("isqx is not null");
            return (Criteria) this;
        }

        public Criteria andIsqxEqualTo(String value) {
            addCriterion("isqx =", value, "isqx");
            return (Criteria) this;
        }

        public Criteria andIsqxNotEqualTo(String value) {
            addCriterion("isqx <>", value, "isqx");
            return (Criteria) this;
        }

        public Criteria andIsqxGreaterThan(String value) {
            addCriterion("isqx >", value, "isqx");
            return (Criteria) this;
        }

        public Criteria andIsqxGreaterThanOrEqualTo(String value) {
            addCriterion("isqx >=", value, "isqx");
            return (Criteria) this;
        }

        public Criteria andIsqxLessThan(String value) {
            addCriterion("isqx <", value, "isqx");
            return (Criteria) this;
        }

        public Criteria andIsqxLessThanOrEqualTo(String value) {
            addCriterion("isqx <=", value, "isqx");
            return (Criteria) this;
        }

        public Criteria andIsqxLike(String value) {
            addCriterion("isqx like", value, "isqx");
            return (Criteria) this;
        }

        public Criteria andIsqxNotLike(String value) {
            addCriterion("isqx not like", value, "isqx");
            return (Criteria) this;
        }

        public Criteria andIsqxIn(List<String> values) {
            addCriterion("isqx in", values, "isqx");
            return (Criteria) this;
        }

        public Criteria andIsqxNotIn(List<String> values) {
            addCriterion("isqx not in", values, "isqx");
            return (Criteria) this;
        }

        public Criteria andIsqxBetween(String value1, String value2) {
            addCriterion("isqx between", value1, value2, "isqx");
            return (Criteria) this;
        }

        public Criteria andIsqxNotBetween(String value1, String value2) {
            addCriterion("isqx not between", value1, value2, "isqx");
            return (Criteria) this;
        }

        public Criteria andQxrqIsNull() {
            addCriterion("qxrq is null");
            return (Criteria) this;
        }

        public Criteria andQxrqIsNotNull() {
            addCriterion("qxrq is not null");
            return (Criteria) this;
        }

        public Criteria andQxrqEqualTo(Date value) {
            addCriterion("qxrq =", value, "qxrq");
            return (Criteria) this;
        }

        public Criteria andQxrqNotEqualTo(Date value) {
            addCriterion("qxrq <>", value, "qxrq");
            return (Criteria) this;
        }

        public Criteria andQxrqGreaterThan(Date value) {
            addCriterion("qxrq >", value, "qxrq");
            return (Criteria) this;
        }

        public Criteria andQxrqGreaterThanOrEqualTo(Date value) {
            addCriterion("qxrq >=", value, "qxrq");
            return (Criteria) this;
        }

        public Criteria andQxrqLessThan(Date value) {
            addCriterion("qxrq <", value, "qxrq");
            return (Criteria) this;
        }

        public Criteria andQxrqLessThanOrEqualTo(Date value) {
            addCriterion("qxrq <=", value, "qxrq");
            return (Criteria) this;
        }

        public Criteria andQxrqIn(List<Date> values) {
            addCriterion("qxrq in", values, "qxrq");
            return (Criteria) this;
        }

        public Criteria andQxrqNotIn(List<Date> values) {
            addCriterion("qxrq not in", values, "qxrq");
            return (Criteria) this;
        }

        public Criteria andQxrqBetween(Date value1, Date value2) {
            addCriterion("qxrq between", value1, value2, "qxrq");
            return (Criteria) this;
        }

        public Criteria andQxrqNotBetween(Date value1, Date value2) {
            addCriterion("qxrq not between", value1, value2, "qxrq");
            return (Criteria) this;
        }

        public Criteria andQxwhIsNull() {
            addCriterion("qxwh is null");
            return (Criteria) this;
        }

        public Criteria andQxwhIsNotNull() {
            addCriterion("qxwh is not null");
            return (Criteria) this;
        }

        public Criteria andQxwhEqualTo(String value) {
            addCriterion("qxwh =", value, "qxwh");
            return (Criteria) this;
        }

        public Criteria andQxwhNotEqualTo(String value) {
            addCriterion("qxwh <>", value, "qxwh");
            return (Criteria) this;
        }

        public Criteria andQxwhGreaterThan(String value) {
            addCriterion("qxwh >", value, "qxwh");
            return (Criteria) this;
        }

        public Criteria andQxwhGreaterThanOrEqualTo(String value) {
            addCriterion("qxwh >=", value, "qxwh");
            return (Criteria) this;
        }

        public Criteria andQxwhLessThan(String value) {
            addCriterion("qxwh <", value, "qxwh");
            return (Criteria) this;
        }

        public Criteria andQxwhLessThanOrEqualTo(String value) {
            addCriterion("qxwh <=", value, "qxwh");
            return (Criteria) this;
        }

        public Criteria andQxwhLike(String value) {
            addCriterion("qxwh like", value, "qxwh");
            return (Criteria) this;
        }

        public Criteria andQxwhNotLike(String value) {
            addCriterion("qxwh not like", value, "qxwh");
            return (Criteria) this;
        }

        public Criteria andQxwhIn(List<String> values) {
            addCriterion("qxwh in", values, "qxwh");
            return (Criteria) this;
        }

        public Criteria andQxwhNotIn(List<String> values) {
            addCriterion("qxwh not in", values, "qxwh");
            return (Criteria) this;
        }

        public Criteria andQxwhBetween(String value1, String value2) {
            addCriterion("qxwh between", value1, value2, "qxwh");
            return (Criteria) this;
        }

        public Criteria andQxwhNotBetween(String value1, String value2) {
            addCriterion("qxwh not between", value1, value2, "qxwh");
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