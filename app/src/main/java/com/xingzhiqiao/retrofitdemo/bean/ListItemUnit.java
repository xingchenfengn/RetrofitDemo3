package com.xingzhiqiao.retrofitdemo.bean;

public class ListItemUnit {
	private int playId;

	private int playType;

	private int showType;

	private String imgUrl;

	private String titleText;

	private String explainText;

	private String optionalText1;

	private String optionalText2;

	/**
	 * 外链播放地址
	 */
	private String videourl;

	private boolean deleted;

	private boolean collected;

	// 标签
	private String is_icon;

	// 剧集里面的说明文字
	private String intro;

	public int getShowType() {
		return showType;
	}

	public void setShowType(int showType) {
		this.showType = showType;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getIs_icon() {
		return is_icon;
	}

	public void setIs_icon(String is_icon) {
		this.is_icon = is_icon;
	}

	private ChargeUnit chargeUnit;

	public int getPlayId() {
		return playId;
	}

	public void setPlayId(int playId) {
		this.playId = playId;
	}

	public int getPlayType() {
		return playType;
	}

	public void setPlayType(int playType) {
		this.playType = playType;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTitleText() {
		return titleText;
	}

	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}

	public String getExplainText() {
		return explainText;
	}

	public void setExplainText(String explainText) {
		this.explainText = explainText;
	}

	public String getOptionalText1() {
		return optionalText1;
	}

	public void setOptionalText1(String optionalText1) {
		this.optionalText1 = optionalText1;
	}

	public String getOptionalText2() {
		return optionalText2;
	}

	public void setOptionalText2(String optionalText2) {
		this.optionalText2 = optionalText2;
	}

	public ChargeUnit getChargeUnit() {
		return chargeUnit;
	}

	public void setChargeUnit(ChargeUnit chargeUnit) {
		this.chargeUnit = chargeUnit;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isCollected() {
		return collected;
	}

	public void setCollected(boolean collected) {
		this.collected = collected;
	}

	public String getVideourl() {
		return videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}



}
