package com.russmiles.antifragilesoftware.api.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // Adding local default value
    @Value("${foo:World!}")
    private String value;

    @Value("${my-secret:Secret!}")
    private String secret;

    @RequestMapping("/")
    public String home() {
        return this.toString() + " instance saying: Hello Microservice World with value of: " + value + ", and a secret of:" + secret;
    }
}
