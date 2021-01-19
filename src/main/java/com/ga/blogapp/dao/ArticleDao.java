package com.ga.blogapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.blogapp.model.Article;
import com.ga.blogapp.model.Author;

public interface ArticleDao extends CrudRepository<Article, Integer> {
	// all needed function are in CrudRepository interface 
	
	
	//this function is the same as 
	public Article findById(int id);
	
}
//DAO / Dao = Document Access Model
//way of access / communicate between objects and relational DB 
