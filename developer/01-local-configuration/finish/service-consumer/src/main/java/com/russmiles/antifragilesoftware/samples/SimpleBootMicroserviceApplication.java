package com.russmiles.antifragilesoftware.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SimpleBootMicroserviceApplication {

    @Value("${consumed.microservice.name}")
    private String consumedServiceName;

    @Value("${consumed.microservice.port}")
    private String consumderServicePort;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/")
    public String home() {
        return "Simple Boot Microservice Consumer Alive!";
    }


    @RequestMapping("/invokeConsumedService")
    public String invokeConsumedService() {
        ResponseEntity<String> exchange =
                this.restTemplate.exchange(
                        "http://" + consumedServiceName + ":" + consumderServicePort + "/",
                        HttpMethod.GET,
                        null,
                        String.class);

        return exchange.getBody();
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleBootMicroserviceApplication.class, args);
    }
}
