package com.currencyfair.data.repository; 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.currencyfair.data.entity.Currency;


/**
* @author Farith Jos� Heras Garc�a
* @version 1.0
*/
public class CurrencyFareRepositoryCustomImpl implements  CurrencyFareRepositoryCustom{
	@PersistenceContext
    private EntityManager em;
	
	/**
	 * Return a list of Currency : code, count
	 */
	public List<Currency> getCurrencyFromGroupByCode(){
		List<Currency> listCurrency = new ArrayList<Currency>();
		String txtQuery = "select o.currencyFrom, count(o) from CurrencyFare o "+
						  "group by o.currencyFrom order by o.currencyFrom";
		Iterator results = em.createQuery(txtQuery)
		        .getResultList()
		        .iterator();

		while ( results.hasNext() ) {
			Object[] row = (Object[])results.next();
			
			String currencyCode = row[0].toString();
			String countryCode = null;
			int count = Integer.parseInt(row[1].toString());
			
			listCurrency.add(new Currency(currencyCode, countryCode, count));
		}
		return listCurrency;
	}

	/**
	 * Return a list of Currency : code, count
	 */
	public List<Currency> getCurrencyToGroupByCode(){
		List<Currency> listCurrency = new ArrayList<Currency>();
		String txtQuery = "select o.currencyTo, count(o) from CurrencyFare o "+
						  "group by o.currencyTo order by o.currencyTo";
		Iterator results = em.createQuery(txtQuery)
		        .getResultList()
		        .iterator();

		while ( results.hasNext() ) {
			Object[] row = (Object[])results.next();
			
			String currencyCode = row[0].toString();
			String countryCode = null;
			int count = Integer.parseInt(row[1].toString());
			
			listCurrency.add(new Currency(currencyCode, countryCode, count));
		}
		return listCurrency;
	}
	
	/**
	 * Return a list of Currency : country, count
	 */
	public List<Currency> getCurrencyGroupByCountry(){
		List<Currency> listCurrency = new ArrayList<Currency>();
		String txtQuery = "select o.originatingCountry, count(o) from CurrencyFare o "+
						  "group by o.originatingCountry order by o.originatingCountry";
		Iterator results = em.createQuery(txtQuery)
		        .getResultList()
		        .iterator();

		while ( results.hasNext() ) {
			Object[] row = (Object[])results.next();
			
			String currencyCode = null;
			String countryCode = row[0].toString();
			int count = Integer.parseInt(row[1].toString());
			
			listCurrency.add(new Currency(currencyCode, countryCode, count));
		}
		return listCurrency;
	}
}
