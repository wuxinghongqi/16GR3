package com.xhq.sbm.account.bean;

public class AddAccount {
	private int providerId;
	private float totalPrice;
	private int isPayed;
	private String accountDate;
	private int goodsId;
	private int businessNum;
	
	public AddAccount() {
		super();
	}

	public AddAccount(int providerId, float totalPrice, int isPayed, String accountDate, int goodsId, int businessNum) {
		super();
		this.providerId = providerId;
		this.totalPrice = totalPrice;
		this.isPayed = isPayed;
		this.accountDate = accountDate;
		this.goodsId = goodsId;
		this.businessNum = businessNum;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getIsPayed() {
		return isPayed;
	}

	public void setIsPayed(int isPayed) {
		this.isPayed = isPayed;
	}

	public String getAccountDate() {
		return accountDate;
	}

	public void setAccountDate(String accountDate) {
		this.accountDate = accountDate;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getBusinessNum() {
		return businessNum;
	}

	public void setBusinessNum(int businessNum) {
		this.businessNum = businessNum;
	}
	
	
}
