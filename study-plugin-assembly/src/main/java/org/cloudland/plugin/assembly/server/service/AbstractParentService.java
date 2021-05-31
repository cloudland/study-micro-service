/**
 * FileName: AbstractParentService
 * Author: hy
 * Company: Cloudland Studio
 * Createdate: 2018/9/29 21:15
 * <p>
 * All rights Reserved, Designed By cloudland Copyright(C) 2010-2018
 */
package org.cloudland.plugin.assembly.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

/**
 * <pre>
 * 服务层公共基础服务类
 * </pre>
 *
 * @author hy
 * @version v1.0
 * @ClassName AbstractParentService
 * @see
 */
public class AbstractParentService {

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
        return LOGGER;
    }

}
