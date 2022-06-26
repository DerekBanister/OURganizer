package com.OURganizer.OURganizerProject.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.OURganizer.OURganizerProject.model.Websites;


@SpringBootTest
class WebsiteServicesImplTest {

	@Autowired
	private WebsitesService websitesService;
	
	@Test
	void test() {
		Websites website = new Websites();
		
		
		website.setId((long) 1);
		website.setWebsiteName("amazon");
		website.setUrl("www.amazon.com");
		
		websitesService.saveWebsites(website);
		
		Long actual = websitesService.getWebsiteById(website.getId()).getId();
		Long expected = website.getId();
		
		assertEquals(actual, expected);
	}

}
