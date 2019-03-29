package com.skytech.api.model.base;

import com.skytech.api.core.model.BaseModelExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseTCourseTimeExample extends BaseModelExample{
    protected List<Criteria> oredCriteria;

    public BaseTCourseTimeExample() {
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

        public Criteria andCourseidIsNull() {
            addCriterion("courseId is null");
            return (Criteria) this;
        }

        public Criteria andCourseidIsNotNull() {
            addCriterion("courseId is not null");
            return (Criteria) this;
        }

        public Criteria andCourseidEqualTo(Integer value) {
            addCriterion("courseId =", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotEqualTo(Integer value) {
            addCriterion("courseId <>", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThan(Integer value) {
            addCriterion("courseId >", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("courseId >=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThan(Integer value) {
            addCriterion("courseId <", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThanOrEqualTo(Integer value) {
            addCriterion("courseId <=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidIn(List<Integer> values) {
            addCriterion("courseId in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotIn(List<Integer> values) {
            addCriterion("courseId not in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidBetween(Integer value1, Integer value2) {
            addCriterion("courseId between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotBetween(Integer value1, Integer value2) {
            addCriterion("courseId not between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andWeekidIsNull() {
            addCriterion("weekId is null");
            return (Criteria) this;
        }

        public Criteria andWeekidIsNotNull() {
            addCriterion("weekId is not null");
            return (Criteria) this;
        }

        public Criteria andWeekidEqualTo(Integer value) {
            addCriterion("weekId =", value, "weekid");
            return (Criteria) this;
        }

        public Criteria andWeekidNotEqualTo(Integer value) {
            addCriterion("weekId <>", value, "weekid");
            return (Criteria) this;
        }

        public Criteria andWeekidGreaterThan(Integer value) {
            addCriterion("weekId >", value, "weekid");
            return (Criteria) this;
        }

        public Criteria andWeekidGreaterThanOrEqualTo(Integer value) {
            addCriterion("weekId >=", value, "weekid");
            return (Criteria) this;
        }

        public Criteria andWeekidLessThan(Integer value) {
            addCriterion("weekId <", value, "weekid");
            return (Criteria) this;
        }

        public Criteria andWeekidLessThanOrEqualTo(Integer value) {
            addCriterion("weekId <=", value, "weekid");
            return (Criteria) this;
        }

        public Criteria andWeekidIn(List<Integer> values) {
            addCriterion("weekId in", values, "weekid");
            return (Criteria) this;
        }

        public Criteria andWeekidNotIn(List<Integer> values) {
            addCriterion("weekId not in", values, "weekid");
            return (Criteria) this;
        }

        public Criteria andWeekidBetween(Integer value1, Integer value2) {
            addCriterion("weekId between", value1, value2, "weekid");
            return (Criteria) this;
        }

        public Criteria andWeekidNotBetween(Integer value1, Integer value2) {
            addCriterion("weekId not between", value1, value2, "weekid");
            return (Criteria) this;
        }

        public Criteria andStartcoursetimeIsNull() {
            addCriterion("startCourseTime is null");
            return (Criteria) this;
        }

        public Criteria andStartcoursetimeIsNotNull() {
            addCriterion("startCourseTime is not null");
            return (Criteria) this;
        }

        public Criteria andStartcoursetimeEqualTo(Date value) {
            addCriterion("startCourseTime =", value, "startcoursetime");
            return (Criteria) this;
        }

        public Criteria andStartcoursetimeNotEqualTo(Date value) {
            addCriterion("startCourseTime <>", value, "startcoursetime");
            return (Criteria) this;
        }

        public Criteria andStartcoursetimeGreaterThan(Date value) {
            addCriterion("startCourseTime >", value, "startcoursetime");
            return (Criteria) this;
        }

        public Criteria andStartcoursetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("startCourseTime >=", value, "startcoursetime");
            return (Criteria) this;
        }

        public Criteria andStartcoursetimeLessThan(Date value) {
            addCriterion("startCourseTime <", value, "startcoursetime");
            return (Criteria) this;
        }

        public Criteria andStartcoursetimeLessThanOrEqualTo(Date value) {
            addCriterion("startCourseTime <=", value, "startcoursetime");
            return (Criteria) this;
        }

        public Criteria andStartcoursetimeIn(List<Date> values) {
            addCriterion("startCourseTime in", values, "startcoursetime");
            return (Criteria) this;
        }

        public Criteria andStartcoursetimeNotIn(List<Date> values) {
            addCriterion("startCourseTime not in", values, "startcoursetime");
            return (Criteria) this;
        }

        public Criteria andStartcoursetimeBetween(Date value1, Date value2) {
            addCriterion("startCourseTime between", value1, value2, "startcoursetime");
            return (Criteria) this;
        }

        public Criteria andStartcoursetimeNotBetween(Date value1, Date value2) {
            addCriterion("startCourseTime not between", value1, value2, "startcoursetime");
            return (Criteria) this;
        }

        public Criteria andEndcoursetimeIsNull() {
            addCriterion("endCourseTime is null");
            return (Criteria) this;
        }

        public Criteria andEndcoursetimeIsNotNull() {
            addCriterion("endCourseTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndcoursetimeEqualTo(Date value) {
            addCriterion("endCourseTime =", value, "endcoursetime");
            return (Criteria) this;
        }

        public Criteria andEndcoursetimeNotEqualTo(Date value) {
            addCriterion("endCourseTime <>", value, "endcoursetime");
            return (Criteria) this;
        }

        public Criteria andEndcoursetimeGreaterThan(Date value) {
            addCriterion("endCourseTime >", value, "endcoursetime");
            return (Criteria) this;
        }

        public Criteria andEndcoursetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endCourseTime >=", value, "endcoursetime");
            return (Criteria) this;
        }

        public Criteria andEndcoursetimeLessThan(Date value) {
            addCriterion("endCourseTime <", value, "endcoursetime");
            return (Criteria) this;
        }

        public Criteria andEndcoursetimeLessThanOrEqualTo(Date value) {
            addCriterion("endCourseTime <=", value, "endcoursetime");
            return (Criteria) this;
        }

        public Criteria andEndcoursetimeIn(List<Date> values) {
            addCriterion("endCourseTime in", values, "endcoursetime");
            return (Criteria) this;
        }

        public Criteria andEndcoursetimeNotIn(List<Date> values) {
            addCriterion("endCourseTime not in", values, "endcoursetime");
            return (Criteria) this;
        }

        public Criteria andEndcoursetimeBetween(Date value1, Date value2) {
            addCriterion("endCourseTime between", value1, value2, "endcoursetime");
            return (Criteria) this;
        }

        public Criteria andEndcoursetimeNotBetween(Date value1, Date value2) {
            addCriterion("endCourseTime not between", value1, value2, "endcoursetime");
            return (Criteria) this;
        }

        public Criteria andClassidIsNull() {
            addCriterion("classId is null");
            return (Criteria) this;
        }

        public Criteria andClassidIsNotNull() {
            addCriterion("classId is not null");
            return (Criteria) this;
        }

        public Criteria andClassidEqualTo(Integer value) {
            addCriterion("classId =", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotEqualTo(Integer value) {
            addCriterion("classId <>", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThan(Integer value) {
            addCriterion("classId >", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThanOrEqualTo(Integer value) {
            addCriterion("classId >=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThan(Integer value) {
            addCriterion("classId <", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThanOrEqualTo(Integer value) {
            addCriterion("classId <=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidIn(List<Integer> values) {
            addCriterion("classId in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotIn(List<Integer> values) {
            addCriterion("classId not in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidBetween(Integer value1, Integer value2) {
            addCriterion("classId between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotBetween(Integer value1, Integer value2) {
            addCriterion("classId not between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
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