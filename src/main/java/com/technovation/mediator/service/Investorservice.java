package com.technovation.mediator.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.technovation.mediator.entity.Investor;

public interface Investorservice {
	
	public Investor addInvestor(Investor inv);
	public Investor updateInvestor(Investor  inv,Integer id) throws Exception;
    public String removeInvestor(Integer id) throws Exception;
	List<Investor> viewAllInvestors() throws Exception;
	Investor viewInvestorById(Integer id) throws Exception;
}
