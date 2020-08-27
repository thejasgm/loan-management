package com.scb.pod2.loanmanagementservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.scb.pod2.loanmanagementservice.model.LoanManagementEnity;
import com.scb.pod2.loanmanagementservice.service.LoanSearchService;



@RestController
public class LoanSearchController {
	
	//private Logger LOGGER = LoggerFactory.getLogger(LoanSearchController.class);

	
	@Autowired
	private LoanSearchService service;
	

	
	@GetMapping("/loanmanagement/data/users/{id}")
	public List<LoanManagementEnity> retrieveLoanDataByUsers(@PathVariable int id) {
		List<LoanManagementEnity> userOptional = service.retriveLoanMangementByUSer(id);
		
		return userOptional;
	}
	
	@GetMapping("/loanmanagement/data")
	public List<LoanManagementEnity> retrieveAllLoanData() {
		List<LoanManagementEnity> userOptional = service.retriveAllLoanMangement();
		
		return userOptional;
	}
	
}
