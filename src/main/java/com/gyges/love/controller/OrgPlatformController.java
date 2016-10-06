package com.gyges.love.controller;

import com.gyges.love.model.common.Response;
import com.gyges.love.model.po.Organization;
import com.gyges.love.service.OrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ResponseBody
    public Response getQueryResult(@RequestParam(required = false) String account,
                                   @RequestParam(required = false) String company,
                                   @RequestParam(required = false) String createTime) {
        Response response = new Response();
        try {
            Organization organization = orgService.findOrgName(account, company, createTime);
            response.setCode(1);
            response.setData(organization);
        }catch (Exception ex){
            ex.printStackTrace();
            LOGGER.error("查询失败",ex);
        }
        return response;
    }

    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    public Response<Organization> getSaveResult(Integer id, String account, String company) {
        Response response = new Response();
        try {
            Organization organization = orgService.saveOrgInfo(id, account, company);
            response.setCode(1);
            response.setData(organization);
        }catch (Exception ex){
            ex.printStackTrace();
            LOGGER.error("插入失败");
        }

        return response;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
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

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public Response getSaveResult(Integer id, String account) {
        Response response = new Response();
        try {
            Organization organization = orgService.updateOrgAccount(id, account);
            response.setCode(1);
            response.setData(organization);
        }catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error("更新失败", ex);
        }
        return response;
    }
}
