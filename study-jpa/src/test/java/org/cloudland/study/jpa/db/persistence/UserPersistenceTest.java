package org.cloudland.study.jpa.db.persistence;

import org.cloudland.study.jpa.JUnitParentTest;
import org.cloudland.study.jpa.db.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;


public class UserPersistenceTest extends JUnitParentTest {

    @Resource
    private UserPersistence userPersistence;

    @Test
    @Transactional
    @Rollback(false)
    public void testSave() {
        UserEntity entity = new UserEntity("2", "我是名字", 22, new Date());
        userPersistence.save(entity);
    }
}