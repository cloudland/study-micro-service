/**
 * FileName: AbstractParentControl
 * Author: Lei
 * Company: Cloudland Studio
 * Createdate: 2018/12/6 16:06
 * <p>
 * All rights Reserved, Designed By cloudland Copyright(C) 2010-2018
 */
package org.cloudland.seata.tm.server.control;

import org.cloudland.seata.tm.core.JsonResult;
import org.cloudland.seata.tm.server.service.Union;
import org.cloudland.seata.tm.server.service.UnionTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * 所有控制器需要集成的基础控制类
 * </pre>
 *
 * @author Lei
 * @version v1.0
 * @ClassName AbstractParentControl
 * @see
 */
public abstract class AbstractParentControl {

    /**
     * 日志对象
     */
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     * 默认每页显示记录数
     */
    private Integer DEFAULT_PAGESIZE = 10;

    /**
     * 联合事务管理接口
     */
    @Resource(name = "Web.Frame.Transactional.UnionTransactional")
    private UnionTransactional unionTransactional;

    /**
     * 获取日志对象
     *
     * @return
     */
    protected Logger getLogger() {
        return LOGGER;
    }

    /**
     * 默认分页大小
     *
     * @return
     */
    protected Integer getPageSize() {
        return DEFAULT_PAGESIZE;
    }

    /**
     * 针对AJax请求的处理响应封装
     *
     * @param result true-成功
     * @return 回传结果
     */
    protected <L> JsonResult<L> doSuccess(L result) {
        return new JsonResult<L>(result);
    }

    /**
     * 针对AJax请求的处理响应封装
     *
     * @param code 错误码
     * @param msg  错误消息
     * @return
     */
    protected JsonResult<String> doError(String code, String msg) {
        return new JsonResult<String>(code, msg);
    }

    /**
     * 联合操作事务控制
     *
     * @param union 联合操作内容
     */
    protected Object doTransactional(Union union) {
        // 执行需要控制的联合事务
        return unionTransactional.doTransactional(union);
    }

}
