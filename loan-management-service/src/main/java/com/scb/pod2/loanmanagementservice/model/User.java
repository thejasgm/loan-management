package com.scb.pod2.loanmanagementservice.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(unique = true)
	private String userName;

	private String password;
	
	@OneToMany(mappedBy="user")
	private List<LoanManagementEnity> loanManagement;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<LoanManagementEnity> getLoanManagement() {
		return loanManagement;
	}
	public void setLoanManagement(List<LoanManagementEnity> loanManagement) {
		this.loanManagement = loanManagement;
	}
	
	
	



}
