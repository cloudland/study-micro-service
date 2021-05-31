package org.cloudland.study.seata.a.master.information.support;

import org.apache.dubbo.config.annotation.DubboService;
import org.cloudland.study.seata.a.master.AbstractParentSupport;
import org.cloudland.study.seata.a.master.information.InformationRepository;
import org.cloudland.study.seata.a.master.information.bean.Information;

@DubboService(group = "A.Master", version = "1.0.0", timeout = 2000)
public class InformationSupport extends AbstractParentSupport implements InformationRepository {

    @Override
    public Information find(String id) {
        getLogger().info("RM A id: {}", id);

        return null;
    }

}
