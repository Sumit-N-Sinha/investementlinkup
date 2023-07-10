package com.technovation.mediator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technovation.mediator.entity.Investor;
import com.technovation.mediator.repository.InvestorRepository;

@Service
public class InvestorServiceImpl implements Investorservice {

	@Autowired
	private InvestorRepository invRepo;
	
	@Override
	public Investor addInvestor(Investor inv) {
		return invRepo.save(inv);
	}

	@Override
	public Investor updateInvestor(Investor inv, Integer id) throws Exception  {
		Investor inves = null;
		if (invRepo.existsById(id)) {
			inves = invRepo.findById(id).get();
			inves.setFirstName(inv.getFirstName());
			inves.setLastName(inv.getLastName());
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
		List l1 = (List<Investor>) invRepo.findAll();
		if(l1.isEmpty()) {
			throw new Exception("List is Empty. Add new Products.");
		}
		else {
			return l1;
		}
	}

}
