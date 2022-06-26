package com.OURganizer.OURganizerProject.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.OURganizer.OURganizerProject.model.Services;
import com.OURganizer.OURganizerProject.model.User;
import com.OURganizer.OURganizerProject.repository.ServicesRepository;
import com.OURganizer.OURganizerProject.repository.UserRepository;

@SpringBootTest
class ServicesServiceImplTest {

	@Autowired
	private ServicesService servicesService;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void test() {
		Services service = new Services();
		
		User user = new User();
		
		user.setId((long) 1);
		user.setEmail("derek123@gmail.com");
		user.setFirstName("derek123");
		user.setLastName("banister123");
		user.setPassword("password123");
		
		userRepository.save(user);
		
		service.setId((long) 1);
		service.setServiceName("amazon");
		service.setPassword("password");
		service.setUser_id(user);
		service.setUserName("derek123@gmail.com");
		
		servicesService.saveServices(service);
		
		Long actual = servicesService.getServiceById(service.getId()).getId();
		Long expected = service.getId();
		
		assertEquals(actual, expected);
	}

}
