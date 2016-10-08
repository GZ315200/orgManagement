package com.gyges.love.dao;

import com.gyges.love.model.po.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by gygesM on 2016/10/2.
 */
@Transactional
@SuppressWarnings("JpaQlInspection")
public interface OrgRepository extends JpaRepository<Organization, String>, JpaSpecificationExecutor<Organization> {


    Organization findByAccount(String account);

    Organization findByCompanyAndCreateTime(String account, String createTime);

    @Query(value = "from Organization o where o.account=:account")
    Organization findOrg(@Param("account") String account);

    void delete(String id);

    @Modifying
    @Query(value = "update Organization org set org.account =?1 where org.id=?2")
    int setName(String account, String id);//其中返回值int表示更新语句影响的行数。
}
