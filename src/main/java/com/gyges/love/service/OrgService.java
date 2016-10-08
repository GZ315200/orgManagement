package com.gyges.love.service;

import com.gyges.love.dao.OrgRepository;
import com.gyges.love.model.po.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by gygesM on 2016/10/2.
 */
@Service
public class OrgService {

    @Resource
    private OrgRepository crudDao;

    public static final Logger LOGGER = LoggerFactory.getLogger(OrgService.class);
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Organization saveOrgInfo(String account,String company) {
        String time = dateFormat.format(new Date());
        String id = UUID.randomUUID().toString().replace("-","");
        Organization organization = new Organization(id,account, company, time);
        organization.setId(id);
        organization.setAccount(account);
        organization.setCompany(company);
        organization.setCreateTime(time);
        crudDao.save(organization);
        return organization;
    }

    public Organization deleteOrgAccount(String id) {
        Organization organization = new Organization();
        organization.setId(id);
        crudDao.delete(id);
        return organization;
    }

    public Organization findOrgName(String account,String company,String createTime) {
        Organization organization = new Organization();
        organization.setAccount(account);
        organization.setCompany(company);
        organization.setCreateTime(createTime);
        crudDao.findOrg(account);
        return organization;
    }
    public Organization findOrgNameAndCompany(String account,String createTime){
        Organization organization = new Organization(account,createTime);
        organization.setAccount(account);
        organization.setCreateTime(createTime);
        crudDao.findByCompanyAndCreateTime(account,createTime);
        return organization;
    }

    public Organization updateOrgAccount(String id, String account) {
        Organization organization = new Organization();
        organization.setId(id);
        organization.setAccount(account);
        crudDao.setName(organization.getAccount(), organization.getId());
        return organization;
    }

}
