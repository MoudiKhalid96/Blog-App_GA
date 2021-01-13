package com.ga.blogapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HomeController {

	//HTTP GET REQUEST - Root Route 
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("home/index");
		mv.addObject("Welcome", "Welcome to our Blog App");
		mv.addObject("Moudi", "This is your first website :D");
		return mv;
	}
}
