package com.OURganizer.OURganizerProject.web.dto;

import java.util.Collection;

import com.OURganizer.OURganizerProject.model.Services;

//data transfer object
public class UserRegistrationDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Collection<Services> services;

    public UserRegistrationDto() {

    }

	public UserRegistrationDto(String firstName, String lastName, String email, String password, Collection<Services> services) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.services = services;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Services> getServices() {
		return services;
	}

	public void setServices(Collection<Services> services) {
		this.services = services;
	}

   
}
