package com.russmiles.antifragilesoftware.samples;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient("${consumed.microservice.name}")
interface HelloClient {
    @RequestMapping(value = "/", method = GET)
    String hello();
}