package org.cloudland.study.jpa.db.persistence;

import org.cloudland.study.jpa.JUnitParentTest;
import org.cloudland.study.jpa.db.entity.AEntity;
import org.cloudland.study.jpa.db.entity.UserEntity;
import org.cloudland.study.jpa.db.term.ATerm;
import org.cloudland.study.jpa.db.term.TermCollect;
import org.cloudland.study.jpa.db.term.TermCollectManager;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public class APersistenceTest extends JUnitParentTest {

    @Resource(name = "Study.DB.JPA.APersistence")
    private APersistence persistence;

    @Test
    @Transactional
    @Rollback(false)
    public void testSave() {
        AEntity entity = new AEntity("主鍵", "文本2", 12, new BigDecimal(13.22));
        AEntity save = persistence.save(entity);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testUpdate() {
        AEntity entity = persistence.findOne((_root, _query, _builder) -> {
            // _root: 比较的属性, builder: 查询条件
            // 获取待比较属性
            Path<Object> queryFiled = _root.get("indetifierNo");

            // 构建查询条件
            Predicate condId = _builder.equal(queryFiled, "主鍵");

            return condId;
        }).orElse(null);

        entity.setText("文本A");
        entity.setNumber(11);
        entity.setDecimal(new BigDecimal(12.23));

        persistence.save(entity);
    }

    @Test
    public void testRemove() {
        AEntity entity = persistence.findOne((_root, _query, _builder) -> {
            // _root: 比较的属性, builder: 查询条件
            // 获取待比较属性
            Path<Object> queryFiled = _root.get("indetifierNo");

            // 构建查询条件
            Predicate condId = _builder.equal(queryFiled, "主鍵");

            return condId;
        }).orElse(null);

        persistence.delete(entity);
    }

    @Test
    public void testFind() {
        List<AEntity> entity = persistence.findAll((_root, _query, _builder) -> {
            // _root: 比较的属性, builder: 查询条件
            // 获取待比较属性
            Path<Object> queryFiled = _root.get("number");

            // 构建查询条件
            Predicate condId = _builder.equal(queryFiled, 11);

            return condId;
        });

//        getLogger().debug("主键: {}, 文本: {}, 数字: {}, 浮点: {}", entity.getIndetifierNo(), entity.getText(), entity.getNumber(), entity.getDecimal());
    }

    @Test
    public void testFindPage() {
        Sort sort = Sort.by(Sort.Direction.DESC, "indetifierNo");

        Page<AEntity> resultPage = persistence.findAll((_root, _query, _builder) -> {
            // _root: 比较的属性, builder: 查询条件
            // 获取待比较属性
            Path<Comparable> queryFiled = _root.get("number");

            // 构建查询条件
            Predicate condId = _builder.equal(queryFiled, "11");

//            SimpleExpression number = Restrictions.le("number", 11);

//            Predicate condId = _builder.lessThan(queryFiled, (Comparable)11);

//            Predicate condId = _builder.between(queryFiled, (Comparable)10, (Comparable)12);

            return condId;
        }, PageRequest.of(0, 3, sort));

//        TermCollect termCollect = TermCollectManager.collect();
        // 等于
//        termCollect.field("number").equal(11);
        // 不等于
//        termCollect.field("number").notEqual(11);
        // 大于
//        termCollect.field("number").greaterThan(11);

//        Date begin = Date.from(LocalDateTime.of(2021, 5, 28, 0, 0,0).atZone(ZoneId.systemDefault()).toInstant());
//        termCollect.field(ATerm.CREATED_TIME).greaterThan(begin);

        // 大于等于
//        termCollect.field("number").greaterThanOrEqualTo(11);
        // 小于
//        termCollect.field("number").lessThan(11);
        // 小于等于
//        termCollect.field("number").lessThanOrEqualTo(11);
        // 区间
//        termCollect.field("number").between(10, 12);

//        Date begin = Date.from(LocalDateTime.of(2021, 5, 20, 0, 0,0).atZone(ZoneId.systemDefault()).toInstant());
//        Date end = Date.from(LocalDateTime.of(2021, 5, 30, 0, 0,0).atZone(ZoneId.systemDefault()).toInstant());
//        termCollect.field(ATerm.CREATED_TIME).between(begin, end);

        // 包含
//        termCollect.field("number").in(10, 12);

//        Page<AEntity> resultPage = persistence.findAll(termCollect.compile(), PageRequest.of(0, 3, sort));
//        List<AEntity> resultArray = persistence.findAll(termCollect.compile());

        getLogger().debug("size: {}, number: {}, page: {}, elem: {}", resultPage.getSize(), resultPage.getNumber(), resultPage.getTotalPages(), resultPage.getTotalElements());
        resultPage.get().forEach(entity -> {
            getLogger().debug("主键: {}, 文本: {}, 数字: {}, 浮点: {}", entity.getIndetifierNo(), entity.getText(), entity.getNumber(), entity.getDecimal());
        });

    }

}