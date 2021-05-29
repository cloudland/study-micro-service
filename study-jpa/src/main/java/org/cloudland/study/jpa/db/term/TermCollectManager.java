package org.cloudland.study.jpa.db.term;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.*;
import java.util.stream.Collectors;

public class TermCollectManager implements TermCollect {

    /**
     * 查询条件限制集合
     */
    private Map<String, FieldCondEntity> fieldEntityMapping = new HashMap<>(6);

    /**
     * 需排序字段集合
     */
    private Map<String, Sort> fieldSortMapping = new HashMap<>(6);

    private Integer pageNo = 1;

    private Integer pageSize = 9;

    private TermCollectManager() {
    }

    /**
     * 获取实例
     *
     * @return
     */
    public static TermCollect collect() {
        return new TermCollectManager();
    }

    public FieldRule field(String field) {
        FieldCondEntity fieldEntity = fieldEntityMapping.get(field);
        if (null == fieldEntity) {
            fieldEntity = new FieldCondEntity(null, field, null);
            fieldEntityMapping.put(field, fieldEntity);
        }

        return new InnerFieldRule(this, fieldEntity);
    }

    @Override
    public FieldSort orderBy(String field) {
        Sort fieldSort = fieldSortMapping.get(field);
        if (null == fieldSort) {
            fieldSort = Sort.by(field);
        }

        return new InnerFieldSort(this, fieldSort);
    }

