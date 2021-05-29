package org.cloudland.study.jpa.db.persistence;

import org.cloudland.study.jpa.db.entity.AEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;

@Repository("Study.DB.JPA.APersistence")
public interface APersistence extends Persistence<AEntity, String> {
}
