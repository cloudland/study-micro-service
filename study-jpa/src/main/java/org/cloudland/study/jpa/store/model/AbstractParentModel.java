/**
 * fileName:  AbstractParentModel.java
 * author:  Lei
 * Company:  Cloudland Studio
 * Createdate:  2016年12月17日 下午8:43:23
 * <p>
 * All rights Reserved, Designed By cloudland Copyright(C) 2010-2011
 * <p>
 * Modification  History:
 * Date           Author        Version
 * -------------------------------------------
 * 2016年12月17日          	    Lei            1.0
 * <p>
 * Why & What is modified:
 * 1.0: 文件创建
 */
package org.cloudland.study.jpa.store.model;

import java.util.Date;

/**
 * <pre>
 * 领域对象基础类
 * </pre>
 *
 * @author Lei
 * @version %I%, %G%
 * @ClassName AbstractParentModel
 * @see
 * @since JDK1.6
 */
public abstract class AbstractParentModel {

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 失效时间
     */
    private Date loseTime;

    /**
     * 当前模型版本号
     */
    private Integer version;

    /**
     * 构造函数
     *
     * @param createdTime 创建时间
     * @param updatedTime 更新时间
     * @param loseTime    失效时间
     * @param version     版本号
     */
    public AbstractParentModel(Date createdTime, Date updatedTime, Date loseTime, Integer version) {
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.loseTime = loseTime;
        this.version = version;
    }

    /**
     * 获取创建时间
     *
     * @return createdTime
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime the value of createdTime
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取更新时间
     *
     * @return updatedTime
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更新时间
     *
     * @param updatedTime the value of updatedTime
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取失效时间
     *
     * @return loseTime
     */
    public Date getLoseTime() {
        return loseTime;
    }

    /**
     * 设置失效时间
     *
     * @param loseTime the value of loseTime
     */
    public void setLoseTime(Date loseTime) {
        this.loseTime = loseTime;
    }

    /**
     * 获取版本号
     *
     * @return
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

}
