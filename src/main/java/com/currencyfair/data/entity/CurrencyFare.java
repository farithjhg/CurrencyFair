package com.currencyfair.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
* @author Farith José Heras García
* @version 1.0
*/
@XmlRootElement
@Entity
@NamedQuery(name = "CurrencyFare.findAll", query = "select o from CurrencyFare o") 
public class CurrencyFare implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="currency_fare_id", nullable = false)
    private Integer currencyFareId;
    @Column(name="user_id")
    private String userId;
    @Column(name="currency_from")
    private String currencyFrom;
    @Column(name="currency_to")
    private String currencyTo;
    @Column(name="amount_sell")
    private Double amountSell;
    @Column(name="amount_buy")
    private Double amountBuy;
    @Column(name="rate")
    private Double rate;
    @Column(name="time_placed")
    private Date timePlaced;
    @Column(name="originating_country")
    private String originatingCountry;
    
    public CurrencyFare() {
	}

	public CurrencyFare(Integer currencyFareId, String userId,
			String currencyFrom, String currencyTo, Double amountSell,
			Double amountBuy, Double rate, Date timePlaced,
			String originatingCountry) {
		this.currencyFareId = currencyFareId;
		this.userId = userId;
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.amountSell = amountSell;
		this.amountBuy = amountBuy;
		this.rate = rate;
		this.timePlaced = timePlaced;
		this.originatingCountry = originatingCountry;
	}

	public Integer getCurrencyFareId() {
		return currencyFareId;
	}

	public void setCurrencyFareId(Integer currencyFareId) {
		this.currencyFareId = currencyFareId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public Double getAmountSell() {
		return amountSell;
	}

	public void setAmountSell(Double amountSell) {
		this.amountSell = amountSell;
	}

	public Double getAmountBuy() {
		return amountBuy;
	}

	public void setAmountBuy(Double amountBuy) {
		this.amountBuy = amountBuy;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Date getTimePlaced() {
		return timePlaced;
	}

	public void setTimePlaced(Date timePlaced) {
		this.timePlaced = timePlaced;
	}

	public String getOriginatingCountry() {
		return originatingCountry;
	}

	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}
    
}
