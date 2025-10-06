package com.banking.banking_system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.banking_system.models.Account;
import com.banking.banking_system.models.User;
import com.banking.banking_system.repo.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionService transactionService;
	
	//create new account
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}
	
	//find by account number
	public Optional<Account> findAccountByNumber(String accountNumber){
		return accountRepository.findByAccountNumber(accountNumber);
	}
	
	//Get all account for a User
	public List<Account> findAccountsByUser(User user){
		return accountRepository.findByUser(user);
	}
	
	//Deposit Money
	public Account deposit(String accountNumber, double amount) {
		Account acc = accountRepository.findByAccountNumber(accountNumber)
					  .orElseThrow(()-> new RuntimeException("Account Not Found"));
		acc.setBalance(acc.getBalance() + amount);
		accountRepository.save(acc);
		
		
		//record transaction
		transactionService.recordTransaction("Deposit", amount, null, accountNumber, acc);
		
		return acc;
	}
	
	//Withdraw money
	public Account withdraw(String accountNumber, Double amount) {
		Account acc = accountRepository.findByAccountNumber(accountNumber)
					  .orElseThrow(()-> new RuntimeException("Account Not Found"));
		if(acc.getBalance() < amount) {
			throw new RuntimeException("Insufficient Balance");
		}
		acc.setBalance(acc.getBalance() - amount);
		accountRepository.save(acc);
		
		//record transaction
		transactionService.recordTransaction("Deposit", amount, accountNumber, null, acc);
		
		return acc;
	}
	
	//Transfer Between Two Accounts
	public void transfer(String fromAccNo, String toAccNo, Double amount) {
		Account fromAcc = accountRepository.findByAccountNumber(fromAccNo)
						  .orElseThrow(()-> new RuntimeException("Account Not Found"));
		Account toAcc = accountRepository.findByAccountNumber(toAccNo)
				  .orElseThrow(()-> new RuntimeException("Account Not Found"));
		
		if (fromAcc.getBalance() < amount) {
			throw new RuntimeException("Insufficient Balance");
		}
		
		fromAcc.setBalance(fromAcc.getBalance() - amount);
		toAcc.setBalance(toAcc.getBalance() + amount);
		
		accountRepository.save(fromAcc);
		accountRepository.save(toAcc);
		
		// Record transactions
        transactionService.recordTransaction("TRANSFER_OUT", amount, fromAccNo, toAccNo, fromAcc);
        transactionService.recordTransaction("TRANSFER_IN", amount, fromAccNo, toAccNo, toAcc);
	}

}
