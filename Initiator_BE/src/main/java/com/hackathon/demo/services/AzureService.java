package com.hackathon.demo.services;

import com.hackathon.demo.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AzureService
{
    @Autowired
    private UserDetailsService userDetailsService;
    public void createUserProfile(UserDetails userDetails){
        UserDetails userDetails1 = userDetailsService.createUser(userDetails);
        System.out.println(userDetails1.getProfileId() + " : " + userDetails1.getUserId());

    }
    public void getUserProfile(int userId){
        UserDetails userDetails1 = userDetailsService.getUserDetailsById(userId);
        System.out.println(userDetails1.getProfileId() + " : " + userDetails1.getUserId());

    }
}
