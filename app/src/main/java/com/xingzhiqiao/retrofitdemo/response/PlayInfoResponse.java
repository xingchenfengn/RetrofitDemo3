package com.xingzhiqiao.retrofitdemo.response;

import com.xingzhiqiao.retrofitdemo.bean.AddUrl;
import com.xingzhiqiao.retrofitdemo.bean.PlaySource;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class PlayInfoResponse extends BaseResponse implements Serializable {

    private int playType;
    private int playId;
    private String tvName;
    private String programName;
    private ArrayList<PlaySource> playSources;
    private boolean collected;
    private String startTime;
    private String endTime;
    private boolean allowComment;
    private AddUrl addUrl;
    private String logo;

    public int getPlayType() {
        return playType;
    }

    public void setPlayType(int playType) {
        this.playType = playType;
    }

    public int getPlayId() {
        return playId;
    }

    public void setPlayId(int playId) {
        this.playId = playId;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isAllowComment() {
        return allowComment;
    }

    public void setAllowComment(boolean allowComment) {
        this.allowComment = allowComment;
    }

    public AddUrl getAddUrl() {
        return addUrl;
    }

    public void setAddUrl(AddUrl addUrl) {
        this.addUrl = addUrl;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public ArrayList<PlaySource> getPlaySources() {
        return playSources;
    }

    public void setPlaySources(ArrayList<PlaySource> playSources) {
        this.playSources = playSources;
    }

    public String getLogoUrl() {
        return logo;
    }

    public void setLogoUrl(String logoUrl) {
        this.logo = logoUrl;
    }

}
