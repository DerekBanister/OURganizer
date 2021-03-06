package com.OURganizer.OURganizerProject.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(
            name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
            name = "role_id", referencedColumnName = "id"))
    private Collection < Role > roles;
    
    //Unnecessary table, but didn't want to break app right before deadline so I left it
    //it doesnt necessarily affect anything except creating an unused table in heidisql
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_services",
            joinColumns = @JoinColumn(
                name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                name = "service_id", referencedColumnName = "id"))
    private Collection <Services> services;
    

    public User(String firstName, String lastName, String email, String password, Collection < Role > roles, Collection <Services> services) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.services = services;
    }
    
    public User() {
	}

	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Collection < Role > getRoles() {
        return roles;
    }
    public void setRoles(Collection < Role > roles) {
        this.roles = roles;
    }

	public Collection<Services> getServices() {
		return services;
	}

	public void setServices(Collection<Services> services) {
		this.services = services;
	}
	
	public void addServices(Services service) {
		this.services.add(service);
		
	}

}
