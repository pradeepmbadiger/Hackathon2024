package com.hackathon.demo.services;

import com.hackathon.demo.doa.UserDetailsRepository;
import com.hackathon.demo.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public UserDetails createUser(UserDetails userDetails){
        return userDetailsRepository.save(userDetails);
    }
    public UserDetails getUserDetailsById(int id){
        return userDetailsRepository.findById(id).orElse(null);
    }

    public UserDetails updateUserDetails(UserDetails newUserDetails){
        UserDetails oldUserDetail;
        Optional<UserDetails> userDetail = userDetailsRepository.findById(newUserDetails.getUserId());
        if(userDetail.isPresent()){
            oldUserDetail = userDetail.get();
            oldUserDetail.setFirstName(newUserDetails.getFirstName());
            oldUserDetail.setLastName(newUserDetails.getLastName());
            oldUserDetail.setProfileId((newUserDetails.getProfileId()));
            userDetailsRepository.save(oldUserDetail);
        }else {
            return new UserDetails();
        }
        return oldUserDetail;
    }

    public String deleteUserDetailsById(int Id){
        userDetailsRepository.deleteById(Id);
        return "User details deleted successfully";
    }
}
