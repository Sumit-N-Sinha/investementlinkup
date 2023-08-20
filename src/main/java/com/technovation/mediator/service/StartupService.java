package com.technovation.mediator.service;

import java.util.List;

import javax.validation.Valid;

import com.technovation.mediator.dto.StartUpDTO;
import com.technovation.mediator.entity.StartsUp;

public interface StartupService {

	List<StartsUp> findAllStartup() throws Exception;

	StartsUp findById(Integer id) throws Exception;

	String deleteById(Integer id) throws Exception;

	StartsUp createNew(@Valid StartUpDTO startsUp) throws Exception;

	StartsUp findbyName(String founderName) throws Exception;

}
