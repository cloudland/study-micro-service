/**
 * fileName:  AbstractBasicTerm.java
 * author:  Lei
 * Company:  Cloudland Studio
 * Createdate:  2016-7-15 上午9:54:37
 * <p>
 * All rights Reserved, Designed By cloudland Copyright(C) 2016
 * <p>
 * Modification  History:
 * Date           Author        Version
 * -------------------------------------------
 * 2016-7-15           Lei            1.0
 * <p>
 * Why & What is modified:
 * 1.0: 文件创建
 */
package org.cloudland.study.jpa.db.term;

/**
 * <pre>
 * 抽象的基础数据库条件实体类
 * </pre>
 *
 * @author Lei
 * @version %I%, %G%
 * @ClassName AbstractBasicTerm
 * @see
 * @since JDK1.6
 */
public abstract class AbstractBasicTerm {

    /**
     * 主键编号
     */
    private String indetifierNo;

    /**
     * 开始行数
     */
    private Integer pageNo = 0;

    /**
     * 结束行数
     */
    private Integer pageSize = 9;

    /**
     * 默认查询不包含逻辑删除的数据
     */
    private Boolean endTime = true;

    public String getIndetifierNo() {
        return indetifierNo;
    }

    public void setIndetifierNo(String indetifierNo) {
        this.indetifierNo = indetifierNo;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getEndTime() {
        return endTime;
    }

    public void setEndTime(Boolean endTime) {
        this.endTime = endTime;
    }

}
