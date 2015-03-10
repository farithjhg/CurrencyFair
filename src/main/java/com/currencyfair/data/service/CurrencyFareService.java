package com.currencyfair.data.service; 

import java.util.List;

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

    public List<Currency> getCurrencyFromGroupByCode();
	public List<Currency> getCurrencyToGroupByCode();
	public List<Currency> getCurrencyGroupByCountry();
}
