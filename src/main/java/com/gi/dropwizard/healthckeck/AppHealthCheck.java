package com.gi.dropwizard.healthckeck;


import com.codahale.metrics.health.HealthCheck;

/**
 * Created by istvan on 8/21/17.
 */
public class AppHealthCheck  extends HealthCheck {


    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
