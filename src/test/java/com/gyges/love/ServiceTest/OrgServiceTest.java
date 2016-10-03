package com.gyges.love.ServiceTest;

import com.google.gson.Gson;
import com.gyges.love.model.po.Organization;
import com.gyges.love.service.OrgService;
import org.junit.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Created by gygesM on 2016/10/3.
 */
@SpringBootTest
@SpringBootConfiguration
public class OrgServiceTest {
    @Resource
    OrgService orgService;
    @Test
    public void getResult(){
        int id = 1;
        String account = "tianxingshuke";
        String company = "tianxing";
        Organization organization = orgService.saveOrgInfo(id,company,account);
        organization.getAccount();
        organization.getCreateTime();
        organization.getOrgName();
        System.out.println("插入的数据为："+new Gson().toJson(organization));
    }
}
