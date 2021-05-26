package org.cloudland.study.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DubboProviderServerApplication {

    /**
     * 主启动程序
     */
    public static void main(String[] args) {
        SpringApplication.run(DubboProviderServerApplication.class, args);
    }

}
