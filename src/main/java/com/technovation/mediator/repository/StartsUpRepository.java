package com.technovation.mediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technovation.mediator.entity.StartsUp;

@Repository
public interface StartsUpRepository extends JpaRepository<StartsUp, Integer>{

	StartsUp findByCompanyEmail(String companyEmail);

}
