
package com.xingzhiqiao.retrofitdemo.bean;

import java.util.ArrayList;

public class DirectShow {
    private int id;

    private int playId;

    private String imgUrl;

    private String tvName;

    private ArrayList<ProgramInfo> programInfoList;

    private int playType;

    private ChargeUnit chargeUnit;

    private String re_title;

    private String re_logo;

    private String isfee;
    
    private String videourl;

    /** 链接地址 */
    private String optionalText1;

    private String is_icon;

    /** 广告标题 */
    private String titleText;

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getIs_icon() {
        return is_icon;
    }

    public void setIs_icon(String is_icon) {
        this.is_icon = is_icon;
    }

    public String getOptionalText1() {
        return optionalText1;
    }

    public void setOptionalText1(String optionalText1) {
        this.optionalText1 = optionalText1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public ArrayList<ProgramInfo> getProgramInfoList() {
        return programInfoList;
    }

    public void setProgramInfoList(ArrayList<ProgramInfo> programInfoList) {
        this.programInfoList = programInfoList;
    }

    public int getPlayType() {
        return playType;
    }

    public void setPlayType(int playType) {
        this.playType = playType;
    }

    public ChargeUnit getChargeUnit() {
        return chargeUnit;
    }

    public void setChargeUnit(ChargeUnit chargeUnit) {
        this.chargeUnit = chargeUnit;
    }

    public String getRe_title() {
        return re_title;
    }

    public void setRe_title(String re_title) {
        this.re_title = re_title;
    }

    public String getRe_logo() {
        return re_logo;
    }

    public void setRe_logo(String re_logo) {
        this.re_logo = re_logo;
    }

    public String getIsfee() {
        return isfee;
    }

    public void setIsfee(String isfee) {
        this.isfee = isfee;
    }

    public int getPlayId() {
        return playId;
    }

    public void setPlayId(int playId) {
        this.playId = playId;
    }

	public String getVideourl() {
		return videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}
    
}
