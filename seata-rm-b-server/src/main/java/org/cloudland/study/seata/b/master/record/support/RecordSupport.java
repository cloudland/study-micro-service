package org.cloudland.study.seata.b.master.record.support;

import org.apache.dubbo.config.annotation.DubboService;
import org.cloudland.study.seata.b.master.AbstractParentSupport;
import org.cloudland.study.seata.b.master.record.RecordService;
import org.cloudland.study.seata.b.master.record.bean.State;

@DubboService(group = "B.Master", version = "1.0.0", timeout = 2000)
public class RecordSupport extends AbstractParentSupport implements RecordService {

    @Override
    public State handler(String id) {
        getLogger().info("RM B id: {}", id);

        return null;
    }

}
