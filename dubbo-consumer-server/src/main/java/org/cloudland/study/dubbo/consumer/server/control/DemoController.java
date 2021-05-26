package org.cloudland.study.dubbo.consumer.server.control;

import org.apache.dubbo.config.annotation.DubboReference;
import org.cloudland.study.dubbo.treaty.demo.DemoRepository;
import org.cloudland.study.dubbo.treaty.demo.dto.Demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @DubboReference(group = "Demo", version = "1.0.0")
    private DemoRepository service;

    @GetMapping(value = "/hello")
    public void sayHello() {
        Demo demo = service.newInstact();
        System.out.println(demo.getId() + demo.getAge());
    }

}
