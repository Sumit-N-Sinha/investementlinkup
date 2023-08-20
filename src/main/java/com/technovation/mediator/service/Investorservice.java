package com.technovation.mediator.service;

import java.util.List;

import com.technovation.mediator.dto.InvestorDTO;
import com.technovation.mediator.entity.Investor;

public interface Investorservice {
	
	Investor addInvestor(InvestorDTO inv) throws Exception;
	Investor updateInvestor(Investor  inv,Integer id) throws Exception;
    String removeInvestor(Integer id) throws Exception;
	List<Investor> viewAllInvestors() throws Exception;
	Investor viewInvestorById(Integer id) throws Exception;
	List<Investor> findByName(String firstName);
}
