package com.SpringBoot.securityInDB.securityInDB.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String welcome()
    {
        return "Welcome to our office..... ";
    }

    @GetMapping("/user")
    public String user()
    {
        return "Hello world from user !!!";
    }

    @GetMapping("/admin")
    public String admin()
    {
        return "Hello world from admin !!!";
    }

}
