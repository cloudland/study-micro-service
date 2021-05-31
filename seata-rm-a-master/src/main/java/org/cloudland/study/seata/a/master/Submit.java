/**
 * fileName:  Submit.java
 * author:  14010519
 * Company:  Cloudland Studio
 * Createdate:  2015-5-11 下午7:34:21
 * <p>
 * All rights Reserved, Designed By cloudland Copyright(C) 2010-2011
 * <p>
 * Modification  History:
 * Date           Author        Version
 * -------------------------------------------
 * 2015-5-11          14010519            1.0
 * <p>
 * Why & What is modified:
 * 1.0: 文件创建
 */
package org.cloudland.study.seata.a.master;

/**
 * <pre>
 * 提交接口
 * </pre>
 *
 * @author 14010519
 * @version %I%, %G%
 * @ClassName Submit
 * @see
 * @since JDK1.6
 */
public interface Submit {

    /**
     * 提交
     *
     * @return 标识符
     */
    String submit();

}
