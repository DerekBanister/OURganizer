package com.OURganizer.OURganizerProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.OURganizer.OURganizerProject.service.WebsitesService;

@Controller
@RequestMapping("/api")
public class WebsitesController {
		
	@Autowired
	private WebsitesService websitesService;
	
	
	@GetMapping("/websites")
	public String displayWebsites(Model model) {
		model.addAttribute("listWebsites", websitesService.getAllWebsites());
		return "websites";
	}
}
