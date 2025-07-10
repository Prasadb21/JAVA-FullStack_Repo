package com.SpringBoot.dockerDemo_SB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserRepo userRepo;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {
        return userRepo.save(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }

}
