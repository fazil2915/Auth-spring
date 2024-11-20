package com.example.demo.services;

import com.example.demo.models.UserPrincipal;
import com.example.demo.models.Users;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Users user=repo.findByUsername(username);
        if(user==null){
            System.out.println("User not found !!");
            throw new UsernameNotFoundException("User not found!!");
        }else{
            System.out.println("User successfully found!!");
        }
        return new UserPrincipal(user);
    }
}
