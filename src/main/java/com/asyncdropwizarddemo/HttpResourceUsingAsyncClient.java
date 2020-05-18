package com.asyncdropwizarddemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import java.util.concurrent.ExecutionException;

@Path("/hello2")
public class HttpResourceUsingAsyncClient {
    private final AsyncApiClient client;

    public HttpResourceUsingAsyncClient(Client client) {
        this.client = new AsyncApiClient(client);
    }

    @GET
    public String getGreeting() throws ExecutionException, InterruptedException {
        return this.client.getData().get();
    }
}
