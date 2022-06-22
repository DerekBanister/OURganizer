package com.OURganizer.OURganizerProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.OURganizer.OURganizerProject.model.Services;
import com.OURganizer.OURganizerProject.service.ServicesService;

@Controller
@RequestMapping("/api")
public class ServicesController {
	
	@Autowired
	private ServicesService servicesService;
	
	//display list of services
	@GetMapping("/credentials")
	public String displayServices(Model model) {
		model.addAttribute("listServices", servicesService.getAllServices());
		return "credentials";
	}
	
	@GetMapping("/addCredentials")
	public String addCredentials(Model model) {
		Services service = new Services();
		model.addAttribute("services", service);
		return "newService";
	}
	
	@PostMapping("/saveServices")
	public String saveCredentials(@ModelAttribute("services") Services services) {
		servicesService.saveServices(services);
		return "redirect:/api/credentials";
	}
	
	@GetMapping("/update/{id}")
	public String updateService(@PathVariable (value = "id") long id, Model model) {
		Services services = servicesService.getServiceById(id);
		
		
		model.addAttribute("services", services);
		return "updateService";
	}
	
    @PostMapping("/updateService/{id}")
    public String updateServices(@PathVariable Long id, @ModelAttribute("services") Services service, Model model) {
        // get student from database by id
        Services existingService = servicesService.getServiceById(id);

        existingService.setServiceName(service.getServiceName());
        existingService.setUserName(service.getUserName());
        existingService.setPassword(service.getPassword());

        // save updated student object
        servicesService.updateServices(existingService);
        return "redirect:/api/credentials";
    }
}