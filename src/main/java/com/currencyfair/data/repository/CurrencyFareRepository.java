package com.currencyfair.data.repository; 

import org.springframework.data.repository.PagingAndSortingRepository;

import com.currencyfair.data.entity.CurrencyFare;

/**
* @author Farith Jos� Heras Garc�a
* @version 1.0
*/
public interface CurrencyFareRepository extends PagingAndSortingRepository<CurrencyFare,Integer>, CurrencyFareRepositoryCustom {

}
