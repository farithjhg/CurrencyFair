package com.currencyfair.data.factory; 

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.currencyfair.data.config.ApplicationConfig;
import com.currencyfair.data.service.CurrencyFareService;

/**
* @author Farith José Heras García
* @version 1.0
*/
public class ServicesFactory{
     private static ApplicationContext ctx;
     private static CurrencyFareService currencyFareService;

     public static CurrencyFareService getCurrencyFareService() {
		if (ctx == null)
			ctx = getCtx();

		if (currencyFareService == null)
			currencyFareService = (CurrencyFareService) ctx.getBean("CurrencyFareService"); 

		return currencyFareService;
     }

	 private static ApplicationContext getCtx() {
		return new AnnotationConfigApplicationContext(ApplicationConfig.class);
     }
}
