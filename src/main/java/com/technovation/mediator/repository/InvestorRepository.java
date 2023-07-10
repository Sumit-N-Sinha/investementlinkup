package com.technovation.mediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technovation.mediator.entity.Investor;

@Repository
public interface InvestorRepository extends JpaRepository<Investor,Integer> {

}
