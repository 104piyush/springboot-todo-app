package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {


	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String registrationPage() {
		return "registration";
	}
	
	@PostMapping("/doRegister")
	public String doRegister(@ModelAttribute User user , Model model) {
		if (userService.isNameExists(user.getName())){
			model.addAttribute("error" ,"user name already exits");
			return "registration";
		}
		userService. saveUser(user) ;
		model.addAttribute("mgs" ,"user successfully register");
		return "login";
	}
	
	
	@GetMapping("/login")
    public String loginPage() {
        return "login";
    }
	 @PostMapping("/doLogin")
	    public String doLogin(@RequestParam String name,
	                          @RequestParam String password,
	                          Model model,
	                          HttpSession session) {
	        User user = userService.getByNameAndPassword(name, password);
	        if (user != null) {
	        	session.setAttribute("loggedUserName", user.getName());
	            return "redirect:/dashboard";
	        } else {
	            model.addAttribute("error", "Invalid name or password");
	            return "login";
	        }
	    }

}
