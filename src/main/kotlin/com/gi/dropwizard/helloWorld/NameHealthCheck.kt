package com.gi.dropwizard.helloWorld

import com.codahale.metrics.health.HealthCheck

/**
 * Created by istvan on 8/22/17.
 */
class NameHealthCheck(private val name: String) : HealthCheck() {

    override fun check(): Result {

        return if (!name.contains("istvan")){
            return HealthCheck.Result.unhealthy("I dont say hello to $name")
        } else {
             HealthCheck.Result.healthy()

        }
    }

}