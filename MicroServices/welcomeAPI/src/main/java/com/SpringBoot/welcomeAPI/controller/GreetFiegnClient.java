package com.SpringBoot.welcomeAPI.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GREET-API")
public interface GreetFiegnClient {


    @GetMapping("/greet")
    public String invokeGreetApi();

}
