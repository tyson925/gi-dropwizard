package com.gi.dropwizard.helloWorld

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import org.hibernate.validator.constraints.NotEmpty

/**
* Created by istvan on 7/6/17.
*/
class HelloWorldConfiguration : Configuration() {
    @NotEmpty
    private var template : String = ""

    @NotEmpty
    private var defaultName = "Stranger"

    @JsonProperty fun getTemplate() : String {
        return template
    }

    @JsonProperty fun setTemplate(template : String) {
        this.template = template
    }

    @JsonProperty fun getDefaultName() : String {
        return defaultName
    }

    @JsonProperty fun setDefaultName(name : String) {
        this.defaultName = name
    }
}