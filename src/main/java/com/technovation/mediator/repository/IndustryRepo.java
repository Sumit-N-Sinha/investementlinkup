package com.technovation.mediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technovation.mediator.entity.Industry;

@Repository
public interface IndustryRepo extends JpaRepository<Industry, Integer> {

}
