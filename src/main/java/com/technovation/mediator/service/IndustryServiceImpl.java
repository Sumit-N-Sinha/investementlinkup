package com.technovation.mediator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technovation.mediator.entity.Industry;
import com.technovation.mediator.repository.IndustryRepo;

@Service
public class IndustryServiceImpl implements IndustryService {

	@Autowired
	private IndustryRepo indRepo;

	@Override
	public List<Industry> getAllIndustry() {
		
		return indRepo.findAll();
	}
	
	
}
