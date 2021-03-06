package com.OURganizer.OURganizerProject.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.OURganizer.OURganizerProject.model.Role;
import com.OURganizer.OURganizerProject.model.Services;
import com.OURganizer.OURganizerProject.model.User;
import com.OURganizer.OURganizerProject.repository.UserRepository;
import com.OURganizer.OURganizerProject.web.dto.UserRegistrationDto;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
 
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
    	
        User user = new User(registrationDto.getFirstName(),
            registrationDto.getLastName(), 
            registrationDto.getEmail(),
            passwordEncoder.encode(registrationDto.getPassword()), 
            Arrays.asList(new Role("ROLE_USER")), registrationDto.getServices());


        return userRepository.save(user);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid Username or Password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}


}
