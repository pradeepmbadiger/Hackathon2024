package com.hackathon.demo.controller;


import com.hackathon.demo.entity.UserDetails;
import com.hackathon.demo.services.AzureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class SpeakerIdentificationController {
    @Autowired
    private AzureService azureService;
    @PostMapping(value ="/enrollUserProfile",produces = { "application/json" },
            consumes = { "multipart/form-data" })
   // public ResponseEntity<Boolean>  enrollUserProfile(@RequestBody RegisterUserProfileRequest body){
    public ResponseEntity<Boolean>  enrollUserProfile(@RequestParam String firstName, @RequestParam String lastName,
                                                      @RequestParam("audioFile") MultipartFile audioFile ){
        System.out.println("First Name :" + firstName);
        System.out.println("Last Name :" + lastName);
        System.out.println("audio :" + audioFile.getName());
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(firstName);
        userDetails.setLastName(lastName);
        userDetails.setProfileId(null);
        azureService.createUserProfile(userDetails, audioFile);
        azureService.getUserProfile(1);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    @PostMapping(value ="/identifyUserVoice",produces = { "application/json" },
            consumes = { "multipart/form-data" })
    public ResponseEntity<Boolean>  identifyUserVoice(@RequestParam String userId, @RequestParam("audioFile") MultipartFile audioFile ){
        System.out.println("userId :" + userId);

        System.out.println("audio :" + audioFile.getName());
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
   // public ResponseEntity<>
}
