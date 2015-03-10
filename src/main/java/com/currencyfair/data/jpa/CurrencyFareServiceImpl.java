package com.currencyfair.data.jpa; 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.currencyfair.data.entity.Currency;
import com.currencyfair.data.entity.CurrencyFare;
import com.currencyfair.data.repository.CurrencyFareRepository;
import com.currencyfair.data.service.CurrencyFareService;
/**
* @author Farith José Heras García
* @version 1.0
*/
@Service("CurrencyFareService")
@Repository
@Transactional
public class CurrencyFareServiceImpl implements CurrencyFareService {
    @Autowired
    private CurrencyFareRepository currencyFareRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    public CurrencyFare findByPK(Integer id){
		return currencyFareRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public List<CurrencyFare> findAll() {
		return (List<CurrencyFare>)currencyFareRepository.findAll();
    }

    public CurrencyFare save(CurrencyFare entity) {
		if(entity.getCurrencyFareId()==null){
			currencyFareRepository.save(entity);
		}else{
			em.merge(entity);
		}
		return entity;
    }

    public void delete(CurrencyFare entity) {
         em.remove(findByPK(entity.getCurrencyFareId()));
    }

	public List<Currency> getCurrencyFromGroupByCode() {
		return currencyFareRepository.getCurrencyFromGroupByCode();
	}

	public List<Currency> getCurrencyToGroupByCode() {
		return currencyFareRepository.getCurrencyToGroupByCode();
	}

	public List<Currency> getCurrencyGroupByCountry() {
		return currencyFareRepository.getCurrencyGroupByCountry();
	}

}
