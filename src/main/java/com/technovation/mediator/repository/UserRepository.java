package com.technovation.mediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technovation.mediator.entity.User;
import com.technovation.mediator.entity.UserRole;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmailId(String emailId);

	public User findByEmailIdAndPassword(String tempEmail, String tempPass);
	
	public User findByUserRole(UserRole userRole);

	public User findByName(String founderName);
}
