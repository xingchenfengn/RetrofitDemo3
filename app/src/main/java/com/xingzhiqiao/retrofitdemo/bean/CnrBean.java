package com.xingzhiqiao.retrofitdemo.bean;

import java.io.Serializable;

/**
 * Created by xingzhiqiao on 16/10/12.
 */

public class CnrBean implements Serializable{

    private String id;
    private String name;
    private String current_play;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrent_play() {
        return current_play;
    }

    public void setCurrent_play(String current_play) {
        this.current_play = current_play;
    }
}
