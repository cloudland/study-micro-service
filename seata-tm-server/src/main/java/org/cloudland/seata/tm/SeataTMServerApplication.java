package org.cloudland.seata.tm;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class SeataTMServerApplication {

    /**
     * 主启动程序
     */
    public static void main(String[] args) {
        SpringApplication.run(SeataTMServerApplication.class, args);
    }

}
