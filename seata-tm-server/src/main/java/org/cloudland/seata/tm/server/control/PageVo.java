/**
 * FileName: PageVo
 * Author: hy
 * Company: Cloudland Studio
 * Createdate: 2018/10/1 14:30
 * <p>
 * All rights Reserved, Designed By cloudland Copyright(C) 2010-2018
 */
package org.cloudland.mango.server.control;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  分页使用的视图对象
 *  针对需要分页需求, 将对象集合, 当前页, 总记录数保存对象中, 用于分页使用
 * </pre>
 *
 * @author hy
 * @version v1.0
 * @ClassName PageVo
 * @see
 */
public class PageVo<L> {

    /**
     * totalRecords 总记录数
     */
    private Integer totalRecords = 0;

    /**
     * list 当前页视图对象集合
     */
    private List<L> list;

    /**
     * <pre>
     * 视图对象构造函数
     * </pre>
     *
     * @param totalRecords 总记录数
     * @param list         当前页视图对象集合
     */
    public PageVo(Integer totalRecords, List<L> list) {
        this.totalRecords = totalRecords;
        this.list = list;
    }

    /**
     * get totalRecords
     *
     * @return totalRecords
     */
    public Integer getTotalRecords() {
        return totalRecords;
    }

    /**
     * get list
     *
     * @return list
     */
    public List<L> getList() {
        if (null == list) {
            list = new ArrayList<L>(0);
        }
        return list;
    }
}
