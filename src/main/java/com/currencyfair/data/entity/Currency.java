package com.currencyfair.data.entity;

import java.io.Serializable;

public class Currency implements Serializable {
    private static final long serialVersionUID = 1L;
	private String currencyCode;
	private String countryCode; 
	private int count;
	
	public Currency() {
	}

	public Currency(String currencyCode, String countryCode, int count) {
		super();
		this.currencyCode = currencyCode;
		this.countryCode = countryCode;
		this.count = count;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
