package com.OURganizer.OURganizerProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OURganizer.OURganizerProject.model.Websites;

@Repository
public interface WebsitesRepository extends JpaRepository<Websites, Long>{
	
}
