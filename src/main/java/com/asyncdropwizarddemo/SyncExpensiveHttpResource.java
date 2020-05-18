package com.asyncdropwizarddemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("hellosyncexpensive")
public class SyncExpensiveHttpResource {
    @GET
    public Response get() throws InterruptedException {
        Thread.sleep(5000);
        return Response.ok("hello after 5s").build();
    }
}
