package com.OURganizer.OURganizerProject.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.OURganizer.OURganizerProject.model.User;
import com.OURganizer.OURganizerProject.web.dto.UserRegistrationDto;



public interface UserService extends UserDetailsService{
 User save(UserRegistrationDto registrationDto);
}
