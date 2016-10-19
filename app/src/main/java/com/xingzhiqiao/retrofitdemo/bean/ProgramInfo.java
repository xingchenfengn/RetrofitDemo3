package com.xingzhiqiao.retrofitdemo.bean;

public class ProgramInfo {
	private int tvId;
	private String startTime;
	private String endTime;
	private String programName;
	private int showStatus;
	private String week;

	public int getTvId() {
		return tvId;
	}

	public void setTvId(int tvId) {
		this.tvId = tvId;
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

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public int getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(int showStatus) {
		this.showStatus = showStatus;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

}
