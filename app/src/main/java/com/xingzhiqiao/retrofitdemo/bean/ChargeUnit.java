package com.xingzhiqiao.retrofitdemo.bean;

public class ChargeUnit {
	private String needCharge;
	private int chargeId;
	private int leftFreeSeconds;

	public String isNeedCharge() {
		return needCharge;
	}

	public void setNeedCharge(String needCharge) {
		this.needCharge = needCharge;
	}

	public int getChargeId() {
		return chargeId;
	}

	public void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}

	public int getLeftFreeSeconds() {
		return leftFreeSeconds;
	}

	public void setLeftFreeSeconds(int leftFreeSeconds) {
		this.leftFreeSeconds = leftFreeSeconds;
	}

}
