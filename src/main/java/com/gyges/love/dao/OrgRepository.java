package com.gyges.love.dao;

import com.gyges.love.model.po.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by gygesM on 2016/10/2.
 */
@Repository
public interface OrgRepository extends JpaRepository<Organization,Integer> {

    <S extends Organization> S save(S var1);

    List<Organization> findAll(Organization organization);

    void delete(Organization id);

    @SuppressWarnings("JpaQlInspection")
    @Modifying
    @Transactional
    @Query(value = "update Organization org set org.account =?1 where org.id=?2")
    int setName(String account,Integer id);//其中返回值int表示更新语句影响的行数。
}
