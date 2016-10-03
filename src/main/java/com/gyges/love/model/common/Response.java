package com.gyges.love.model.common;

/**
 * Created by gygesM on 2016/10/2.
 */
public class Response<T> {

    T data;
    int code;

    public Response(T data) {
        this.data = data;
    }

    public Response() {
    }

    public Response(T data, int code) {
        this.data = data;
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
