package org.cloudland.seata.tm.server.control.tm;

import org.cloudland.seata.tm.core.JsonResult;
import org.cloudland.seata.tm.server.control.AbstractParentControl;
import org.cloudland.seata.tm.server.service.tm.TMService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/seata/tm/")
public class TMControl extends AbstractParentControl {

    @Resource(name = "Web.Service.TMService")
    private TMService service;

    @PostMapping(value = "commit")
    public JsonResult<String> doSave(HttpServletRequest request, HttpServletResponse response) {
        service.exec();
        return doSuccess(null);
    }

}
