package com.asyncdropwizarddemo;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class AsyncDropwizardDemoApplication extends Application<AsyncDropwizardDemoConfiguration> {
    public static void main(String[] args) throws Exception {
        new com.asyncdropwizarddemo.AsyncDropwizardDemoApplication().run(args);
    }

    public void run(com.asyncdropwizarddemo.AsyncDropwizardDemoConfiguration configuration, Environment environment) {
        Client client = ClientBuilder.newClient();
        environment.jersey().register(new HttpResourceUsingSyncClient(client));
        environment.jersey().register(new HttpResourceUsingAsyncClient(client));
        environment.jersey().register(new AsyncExpensiveHttpResource());
        environment.jersey().register(new SyncExpensiveHttpResource());
    }
}
