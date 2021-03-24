//package com.ga.blogapp.controller;
//
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.core.env.Environment;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.web.servlet.ModelAndView;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; // A ResultMatcher matches the result of an executed request against some expectation.
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.ga.blogapp.dao.UserDao;
//import com.ga.blogapp.model.User;
//
//import ch.qos.logback.core.net.ObjectWriter;
//
//import org.springframework.http.MediaType;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.List;
//@RunWith(SpringRunner.class) //tells JUnit to use spring boot testing
//@WebMvcTest(UserController.class) // focuses on this component
//class UserControllerTest {
//	@Autowired
//	private MockMvc mockMvc;
//	@MockBean
//	private UserDao userDao;
//	
////	@Test
////	public void hello_ReturnsString_Success() throws Exception{
////		RequestBuilder requestBuilder = MockMvcRequestBuilders // mock implementation HTTP request 
////	                                  .get("/hello");
////		mockMvc.perform(requestBuilder)
////		       .andExpect(status().isOk())
////		       .andExpect(forwardedUrl("/views/Hi.jsp"));
////	}
//	
//	
//	//this test now is for request..
//	@Test
//	public void hello_ReturnsString_Success() throws Exception{
//		
//		UserController uc = new UserController();
//		String real = uc.hello();
//		String expected = "Hi"; // the expected String to be returned ad a tested
//		
//		Assert.assertEquals(real, expected); // test the real and expected coming string 
//		
//	}
//	
//	@Autowired 
//	private UserDao dao;
////	
////	@Test
////	public void login_Redirect_Success() throws Exception {
////		
////		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();// give a new user rather than communicating with DB
////		String newPassword = bc.encode("12345");// give him a password to compare with the given.. then compare same password one encrypted and one not-encrypted
////		
////		//Mockito is frame work of mocks .. whenever there is a calling this function in real
////		//Mock is like replace of origin... 
////		Mockito.when(dao.findByEmailAddress("a@b")).thenReturn(new User(newPassword));
////		
////		RequestBuilder rb = MockMvcRequestBuilders.post("/user/login")
////							.param("emailAddress", "a@b")
////							.param("password", "12345");
////		
////		mockMvc.perform(rb).andExpect(status().is3xxRedirection())
////				.andExpect(redirectedUrl("/user/login"));
////		
////		
////		
////		/* this scenario we have imagine where the user should be redirected after do the login
////		 * first  we have created new password and encrypt it
////		 * then create new dummy request using `Mock`
////		 * say's .. if user reaches this line don't go to the DB
////		 * we're giving you a new password as if it's from the user (so like that we don't have to communicate with DB)
////		 * after that we assumed once the user entered the right password
////		 * as a test case, and one is for wrong password 
////		 * */
////		
////	}
//	
//	@Test
//	public void register_notRegistered() throws Exception { // test when trying to register a user that exists
//		Iterable<User> iterable = Arrays.asList(new User("12345", "a@b"), new User("123", "a@c"));
//		Mockito.when(dao.findAll()).thenReturn(iterable);
//
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/registration").param("emailAddress", "a@b")
//				.param("firstName", "samar").param("lastName", "fares").param("userRole", "admin")
//				.param("password", "12345").contentType(MediaType.APPLICATION_JSON);
//
//		mockMvc.perform(requestBuilder).andExpect(status().isOk())
//				.andExpect(model().attribute("message", "User already exists"));
//
//		;
//
//	}
//
///*
////		 * 1- take input
////		 * 2- check if it's exists or not
////		 * 3- return the direction*/
//	
//}