package com.currencyfair.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.currencyfair.data.entity.Country;
import com.currencyfair.data.entity.Currency;
import com.currencyfair.data.entity.CurrencyFare;
import com.currencyfair.data.factory.ServicesFactory;
import com.currencyfair.data.service.CurrencyFareService;

@Path("/services")
public class CurrencyFareRestService {

    private final CurrencyFareService currencyFareService;

    public CurrencyFareRestService() {
        this.currencyFareService = ServicesFactory.getCurrencyFareService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CurrencyFare> getAllCurrencyFare() {
        return currencyFareService.findAll();
    }

    @GET
    @Path("getCurrencyFromGroupByCode")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Currency> getCurrencyFromGroupByCode() {
        return currencyFareService.getCurrencyFromGroupByCode();
    }

    @GET
    @Path("getCurrencyToGroupByCode")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Currency> getCurrencyToGroupByCode() {
        return currencyFareService.getCurrencyToGroupByCode();
    }

    @GET
    @Path("getCountryGroupByCode")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getCountryGroupByCode() {
        return currencyFareService.getCountryGroupByCode();
    }
    
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CurrencyFare getCurrencyFareById(@PathParam("id") Integer id) {
        return currencyFareService.findByPK(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CurrencyFare save(CurrencyFare CurrencyFare) {
        return currencyFareService.save(CurrencyFare);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CurrencyFare update(CurrencyFare CurrencyFare) {
        return currencyFareService.save(CurrencyFare);
    }


    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") int id) {
    	currencyFareService.delete(currencyFareService.findByPK(id));
    }    
}
