package com.hackathon.demo.doa;

import com.hackathon.demo.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

}
