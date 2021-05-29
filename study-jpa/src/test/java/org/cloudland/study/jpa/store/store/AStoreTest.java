package org.cloudland.study.jpa.store.store;

import org.cloudland.study.jpa.JUnitParentTest;
import org.cloudland.study.jpa.store.PageResult;
import org.cloudland.study.jpa.store.model.AModel;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AStoreTest extends JUnitParentTest {

    @Resource(name = "Study.Domain.Business.AStore")
    private AStore store;

    @Test
    @Transactional
    @Rollback(false)
    void create() {
        AModel newModel = new AModel("主键6", "文本", 21, new BigDecimal(99.99), null, null, null, 1);
        store.create(newModel);
    }

    @Test
    @Transactional
    @Rollback(false)
    void update() {
        AModel dbModel = store.find("主键6");

        dbModel.setText("更新的文本");
        dbModel.setNumber(20);
        dbModel.setDecimal(new BigDecimal(99.90));

        store.create(dbModel);
    }

    @Test
    @Transactional
    @Rollback(false)
    void remove() {
        AModel dbModel = store.find("主键6");
        store.remove(dbModel);
    }

    @Test
    void testFindPage() {
        PageResult<AModel> resultPage = store.findPage("9", 1, 9);

        resultPage.list().stream().forEach(model -> {
            getLogger().info("标识: {}, 文本: {}, 数值: {}, 浮点: {}, 创建: {}, 更新: {}, 失效: {}, 版本: {}", model.getId(), model.getText(), model.getNumber(), model.getDecimal(), model.getCreatedTime(), model.getUpdatedTime(), model.getLoseTime(), model.getVersion());
        });

    }

}