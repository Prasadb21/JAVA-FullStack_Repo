package com.SpringBoot.springSecurity.springSecurity.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("CustomUserDetailsService ------ 3");


//        if(!username.equals("Prasad"))
//        {
//            throw new UsernameNotFoundException("User Not Found !!!");
//        }
//        String encodedPass = new BCryptPasswordEncoder().encode("root");
//        return User.withUsername("Prasad").password(encodedPass)
//                .roles("USER")
//                .build();

        String encodedPass = new BCryptPasswordEncoder().encode("root");
        if(username.equals("Prasad"))
        {
            return User.withUsername("Prasad").password(encodedPass)
                .roles("ADMIN")
                .build();
        }

        String encodedPassVaishu = new BCryptPasswordEncoder().encode("root");
        if(username.equals("Vaishu"))
        {
            return User.withUsername("Prasad").password(encodedPassVaishu)
                    .roles("USER")
                    .build();
        }
        throw new UsernameNotFoundException(" User Not Found !!!");



    }

}
