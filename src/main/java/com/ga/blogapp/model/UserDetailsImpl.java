package com.ga.blogapp.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails{

	//Attributes
	private String username;
	private String password;
//	private String firstName;
//	private String lastName;
	private List<GrantedAuthority> authorities;
	
	//Constructors:
	public UserDetailsImpl(User user) {
		
		//this will map me with the authentication for security
		this.username = user.getEmailAddress();
		this.password = user.getPassword();
//		this.firstName = user.getFirstName();
//		this.lastName = user.getLastName();
		this.authorities = Arrays
								.stream(user.getUserRole().split(",")) // make it as an array and if it's > 1 .. split it with comma and assign that to an array
								.map(SimpleGrantedAuthority::new) // this is a new way to write an object
								.collect(Collectors.toList());
	}
	
	
	//Methods
	
	//Override Methods 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
