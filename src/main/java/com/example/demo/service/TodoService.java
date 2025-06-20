package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.TodoRepo;
import com.example.demo.model.Todo;
import com.example.demo.model.User;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepo todoRepo;
	
	public void saveTodo(Todo todo) {
		todoRepo.save(todo);
	}
	
	public List<Todo> getTodoByUser(User user) {
		return  todoRepo.findByUser(user);
	}
	
	public void deleteById(long id) {
		todoRepo.deleteById(id);
	}
}
