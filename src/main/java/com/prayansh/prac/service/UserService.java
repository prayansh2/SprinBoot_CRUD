package com.prayansh.prac.service;

import java.util.List;

import com.prayansh.prac.Entity.User;

public interface UserService {
	
	//create User
	User createUser(User user);
	
	//update User
	User updateUser(User user,Integer id);
	
	//get All Users
	List<User> getAllUsers();
	
	//getUserById
	User getUserById(Integer id);
	
	//delete User
	void deleteUser(Integer id);
}
