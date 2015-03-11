package com.currencyfair.data.repository; 

import java.util.List;

import com.currencyfair.data.entity.Country;
import com.currencyfair.data.entity.Currency;


/**
* @author Farith José Heras García
* @version 1.0
*/
public interface CurrencyFareRepositoryCustom  {
	/**
     * Get a List of Currency group by Currency From
     * @return List<Currency>
     */
    public List<Currency> getCurrencyFromGroupByCode();
    /**
     * Get a List of Currency group by Currency To
     * @return List<Currency>
     */
	public List<Currency> getCurrencyToGroupByCode();
    /**
     * Get a List of Country group by Country Code
     * @return List<Country>
     */
	public List<Country> getCountryGroupByCode();
}
