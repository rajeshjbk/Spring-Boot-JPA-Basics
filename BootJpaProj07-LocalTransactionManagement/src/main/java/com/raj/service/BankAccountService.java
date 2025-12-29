package com.raj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.BankAccount;
import com.raj.exception.BankAccountNotFoundException;
import com.raj.repository.IBankAccountRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class BankAccountService implements IBankAccountService {

	@Autowired
	private IBankAccountRepository bankAccountRepo;

	@Override
	public String openBankAccount(BankAccount account) {

		//save the object
		account.setOpenedBy(System.getProperty("user.name"));

		Long acno = bankAccountRepo.save(account).getAcno();

		return "Bank account is opened having account number:: "+acno;
	}

	@Override
	public String withdrawAmount(long acno, double amount) {

		//Load object
		BankAccount account = bankAccountRepo.findById(acno).orElseThrow(()->new BankAccountNotFoundException("Invalid Account number."));

		//write the withdaw logic
		account.setAmount(account.getAmount()-amount);
		account.setUpdatedBy(System.getProperty("user.name"));
		bankAccountRepo.save(account);

		return amount+ " is withdrawn from Bank account:: "+acno;
	}

	@Override
	public String depositeAmount(long acno, double amount) {

		//Load object
		BankAccount account = bankAccountRepo.findById(acno).orElseThrow(()->new BankAccountNotFoundException("Invalid Account number."));

		//write the deposite logic
		account.setAmount(account.getAmount()+amount);
		account.setUpdatedBy(System.getProperty("user.name"));
		bankAccountRepo.save(account);

		return amount+ " is deposited to Bank account:: "+acno;
	}

	@Override
	public String transferMoney(long srcAcno, long destAcno, double amount) {

          withdrawAmount(srcAcno, amount);
          depositeAmount(destAcno, amount);
          
		return "Money Transfered from "+srcAcno+" to "+destAcno;
	}

}
