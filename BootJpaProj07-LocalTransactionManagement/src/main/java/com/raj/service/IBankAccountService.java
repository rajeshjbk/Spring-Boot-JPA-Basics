package com.raj.service;

import com.raj.entity.BankAccount;

public interface IBankAccountService {

String openBankAccount(BankAccount account);
	
	String withdrawAmount(long acno, double amount);
	
	String depositeAmount(long acno, double amount);
	
	String transferMoney(long srcAcno, long destAcno, double amount);
	
}
