package com.technovation.mediator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.technovation.mediator.entity.User;
import com.technovation.mediator.entity.UserRole;
import com.technovation.mediator.repository.UserRepository;

@Service
public class UserServImpl implements UserServ{

	@Autowired
	private UserRepository userRepository;
	
	private String s;

	@Override
	public User fetchEmail(String email) {
		return userRepository.findByEmailId(email);
	}

	@Override
	public User fetchEmailPass(String tempEmail, String tempPass) {
		return userRepository.findByEmailIdAndPassword(tempEmail,tempPass);
	}

	@Override
	public User saveUser(User user) throws Exception {
		String tempEmail = user.getEmailId();
		if(tempEmail!=null && !"".equals(tempEmail)) {
			User mail = fetchEmail(tempEmail);
			if(mail != null){
				throw new Exception("Email already present");
			}
		}
		user.setId(user.getId());
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public ResponseEntity<User> login(String email, String password) {
		String tempEmail = email;
		String tempPass = password;
		User userObj = null;
		if(tempEmail != null && tempPass != null) {
			userObj = fetchEmailPass(tempEmail,tempPass);
		}
		if(userObj == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			s = tempEmail;
			return new ResponseEntity<>(fetchEmail(tempEmail),HttpStatus.ACCEPTED);
		}
	}
	
	public User getCurrentUser() {
		return userRepository.findByEmailId(s);
	}

	@Override
	public User logOut() {
		if(this.getCurrentUser()!=userRepository.findByUserRole(UserRole.DEFAULT)) {
			s = userRepository.findByUserRole(UserRole.DEFAULT).getEmailId();
			
		}
		return userRepository.findByUserRole(UserRole.DEFAULT);
	}
}
