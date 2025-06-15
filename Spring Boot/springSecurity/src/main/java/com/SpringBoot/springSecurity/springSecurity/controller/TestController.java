package com.SpringBoot.springSecurity.springSecurity.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/security")
@CrossOrigin("*")
public class TestController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin()
    {
        return "ADMIN has logged in !!";
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public String test()
    {
        return "test";
    }

    // security required
    @GetMapping("/getBal")
    @PreAuthorize("hasRole('USER) or hasRole('ADMIN')")
    public String getBalance()
    {
        return "Your current balance is : 50000";
    }


    // security not required
    @GetMapping("/contactUs")
    public String hello()
    {
        return "Hi Prasad here, You can contact me at : 9730235624";
    }

    // security not required
    @GetMapping("/aboutUs")
    public String aboutUs()
    {
        return "We are the most trusted bank, SBI bank....";
    }



}
