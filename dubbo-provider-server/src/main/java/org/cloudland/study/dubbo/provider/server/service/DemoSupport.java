package org.cloudland.study.dubbo.provider.server.service;


import org.apache.dubbo.config.annotation.DubboService;
import org.cloudland.study.dubbo.treaty.demo.DemoRepository;
import org.cloudland.study.dubbo.treaty.demo.dto.Demo;

import java.util.Collections;
import java.util.List;


@DubboService(group = "Demo", version = "1.0.0", timeout = 2000)
public class DemoSupport implements DemoRepository {

    @Override
    public Demo newInstact() {
        System.out.println("请求进来了");
        return new Demo("这里是中文", 10, Collections.emptyList());
    }

    @Override
    public List<Demo> findPage(Integer pageNo, Integer pageSize) {
        return null;
    }
}
