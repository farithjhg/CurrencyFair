package com.currencyfair.data.entity;

import java.io.Serializable;


public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
	private String countryCode; 
	private int count;
	
	public Country() {
	}

	public Country(String countryCode, int count) {
		this.countryCode = countryCode;
		this.count = count;
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
