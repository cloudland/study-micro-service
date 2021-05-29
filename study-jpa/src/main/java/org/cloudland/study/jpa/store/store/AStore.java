package org.cloudland.study.jpa.store.store;


import org.apache.commons.lang.StringUtils;
import org.cloudland.study.jpa.db.entity.AEntity;
import org.cloudland.study.jpa.db.persistence.APersistence;
import org.cloudland.study.jpa.db.term.*;
import org.cloudland.study.jpa.store.PageResult;
import org.cloudland.study.jpa.store.model.AModel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.List;

@Repository("Study.Domain.Business.AStore")
public class AStore extends AbstractParentStore<AEntity, AModel> {

    @Resource(name = "Study.DB.JPA.APersistence")
    private APersistence persistence;

    @Override
    protected APersistence getPersistence() {
        return persistence;
    }

    @Override
    protected AEntity transform(AModel model) {
        if (StringUtils.isBlank(model.getId())) {
            model.setId(getPrimaryKey());
        }

        AEntity entity = new AEntity(model.getId(), model.getText(), model.getNumber(), model.getDecimal());
        entity.setSeqNo(model.getVersion());
        return entity;
    }

    @Override
    protected AModel untransform(AEntity entity) {
        return new AModel(entity.getIndetifierNo(), entity.getText(), entity.getNumber(), entity.getDecimal(), entity.getCreatedTime(), entity.getUpdatedTime(), entity.getEndTime(), entity.getSeqNo());
    }

    public AModel find(String id) {
        TermCollect term = buildTerm();
        term.field(BTerm.INDETIFIER_NO).equal(id);

        List<AModel> modelArray = findByTerm(term);
        if (null == modelArray || modelArray.isEmpty()) {
            return null;
        }

        return modelArray.get(0);
    }

    /**
     * <pre>
     * 分页查询地址信息
     * </pre>
     *
     * @param number
     * @param beginRow
     * @param endRow
     * @return
     */
    public PageResult<AModel> findPage(String number, Integer beginRow, Integer endRow) {
        TermCollect term = buildTerm();
        term.field(ATerm.NUMBER).equal(number);
        term.limit(beginRow, endRow);

        return findPageByTerm(term);
    }

}
