package com.gyges.love.model.common;

/**
 * Created by gygesM on 2016/10/2.
 */
public class Response<T> {

    boolean success = true;
    T data;

    public Response(T data) {
        this.data = data;
    }

    public Response() {
    }

    public Response(boolean success, T data) {
        this.data = data;
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
