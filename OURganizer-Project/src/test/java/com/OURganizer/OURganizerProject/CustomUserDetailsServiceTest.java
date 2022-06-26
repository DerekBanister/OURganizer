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
	
	@Autowired UserRepository userRepository;
	
	@Test
	void test() {
		User user = new User();
		
		user.setId((long) 15);
		user.setEmail("duck@gmail.com");
		user.setFirstName("ddbo");
		user.setLastName("banny");
		user.setPassword("him");
		
		userRepository.save(user);
		
		
		String actual = customService.loadUserByUsername("duck@gmail.com").getUsername();
		
		
		String expected = user.getEmail();
		
		assertEquals(actual, expected);
		
	}

}
