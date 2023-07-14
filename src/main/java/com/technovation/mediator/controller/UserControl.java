package com.technovation.mediator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.technovation.mediator.dto.UserLogin;
import com.technovation.mediator.entity.User;
import com.technovation.mediator.service.UserServ;

@RestController
@RequestMapping("/user/")
@CrossOrigin(origins = "*",maxAge = 3000)
public class UserControl {

	@Autowired
	private UserServ userServ;
	
	@GetMapping("/getAll")
	public List<User> getUser(){
		return userServ.findAll();
	}
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) throws Exception {
		return userServ.saveUser(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody UserLogin userLogin) throws Exception {
		String email = userLogin.getEmail();
		String password = userLogin.getPassword();
		return userServ.login(email,password);
	}
	
	@GetMapping("/currentUser")
	public User getCurrentUser() {
		return userServ.getCurrentUser();
	}
	
	@GetMapping("/logout")
	public User getDefaultUser() {
		return userServ.logOut();
	}
}
