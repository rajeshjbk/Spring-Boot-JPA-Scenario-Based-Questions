package com.raj.service;

import com.raj.entity.Account;

public interface IAccountService {

	String openAccount(Account account);
	String depositeMoney(int acno, double amount);
	String withdrawMoney(int acno, double amount);
	String transferMoney(int srcAcc, int destAcc, double amount);
}
