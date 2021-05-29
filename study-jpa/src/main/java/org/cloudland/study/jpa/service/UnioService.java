package org.cloudland.study.jpa.service;

import org.cloudland.study.jpa.store.model.AModel;
import org.cloudland.study.jpa.store.model.BModel;
import org.cloudland.study.jpa.store.store.AStore;
import org.cloudland.study.jpa.store.store.BStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;


@Service("Service.UnioService")
public class UnioService {

    @Resource(name = "Study.Domain.Business.AStore")
    private AStore aStore;

    @Resource(name = "Study.Domain.Business.BStore")
    private BStore bStore;

    public void testException(Integer number) {
        AModel newAModel = new AModel(null, "文本", 21, new BigDecimal(99.99), null, null, null, 1);
        aStore.create(newAModel);

        if (0 == number) {
            throw new RuntimeException("");
        }

        BModel newBModel = new BModel(null, "文本", 21, new BigDecimal(99.99), null, null, null, 1);
        bStore.create(newBModel);
    }

}
