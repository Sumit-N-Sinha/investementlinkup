package com.technovation.mediator.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technovation.mediator.controller.UserControl;
import com.technovation.mediator.dto.InvestorDTO;
import com.technovation.mediator.entity.Investor;
import com.technovation.mediator.entity.StartsUp;
import com.technovation.mediator.entity.User;
import com.technovation.mediator.entity.UserRole;
import com.technovation.mediator.repository.InvestorRepository;


@Service
public class InvestorServiceImpl implements Investorservice {

	@Autowired
	private InvestorRepository invRepo;
	
	@Autowired
	private UserControl userControl;
	
	private User user;
	
	@Override
	public Investor addInvestor(InvestorDTO pr) throws Exception {
		user = userControl.getCurrentUser();
		if(user.getUserRole().compareTo(UserRole.INVESTOR)==0) {
			Investor inv = new Investor();
			inv.getInvId();
			inv.setAmountInvested(pr.getAmountInvested());
			inv.setEmail(pr.getEmail());
			inv.setFirstName(pr.getFirstName());
			inv.setIndustry(pr.getIndustry());
			inv.setStartUpsInvested(pr.getStartUpsInvested());
			inv.setUser(userControl.getCurrentUser());
			return invRepo.save(inv);			
		}else {
			throw new Exception("Invalid User");
		}
	}

	@Override
	public Investor updateInvestor(Investor inv, Integer id) throws Exception  {
		Investor inves = null;
		if (invRepo.existsById(id)) {
			inves = invRepo.findById(id).get();
			inves.setFirstName(inv.getFirstName());
			inves.setEmail(inv.getEmail());
			inves.setIndustry(inv.getIndustry());
			inves.setStartUpsInvested(inv.getStartUpsInvested());
			inves.setAmountInvested(inv.getAmountInvested());
		}
		else {
			throw new Exception("No Product exists with id: "+id);
		}
			
		return invRepo.save(inves);
	}

	@Override
	public String removeInvestor(Integer id) throws Exception{
		if (invRepo.findById(id).isPresent()) {
			invRepo.deleteById(id);
			return "Deleted: Product with id: "+id;
		} else {
			throw new Exception("No product exists with id: "+id);
		}
	}

	@Override
	public Investor viewInvestorById(Integer id) throws Exception  {
		Investor pr = null;
		if (invRepo.findById(id).isEmpty()) {
			throw new Exception("No product exists with id: "+id);
		}
		else {
			pr = invRepo.findById(id).get();
		}
		return pr;
	}

	@Override
	public List<Investor> viewAllInvestors() throws Exception {
		user = userControl.getCurrentUser();				//get current user
		if(user.getUserRole().compareTo(UserRole.STARTUP)==0) {		//checking the condition
			List<Investor> l1 = invRepo.findAll();
			if(l1.isEmpty()) {
				throw new Exception("List is Empty. Add new Products.");
			}
			else {
				return l1;
			}
		}else {
			throw new Exception("Invalid User");
		}
		
		
		
	}

	public List<Investor> findByName(String firstName) {
		user = userControl.getCurrentUser();
		
		return null;
	}

}
