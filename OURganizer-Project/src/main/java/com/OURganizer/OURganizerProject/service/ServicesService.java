package com.OURganizer.OURganizerProject.service;

import java.util.List;

import com.OURganizer.OURganizerProject.model.Services;

public interface ServicesService {
	List<Services> getAllServices();
	void saveServices(Services service);
	Services getServiceById(Long id);
	Services updateServices(Services service);
	void deleteService(Long id);
}
