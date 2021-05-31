/**
 * FileName: UnionTransactional.java
 * Author: Lei
 * Company: Cloudland Studio
 * Createdate: 2020-12-20 13:56
 * <p>
 * All rights Reserved, Designed By cloudland Copyright(C) 2010-2020
 */
package org.cloudland.seata.tm.server.service;

import org.springframework.stereotype.Service;

/**
 * <pre>
 * 联合事务管理接口
 *
 * 实现类可在实现内里控制事务
 * </pre>
 *
 * @author Lei
 * @version v1.0
 * @ClassName UnionTransactional
 * @see
 */
@Service("Web.Frame.Transactional.UnionTransactional")
public class UnionTransactional extends AbstractParentService {

    /**
     * 执行联合内容
     *
     * @param unoin 联合内容
     */
    public Object doTransactional(Union unoin) {
        try {
            return unoin.exec();
        } catch (Exception e) {
            getLogger().error("[框架][事务]联合事务执行异常, 回滚事务", e);
            throw new RuntimeException("");
        }
    }
}
