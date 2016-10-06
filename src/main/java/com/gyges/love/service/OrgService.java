package com.gyges.love.service;

import com.gyges.love.dao.OrgRepository;
import com.gyges.love.model.po.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gygesM on 2016/10/2.
 */
@Service
public class OrgService {

    @Resource
    private OrgRepository crudDao;

    public static final Logger LOGGER = LoggerFactory.getLogger(OrgService.class);
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Organization saveOrgInfo(int id, String company, String account) {
        String time = dateFormat.format(new Date());
        Organization organization = new Organization(id,account,company,time);
        organization.setAccount(account);
        organization.setId(id);
        organization.setOrgName(company);
        organization.setCreateTime(time);
        crudDao.save(organization);
        return organization;
    }

    public Organization deleteOrgAccount(Integer id){
        Organization organization = new Organization();
        organization.setId(id);
        crudDao.delete(id);
        return organization;
    }

    public Organization findOrgName(String account, String company, String createTime){
        Organization organization = new Organization();
        organization.setAccount(account);
        organization.setOrgName(company);
        organization.setCreateTime(createTime);
        crudDao.findByAccountAndOrgNameAndCreateTime(account,company,createTime);
        return organization;
    }
    public Organization updateOrgAccount(Integer id, String account){
        Organization organization = new Organization();
        organization.setId(id);
        organization.setAccount(account);
        crudDao.setName(organization.getAccount(),organization.getId());
        return organization;
    }

}
