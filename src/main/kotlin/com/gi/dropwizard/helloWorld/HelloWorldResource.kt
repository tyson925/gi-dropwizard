package com.gi.dropwizard.helloWorld

import javax.ws.rs.QueryParam
import com.codahale.metrics.annotation.Timed
import javax.ws.rs.GET
import java.util.concurrent.atomic.AtomicLong
import javax.ws.rs.core.MediaType.APPLICATION_JSON
import javax.ws.rs.Produces
import java.util.Optional;
import javax.ws.rs.Path
import javax.ws.rs.core.MediaType


/**
 * Created by istvan on 7/6/17.
 */
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
class HelloWorldResource(private val template: String, private val defaultName: String) {
    private val counter: AtomicLong = AtomicLong()

    @GET
    @Timed
    fun sayHello(@QueryParam("name") name: Optional<String>): Saying {
        val value = String.format(template, name.orElse(defaultName))
        return Saying(counter.incrementAndGet(), value)
    }
}
