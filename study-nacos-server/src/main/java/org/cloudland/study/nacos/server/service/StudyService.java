package org.cloudland.study.nacos.server.service;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.cloudland.study.nacos.core.StudyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Web.StudyService")
//@NacosPropertySource(dataId = "study-configuration.yaml", autoRefreshed = true)
public class StudyService {

//    @Autowired
    private StudyConfiguration cfg;

    @NacosValue(value = "${name}", autoRefreshed = true)
    private String name;

    public String readConfig(){
//        return cfg.getName();
        return name;
    }

}
