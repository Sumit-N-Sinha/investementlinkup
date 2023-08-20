package com.technovation.mediator.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technovation.mediator.controller.UserControl;
import com.technovation.mediator.dto.StartUpDTO;
import com.technovation.mediator.entity.StartsUp;
import com.technovation.mediator.entity.User;
import com.technovation.mediator.entity.UserRole;
import com.technovation.mediator.repository.StartsUpRepository;
import com.technovation.mediator.repository.UserRepository;


@Service
public class StartupServiceImpl implements StartupService {

	@Autowired
	private StartsUpRepository startsUpRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserControl userControl;

	private User user;

	@Override
	public List<StartsUp> findAllStartup() throws Exception {
		user = userControl.getCurrentUser();
		if(user.getUserRole().compareTo(UserRole.STARTUP)==0) {
			return startsUpRepository.findAll();
		}else {
			throw new Exception("Invalid User");
		}
	}

	@Override
	public StartsUp findById(@Valid Integer id) throws Exception {
		user = userControl.getCurrentUser();
		if(user.getUserRole().compareTo(UserRole.STARTUP)==0) {
			StartsUp st = new StartsUp();
			st = startsUpRepository.findById(id).get();
			if(user.getName().equals(st.getFounderName())){
				return startsUpRepository.findById(id).get();
			}else {
				throw new Exception("Not Authorized");
			}
		}else {
			throw new Exception("Invalid User");
		}
	}

	@Override
	public String deleteById(Integer id) throws Exception {
		user = userControl.getCurrentUser();
		if(user.getUserRole().compareTo(UserRole.STARTUP)==0) {
			StartsUp st = new StartsUp();
			st = startsUpRepository.findById(id).get();
			if(user.getName().equals(st.getFounderName())){
				startsUpRepository.deleteById(id);
				return "Deleted";
			}
			return "Startup not found.";
		}else {
			throw new Exception("Invalid User");
		}
	}

	@Override
	public StartsUp createNew(@Valid StartUpDTO startsUp) throws Exception {
		user = userControl.getCurrentUser();
		if(user.getUserRole().compareTo(UserRole.STARTUP)==0 ) {
			if(startsUpRepository.findByCompanyEmail(startsUp.getCompanyEmail())==null) {
				StartsUp st = new StartsUp();
				st.getStartId();
				st.setFounderName(user.getName());
				st.setCompanyEmail(startsUp.getCompanyEmail());
				st.setCompanyName(startsUp.getCompanyName());
				st.setDescription(startsUp.getDescription());
				st.setIndustryType(startsUp.getIndustryType());
				st.setLocation(startsUp.getLocation());
				st.setServices(startsUp.getServices());
				st.setTotalValuation(startsUp.getTotalValuation());
				st.setUser(userRepository.findByName(user.getName()));
				return startsUpRepository.save(st);
			}else {
				throw new Exception("Already Registered...");
			}
		}else {
			throw new Exception("Invalid User");
		}
	}

	@Override
	public StartsUp findbyName(String name) throws Exception {
		user = userControl.getCurrentUser();
		if(user.getUserRole().compareTo(UserRole.STARTUP)==0) {
			StartsUp st = new StartsUp();
			st = startsUpRepository.findByFounderName(name).get();
			if(user.getName().equals(st.getFounderName())){
				return startsUpRepository.findByFounderName(name).get();
			}else {
				throw new Exception("Not Authorized");
			}
		}else {
			throw new Exception("Invalid User");
		}
	}


}
