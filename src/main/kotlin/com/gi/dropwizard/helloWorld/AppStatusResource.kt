package com.gi.dropwizard.helloWorld

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/**
 * Created by istvan on 8/22/17.
 */
@Path("/status")
public class AppStatusResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public fun getStatus() : String {
        return "downstream app is up";
    }
}