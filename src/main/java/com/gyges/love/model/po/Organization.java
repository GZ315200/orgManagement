package com.gyges.love.model.po;



import javax.persistence.*;

/**
 * Created by gygesM on 2016/10/2.
 */
@Entity
@Table(name = "organization")
public class Organization{
    /**
     * 机构id
     */
    @Id
    private String id;
    /**
     * 机构账号
     */
    @Column(nullable = false)
    private String account;
    /**
     * 公司名称
     */
    @Column(nullable = false,name = "company")
    private String company;

    private String createTime;

    public Organization() {
    }

    public Organization(String id, String account, String company, String createTime) {
        this.id = id;
        this.account = account;
        this.company = company;
        this.createTime = createTime;
    }

    public Organization(String account, String createTime) {
        this.account = account;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建时间
     */



}
