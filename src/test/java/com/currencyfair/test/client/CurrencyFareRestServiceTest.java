package com.currencyfair.test.client;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.currencyfair.data.entity.CurrencyFare;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CurrencyFareRestServiceTest {

    private final ClientProvider clientProvider;
    private WebResource webService;

    public CurrencyFareRestServiceTest() {
        clientProvider = new ClientProvider();
    }

    @Before
    public void startServer() throws IOException {
        webService = clientProvider.getWebResource();
    }

    @After
    public void stopServer() {
        
    }

    @Test
    public void testCreateSomeCurrencyFare() throws IOException {
		
    	List<CurrencyFare> listCurrencyFare = new ArrayList<CurrencyFare>();
    	listCurrencyFare.add(new CurrencyFare(1,"134256","EUR","GBP",1000D,713.7D,0.7137D, new Date(),"FR"));
    	listCurrencyFare.add(new CurrencyFare(2,"123456","USD","EUR",1000D,930.1D,0.9301D, new Date(),"ES"));
    	listCurrencyFare.add(new CurrencyFare(3,"123457","EUR","USD",1000D,1075D,1.075D, new Date(),"CO"));
    	listCurrencyFare.add(new CurrencyFare(4,"123458","USD","GBP",1000D,663.8D,0.6638D, new Date(),"CO"));
    	listCurrencyFare.add(new CurrencyFare(5,"123459","JPY","EUR",1000D,7.674D,0.007674D, new Date(),"ES"));
    	listCurrencyFare.add(new CurrencyFare(6,"123460","EUR","JPY",1000D,130300D,130.3D, new Date(),"FR"));
    	listCurrencyFare.add(new CurrencyFare(7,"123461","USD","GBP",1000D,663.8D,0.6638D, new Date(),"IT"));
    	listCurrencyFare.add(new CurrencyFare(8,"123462","EUR","USD",1000D,1075D,1.075D, new Date(),"SU"));
    	listCurrencyFare.add(new CurrencyFare(9,"123463","JPY","GBP",1000D,5.477D,0.005477D, new Date(),"ES"));
    	listCurrencyFare.add(new CurrencyFare(10,"123464","EUR","CHF",1000D,1067D,1.067D, new Date(),"FR"));
    	listCurrencyFare.add(new CurrencyFare(11,"123465","USD","GBP",1000D,663.8D,0.6638D, new Date(),"CO"));
    	listCurrencyFare.add(new CurrencyFare(12,"123466","USD","EUR",1000D,930.1D,0.9301D, new Date(),"MX"));
    	listCurrencyFare.add(new CurrencyFare(13,"123467","EUR","USD",1000D,1075D,1.075D, new Date(),"EC"));
    	listCurrencyFare.add(new CurrencyFare(14,"123468","EUR","JPY",1000D,130300D,130.3D, new Date(),"PE"));
    	listCurrencyFare.add(new CurrencyFare(15,"123469","JPY","CHF",1000D,8.189D,0.008189D, new Date(),"ES"));
    	listCurrencyFare.add(new CurrencyFare(16,"123470","JPY","GBP",1000D,5.477D,0.005477D, new Date(),"FR"));
    	listCurrencyFare.add(new CurrencyFare(17,"123471","USD","EUR",1000D,930.1D,0.9301D, new Date(),"ES"));
    	listCurrencyFare.add(new CurrencyFare(18,"123472","USD","GBP",1000D,663.8D,0.6638D, new Date(),"CO"));
    	listCurrencyFare.add(new CurrencyFare(19,"123473","EUR","USD",1000D,1075D,1.075D, new Date(),"ES"));

    	for (CurrencyFare currencyFare : listCurrencyFare) {
        	ClientResponse resp = webService.path("rest").path("services")
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .accept(MediaType.APPLICATION_JSON)
                    .post(ClientResponse.class, currencyFare);

            System.out.println("Got response: " + resp);
            String actual = resp.getEntity(String.class);
            String expectedId = "\"currencyFareId\":"+currencyFare.getCurrencyFareId();

            assertTrue(actual.contains(expectedId));
		}
    }

    
    @Test
    public void testGetAllCurrencyFareShouldReturnSuccessStatus() throws IOException {
        ClientResponse resp = webService.path("rest").path("services")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        System.out.println("Got response: " + resp);

        assertEquals(200, resp.getStatus());
    }

    @Test
    public void testGetAllCurrencyFareShouldReturnJSArray() throws IOException {
        ClientResponse resp = webService.path("rest").path("services")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        System.out.println("Got response: " + resp);
        String actual = resp.getEntity(String.class);
        System.out.println("JSON: " + actual);
        assertTrue("Result must be a JavaScript array: But it starts with '{'!", !actual.startsWith("{"));
        assertTrue("Result must be a JavaScript array: But it does not start with '['!", actual.startsWith("["));
    }

    @Test
    public void testGetCurrencyFromGroupByCodeShouldReturnJSArray() throws IOException {
        ClientResponse resp = webService.path("rest").path("services").path("getCurrencyFromGroupByCode")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        System.out.println("Got response: " + resp);
        String actual = resp.getEntity(String.class);
        System.out.println("JSON: " + actual);
        assertTrue("Result must be a JavaScript array: But it starts with '{'!", !actual.startsWith("{"));
        assertTrue("Result must be a JavaScript array: But it does not start with '['!", actual.startsWith("["));
    }

    @Test
    public void testGetCurrencyToGroupByCodeShouldReturnJSArray() throws IOException {
        ClientResponse resp = webService.path("rest").path("services").path("getCurrencyToGroupByCode")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        System.out.println("Got response: " + resp);
        String actual = resp.getEntity(String.class);
        System.out.println("JSON: " + actual);
        assertTrue("Result must be a JavaScript array: But it starts with '{'!", !actual.startsWith("{"));
        assertTrue("Result must be a JavaScript array: But it does not start with '['!", actual.startsWith("["));
    }

    @Test
    public void testGetNewIdShouldReturn20() throws IOException {
        ClientResponse resp = webService.path("rest").path("services").path("getNewId")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        System.out.println("Got response: " + resp);
        String actual = resp.getEntity(String.class);
        System.out.println("Id: " + actual);
        assertTrue(actual.equals("20"));
    }
    
    @Test
    public void testGetCurrencyGroupByCountryShouldReturnJSArray() throws IOException {
        ClientResponse resp = webService.path("rest").path("services").path("getCurrencyGroupByCountry")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        System.out.println("Got response: " + resp);
        String actual = resp.getEntity(String.class);
        System.out.println("JSON: " + actual);
        assertTrue("Result must be a JavaScript array: But it starts with '{'!", !actual.startsWith("{"));
        assertTrue("Result must be a JavaScript array: But it does not start with '['!", actual.startsWith("["));
    }
    
    
    @Test
    public void testGetRegionByIdShouldReturnSuccessStatus() throws IOException {
        ClientResponse resp = webService.path("rest").path("services/1")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        System.out.println("Got response: " + resp);
        String actual = resp.getEntity(String.class);
        System.out.println("JSON: " + actual);
        assertEquals(200, resp.getStatus());
    }


    @Test
    public void testCreateCurrencyFare() throws IOException {
		
    	CurrencyFare currencyFare = new CurrencyFare(20, "123474", "EUR", "GBP", 1000D, 713.7D, 0.714D,new Date(), "FR");
    	
    	ClientResponse resp = webService.path("rest").path("services")
                .type(MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, currencyFare);

        System.out.println("Got response: " + resp);
        String actual = resp.getEntity(String.class);
        String expectedId = "\"currencyFareId\":1";

        assertTrue(actual.contains(expectedId));
    }
    
}
