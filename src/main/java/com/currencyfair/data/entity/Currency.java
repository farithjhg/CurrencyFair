package com.currencyfair.data.entity;

import java.io.Serializable;

public class Currency implements Serializable {
    private static final long serialVersionUID = 1L;
	private String currencyCode;
	private int count;
	
	public Currency() {
	}

	public Currency(String currencyCode, int count) {
		super();
		this.currencyCode = currencyCode;
		this.count = count;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
