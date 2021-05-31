/**
 * FileName: Union.java
 * Author: Lei
 * Company: Cloudland Studio
 * Createdate: 2020-12-20 14:10
 * <p>
 * All rights Reserved, Designed By cloudland Copyright(C) 2010-2020
 */
package org.cloudland.seata.tm.server.service;
/**
 * <pre>
 * 联合执行内容
 * </pre>
 *
 * @author Lei
 * @version v1.0
 * @ClassName Union
 * @see
 */
public interface Union {

    /**
     * 执行
     *
     * @return 执行结果
     */
    Object exec();
}
