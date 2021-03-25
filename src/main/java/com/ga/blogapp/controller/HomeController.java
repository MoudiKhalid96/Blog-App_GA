package com.ga.blogapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class HomeController {

	@Autowired 
	private Environment env;
	
	@Autowired
	private HttpServletRequest request;
	
	// HTTP GET REQUEST - Root Route
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("home/index");
		
		setAppName(mv, env);
		return mv;
	}
	
	// Setting an App name (Other common properties)
	public ModelAndView setAppName(ModelAndView mv, Environment env) {
		String appName = env.getProperty("app.name");
		mv.addObject("appName", appName);
		mv.addObject("blogapp", "Blog App");

		return mv;
	}
	
}