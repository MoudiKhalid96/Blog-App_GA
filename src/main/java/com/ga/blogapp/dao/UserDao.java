package com.ga.blogapp.dao;

import org.springframework.data.repository.CrudRepository;
import com.ga.blogapp.model.User;

//								   Name of the model, data-type of the PK
public interface UserDao extends CrudRepository<User, Integer>{

	//findBy .. is a word that Crud understand as SELECT
	//this is like hint `findBy`
	//it check by id or any thing is can be searched 
	User findByEmailAddress(String email);
	
}
