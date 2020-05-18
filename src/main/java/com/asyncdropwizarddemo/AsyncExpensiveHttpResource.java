package com.asyncdropwizarddemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

@Path("/helloasync")
public class AsyncExpensiveHttpResource {
    @GET
    public void asyncGet(@Suspended final AsyncResponse asyncResponse) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = null;
                try {
                    result = expensiveOperation();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                asyncResponse.resume(result);
            }

            private String expensiveOperation() throws InterruptedException {
                Thread.sleep(5000);
                return "hello after 5s";
            }
        }).start();
    }
}
