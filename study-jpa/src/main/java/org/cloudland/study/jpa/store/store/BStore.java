package org.cloudland.study.jpa.store.store;

import org.apache.commons.lang.StringUtils;
import org.cloudland.study.jpa.db.entity.AEntity;
import org.cloudland.study.jpa.db.entity.BEntity;
import org.cloudland.study.jpa.db.persistence.BPersistence;
import org.cloudland.study.jpa.db.persistence.Persistence;
import org.cloudland.study.jpa.store.model.AModel;
import org.cloudland.study.jpa.store.model.BModel;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Repository("Study.Domain.Business.BStore")
public class BStore extends AbstractParentStore<BEntity, BModel> {

    @Resource(name = "Study.DB.JPA.BPersistence")
    private BPersistence persistence;

    @Override
    protected BPersistence getPersistence() {
        return persistence;
    }

    @Override
    protected BEntity transform(BModel model) {
        if (StringUtils.isBlank(model.getId())) {
            model.setId(getPrimaryKey());
        }

        BEntity entity = new BEntity(model.getId(), model.getText(), model.getNumber(), model.getDecimal());
        entity.setSeqNo(model.getVersion());
        return entity;
    }

    @Override
    protected BModel untransform(BEntity entity) {
        return new BModel(entity.getIndetifierNo(), entity.getText(), entity.getNumber(), entity.getDecimal(), entity.getCreatedTime(), entity.getUpdatedTime(), entity.getEndTime(), entity.getSeqNo());
    }

    public List<BModel> findSQL(Integer number) {

        List<BEntity> dbCustomArray = getPersistence().findSQL(number);

        return dbCustomArray.stream().map(entity -> untransform(entity)).collect(Collectors.toList());
    }

//    public List<BModel> findJPQL(Integer number) {
//
//        List<BEntity> dbCustomArray = getPersistence().findJPQL(number);
//
//        return dbCustomArray.stream().map(entity -> untransform(entity)).collect(Collectors.toList());
//    }

}
