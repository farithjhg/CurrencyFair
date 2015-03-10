package com.currencyfair.data.repository; 

import java.util.List;

import com.currencyfair.data.entity.Currency;


/**
* @author Farith José Heras García
* @version 1.0
*/
public interface CurrencyFareRepositoryCustom  {
	public List<Currency> getCurrencyFromGroupByCode();
	public List<Currency> getCurrencyToGroupByCode();
	public List<Currency> getCurrencyGroupByCountry();
}
