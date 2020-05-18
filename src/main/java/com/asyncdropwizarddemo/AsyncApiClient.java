package com.asyncdropwizarddemo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import java.util.concurrent.Future;

public class AsyncApiClient {
    private final Client client;

    public AsyncApiClient(Client client) {
        this.client = client;
    }

    public Future<String> getData() {
        WebTarget webTarget = client.target("https://www.w3.org/TR/PNG/iso_8859-1.txt");
        return webTarget.request().async().get(new InvocationCallback<String>() {
            @Override
            public void completed(String s) {
                System.out.println(String.format("Completed: %s", s));
            }

            @Override
            public void failed(Throwable throwable) {
                System.out.println("failed");
            }
        });
    }
}
