package com.example.demo.controller;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Todo;
import com.example.demo.model.User;
import com.example.demo.service.TodoService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@Autowired
    private UserService userService;

	
	@PostMapping("/addTodo")
	public String addTodo(@RequestParam String title,@RequestParam String description, @RequestParam String dueDate,HttpSession session) {
			String name = (String)session.getAttribute("loggedUserName");
			User user = userService.getByName(name);
			
			Todo todo = new Todo();
			todo.setTitle(title);
			todo.setDescription(description);
			todo.setDueDate(LocalDate.parse(dueDate));
			todo.setUser(user);
			
			todoService.saveTodo(todo);
			return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String getAllList(HttpSession session, Model model) {
	    String name = (String) session.getAttribute("loggedUserName");
	    if (name == null) return "redirect:/login";

	    User user = userService.getByName(name);
	    model.addAttribute("todos", todoService.getTodoByUser(user));
	    return "dashboard";
	}

	
	@GetMapping("/deleteTodo")
	public String deleteTodo(@RequestParam long id) {
		  todoService.deleteById(id);
	        return "redirect:/dashboard";
	    
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/login"; 
	}

}
