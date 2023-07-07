package com.technovation.mediator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technovation.mediator.entity.Industry;
import com.technovation.mediator.service.IndustryService;

@RestController
@RequestMapping("/industry/")
public class IndustryController {

	@Autowired
	private IndustryService indService;
	
	@GetMapping("/getAll")
	public List<Industry> getIndustry(){
		return indService.getAllIndustry();
	}
	
}
