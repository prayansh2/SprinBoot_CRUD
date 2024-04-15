package com.prayansh.prac.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prayansh.prac.Entity.User;
import com.prayansh.prac.Repository.UserRepo;
import com.prayansh.prac.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;
	@Override
	public User createUser(User user) {
		User save = this.repo.save(user);
		 return save;
	}

	@Override
	public User updateUser(User user,Integer id) {
		User userbyid = this.repo.findById(id).get();
		userbyid.setBio(user.getBio());
		userbyid.setName(user.getName());
		userbyid.setUsername(user.getUsername());
		userbyid.setPassword(user.getPassword());
		User save = this.repo.save(userbyid);
		return save;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> findAll = this.repo.findAll();
		return findAll;
	}

	@Override
	public User getUserById(Integer id) {
		User user = this.repo.findById(id).get();
		return user;
	}

	@Override
	public void deleteUser(Integer id) {
		User user = this.repo.findById(id).get();
		this.repo.delete(user);
		
	}

}
