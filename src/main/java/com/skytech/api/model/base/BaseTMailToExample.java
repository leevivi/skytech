package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseModelExample;

import java.util.ArrayList;
import java.util.List;

public class BaseTMailToExample extends BaseModelExample{

    protected List<Criteria> oredCriteria;

    public BaseTMailToExample() {
        oredCriteria = new ArrayList<Criteria>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMailidIsNull() {
            addCriterion("mailId is null");
            return (Criteria) this;
        }

        public Criteria andMailidIsNotNull() {
            addCriterion("mailId is not null");
            return (Criteria) this;
        }

        public Criteria andMailidEqualTo(Integer value) {
            addCriterion("mailId =", value, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidNotEqualTo(Integer value) {
            addCriterion("mailId <>", value, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidGreaterThan(Integer value) {
            addCriterion("mailId >", value, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mailId >=", value, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidLessThan(Integer value) {
            addCriterion("mailId <", value, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidLessThanOrEqualTo(Integer value) {
            addCriterion("mailId <=", value, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidIn(List<Integer> values) {
            addCriterion("mailId in", values, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidNotIn(List<Integer> values) {
            addCriterion("mailId not in", values, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidBetween(Integer value1, Integer value2) {
            addCriterion("mailId between", value1, value2, "mailid");
            return (Criteria) this;
        }

        public Criteria andMailidNotBetween(Integer value1, Integer value2) {
            addCriterion("mailId not between", value1, value2, "mailid");
            return (Criteria) this;
        }

        public Criteria andTouserIsNull() {
            addCriterion("toUser is null");
            return (Criteria) this;
        }

        public Criteria andTouserIsNotNull() {
            addCriterion("toUser is not null");
            return (Criteria) this;
        }

        public Criteria andTouserEqualTo(String value) {
            addCriterion("toUser =", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserNotEqualTo(String value) {
            addCriterion("toUser <>", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserGreaterThan(String value) {
            addCriterion("toUser >", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserGreaterThanOrEqualTo(String value) {
            addCriterion("toUser >=", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserLessThan(String value) {
            addCriterion("toUser <", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserLessThanOrEqualTo(String value) {
            addCriterion("toUser <=", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserLike(String value) {
            addCriterion("toUser like", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserNotLike(String value) {
            addCriterion("toUser not like", value, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserIn(List<String> values) {
            addCriterion("toUser in", values, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserNotIn(List<String> values) {
            addCriterion("toUser not in", values, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserBetween(String value1, String value2) {
            addCriterion("toUser between", value1, value2, "touser");
            return (Criteria) this;
        }

        public Criteria andTouserNotBetween(String value1, String value2) {
            addCriterion("toUser not between", value1, value2, "touser");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
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