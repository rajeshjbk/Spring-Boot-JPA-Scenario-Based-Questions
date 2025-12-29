package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Integer> {

}
