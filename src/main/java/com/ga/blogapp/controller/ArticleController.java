package com.ga.blogapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ga.blogapp.dao.*;
import com.ga.blogapp.model.Article;

@Controller
public class ArticleController {
	

	//CRUD OPERATIONS
	// C -> Create = done
	// R -> Select = done
	// U -> Update = done
	// D -> Delete =  done
	
	@Autowired 
	private Environment env;
	
	@Autowired 
	private UserController uc;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired //I want to use this object but, by not creating an instance of it.. 
	private AuthorDao authorDao;
	
	@Autowired
	private ArticleDao dao;
	
	// HTTP GET REQUEST - Article Add
	@GetMapping("/article/add")
	public ModelAndView addArticle() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("article/add");
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		var it = authorDao.findAll();
		mv.addObject("authors", it);
		
		return mv;
	}
	
	// HTTP POST REQUEST - Article Add
	@PostMapping("/article/add")
	public String addArticle(Article article) {
		dao.save(article);
		
		return "redirect:/article/index";
	}
	
	// HTTP GET REQUEST - Article Index
	@GetMapping("/article/index")
	public ModelAndView getArticle() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("article/index");
		
		var it = dao.findAll();
		mv.addObject("articles", it);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		return mv;
	}
	
	// HTTP GET REQUEST - Article Detail
	@GetMapping("/article/detail")
	public ModelAndView articleDetails(@RequestParam int id) {
		
		Article article = dao.findById(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("article/detail");
		mv.addObject("article", article);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		return mv;	
	}

	// HTTP GET REQUEST - Article Edit
	@GetMapping("/article/edit")
	public ModelAndView editArticle(@RequestParam int id) {
		Article article = dao.findById(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("article/edit");
		mv.addObject("article", article);
		
		var it = authorDao.findAll();
		mv.addObject("authors", it);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);

		return mv;
	}
	
	// HTTP GET REQUEST - Article Delete
	@GetMapping("/article/delete")
	public String deleteArticle(@RequestParam int id) {
		
		dao.deleteById(id);
		return "redirect:/article/index";
	}

}