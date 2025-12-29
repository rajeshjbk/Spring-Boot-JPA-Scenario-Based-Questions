package com.raj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.Account;
import com.raj.exception.AccountNotFoundException;
import com.raj.repository.IAccountRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountRepository accountRepo;

	@Override
	public String openAccount(Account account) {

		Integer accountId = accountRepo.save(account).getAccountId();
		return "New Account is opened with Account ID: "+accountId;
	}

	@Override
	public String depositeMoney(int acno, double amount) {

		Account account = accountRepo.findById(acno).orElseThrow(()-> new AccountNotFoundException("Invalid Account number."));
		account.setBalance(account.getBalance()+amount);

		return amount+" is deposited to Bank Account:: "+acno;
	}

	@Override
	public String withdrawMoney(int acno, double amount) {

		Account account = accountRepo.findById(acno).orElseThrow(()-> new AccountNotFoundException("Invalid Account number."));
		account.setBalance(account.getBalance()-amount);

		return amount+" is withdrawn from Bank Account:: "+acno;
	}

	@Override
	@Transactional
	public String transferMoney(int srcAcc, int destAcc, double amount) {
		
		withdrawMoney(srcAcc, amount);
		depositeMoney(destAcc, amount);
		
		return "Money Transfered from "+srcAcc+" to "+destAcc;
	}

}
