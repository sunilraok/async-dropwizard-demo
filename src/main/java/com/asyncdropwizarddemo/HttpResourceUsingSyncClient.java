package com.asyncdropwizarddemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;

@Path("/hello")
public class HttpResourceUsingSyncClient {
    private final ApiClient client;

    public HttpResourceUsingSyncClient(Client client) {
        this.client = new ApiClient(client);
    }

    @GET
    public String getGreeting() {
        return client.getData();
    }
}
