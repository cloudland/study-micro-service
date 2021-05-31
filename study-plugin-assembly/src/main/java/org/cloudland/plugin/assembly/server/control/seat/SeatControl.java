package org.cloudland.plugin.assembly.server.control.seat;

import org.cloudland.plugin.assembly.core.JsonResult;
import org.cloudland.plugin.assembly.server.control.AbstractParentControl;
import org.cloudland.plugin.assembly.server.service.seat.SeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/seat/")
public class SeatControl extends AbstractParentControl {

    @Resource(name = "Web.SeatService")
    private SeatService service;

    @GetMapping(value = "hello")
    public JsonResult<String> hello(HttpServletRequest request, HttpServletResponse response) {
        getLogger().info("Control 进来咯");

        service.doTest();
        return doSuccess(null);
    }

}
