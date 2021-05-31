package org.cloudland.study.seata.b.master.task.support;

import org.apache.dubbo.config.annotation.DubboService;
import org.cloudland.study.seata.b.master.AbstractParentSupport;
import org.cloudland.study.seata.b.master.task.TaskRepository;

@DubboService(group = "D.Master", version = "1.0.0", timeout = 2000)
public class TaskSupport extends AbstractParentSupport implements TaskRepository {

    @Override
    public void remove(String id) {
        getLogger().info("RM D id: {}", id);
    }

}
