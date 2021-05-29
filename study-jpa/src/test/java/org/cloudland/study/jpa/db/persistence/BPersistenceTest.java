package org.cloudland.study.jpa.db.persistence;

import org.cloudland.study.jpa.JUnitParentTest;
import org.cloudland.study.jpa.db.entity.BEntity;
import org.cloudland.study.jpa.db.term.BTerm;
import org.cloudland.study.jpa.db.term.TermCollect;
import org.cloudland.study.jpa.db.term.TermCollectManager;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.math.BigDecimal;

public class BPersistenceTest extends JUnitParentTest {

    @Resource(name = "Study.DB.JPA.BPersistence")
    private BPersistence persistence;

    @Test
    @Transactional
    @Rollback(false)
    public void testSave() {
        BEntity entity = new BEntity("主鍵B", "文本B", 20, new BigDecimal(12.22));
        persistence.save(entity);
    }

    @Test
    public void testFind() {
        TermCollect collect = TermCollectManager.collect();
        collect.field(BTerm.INDETIFIER_NO).equal("主键");
        collect.field(BTerm.NUMBER).equal(12);
        collect.compile();
    }

}