package com.currencyfair.data.service; 

import java.util.List;

import com.currencyfair.data.entity.Country;
import com.currencyfair.data.entity.Currency;
import com.currencyfair.data.entity.CurrencyFare;

/**
* @author Farith José Heras García
* @version 1.0
*/
public interface CurrencyFareService {

    /**
     * Return CurrencyFare's entity by PK
     * @return CurrencyFare
     */
    public CurrencyFare findByPK(Integer id);

    /**
     * Return all CurrencyFare rows 
     */
    public List<CurrencyFare> findAll();

    /**
     * Add a row in the CurrencyFare Table
     * @return CurrencyFare
     */
    public CurrencyFare save(CurrencyFare entity);

    /**
    * Delete a row in the CurrencyFare Table by PK 
    */
    public void delete(CurrencyFare entity);

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
	
	/**
	 * Get the new Id 
	 * @return Integer
	 */
	public Integer getMaxId();	
}
