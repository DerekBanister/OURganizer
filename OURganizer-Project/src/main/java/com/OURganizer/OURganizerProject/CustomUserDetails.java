package com.OURganizer.OURganizerProject;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.OURganizer.OURganizerProject.model.User;

public class CustomUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;
    private User user;
    

    public CustomUserDetails(User user) {
        this.user = user;
    }

    public String getEmail() {
        return this.user.getEmail();
    }
    
    public Long getUserId() {
        return this.user.getId();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}
