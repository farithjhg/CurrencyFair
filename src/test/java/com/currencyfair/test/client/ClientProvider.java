package com.currencyfair.test.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ClientProvider {
	private static final String URL="http://localhost:8080/CurrencyFair/";
    public ClientProvider() {
    }

    public WebResource getWebResource() {
        Client client = Client.create(new DefaultClientConfig());
        return client.resource(URL);
    }

}
