package com.gyges.love.model.po;

import javax.persistence.Column;;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by gygesM on 2016/10/2.
 */
@Entity(name = "organization")
public class Organization{
    /**
     * 机构id
     */
    @Id
    @GeneratedValue
    private int id;
    /**
     * 机构账号
     */
    @Column(nullable = false)
    private String account;
    /**
     * 公司名称
     */
    @Column(nullable = false,name = "company")
    private String orgName;

    public Organization() {
    }

    public Organization(String account, String orgName, String createTime) {
        this.account = account;
        this.orgName = orgName;
        this.createTime = createTime;
    }

    public Organization(int id,String account, String orgName) {
        this.account = account;
        this.orgName = orgName;
    }

    public Organization(int id, String account, String orgName, String createTime) {
        this.id = id;
        this.account = account;
        this.orgName = orgName;
        this.createTime = createTime;
    }

    /**
     * 创建时间
     */

    private String createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", orgName='" + orgName + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
