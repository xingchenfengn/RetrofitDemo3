package com.xingzhiqiao.retrofitdemo.response;

import com.xingzhiqiao.retrofitdemo.bean.StatusUnit;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BaseResponse implements Serializable {

    StatusUnit status;

    public StatusUnit getStatus() {
        return status;
    }

    public void setStatus(StatusUnit status) {
        this.status = status;
    }
}
