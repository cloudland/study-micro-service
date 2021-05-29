package org.cloudland.study.jpa.service;

import org.cloudland.study.jpa.JUnitParentTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

class UnioServiceTest extends JUnitParentTest {

    @Resource
    private UnioService service;

    @Test
    @Transactional
    @Rollback(false)
    void testException() {
        service.testException(1);
    }
}