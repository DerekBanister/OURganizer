package com.OURganizer.OURganizerProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.OURganizer.OURganizerProject.model.Websites;
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
	
	@GetMapping("/addWebsites")
	public String addWebsites(Model model) {
		Websites websites = new Websites();
		model.addAttribute("websites", websites);
		return "newWebsite";
	}
	
	@PostMapping("/saveWebsites")
	public String saveWebsites(@ModelAttribute("websites") Websites websites) {
		websitesService.saveWebsites(websites);
		return "redirect:/api/websites";
	}
	
	@GetMapping("/updateWeb/{id}")
	public String updateWebsite(@PathVariable (value="id") Long id, Model model) {
		Websites websites = websitesService.getWebsiteById(id);
		model.addAttribute("websites", websites);
		return "updateWebsite";
	}
	
	@PostMapping("/updateWebsite/{id}")
	public String updateWebsites(@PathVariable Long id, @ModelAttribute("websites") Websites websites, Model model) {
		Websites existingWebsite = websitesService.getWebsiteById(id);
		
		existingWebsite.setWebsiteName(websites.getWebsiteName());
		existingWebsite.setUrl(websites.getUrl());
		
		websitesService.updateWebsites(existingWebsite);
		return "redirect:/api/websites";
	}
	
	@GetMapping("/deleteWebsite/{id}")
	public String deleteWebsite(@PathVariable (value = "id") Long id) {
		this.websitesService.deleteWebsite(id);
		return "redirect:/api/websites";
	}
	
}
