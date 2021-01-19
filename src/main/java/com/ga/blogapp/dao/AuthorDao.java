package com.ga.blogapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.blogapp.model.Author;

public interface AuthorDao extends CrudRepository<Author, Integer> {
	// all needed function are in CrudRepository interface 
	
	
	//Methods
	public Author findById(int id);
	
}


//Data Access Object
//Way to communicate between model and DB
//CrudRepository: ==> Search !