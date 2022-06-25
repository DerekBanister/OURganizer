package com.OURganizer.OURganizerProject.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.OURganizer.OURganizerProject.model.Services;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long>{
	@Query(value = "SELECT * FROM services where user_id = :id", nativeQuery=true)
	public Collection<Services> getAllServicesLoggedIn(Long id);
}
