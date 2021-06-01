package org.cloudland.study.nacos.core;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.Getter;
import org.springframework.context.annotation.Configuration;

//@Configuration("StudyConfiguration")
//@NacosPropertySource(dataId = "study-configuration.yaml", groupId = "DEFAULT_GROUP", autoRefreshed = true)
//@NacosConfigurationProperties(dataId = "study-configuration.yaml", autoRefreshed = true)
@Getter
public class StudyConfiguration {

//    @NacosValue(value = "${name}", autoRefreshed = true)
    private String name;

}
