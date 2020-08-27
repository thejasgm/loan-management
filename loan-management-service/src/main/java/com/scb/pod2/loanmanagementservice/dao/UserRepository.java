package com.scb.pod2.loanmanagementservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.scb.pod2.loanmanagementservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

