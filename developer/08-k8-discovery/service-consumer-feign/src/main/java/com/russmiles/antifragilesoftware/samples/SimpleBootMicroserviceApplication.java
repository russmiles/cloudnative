package com.russmiles.antifragilesoftware.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EnableFeignClients
public class SimpleBootMicroserviceApplication {

    @Autowired
    private HelloService helloService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @RequestMapping("/")
    public String home() {
        return "Simple Boot Microservice Consumer Alive!";
    }

    @RequestMapping("/invokeConsumedService")
    public String invokeConsumedService() {
        return helloService.goAndSayHello();
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleBootMicroserviceApplication.class, args);
    }
}
