package com.SpringBoot.Greet_API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {


    @Autowired
    private Environment environment;

    @GetMapping("/greet")
    public String greetMessage()
    {
        String port = environment.getProperty("server.port");
        System.out.println("running on port : " + port);
        return "Hello from the world from Microservices currently running on port : " + port;
    }

}
