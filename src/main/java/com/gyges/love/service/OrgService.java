package com.gyges.love.service;

import com.gyges.love.dao.OrgRepository;
import com.gyges.love.model.common.Response;
import com.gyges.love.model.common.Status;
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

    public Organization saveOrgInfo(int id, String orgName, String account) {
        String time = dateFormat.format(new Date());
        Organization organization = new Organization();
        organization.setAccount(account);
        organization.setId(id);
        organization.setOrgName(orgName);
        organization.setCreateTime(time);
        return organization;
    }

    public Organization deleteOrgAccount(Integer id){
        Organization organization = new Organization();
        organization.setId(id);
        crudDao.delete(id);
        return organization;
    }

    public Organization findOrgName(String account, String orgName, String createTime){
        Organization organization = new Organization();
        Response<Status> response = new Response<>();
        Status status = null;
        status = Status.SUCCESS;
        response.setData(status);
        organization.setAccount(account);
        organization.setOrgName(orgName);
        organization.setCreateTime(createTime);
        crudDao.findAll(organization);
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