    @Override
    public void limit(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    @Override
    public Result compile() {
        return new Result() {

            @Override
            public Specification specification() {
                return new TransferCond(fieldEntityMapping.values().stream().collect(Collectors.toList()));
            }

            @Override
            public Pageable pageable() {
                Sort sort = fieldSortMapping.values().stream().reduce((_curent, _next) -> _curent.and(_next)).orElse(null);
                return null == sort ? PageRequest.of(0 < pageNo ? pageNo - 1 : 0, pageSize) : PageRequest.of(0 < pageNo ? pageNo - 1 : 0, pageSize, sort);
            }
        };
    }

    /**
     * 条件转换为JPA支撑类
     */
    static class TransferCond implements Specification<InnerFieldRule> {

        private List<FieldCondEntity> fieldCondArray;

        public TransferCond(List<FieldCondEntity> fieldCondArray) {
            this.fieldCondArray = fieldCondArray;
        }

        private <L> Path<L> getQueryFiled(Root<InnerFieldRule> root, FieldCondEntity fieldEntity) {
            return root.get(fieldEntity.getField());
        }

        @Override
        public Predicate toPredicate(Root<InnerFieldRule> root, CriteriaQuery<?> query, CriteriaBuilder builder) {


            List<Predicate> predicateArray = new ArrayList<>(6);
            fieldCondArray.stream().filter(field -> 0 < field.getValueArray().length).forEach(field -> {

                // 循环匹配可以处理的类型
                Predicate predicate;
                switch (field.getCond()) {
                    case EQUAL:
                        // field = ?
                        Path<Object> queryFiled = getQueryFiled(root, field);
                        predicate = builder.equal(queryFiled, field.valueArray[0]);

                        predicateArray.add(predicate);
                        break;
                    case BEWTEEN:
                        // field between ? and ?
                        Path<Comparable> between = getQueryFiled(root, field);
                        if (2 > field.valueArray.length) {
                            // TODO 异常
                            break;
                        }
                        Comparable after = (Comparable) field.valueArray[0], before = (Comparable) field.valueArray[1];
                        predicate = builder.between(between, after, before);

                        predicateArray.add(predicate);
                        break;
                    case LESS_THAN:
                        // field < ?
                        Path<Comparable> lessThan = getQueryFiled(root, field);
                        predicate = builder.lessThan(lessThan, (Comparable) field.valueArray[0]);

                        predicateArray.add(predicate);
                        break;
                    case LESS_THAN_EQUAL:
                        // field <= ?
                        Path<Comparable> lessThanOrEqualTo = getQueryFiled(root, field);
                        predicate = builder.lessThanOrEqualTo(lessThanOrEqualTo, (Comparable) field.valueArray[0]);

                        predicateArray.add(predicate);
                        break;
                    case GREATEROR_THAN:
                        // field > ?
                        Path<Comparable> greaterThan = getQueryFiled(root, field);
                        predicate = builder.greaterThan(greaterThan, (Comparable) field.valueArray[0]);

                        predicateArray.add(predicate);
                        break;
                    case GREATEROR_THAN_EQUAL:
                        // field >= ?
                        Path<Comparable> greaterThanOrEqualTo = getQueryFiled(root, field);
                        predicate = builder.greaterThanOrEqualTo(greaterThanOrEqualTo, (Comparable) field.valueArray[0]);

                        predicateArray.add(predicate);
                        break;
                    case NOT_EQUAL:
                        Path<Object> notEqual = getQueryFiled(root, field);
                        predicate = builder.notEqual(notEqual, field.valueArray[0]);

                        predicateArray.add(predicate);
                        break;
                    case IS_NULL:
                        Path<Object> isNull = getQueryFiled(root, field);
                        predicate = builder.isNull(isNull);

                        predicateArray.add(predicate);
                        break;
                    case IS_NOT_NULL:
                        Path<Object> isNotNull = getQueryFiled(root, field);
                        predicate = builder.isNotNull(isNotNull);

                        predicateArray.add(predicate);
                        break;
                    case LEFT_LIKE:
                        // field like '%?'
                        Path<String> leftLike = getQueryFiled(root, field);
                        predicate = builder.like(leftLike, "%".concat(String.valueOf(field.valueArray[0])));

                        predicateArray.add(predicate);
                        break;
                    case RIGHT_LIKE:
                        // field like '?%'
                        Path<String> rightLike = getQueryFiled(root, field);
                        predicate = builder.like(rightLike, String.valueOf(field.valueArray[0]).concat("%"));

                        predicateArray.add(predicate);
                        break;
                    case FULL_LIKE:
                        // field like '%?%'
                        Path<String> fullLike = getQueryFiled(root, field);
                        predicate = builder.like(fullLike, new StringBuffer("%").append(String.valueOf(field.valueArray[0])).append("%").toString());

                        predicateArray.add(predicate);
                        break;
                    case DEFAULT_LIKE:
                        // field like '?'
                        Path<String> like = getQueryFiled(root, field);
                        predicate = builder.like(like, String.valueOf(field.valueArray[0]));

                        predicateArray.add(predicate);
                        break;
                    case NOT_LIKE:
                        //
                        Path<String> notLike = getQueryFiled(root, field);
                        predicate = builder.notLike(notLike, String.valueOf(field.valueArray[0]));

                        predicateArray.add(predicate);
                        break;
                    case IN:
                        // field in (?, ?...)
                        Path<Object> in = getQueryFiled(root, field);
                        CriteriaBuilder.In inArray = builder.in(in);
                        Arrays.stream(field.valueArray).forEach(value -> inArray.value(value));

                        predicateArray.add(inArray);
                        break;
                    default:
                        // TODO 不支持异常
                        break;
                }

            });

            return builder.and(predicateArray.stream().toArray(Predicate[]::new));
        }

    }

    /**
     * 字段支撑的比较规则, 可以手动添加新的比较规则
     */
    static class InnerFieldRule implements TermCollect.FieldRule {

        private TermCollect collect;

        private FieldCondEntity fieldEntity;

        public InnerFieldRule(TermCollect collect, FieldCondEntity fieldEntity) {
            this.fieldEntity = fieldEntity;
            this.collect = collect;
        }

        @Override
        public TermCollect equal(Object value) {
            fieldEntity.setCond(Rule.EQUAL);
            fieldEntity.setValueArray(new Object[]{value});
            return this.collect;
        }

        @Override
        public TermCollect notEqual(Object value) {
            fieldEntity.setCond(Rule.NOT_EQUAL);
            fieldEntity.setValueArray(new Object[]{value});
            return this.collect;
        }

        @Override
        public TermCollect greaterThan(Object value) {
            fieldEntity.setCond(Rule.GREATEROR_THAN);
            fieldEntity.setValueArray(new Object[]{value});
            return this.collect;
        }

        @Override
        public TermCollect greaterThanOrEqualTo(Object value) {
            fieldEntity.setCond(Rule.GREATEROR_THAN_EQUAL);
            fieldEntity.setValueArray(new Object[]{value});
            return this.collect;
        }

        @Override
        public TermCollect lessThan(Object value) {
            fieldEntity.setCond(Rule.LESS_THAN);
            fieldEntity.setValueArray(new Object[]{value});
            return this.collect;
        }

        @Override
        public TermCollect lessThanOrEqualTo(Object value) {
            fieldEntity.setCond(Rule.LESS_THAN_EQUAL);
            fieldEntity.setValueArray(new Object[]{value});
            return this.collect;
        }

        @Override
        public TermCollect between(Object... value) {
            fieldEntity.setCond(Rule.BEWTEEN);
            fieldEntity.setValueArray(value);
            return this.collect;
        }

        @Override
        public TermCollect in(Object... value) {
            fieldEntity.setCond(Rule.IN);
            fieldEntity.setValueArray(value);
            return this.collect;
        }
    }

    static class InnerFieldSort implements FieldSort {

        private TermCollect collect;

        private Sort fieldSort;

        public InnerFieldSort(TermCollect collect, Sort fieldSort) {
            this.collect = collect;
            this.fieldSort = fieldSort;
        }

        @Override
        public TermCollect ASC() {
            fieldSort.ascending();
            return this.collect;
        }

        @Override
        public TermCollect DESC() {
            fieldSort.descending();
            return this.collect;
        }
    }

    /**
     * 临时存储字段比较条件
     */
    @Data
    @AllArgsConstructor
    static class FieldCondEntity {

        /**
         * 查找条件
         */
        private Rule cond;

        /**
         * 查询字段
         */
        private String field;

        /**
         * 查询取值
         */
        private Object[] valueArray;

    }

    /**
     * 支持的比较规则
     */
    private enum Rule {

        /**
         * =
         */
        EQUAL,

        /**
         * bewteen and
         */
        BEWTEEN,

        /**
         * <
         */
        LESS_THAN,

        /**
         * <=
         */
        LESS_THAN_EQUAL,

        /**
         * >
         */
        GREATEROR_THAN,

        /**
         * >=
         */
        GREATEROR_THAN_EQUAL,

        /**
         * !=
         */
        NOT_EQUAL,

        /**
         * is null
         */
        IS_NULL,

        /**
         * is not null
         */
        IS_NOT_NULL,

        /**
         * XXX%
         */
        RIGHT_LIKE,

        /**
         * %XXX
         */
        LEFT_LIKE,

        /**
         * %XXX%
         */
        FULL_LIKE,

        /**
         * like XXX
         */
        DEFAULT_LIKE,

        /**
         * not like XXX
         */
        NOT_LIKE,

        /**
         * in
         */
        IN;
    }

}

