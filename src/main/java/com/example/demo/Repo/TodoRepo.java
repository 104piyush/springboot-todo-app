package com.example.demo.Repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Todo;
import com.example.demo.model.User;

public interface TodoRepo extends JpaRepository<Todo, Long>{

	List<Todo> findByUser(User user);

}
