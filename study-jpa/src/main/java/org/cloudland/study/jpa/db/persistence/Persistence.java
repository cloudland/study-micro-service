package org.cloudland.study.jpa.db.persistence;

import org.cloudland.study.jpa.db.entity.AEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface Persistence<L, ID> extends CrudRepository<L, ID>, JpaSpecificationExecutor<L> {
}
