package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.UserRepo;
import com.example.demo.model.User;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
		
	public boolean isNameExists(String name) {
		return userRepo.findByName(name) != null;
	}
	
	public void saveUser(User user) {
        userRepo.save(user);
    }
	
	 public User getByNameAndPassword(String name, String password) {
	        User user = userRepo.findByName(name);
	        if (user != null && user.getPassword().equals(password)) {
	            return user;
	        }
	        return null;
	    }

	public  User getByName(String name) {
		return userRepo.findByName(name);
	}

	
}
