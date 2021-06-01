package org.cloudland.study.nacos.server.control;

import org.cloudland.study.nacos.server.service.StudyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/study/nacos/")
public class StudyControl {

    @Resource(name = "Web.StudyService")
    private StudyService service;

    @GetMapping(value = "cfg")
    public String doSave(HttpServletRequest request, HttpServletResponse response) {
        return service.readConfig();
    }

}
