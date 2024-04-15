package com.prayansh.prac.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prayansh.prac.Entity.User;
import com.prayansh.prac.ServiceImpl.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl serv;
	
	@PostMapping("")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User createUser = this.serv.createUser(user);	
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Integer id)
	{
		User updateUser = this.serv.updateUser(user, id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id)
	{
		User userById = this.serv.getUserById(id);
		return new ResponseEntity<User>(userById,HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> allUsers = this.serv.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HashMap<String , String>> deleteUser(@PathVariable Integer id)
	{
		this.serv.deleteUser(id);
		HashMap<String , String> m=new HashMap<>();
		m.put("Message", "User deleted Successfully");
		return new ResponseEntity<HashMap<String ,String>>(m,HttpStatus.OK);
	}
	
	
	
	
}
