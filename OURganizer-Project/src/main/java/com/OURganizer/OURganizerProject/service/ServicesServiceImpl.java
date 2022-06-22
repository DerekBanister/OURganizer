package com.OURganizer.OURganizerProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OURganizer.OURganizerProject.model.Services;
import com.OURganizer.OURganizerProject.repository.ServicesRepository;


@Service
public class ServicesServiceImpl implements ServicesService {

	@Autowired
	private ServicesRepository servicesRepository;
	
	@Override
	public List<Services> getAllServices() {
		return servicesRepository.findAll();
	}

	@Override
	public void saveServices(Services service) {
		this.servicesRepository.save(service);
		
	}
	//update
	@Override
	public Services getServiceById(long id) {
		Optional<Services> optional = servicesRepository.findById(id);
		Services services = null;
		if(optional.isPresent()) {
			services = optional.get();
		} else {
			throw new RuntimeException("Service not found" + id);
		}
		return services;
	}

}
