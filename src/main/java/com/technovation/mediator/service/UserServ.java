package com.technovation.mediator.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.technovation.mediator.entity.User;


public interface UserServ {

	User saveUser(User user) throws Exception;
	User fetchEmail(String email);
	User fetchEmailPass(String tempEmail, String tempPass);
	List<User> findAll();
	ResponseEntity<User> login(String email, String password);
	User getCurrentUser();
}
