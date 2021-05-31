package org.cloudland.study.seata.a.master;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 提交动作抽象类
 * </pre>
 *
 * @author 14010519
 * @version %I%, %G%
 * @ClassName SubmitBean
 * @see
 * @since JDK1.6
 */

public abstract class SubmitBean implements Submit {

    /**
     * 日志对象
     */
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取日志记录对象
     *
     * @return
     */
    protected Logger getLogger() {
        return LOGGER;
    }

    @Override
    public String submit() {

        // 提交请求, 前置条件校验
        validate();

        // 提交请求
        return doSubmit();
    }

    /**
     * 参数校验
     */
    protected abstract void validate();

    /**
     * 提交处理
     */
    protected abstract String doSubmit();

}
