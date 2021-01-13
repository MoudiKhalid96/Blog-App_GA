package com.ga.blogapp.test;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

@RestController
public class API {

//	
//	@Autowired
//	private Environment env;
//	
//	@GetMapping("/hello")
//	public String hello() {
//		return "Our app is working";
//	}
//	
//	
//	@GetMapping("/") // root route
//	public HashMap<String, String> rootRoute(@RequestParam(defaultValue = "World") String name) {
//		
//		HashMap<String, String> response = new HashMap();
//				   // key	  ,  value
//		response.put("message", "Hello " + name + " !, how are you?");
//		response.put("course", "Java Immersive Course");
//		
//		System.out.println(env.getProperty("app.name"));
//		
//		return response;
//	}
//	/*
//	 * it will be considered as JSON when using this HashMap ..
//	 * massage , course .. all these are keys which will be read as a JSON*/
	
	
}
