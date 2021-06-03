package org.cloudland.study.nacos.server.service;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("Web.StudyService")
//@RefreshScope // 支撑 nacos 动态刷新
@NacosPropertySource(dataId = "study-configuration.yaml", autoRefreshed = true)
@Slf4j
public class StudyService {

//    @Resource
//    private StudyConfiguration cfg;

    @NacosValue(value = "${name}", autoRefreshed = true)
    private String name;

    public String readConfig(){
        log.info("读取配置");

//        return cfg.getName();
        return name;
    }

}
