package org.cloudland.study.jpa.db.term;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public interface TermCollect {

    /**
     * 设置字段规则
     *
     * @param field 字段名称
     * @return 限制规则
     */
    FieldRule field(String field);

    /**
     * 设置字段排序
     *
     * @param field 字段名称
     * @return 排序规则
     */
    FieldSort orderBy(String field);

    /**
     * 设置查询记录数
     *
     * @param pageNo   开始页数
     * @param pageSize 每页大小
     */
    void limit(Integer pageNo, Integer pageSize);

    /**
     * 编译成JPT使用条件
     *
     * @return
     */
    Result compile();

    /**
     * 字段查询规则
     */
    interface FieldRule {

        /**
         * 等于
         *
         * @param value 取值
         * @return
         */
        TermCollect equal(Object value);

        /**
         * 不等于
         *
         * @param value 取值
         * @return
         */
        TermCollect notEqual(Object value);

        /**
         * 大于
         *
         * @param value 取值
         * @return
         */
        TermCollect greaterThan(Object value);

        /**
         * 大于等于
         *
         * @param value 取值
         * @return
         */
        TermCollect greaterThanOrEqualTo(Object value);

        /**
         * 小于
         *
         * @param value 取值
         * @return
         */
        TermCollect lessThan(Object value);

        /**
         * 小于等于
         *
         * @param value 取值
         * @return
         */
        TermCollect lessThanOrEqualTo(Object value);

        /**
         * 区间
         *
         * @param value 取值
         * @return
         */
        TermCollect between(Object... value);

        /**
         * 包含
         *
         * @param value 取值
         * @return
         */
        TermCollect in(Object... value);

    }

    /**
     * 字段排序
     */
    interface FieldSort {

        /**
         * 升序
         *
         * @return
         */
        TermCollect ASC();

        /**
         * 降序
         *
         * @return
         */
        TermCollect DESC();

    }

    /**
     * 编译结果
     */
    interface Result {

        /**
         * 查询条件
         *
         * @return
         */
        Specification specification();

        /**
         * 分页条件
         *
         * @return
         */
        Pageable pageable();

    }
}
