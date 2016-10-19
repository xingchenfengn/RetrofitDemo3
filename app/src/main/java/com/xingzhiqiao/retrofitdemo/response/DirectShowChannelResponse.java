package com.xingzhiqiao.retrofitdemo.response;

import com.xingzhiqiao.retrofitdemo.bean.DirectShow;
import com.xingzhiqiao.retrofitdemo.bean.ListItemUnit;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class DirectShowChannelResponse extends BaseResponse {
    private ArrayList<ListItemUnit> demandBanner;
    private ArrayList<DirectShow> demandProgramList;

    public ArrayList<ListItemUnit> getDirectBanner() {
        return demandBanner;
    }

    public void setDirectBanner(ArrayList<ListItemUnit> demandBanner) {
        this.demandBanner = demandBanner;
    }

    public ArrayList<DirectShow> getDirectProgramList() {
        return demandProgramList;
    }

    public void setDirectProgramList(ArrayList<DirectShow> demandProgramList) {
        this.demandProgramList = demandProgramList;
    }
}
