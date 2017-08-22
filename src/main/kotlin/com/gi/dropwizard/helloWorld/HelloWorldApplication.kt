package com.gi.dropwizard.helloWorld

/**
 * Created by istvan on 7/6/17.
 */
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.io.Serializable

data class Saying(val id : Long,val content : String) : Serializable


class HelloWorldApplication : Application<HelloWorldConfiguration>() {

    @Override
    override fun getName() : String {
        return "hello-world"
    }

    @Override
    override fun initialize(bootstrap: Bootstrap<HelloWorldConfiguration>) {
        // nothing to do yet
    }

    @Override
    override fun run(configuration: HelloWorldConfiguration, environment: Environment) {
        val resource = HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        )
        environment.jersey().register(resource)

        val status = AppStatusResource()
        environment.jersey().register(status)

        val  healthCheck = TemplateHealthCheck(configuration.getTemplate())
        environment.healthChecks().register("template", healthCheck)
        //println("attributes" + environment.applicationContext.attributes)
        val nameHealtCheck = NameHealthCheck("")
        environment.healthChecks().register("name", nameHealtCheck)

        //environment.jersey().register(resource)
    }

    companion object {
        @Throws(Exception::class)
        @JvmStatic fun main(args: Array<String>) {
            //HelloWorldApplication().run(args.joinToString(" "))
            val runArgs = arrayOf("server","example.yml")
            HelloWorldApplication().run("server","example.yml")
        }
    }

}
