package com.prayansh.prac.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prayansh.prac.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
