/*
 * fileName:  AbstractBasicEntity.java
 * author:  Lei
 * Company:  Cloudland Studio
 * Createdate:  2016-7-14 15:01:45
 * <p>
 * All rights Reserved, Designed By cloudland Copyright(C) 2016
 * <p>
 * Modification  History:
 * Date           Author        Version
 * -------------------------------------------
 * 2016-7-14           Lei            1.0
 * <p>
 * Why & What is modified:
 */
package org.cloudland.study.jpa.db.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * <pre>
 * 抽象的基础数据库实体类
 * </pre>
 *
 * @author Lei
 * @version %I%, %G%
 * @ClassName AbstractBasicEntity
 * @see
 * @since JDK1.6
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractBasicEntity {

    @Id
    @Column(name = "INDETIFIER_NO")
    private String indetifierNo;

    /**
     *  创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_TIME", nullable = false)
    private Date createdTime;

    /**
     *  更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_TIME", nullable = false)
    private Date updatedTime;

    /**
     *  失效时间
     */
    @Column(name = "END_TIME", nullable = false)
    private Date endTime;

    /**
     *  序列号
     */
    @Column(name = "SEQ_NO", nullable = true, length = 4)
    private Integer seqNo;

    /**
     * <pre>
     * 构造函数
     * </pre>
     *
     * @param createdTime 创建时间
     * @param updatedTime 修改时间
     * @param endTime     失效时间
     * @param seqNo       序列号
     */
    public AbstractBasicEntity(Date createdTime, Date updatedTime, Date endTime, Integer seqNo) {
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.endTime = endTime;
        this.seqNo = seqNo;
    }

    /**
     * <pre>
     * 默认构造函数
     * </pre>
     */
    public AbstractBasicEntity() {
        // TODO Auto-generated constructor stub
    }

//    public String getIndetifierNo() {
//        return indetifierNo;
//    }
//
//    public void setIndetifierNo(String indetifierNo) {
//        this.indetifierNo = indetifierNo;
//    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

}
