package org.cloudland.study.nacos;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableDiscoveryClient
//@EnableNacosConfig
@NacosPropertySource(dataId = "study-nacos-server", autoRefreshed = true)
@SpringBootApplication
public class StudyNacosServerApplication {

    /**
     * 主启动程序
     */
    public static void main(String[] args) {
        SpringApplication.run(StudyNacosServerApplication.class, args);
    }

}
