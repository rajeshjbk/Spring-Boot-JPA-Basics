package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.BankAccount;

public interface IBankAccountRepository extends JpaRepository<BankAccount, Long> {

}
