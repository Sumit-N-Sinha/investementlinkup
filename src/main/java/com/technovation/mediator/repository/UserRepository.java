package com.technovation.mediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technovation.mediator.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmailId(String emailId);

	public User findByEmailIdAndPassword(String tempEmail, String tempPass);
}
