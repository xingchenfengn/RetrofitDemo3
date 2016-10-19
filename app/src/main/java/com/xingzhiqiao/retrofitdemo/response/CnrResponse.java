package com.xingzhiqiao.retrofitdemo.response;

import com.xingzhiqiao.retrofitdemo.bean.CnrBean;

import java.util.List;

/**
 * Created by xingzhiqiao on 16/10/12.
 */

public class CnrResponse {

    private List<CnrBean> cnrbeans;

    public List<CnrBean> getCnrbeans() {
        return cnrbeans;
    }

    public void setCnrbeans(List<CnrBean> cnrbeans) {
        this.cnrbeans = cnrbeans;
    }
}
