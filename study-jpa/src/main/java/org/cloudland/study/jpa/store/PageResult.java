/**
 * fileName:  PageResult.java
 * author:  Lei
 * Company:  Cloudland Studio
 * Createdate:  2015-4-14 下午9:46:51
 * <p>
 * All rights Reserved, Designed By cloudland Copyright(C) 2010-2011
 * <p>
 * Modification  History:
 * Date           Author        Version
 * -------------------------------------------
 * 2015-4-14          Lei            1.0
 * <p>
 * Why & What is modified:
 * 1.0: 文件创建
 */
package org.cloudland.study.jpa.store;

import java.util.List;

/**
 * <pre>
 * 分页查询结果
 * </pre>
 *
 * @author Lei
 * @version %I%, %G%
 * @ClassName PageResult
 * @see
 * @since JDK1.6
 */
public interface PageResult<L> {

    /**
     * 符合条件的记录总数
     *
     * @return
     */
    Long total();

    /**
     * 当前查询结果
     *
     * @return
     */
    List<L> list();
}
