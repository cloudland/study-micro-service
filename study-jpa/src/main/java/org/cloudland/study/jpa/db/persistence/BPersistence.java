package org.cloudland.study.jpa.db.persistence;

import org.cloudland.study.jpa.db.entity.BEntity;
import org.cloudland.study.jpa.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("Study.DB.JPA.BPersistence")
public interface BPersistence extends Persistence<BEntity, String> {

    /**
     * 自定 JPQL 查询语句
     *
     * @param number
     * @return
     */
//    @Query(value = "from BEntity where number = :number")
//    List<BEntity> findJPQL(@Param("number") Integer number);

    /**
     * 自定 SQL 查询语句
     *
     * @param number
     * @return
     */
    @Query(value = "SELECT * FROM T_B WHERE B_NUMBER = ?", nativeQuery = true)
    List<BEntity> findSQL(Integer number);

}
