package com.ga.blogapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ga.blogapp.dao.UserDao;
import com.ga.blogapp.model.User;
import com.ga.blogapp.model.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	
	@Autowired
	private UserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {

		User user = dao.findByEmailAddress(emailAddress);
		
		if(user == null) {
			throw new UsernameNotFoundException("Not Found");
		}
		
		UserDetailsImpl obj = new UserDetailsImpl(user);
		
		return obj;
		/*
		 * Instead of these two lines above, I can write this statement 
		 * `return user.map(UserDetailImpl::new).get()`
		 * BUT .. the map only worked when I make the user optional 
		 * Like this: `Optional<User> user = dao.findByEmailAddress(emailAddress);`
		 * but when make the user optional here, I have to convert it also to optional in UserDao interface
		 * */
	}

	
}
