package com.OURganizer.OURganizerProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import com.OURganizer.OURganizerProject.model.User;
import com.OURganizer.OURganizerProject.repository.UserRepository;

@SpringBootTest
class CustomUserDetailsServiceTest {
	
	
	@Autowired
	private CustomUserDetailsService customService;
	
	@Autowired 
	UserRepository userRepository;
	
	@Test
	void test() {
		User user = new User();
		
		user.setId((long) 2);
		user.setEmail("derek@gmail.com");
		user.setFirstName("derek");
		user.setLastName("banister");
		user.setPassword("password");
		
		userRepository.save(user);
		
		String actual = customService.loadUserByUsername("derek@gmail.com").getUsername();
		
		String expected = user.getEmail();
		
		assertEquals(actual, expected);
		
	}

}
