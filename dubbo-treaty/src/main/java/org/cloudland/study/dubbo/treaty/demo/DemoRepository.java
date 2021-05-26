package org.cloudland.study.dubbo.treaty.demo;

import org.cloudland.study.dubbo.treaty.demo.dto.Demo;

import java.util.List;

public interface DemoRepository {

    Demo newInstact();

    List<Demo> findPage(Integer pageNo, Integer pageSize);

}
