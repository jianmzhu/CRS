package cn.crs.reserve.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BookCarDtlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookCarDtlExample() {
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

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookDateIsNull() {
            addCriterion("book_date is null");
            return (Criteria) this;
        }

        public Criteria andBookDateIsNotNull() {
            addCriterion("book_date is not null");
            return (Criteria) this;
        }

        public Criteria andBookDateEqualTo(Date value) {
            addCriterionForJDBCDate("book_date =", value, "bookDate");
            return (Criteria) this;
        }

        public Criteria andBookDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("book_date <>", value, "bookDate");
            return (Criteria) this;
        }

        public Criteria andBookDateGreaterThan(Date value) {
            addCriterionForJDBCDate("book_date >", value, "bookDate");
            return (Criteria) this;
        }

        public Criteria andBookDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("book_date >=", value, "bookDate");
            return (Criteria) this;
        }

        public Criteria andBookDateLessThan(Date value) {
            addCriterionForJDBCDate("book_date <", value, "bookDate");
            return (Criteria) this;
        }

        public Criteria andBookDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("book_date <=", value, "bookDate");
            return (Criteria) this;
        }

        public Criteria andBookDateIn(List<Date> values) {
            addCriterionForJDBCDate("book_date in", values, "bookDate");
            return (Criteria) this;
        }

        public Criteria andBookDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("book_date not in", values, "bookDate");
            return (Criteria) this;
        }

        public Criteria andBookDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("book_date between", value1, value2, "bookDate");
            return (Criteria) this;
        }

        public Criteria andBookDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("book_date not between", value1, value2, "bookDate");
            return (Criteria) this;
        }

        public Criteria andBookTimestampIsNull() {
            addCriterion("book_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andBookTimestampIsNotNull() {
            addCriterion("book_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andBookTimestampEqualTo(Date value) {
            addCriterion("book_timestamp =", value, "bookTimestamp");
            return (Criteria) this;
        }

        public Criteria andBookTimestampNotEqualTo(Date value) {
            addCriterion("book_timestamp <>", value, "bookTimestamp");
            return (Criteria) this;
        }

        public Criteria andBookTimestampGreaterThan(Date value) {
            addCriterion("book_timestamp >", value, "bookTimestamp");
            return (Criteria) this;
        }

        public Criteria andBookTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("book_timestamp >=", value, "bookTimestamp");
            return (Criteria) this;
        }

        public Criteria andBookTimestampLessThan(Date value) {
            addCriterion("book_timestamp <", value, "bookTimestamp");
            return (Criteria) this;
        }

        public Criteria andBookTimestampLessThanOrEqualTo(Date value) {
            addCriterion("book_timestamp <=", value, "bookTimestamp");
            return (Criteria) this;
        }

        public Criteria andBookTimestampIn(List<Date> values) {
            addCriterion("book_timestamp in", values, "bookTimestamp");
            return (Criteria) this;
        }

        public Criteria andBookTimestampNotIn(List<Date> values) {
            addCriterion("book_timestamp not in", values, "bookTimestamp");
            return (Criteria) this;
        }

        public Criteria andBookTimestampBetween(Date value1, Date value2) {
            addCriterion("book_timestamp between", value1, value2, "bookTimestamp");
            return (Criteria) this;
        }

        public Criteria andBookTimestampNotBetween(Date value1, Date value2) {
            addCriterion("book_timestamp not between", value1, value2, "bookTimestamp");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Integer value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Integer value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Integer value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Integer value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Integer> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Integer> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Integer value1, Integer value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andBookTimesIsNull() {
            addCriterion("book_times is null");
            return (Criteria) this;
        }

        public Criteria andBookTimesIsNotNull() {
            addCriterion("book_times is not null");
            return (Criteria) this;
        }

        public Criteria andBookTimesEqualTo(String value) {
            addCriterion("book_times =", value, "bookTimes");
            return (Criteria) this;
        }

        public Criteria andBookTimesNotEqualTo(String value) {
            addCriterion("book_times <>", value, "bookTimes");
            return (Criteria) this;
        }

        public Criteria andBookTimesGreaterThan(String value) {
            addCriterion("book_times >", value, "bookTimes");
            return (Criteria) this;
        }

        public Criteria andBookTimesGreaterThanOrEqualTo(String value) {
            addCriterion("book_times >=", value, "bookTimes");
            return (Criteria) this;
        }

        public Criteria andBookTimesLessThan(String value) {
            addCriterion("book_times <", value, "bookTimes");
            return (Criteria) this;
        }

        public Criteria andBookTimesLessThanOrEqualTo(String value) {
            addCriterion("book_times <=", value, "bookTimes");
            return (Criteria) this;
        }

        public Criteria andBookTimesLike(String value) {
            addCriterion("book_times like", value, "bookTimes");
            return (Criteria) this;
        }

        public Criteria andBookTimesNotLike(String value) {
            addCriterion("book_times not like", value, "bookTimes");
            return (Criteria) this;
        }

        public Criteria andBookTimesIn(List<String> values) {
            addCriterion("book_times in", values, "bookTimes");
            return (Criteria) this;
        }

        public Criteria andBookTimesNotIn(List<String> values) {
            addCriterion("book_times not in", values, "bookTimes");
            return (Criteria) this;
        }

        public Criteria andBookTimesBetween(String value1, String value2) {
            addCriterion("book_times between", value1, value2, "bookTimes");
            return (Criteria) this;
        }

        public Criteria andBookTimesNotBetween(String value1, String value2) {
            addCriterion("book_times not between", value1, value2, "bookTimes");
            return (Criteria) this;
        }

        public Criteria andBookUserJobnoIsNull() {
            addCriterion("book_user_jobno is null");
            return (Criteria) this;
        }

        public Criteria andBookUserJobnoIsNotNull() {
            addCriterion("book_user_jobno is not null");
            return (Criteria) this;
        }

        public Criteria andBookUserJobnoEqualTo(String value) {
            addCriterion("book_user_jobno =", value, "bookUserJobno");
            return (Criteria) this;
        }

        public Criteria andBookUserJobnoNotEqualTo(String value) {
            addCriterion("book_user_jobno <>", value, "bookUserJobno");
            return (Criteria) this;
        }

        public Criteria andBookUserJobnoGreaterThan(String value) {
            addCriterion("book_user_jobno >", value, "bookUserJobno");
            return (Criteria) this;
        }

        public Criteria andBookUserJobnoGreaterThanOrEqualTo(String value) {
            addCriterion("book_user_jobno >=", value, "bookUserJobno");
            return (Criteria) this;
        }

        public Criteria andBookUserJobnoLessThan(String value) {
            addCriterion("book_user_jobno <", value, "bookUserJobno");
            return (Criteria) this;
        }

        public Criteria andBookUserJobnoLessThanOrEqualTo(String value) {
            addCriterion("book_user_jobno <=", value, "bookUserJobno");
            return (Criteria) this;
        }

        public Criteria andBookUserJobnoLike(String value) {
            addCriterion("book_user_jobno like", value, "bookUserJobno");
            return (Criteria) this;
        }

        public Criteria andBookUserJobnoNotLike(String value) {
            addCriterion("book_user_jobno not like", value, "bookUserJobno");
            return (Criteria) this;
        }

        public Criteria andBookUserJobnoIn(List<String> values) {
            addCriterion("book_user_jobno in", values, "bookUserJobno");
            return (Criteria) this;
        }

        public Criteria andBookUserJobnoNotIn(List<String> values) {
            addCriterion("book_user_jobno not in", values, "bookUserJobno");
            return (Criteria) this;
        }

        public Criteria andBookUserJobnoBetween(String value1, String value2) {
            addCriterion("book_user_jobno between", value1, value2, "bookUserJobno");
            return (Criteria) this;
        }

        public Criteria andBookUserJobnoNotBetween(String value1, String value2) {
            addCriterion("book_user_jobno not between", value1, value2, "bookUserJobno");
            return (Criteria) this;
        }

        public Criteria andBookSummIsNull() {
            addCriterion("book_summ is null");
            return (Criteria) this;
        }

        public Criteria andBookSummIsNotNull() {
            addCriterion("book_summ is not null");
            return (Criteria) this;
        }

        public Criteria andBookSummEqualTo(String value) {
            addCriterion("book_summ =", value, "bookSumm");
            return (Criteria) this;
        }

        public Criteria andBookSummNotEqualTo(String value) {
            addCriterion("book_summ <>", value, "bookSumm");
            return (Criteria) this;
        }

        public Criteria andBookSummGreaterThan(String value) {
            addCriterion("book_summ >", value, "bookSumm");
            return (Criteria) this;
        }

        public Criteria andBookSummGreaterThanOrEqualTo(String value) {
            addCriterion("book_summ >=", value, "bookSumm");
            return (Criteria) this;
        }

        public Criteria andBookSummLessThan(String value) {
            addCriterion("book_summ <", value, "bookSumm");
            return (Criteria) this;
        }

        public Criteria andBookSummLessThanOrEqualTo(String value) {
            addCriterion("book_summ <=", value, "bookSumm");
            return (Criteria) this;
        }

        public Criteria andBookSummLike(String value) {
            addCriterion("book_summ like", value, "bookSumm");
            return (Criteria) this;
        }

        public Criteria andBookSummNotLike(String value) {
            addCriterion("book_summ not like", value, "bookSumm");
            return (Criteria) this;
        }

        public Criteria andBookSummIn(List<String> values) {
            addCriterion("book_summ in", values, "bookSumm");
            return (Criteria) this;
        }

        public Criteria andBookSummNotIn(List<String> values) {
            addCriterion("book_summ not in", values, "bookSumm");
            return (Criteria) this;
        }

        public Criteria andBookSummBetween(String value1, String value2) {
            addCriterion("book_summ between", value1, value2, "bookSumm");
            return (Criteria) this;
        }

        public Criteria andBookSummNotBetween(String value1, String value2) {
            addCriterion("book_summ not between", value1, value2, "bookSumm");
            return (Criteria) this;
        }

        public Criteria andBookFromIsNull() {
            addCriterion("book_from is null");
            return (Criteria) this;
        }

        public Criteria andBookFromIsNotNull() {
            addCriterion("book_from is not null");
            return (Criteria) this;
        }

        public Criteria andBookFromEqualTo(String value) {
            addCriterion("book_from =", value, "bookFrom");
            return (Criteria) this;
        }

        public Criteria andBookFromNotEqualTo(String value) {
            addCriterion("book_from <>", value, "bookFrom");
            return (Criteria) this;
        }

        public Criteria andBookFromGreaterThan(String value) {
            addCriterion("book_from >", value, "bookFrom");
            return (Criteria) this;
        }

        public Criteria andBookFromGreaterThanOrEqualTo(String value) {
            addCriterion("book_from >=", value, "bookFrom");
            return (Criteria) this;
        }

        public Criteria andBookFromLessThan(String value) {
            addCriterion("book_from <", value, "bookFrom");
            return (Criteria) this;
        }

        public Criteria andBookFromLessThanOrEqualTo(String value) {
            addCriterion("book_from <=", value, "bookFrom");
            return (Criteria) this;
        }

        public Criteria andBookFromLike(String value) {
            addCriterion("book_from like", value, "bookFrom");
            return (Criteria) this;
        }

        public Criteria andBookFromNotLike(String value) {
            addCriterion("book_from not like", value, "bookFrom");
            return (Criteria) this;
        }

        public Criteria andBookFromIn(List<String> values) {
            addCriterion("book_from in", values, "bookFrom");
            return (Criteria) this;
        }

        public Criteria andBookFromNotIn(List<String> values) {
            addCriterion("book_from not in", values, "bookFrom");
            return (Criteria) this;
        }

        public Criteria andBookFromBetween(String value1, String value2) {
            addCriterion("book_from between", value1, value2, "bookFrom");
            return (Criteria) this;
        }

        public Criteria andBookFromNotBetween(String value1, String value2) {
            addCriterion("book_from not between", value1, value2, "bookFrom");
            return (Criteria) this;
        }

        public Criteria andBookToIsNull() {
            addCriterion("book_to is null");
            return (Criteria) this;
        }

        public Criteria andBookToIsNotNull() {
            addCriterion("book_to is not null");
            return (Criteria) this;
        }

        public Criteria andBookToEqualTo(String value) {
            addCriterion("book_to =", value, "bookTo");
            return (Criteria) this;
        }

        public Criteria andBookToNotEqualTo(String value) {
            addCriterion("book_to <>", value, "bookTo");
            return (Criteria) this;
        }

        public Criteria andBookToGreaterThan(String value) {
            addCriterion("book_to >", value, "bookTo");
            return (Criteria) this;
        }

        public Criteria andBookToGreaterThanOrEqualTo(String value) {
            addCriterion("book_to >=", value, "bookTo");
            return (Criteria) this;
        }

        public Criteria andBookToLessThan(String value) {
            addCriterion("book_to <", value, "bookTo");
            return (Criteria) this;
        }

        public Criteria andBookToLessThanOrEqualTo(String value) {
            addCriterion("book_to <=", value, "bookTo");
            return (Criteria) this;
        }

        public Criteria andBookToLike(String value) {
            addCriterion("book_to like", value, "bookTo");
            return (Criteria) this;
        }

        public Criteria andBookToNotLike(String value) {
            addCriterion("book_to not like", value, "bookTo");
            return (Criteria) this;
        }

        public Criteria andBookToIn(List<String> values) {
            addCriterion("book_to in", values, "bookTo");
            return (Criteria) this;
        }

        public Criteria andBookToNotIn(List<String> values) {
            addCriterion("book_to not in", values, "bookTo");
            return (Criteria) this;
        }

        public Criteria andBookToBetween(String value1, String value2) {
            addCriterion("book_to between", value1, value2, "bookTo");
            return (Criteria) this;
        }

        public Criteria andBookToNotBetween(String value1, String value2) {
            addCriterion("book_to not between", value1, value2, "bookTo");
            return (Criteria) this;
        }

        public Criteria andCheckUserJobnoIsNull() {
            addCriterion("check_user_jobno is null");
            return (Criteria) this;
        }

        public Criteria andCheckUserJobnoIsNotNull() {
            addCriterion("check_user_jobno is not null");
            return (Criteria) this;
        }

        public Criteria andCheckUserJobnoEqualTo(String value) {
            addCriterion("check_user_jobno =", value, "checkUserJobno");
            return (Criteria) this;
        }

        public Criteria andCheckUserJobnoNotEqualTo(String value) {
            addCriterion("check_user_jobno <>", value, "checkUserJobno");
            return (Criteria) this;
        }

        public Criteria andCheckUserJobnoGreaterThan(String value) {
            addCriterion("check_user_jobno >", value, "checkUserJobno");
            return (Criteria) this;
        }

        public Criteria andCheckUserJobnoGreaterThanOrEqualTo(String value) {
            addCriterion("check_user_jobno >=", value, "checkUserJobno");
            return (Criteria) this;
        }

        public Criteria andCheckUserJobnoLessThan(String value) {
            addCriterion("check_user_jobno <", value, "checkUserJobno");
            return (Criteria) this;
        }

        public Criteria andCheckUserJobnoLessThanOrEqualTo(String value) {
            addCriterion("check_user_jobno <=", value, "checkUserJobno");
            return (Criteria) this;
        }

        public Criteria andCheckUserJobnoLike(String value) {
            addCriterion("check_user_jobno like", value, "checkUserJobno");
            return (Criteria) this;
        }

        public Criteria andCheckUserJobnoNotLike(String value) {
            addCriterion("check_user_jobno not like", value, "checkUserJobno");
            return (Criteria) this;
        }

        public Criteria andCheckUserJobnoIn(List<String> values) {
            addCriterion("check_user_jobno in", values, "checkUserJobno");
            return (Criteria) this;
        }

        public Criteria andCheckUserJobnoNotIn(List<String> values) {
            addCriterion("check_user_jobno not in", values, "checkUserJobno");
            return (Criteria) this;
        }

        public Criteria andCheckUserJobnoBetween(String value1, String value2) {
            addCriterion("check_user_jobno between", value1, value2, "checkUserJobno");
            return (Criteria) this;
        }

        public Criteria andCheckUserJobnoNotBetween(String value1, String value2) {
            addCriterion("check_user_jobno not between", value1, value2, "checkUserJobno");
            return (Criteria) this;
        }

        public Criteria andCheckFlagIsNull() {
            addCriterion("check_flag is null");
            return (Criteria) this;
        }

        public Criteria andCheckFlagIsNotNull() {
            addCriterion("check_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCheckFlagEqualTo(Integer value) {
            addCriterion("check_flag =", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagNotEqualTo(Integer value) {
            addCriterion("check_flag <>", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagGreaterThan(Integer value) {
            addCriterion("check_flag >", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_flag >=", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagLessThan(Integer value) {
            addCriterion("check_flag <", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagLessThanOrEqualTo(Integer value) {
            addCriterion("check_flag <=", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagIn(List<Integer> values) {
            addCriterion("check_flag in", values, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagNotIn(List<Integer> values) {
            addCriterion("check_flag not in", values, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagBetween(Integer value1, Integer value2) {
            addCriterion("check_flag between", value1, value2, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("check_flag not between", value1, value2, "checkFlag");
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