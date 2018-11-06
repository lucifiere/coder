package com.lucfiere.resolver.appender

import com.lucfiere.common.Cons
import com.lucfiere.resolver.type.CriteriaResolver

import static com.lucfiere.utils.CommonUtils.capitalFirst
import static com.lucfiere.utils.CommonUtils.toCamel

class StandardCriteriaResolver extends BaseAppender implements Appender, CriteriaResolver {

    @Override
    protected String headCode() {
        """
/**
 * @author ${Cons.AUTHOR}
 */ 
class ${capitalFirst(entityName)}Example {

protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> orCriteria;

    public ActivityRuleDOExample() {
        orCriteria = new ArrayList<Criteria>();
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

    public List<Criteria> getOrCriteria() {
        return orCriteria;
    }

    public void or(Criteria criteria) {
        orCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        orCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (orCriteria.size() == 0) {
            orCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        return new Criteria();
    }

    public void clear() {
        orCriteria.clear();
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
        """
    }

    @Override
    protected String bodyCode() {
        String body = ""
        table.getFieldList().each {
            body += """
        public Criteria and${capitalFirst(it.javaName)}IsNull() {
            addCriterion("${it.sqlName} is null");
            return (Criteria) this;
        }

        public Criteria and${capitalFirst(it.javaName)}IsNotNull() {
            addCriterion("${it.sqlName} is not null");
            return (Criteria) this;
        }

        public Criteria and${capitalFirst(it.javaName)}EqualTo(Long value) {
            addCriterion("${it.sqlName} =", value, "${it.javaName}");
            return (Criteria) this;
        }

        public Criteria and${capitalFirst(it.javaName)}NotEqualTo(Long value) {
            addCriterion("${it.sqlName} <>", value, "${it.javaName}");
            return (Criteria) this;
        }

        public Criteria and${capitalFirst(it.javaName)}GreaterThan(Long value) {
            addCriterion("${it.sqlName} >", value, "${it.javaName}");
            return (Criteria) this;
        }

        public Criteria and${capitalFirst(it.javaName)}GreaterThanOrEqualTo(Long value) {
            addCriterion("${it.sqlName} >=", value, "${it.javaName}");
            return (Criteria) this;
        }

        public Criteria and${capitalFirst(it.javaName)}LessThan(Long value) {
            addCriterion("${it.sqlName} <", value, "${it.javaName}");
            return (Criteria) this;
        }

        public Criteria and${capitalFirst(it.javaName)}LessThanOrEqualTo(Long value) {
            addCriterion("${it.sqlName} <=", value, "${it.javaName}");
            return (Criteria) this;
        }

        public Criteria and${capitalFirst(it.javaName)}In(List<Long> values) {
            addCriterion("${it.sqlName} in", values, "${it.javaName}");
            return (Criteria) this;
        }

        public Criteria and${capitalFirst(it.javaName)}NotIn(List<Long> values) {
            addCriterion("${it.sqlName} not in", values, "${it.javaName}");
            return (Criteria) this;
        }

        public Criteria and${capitalFirst(it.javaName)}Between(Long value1, Long value2) {
            addCriterion("${it.sqlName} between", value1, value2, "${it.javaName}");
            return (Criteria) this;
        }

        public Criteria and${capitalFirst(it.javaName)}NotBetween(Long value1, Long value2) {
            addCriterion("${it.sqlName} not between", value1, value2, "${it.javaName}");
            return (Criteria) this;
        }
        """
        }
        body
    }

    @Override
    protected String tailCode() {
        """
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
        """
    }

}
