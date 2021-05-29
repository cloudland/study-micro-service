/**
 * fileName:  PageResultBean.java
 * author:  Lei
 * Company:  Cloudland Studio
 * Createdate:  2014-10-4 下午11:26:47
 * <p>
 * All rights Reserved, Designed By cloudland Copyright(C) 2010-2011
 * <p>
 * Modification  History:
 * Date           Author        Version
 * -------------------------------------------
 * 2014-10-4          Lei            1.0
 * <p>
 * Why & What is modified:
 * 1.0: 文件创建
 */
package org.cloudland.study.jpa.store;

import java.util.List;

/**
 * <pre>
 * 分页结果支撑类
 * </pre>
 *
 * @author Lei
 * @version %I%, %G%
 * @ClassName PageResultBean
 * @see
 * @since JDK1.6
 */
public class PageResultBean<L> implements PageResult<L> {

    /**
     * 符合条件的记录总数
     */
    private Long count;

    /**
     * 结果集
     */
    private List<L> result;

    public PageResultBean(Long count, List<L> result) {
        this.count = count;
        this.result = result;
    }

    @Override
    public Long total() {
        return this.count;
    }

    @Override
    public List<L> list() {
        return this.result;
    }

}
