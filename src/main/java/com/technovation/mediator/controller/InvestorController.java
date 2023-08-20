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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.technovation.mediator.dto.InvestorDTO;
import com.technovation.mediator.entity.Investor;
import com.technovation.mediator.service.InvestorServiceImpl;
import com.technovation.mediator.service.Investorservice;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="*")
public class InvestorController {

	@Autowired
	private Investorservice iserv;

	@GetMapping("investor/{id}")
	public ResponseEntity<?> getInvestor(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(iserv.viewInvestorById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("investor")
	public ResponseEntity<?> getAllInvestors() {
		try {
			return new ResponseEntity<>(iserv.viewAllInvestors(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

		}
	}
	
	@GetMapping("/investor/getByName/")
	public ResponseEntity<?> getInvestorByNamed(@RequestParam String firstName){
		return new ResponseEntity<>(iserv.findByName(firstName),HttpStatus.ACCEPTED);
	}

	@PostMapping("investor")
	public Object addInvestor(@RequestBody InvestorDTO pr) {
		try {
			iserv.addInvestor(pr);
			return new ResponseEntity<>("Investor profile Added! \n" + pr.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Bad Request made", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("investor/{id}")
	public ResponseEntity<?> updateinvestor(@PathVariable("id") Integer id, @RequestBody Investor pr) {
		try {
			return new ResponseEntity<>(iserv.updateInvestor(pr, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}

	@DeleteMapping("investor/{id}")
	public ResponseEntity<?> removeinvestor(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(iserv.removeInvestor(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}

}
