package com.SpringBoot.welcomeAPI.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GreetFiegnClient greetFiegnClient;

    // Using RestTemplate
//    @GetMapping("/welcome")
//    public String welcome()
//    {
//        String welcomeMsg =  "Welcome and ";
//        String greet = restTemplate.getForObject("http://localhost:9090/greet" , String.class);
//        return welcomeMsg + greet;
//    }

        @GetMapping("/welcome")
    public String welcome()
    {
        String welcomeMsg =  "Welcome and ";
        String greet = greetFiegnClient.invokeGreetApi();
        return welcomeMsg + greet;
    }




}
