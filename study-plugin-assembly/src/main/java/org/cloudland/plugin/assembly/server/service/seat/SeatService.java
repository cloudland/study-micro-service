package org.cloudland.plugin.assembly.server.service.seat;

import org.cloudland.plugin.assembly.server.service.AbstractParentService;
import org.springframework.stereotype.Service;

@Service("Web.SeatService")
public class SeatService extends AbstractParentService {

    public void doTest() {
        getLogger().info("进来服务咯");
    }

}
