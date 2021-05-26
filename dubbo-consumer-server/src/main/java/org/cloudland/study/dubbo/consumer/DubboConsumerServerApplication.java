package org.cloudland.study.dubbo.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DubboConsumerServerApplication {

    /**
     * 主启动程序
     */
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerServerApplication.class, args);
    }

}
