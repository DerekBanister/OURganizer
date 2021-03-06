package com.OURganizer.OURganizerProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.OURganizer.OURganizerProject.model.User;
import com.OURganizer.OURganizerProject.repository.UserRepository;


public class CustomUserDetailsService implements UserDetailsService {
	  @Autowired
	    private UserRepository userRepo;
	     
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    	//find a user using the findbyemail method in my user repository
	        User user = userRepo.findByEmail(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        return new CustomUserDetails(user);
	    }
}
