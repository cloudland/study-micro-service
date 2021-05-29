package org.cloudland.study.jpa.db.persistence;

import org.cloudland.study.jpa.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserPersistence extends JpaRepository<UserEntity, String>, JpaSpecificationExecutor<UserEntity> {
}
