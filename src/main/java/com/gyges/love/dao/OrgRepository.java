package com.gyges.love.dao;

import com.gyges.love.model.po.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by gygesM on 2016/10/2.
 */
@Transactional
public interface OrgRepository extends JpaRepository<Organization,Integer>,JpaSpecificationExecutor<Organization> {

    <S extends Organization> List<S> save(Iterable<S> entities);

    List<Organization> findByAccountAndOrgNameAndCreateTime(String account,String company,String createTime);

    void delete(Organization id);

    @SuppressWarnings("JpaQlInspection")
    @Modifying
    @Query(value = "update Organization org set org.account =?1 where org.id=?2")
    int setName(String account,Integer id);//其中返回值int表示更新语句影响的行数。
}
