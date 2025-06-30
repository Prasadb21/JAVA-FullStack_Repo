package com.SpringBoot.JWT.controller;


import com.SpringBoot.JWT.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class JWTController {

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/generate-Token")
    public String generateToken(@RequestParam String username , @RequestParam String password)
    {
        if("admin".equals(username) && "admin".equals(password))
        {
            // generate
            return jwtUtil.generateToken(username);
        }
        else
        {
            return "Invalid credentials !!!";
        }

    }

//    public String fundTransfer(@RequestHeader(value = "Authorization", required = false) String authorizationHeader)
//    {
//        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer "))
//        {
//            String token = authorizationHeader.substring(7);
//        }
//
//    }

}
