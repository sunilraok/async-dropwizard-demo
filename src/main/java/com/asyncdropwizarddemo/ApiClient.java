package com.asyncdropwizarddemo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class ApiClient {
    private final Client client;
    public ApiClient(Client client) {
        this.client = client;
    }

    public String getData() {
        WebTarget webTarget = client.target("https://www.w3.org/TR/PNG/iso_8859-1.txt");
        return webTarget.request().get(String.class);
    }
}
