package com.gyges.love.controller;

import com.gyges.love.model.common.Response;
import com.gyges.love.model.po.Organization;
import com.gyges.love.service.OrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * Created by gygesM on 2016/10/3.
 */
@Controller
@RequestMapping(value = "/")
public class OrgPlatformController {

   @Resource
   OrgService orgService;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrgPlatformController.class);

    @RequestMapping(value = "/select")
    @ResponseBody
    public Response getQueryResult(String account, String orgName, String createTime) {
        Response response = new Response();
        Organization organization = orgService.findOrgName(account, orgName, createTime);
        response.setCode(1);
        response.setData(organization);
        return response;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public Response<Organization> getSaveResult(Integer id, String account, String orgName) {
        Response response = new Response();
        Organization organization = orgService.saveOrgInfo(id, account, orgName);
        response.setCode(1);
        response.setData(organization);
        return response;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Response getDeleteResult(Integer id) {
        Response response = new Response();
        try {
            Organization organization = orgService.deleteOrgAccount(id);
            response.setCode(1);
            response.setData(organization);
        }catch (Exception e){
            LOGGER.error("删除失败");
        }

        return response;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Response getSaveResult(Integer id, String account) {
        Response response = new Response();
        Organization organization = orgService.updateOrgAccount(id, account);
        response.setCode(1);
        response.setData(organization);
        return response;
    }
}
