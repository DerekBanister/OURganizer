package com.OURganizer.OURganizerProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OURganizer.OURganizerProject.model.Services;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long>{

}
