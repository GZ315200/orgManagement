package com.gyges.love.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by gygesM on 2016/10/2.
 */
@Entity(name = "organization")
@Table
public class Organization {
    @Id
    private int id;
    private String account;
    private String orgName;
    private String createTime;

}
