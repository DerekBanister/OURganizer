package com.OURganizer.OURganizerProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.OURganizer.OURganizerProject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	//custom query to find user by their email
	 @Query("SELECT u FROM User u WHERE u.email = ?1")
	    public User findByEmail(String email);
}
