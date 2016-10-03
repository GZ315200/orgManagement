package com.gyges.love.model.common;

/**
 * Created by gygesM on 2016/10/3.
 */
public enum  Status {

    SUCCESS("查询成功",10001),
    FAILED("查询失败",10002);

    private Integer code;
    private String codeDesc;

    Status( String codeDesc,Integer code) {
        this.code = code;
        this.codeDesc = codeDesc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }
}
