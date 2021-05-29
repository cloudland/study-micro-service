package org.cloudland.study.jpa.store.store;

import org.cloudland.study.jpa.JUnitParentTest;
import org.cloudland.study.jpa.store.model.AModel;
import org.cloudland.study.jpa.store.model.BModel;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BStoreTest extends JUnitParentTest {

    @Resource(name = "Study.Domain.Business.BStore")
    private BStore store;

    @Test
    void create() {
        BModel newModel = new BModel(null, "文本", 21, new BigDecimal(99.99), null, null, null, 1);
        store.create(newModel);
    }

    @Test
    void update() {
    }

    @Test
    void remove() {
    }

    @Test
    void findCustom() {
        List<BModel> modelArray = store.findSQL(21);
        modelArray.stream().forEach(model -> {
            getLogger().info("标识: {}, 文本: {}, 数值: {}, 浮点: {}, 创建: {}, 更新: {}, 失效: {}, 版本: {}", model.getId(), model.getText(), model.getNumber(), model.getDecimal(), model.getCreatedTime(), model.getUpdatedTime(), model.getLoseTime(), model.getVersion());
        });
    }
}