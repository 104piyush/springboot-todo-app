package com.example.demo.Repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByName(String name);
		
}
