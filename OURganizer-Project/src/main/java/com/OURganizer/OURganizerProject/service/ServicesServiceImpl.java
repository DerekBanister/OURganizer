package com.OURganizer.OURganizerProject.service;

import java.util.List;

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

}
