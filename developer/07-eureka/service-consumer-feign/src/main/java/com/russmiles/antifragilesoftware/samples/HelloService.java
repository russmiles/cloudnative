package com.russmiles.antifragilesoftware.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloClient consumedService;

    public String goAndSayHello() {
        return consumedService.hello();
    }

    String getBackupHello() {
        return "Hmm, no one available to say hello just yet ... maybe try later?";
    }
}