package com.scb.pod2.loanmanagementservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.pod2.loanmanagementservice.dao.LoanSearchRepository;
import com.scb.pod2.loanmanagementservice.dao.UserRepository;
import com.scb.pod2.loanmanagementservice.model.LoanManagementEnity;
import com.scb.pod2.loanmanagementservice.model.User;

@Service
public class LoanSearchService {

	@Autowired
	private UserRepository userDAO;
	
	@Autowired
	private LoanSearchRepository loanManagementDAO;
	

	public List<LoanManagementEnity> retriveLoanMangementByUSer(int id) {
		Optional<User> userOptional = userDAO.findById(id);
		return userOptional.get().getLoanManagement();
	}

	public List<LoanManagementEnity> retriveAllLoanMangement() {
		return loanManagementDAO.findAll();
			}

	
}
