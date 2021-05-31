package org.cloudland.study.seata.a.master.information;

import org.cloudland.study.seata.a.master.information.bean.Information;

public interface InformationRepository {

    /**
     * 查询信息
     *
     * @param id 信息编号
     * @return
     */
    Information find(String id);

}
