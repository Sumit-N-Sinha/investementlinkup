package com.technovation.mediator.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technovation.mediator.dto.StartUpDTO;
import com.technovation.mediator.entity.StartsUp;
import com.technovation.mediator.service.StartupService;

@RestController
@RequestMapping("/apps/v2/")
@CrossOrigin(origins="*")
public class StartupController {

	@Autowired
	private StartupService startupService;
	
	@GetMapping("/startup/")
	public ResponseEntity<?> getAllStartUp() throws Exception{
		return new ResponseEntity<>(startupService.findAllStartup(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/startup/{id}")
	public ResponseEntity<StartsUp> getStartUpById(@PathVariable Integer id) throws Exception{
		return new ResponseEntity<>(startupService.findById(id),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/startup/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) throws Exception{
		return new ResponseEntity<>(startupService.deleteById(id),HttpStatus.OK);
	}
	
	@PostMapping("/startup/create/")
	public ResponseEntity<StartsUp> createNew(@Valid @RequestBody StartUpDTO startsUp) throws Exception{
		return new ResponseEntity<>(startupService.createNew(startsUp),HttpStatus.CREATED);
	}
}
