package com.OURganizer.OURganizerProject.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.OURganizer.OURganizerProject.model.Services;
import com.OURganizer.OURganizerProject.model.User;
import com.OURganizer.OURganizerProject.repository.ServicesRepository;
import com.OURganizer.OURganizerProject.repository.UserRepository;
import com.OURganizer.OURganizerProject.service.ServicesService;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
@RequestMapping("/api")
public class ServicesController {
	
	@Autowired
	private ServicesService servicesService;
	
	@Autowired
	private ServicesRepository serviceRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	//display list of services
	@GetMapping("/credentials")
	public String displayServices(Model model) {
		//get auth user
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userEmail = ((UserDetails) principal).getUsername();
		//find authd user
		User user = userRepository.findByEmail(userEmail);
		
		Long userId = user.getId();
		System.out.println(userId);
		//show all services attached to loggedin user
		Collection<Services> service = serviceRepository.getAllServicesLoggedIn(userId);
		
		model.addAttribute("listServices", service);
		
		return "credentials";
	}
	
	//add new service
	@GetMapping("/addCredentials")
	public String addCredentials(Model model) {
		Services service = new Services();
		model.addAttribute("services", service);
		return "newService";
	}
	
	//save new service (post request)
	// want to hash pw before it is sent to database for security purposes
	@PostMapping("/saveServices")
	public String saveCredentials(@ModelAttribute("services") Services services) {
		//get and find auth'd user
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userEmail = ((UserDetails) principal).getUsername();
		
		User user = userRepository.findByEmail(userEmail);
		
		Long userId = user.getId();
		System.out.println(userId);
		
		services.setUser_id(user);
		//save new service with auth'd user
		servicesService.saveServices(services);
		
		return "redirect:/api/credentials";
	}
	
	//update a single service by the corresponding ID (routing)
	@GetMapping("/update/{id}")
	public String updateService(@PathVariable (value = "id") Long id, Model model) {
		Services services = servicesService.getServiceById(id);
		model.addAttribute("services", services);
		return "updateService";
	}
	// post request to update a existing service in db
    @PostMapping("/updateService/{id}")
    public String updateServices(@PathVariable Long id, @ModelAttribute("services") Services service, Model model) {
        // get service from database by id
        Services existingService = servicesService.getServiceById(id);

        existingService.setServiceName(service.getServiceName());
        existingService.setUserName(service.getUserName());
        existingService.setPassword(service.getPassword());

        // save updated service object
        servicesService.updateServices(existingService);
        return "redirect:/api/credentials";
    }
    //delete a service from the db by the corresponding id
    @GetMapping("/deleteService/{id}")
    public String deleteService(@PathVariable (value = "id") Long id) {
    	this.servicesService.deleteService(id);
    	return "redirect:/api/credentials";
    }
}
