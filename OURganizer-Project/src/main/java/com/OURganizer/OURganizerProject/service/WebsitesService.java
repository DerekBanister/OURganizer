package com.OURganizer.OURganizerProject.service;

import java.util.List;

import com.OURganizer.OURganizerProject.model.Websites;

public interface WebsitesService {
	List<Websites> getAllWebsites();
	void saveWebsites(Websites websites);
	Websites getWebsiteById(Long id);
	Websites updateWebsites(Websites websites);
	void deleteWebsite(Long id);
}
