package com.ga.blogapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ga.blogapp.dao.UserDao;
import com.ga.blogapp.model.User;

@Controller
public class UserController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UserDao dao;
	
	//takes the current request
	//here is any attribute required by browser
	@Autowired
	private HttpServletRequest request;
		
	//to load the registration form
	@GetMapping("user/registration")
	public ModelAndView registration() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/registration");

		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		return mv;
	}
	
	//to post user registration
	@PostMapping("user/registration")
	public ModelAndView registration(User user) {
		
		ModelAndView mv = new ModelAndView();
//		mv.setViewName("user/login");
		mv.setViewName("home/index");
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		//to check if the user is already registered or not
		var it = dao.findAll(); // the one form DB and the `user` is the one we get from user
		
		for(User dbUser: it) {
			if(dbUser.getEmailAddress().equals(user.getEmailAddress())) {
				mv.addObject("message", "User Already Exists");
				return mv;
			}
		}
		
		//password encryption (plain text to encrypted) 
		BCryptPasswordEncoder bCrypt = new  BCryptPasswordEncoder(); 
		String newPassword = bCrypt.encode(user.getPassword());
		user.setPassword(newPassword);
		
		dao.save(user);
		mv.addObject("message", "User Registered Successfully");

		/////////////////////////
		//to get user attributes from session		
		HttpSession session = request.getSession();
		
		session.setAttribute("user", user);
		session.setAttribute("userRole", user.getUserRole());
				
		return mv;
	}
	
	//to load user login
	@GetMapping("user/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/login");
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		return mv;
	}
//	
	//to post the login form
	@PostMapping("user/login")
	public String login(User user) {
		BCryptPasswordEncoder bCrypt =new BCryptPasswordEncoder(); 
		
		String email = user.getEmailAddress();
		String password = user.getPassword();
		
		User matchedUser = dao.findByEmailAddress(email);
		HttpSession session = request.getSession();

		
		if(matchedUser != null) {
			if(bCrypt.matches(password, matchedUser.getPassword())) {
				
				//Session code goes here
//								  attr name, attr				
				session.setAttribute("user", matchedUser);
				
				//to get user role in this session, because we will be use it later...
				session.setAttribute("userRole", matchedUser.getUserRole());
				
				session.setAttribute("message", "You're logged in sccessfully");
				
				return "redirect:/";
			}
		}
		
		session.setAttribute("message", "Email or Password is Incorrect");
		return "redirect:/user/login";
	}
	
	
	//to log the user out
	@GetMapping("user/logout")
	public String logout() {
		
		HttpSession session = request.getSession();
		session.invalidate();// remove attributes /destroy information all session in this application
		//session.removeAttribute("user"); // remove attributes one by one .. so for good practise is to user invalidate method
		
		
		return "redirect:/user/login";
	}
	
	
	
	  //to check if user is logged in or not 
  public boolean isUserLoggedIn() {
	  
	  HttpSession session = request.getSession();
	  
	  if(session.getAttribute("user") == null) return false;
	  
	 return true; 
   }


}