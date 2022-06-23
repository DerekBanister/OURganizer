package com.OURganizer.OURganizerProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OURganizer.OURganizerProject.model.Websites;
import com.OURganizer.OURganizerProject.repository.WebsitesRepository;

@Service
public class WebsiteServicesImpl implements WebsitesService {
	
	@Autowired
	private WebsitesRepository websitesRepository;
	
	
	
	@Override
	public List<Websites> getAllWebsites() {
		return websitesRepository.findAll();
	}

	@Override
	public void saveWebsites(Websites websites) {
		this.websitesRepository.save(websites);
	}

	@Override
	public Websites getWebsiteById(Long id) {
		Optional<Websites> optional = websitesRepository.findById(id);
		Websites websites = null;
		if(optional.isPresent()) {
			websites = optional.get();
		} else {
			throw new RuntimeException("Website not found" + id);
		}
		return websites;
	}

	@Override
	public Websites updateWebsites(Websites websites) {
	
		return websitesRepository.save(websites);
	}

	@Override
	public void deleteWebsite(Long id) {
		this.websitesRepository.deleteById(id);
		
	}

}
