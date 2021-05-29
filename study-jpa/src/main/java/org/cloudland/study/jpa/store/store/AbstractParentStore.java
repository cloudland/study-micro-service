/**
 * fileName:  AbstractParentStore.java
 * author:  Lei
 * Company:  Cloudland Studio
 * Createdate:  2016-7-14 下午4:03:38
 * <p>
 * All rights Reserved, Designed By cloudland Copyright(C) 2016
 * <p>
 * Modification  History:
 * Date           Author        Version
 * -------------------------------------------
 * 2016-7-14           Lei            1.0
 * <p>
 * Why & What is modified:
 * 1.0: 文件创建
 */
package org.cloudland.study.jpa.store.store;

import org.cloudland.study.jpa.db.entity.AEntity;
import org.cloudland.study.jpa.db.entity.AbstractBasicEntity;
import org.cloudland.study.jpa.db.persistence.Persistence;
import org.cloudland.study.jpa.db.term.TermCollect;
import org.cloudland.study.jpa.db.term.TermCollectManager;
import org.cloudland.study.jpa.store.PageResult;
import org.cloudland.study.jpa.store.PageResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <pre>
 * 仓储抽象基础类
 * </pre>
 *
 * @author Lei
 * @version %I%, %G%
 * @ClassName AbstractParentStore
 * @see
 * @since JDK1.6
 */
public abstract class AbstractParentStore<E extends AbstractBasicEntity, M> {

    /**
     * 日志对象
     */
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     * 失效时间
     */
    private Date loseDate;

    /**
     * <pre>
     * TODO 请充分描述该构造函数的作用，及其参数的作用。
     * </pre>
     */
    public AbstractParentStore() {
        // 设置失效时间
        Calendar calendar = Calendar.getInstance();
        calendar.set(9999, 11, 31, 23, 59, 59);
        loseDate = calendar.getTime();
    }

    /**
     * 获取日志对象
     *
     * @return
     */
    protected Logger getLogger() {
        return this.LOGGER;
    }

    /**
     * 获取失效时间，失效时间为：9999-12-31 23:59:59
     *
     * @return
     */
    protected Date getLoseDate() {
        return this.loseDate;
    }

    /**
     * 获取主键编号，主键格式为UUID 32位。每次调用都会随机产生一个新的。
     * </pre>
     *
     */
    protected String getPrimaryKey() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 将领域模型对象转换为实体对象保存
     *
     * @param model
     */
    public Integer create(M model) {
        // 將領域對象, 轉換為數據庫實體對象存儲
        E entity = transform(model);

        // 默认属性设置
        Date currDate = new Date();
        if (null == entity.getCreatedTime()) {
            entity.setCreatedTime(currDate);
        }

        if (null == entity.getUpdatedTime()) {
            entity.setUpdatedTime(currDate);
        }

        if (null == entity.getEndTime()) {
            entity.setEndTime(getLoseDate());
        }

        if (null == entity.getSeqNo()) {
            entity.setSeqNo(1);
        }

        // 获取影响行数
        Integer changeRow = 0;
        try {
            // 获取影响行数
            changeRow = null == getPersistence().save(entity) ? 0 : 1;
        } catch (Exception e) {
            // 打印异常并直接向上抛出
            getLogger().error("[数据库]新增失败, 数据:[{}].", model.toString(), e);
            throw new RuntimeException(e);
        }

        return changeRow;
    }

    /**
     * 更新领域模型对象
     *
     * @param model
     */
    public Integer update(M model) {
        // 將領域對象, 轉換為數據庫實體對象存儲
        E entity = transform(model);
        entity.setUpdatedTime(new Date());// 设置更新时间

        // 获取影响行数
        Integer changeRow = 0;
        try {
            // 获取影响行数
            changeRow = null == getPersistence().save(entity) ? 0 : 1;
        } catch (Exception e) {
            // 打印异常并直接向上抛出
            getLogger().error("[会员数据库]更新失败, 数据:[{}].", model.toString(), e);
            throw new RuntimeException(e);
        }

        return changeRow;
    }

    /**
     * 移除领域模型对象
     *
     * @param model
     */
    public void remove(M model) {
        // 將領域對象, 轉換為數據庫實體對象存儲
        E entity = transform(model);

        // 获取影响行数
        Integer changeRow = 0;
        try {
            // 获取影响行数
            getPersistence().delete(entity);
        } catch (Exception e) {
            // 打印异常并直接向上抛出
            getLogger().error("[会员数据库]删除失败, 数据:[{}].", model.toString(), e);
            throw new RuntimeException(e);
        }

//        return changeRow;
    }

    /**
     * 获取查询条件
     * @return
     */
    protected TermCollect buildTerm() {
        return TermCollectManager.collect();
    }

    /**
     * 根据条件查询结果集合
     *
     * @param term
     * @return
     */
    protected List<M> findByTerm(TermCollect term) {
        List<M> modelArray = null;

        try {
            // 获取编译结果
            TermCollect.Result result = term.compile();
            // 获取查询结果
            Page<E> page = getPersistence().findAll(result.specification(), result.pageable());
            if (null == page || null == page.toList()) {
                return modelArray;
            }

            // 转换为领域对象集合
            modelArray = page.get().map(entity -> untransform(entity)).collect(Collectors.toList());
        } catch (Exception e) {
            // 打印异常并直接向上抛出
            getLogger().error("[数据库]查询指定条件结果, 条件:[{}].", term.toString(), e);
            throw new RuntimeException(e);
        }

        return modelArray;
    }

    /**
     * 根据条件分页查询
     *
     * @param term
     * @return
     */
    protected PageResult<M> findPageByTerm(TermCollect term) {
        PageResult<M> pageResult = null;

        try {
            // 获取编译结果
            TermCollect.Result result = term.compile();
            // 获取查询结果
            Page<E> page = getPersistence().findAll(result.specification(), result.pageable());
            if (null == page || null == page.toList()) {
                return pageResult;
            }

            // 转换为领域对象集合
            List<M> modelArray = page.get().map(entity -> untransform(entity)).collect(Collectors.toList());

            pageResult = new PageResultBean<M>(page.getTotalElements(), modelArray);
        } catch (Exception e) {
            // 打印异常并直接向上抛出
            getLogger().error("[数据库]查询指定条件结果, 条件:[{}].", term.toString(), e);
            throw new RuntimeException(e);
        }

        return pageResult;
    }

    /**
     * 获取具体操作的数据库对象
     *
     * @return
     */
    abstract protected <P extends Persistence> P getPersistence();

    /**
     * 将领域对象转换为数据库实体对象
     *
     * @param model
     * @return
     */
    abstract protected E transform(M model);

    /**
     * 将数据库实体对象转换为领域对象
     *
     * @param entity
     * @return
     */
    abstract protected M untransform(E entity);

}
