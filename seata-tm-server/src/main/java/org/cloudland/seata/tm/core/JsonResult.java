/**
 * fileName:  JsonResult.java
 * author:  Lei
 * Company:  Cloudland Studio
 * Createdate:  2015-8-5 下午8:17:02
 * <p>
 * All rights Reserved, Designed By cloudland Copyright(C) 2010-2011
 * <p>
 * Modification  History:
 * Date           Author        Version
 * -------------------------------------------
 * 2015-8-5            Lei           1.0
 * <p>
 * Why & What is modified:
 * 1.0: 文件创建
 */
package org.cloudland.seata.tm.core;

/**
 * <pre>
 * 结果对象类
 * </pre>
 *
 * @author Lei
 * @version %I%, %G%
 * @ClassName JsonResult
 * @see
 * @since JDK1.6
 */
public class JsonResult<L> {

    /**
     * code 错误码
     */
    private String code;

    /**
     * msg 消息, 只有当返回码为0, 此参数才会有值
     */
    private String msg;

    /**
     * obj 序列化对象
     */
    private L result;

    /**
     * <pre>
     * TODO 请充分描述该构造函数的作用，及其参数的作用。
     * </pre>
     */
    public JsonResult() {
        // TODO Auto-generated constructor stub
    }

    /**
     * <pre>
     * 构造函数
     * </pre>
     *
     * @param result
     */
    public JsonResult(L result) {
        this.result = result;
    }

    /**
     * <pre>
     * 构造函数
     * </pre>
     *
     * @param code
     * @param msg
     */
    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * <pre>
     * 请求结果
     * </pre>
     *
     * @return
     */
    public Integer getSuccess() {
        return null == code || code.length() <= 0 ? 1 : 0;
    }

    /**
     * <pre>
     * 获取响应码
     * </pre>
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * <pre>
     * 获取提示消息
     * </pre>
     *
     * @return
     */
    public String getMsg() {
        return msg;
    }

    /**
     * <pre>
     * 获取数据结果
     * </pre>
     *
     * @return
     */
    public L getResult() {
        return result;
    }

}
