/**
 * FileName: AbstractParentSupport.java
 * Author: Lei
 * Company: Cloudland Studio
 * Createdate: 2018-12-19 14:54
 * <p>
 * All rights Reserved, Designed By cloudland Copyright(C) 2010-2018
 */package org.cloudland.study.seata.a.master;

 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * <pre>
 * 仓储抽象父级支撑类
 * </pre>
 *
 * @author Lei
 * @version v1.0
 * @ClassName AbstractParentSupport
 * @see
 */public abstract class AbstractParentSupport {

    /**
     * 日志对象
     */
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取日志对象
     *
     * @return
     */
    protected Logger getLogger() {
        return this.LOGGER;
    }
}
