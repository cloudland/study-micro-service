package org.cloudland.study.nacos;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
//@EnableNacosConfig
@NacosPropertySource(dataId = "study-configuration.yaml", autoRefreshed = true)
@SpringBootApplication
public class StudyNacosServerApplication {

    @NacosValue(value = "${name}", autoRefreshed = true)
    private static String name;

    /**
     * 主启动程序
     */
    public static void main(String[] args) {
        System.out.println(name);

        SpringApplication.run(StudyNacosServerApplication.class, args);
    }

}
