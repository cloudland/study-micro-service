package org.cloudland.seata.tm.server.service.tm;

import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.cloudland.seata.tm.server.service.AbstractParentService;
import org.cloudland.study.seata.a.master.information.InformationRepository;
import org.cloudland.study.seata.b.master.record.RecordService;
import org.cloudland.study.seata.b.master.task.TaskRepository;
import org.springframework.stereotype.Service;

@Service("Web.Service.TMService")
public class TMService extends AbstractParentService {

    @DubboReference(group = "A.Master", version = "1.0.0")
    private InformationRepository informationRepository;

    @DubboReference(group = "B.Master", version = "1.0.0")
    private RecordService service;

    @DubboReference(group = "D.Master", version = "1.0.0")
    private TaskRepository taskRepository;

//    @GlobalTransactional
    public void exec() {
        getLogger().info("TM 执行 exec");

        String id = "参数ID";

        getLogger().info("RM 执行 InformationRepository 开始");
        informationRepository.find(id);
        getLogger().info("RM 执行 InformationRepository 结束");

        getLogger().info("RM 执行 RecordService 开始");
        service.handler(id);
        getLogger().info("RM 执行 RecordService 结束");

        getLogger().info("RM 执行 TaskRepository 开始");
        taskRepository.remove(id);
        getLogger().info("RM 执行 TaskRepository 结束");
    }

}
