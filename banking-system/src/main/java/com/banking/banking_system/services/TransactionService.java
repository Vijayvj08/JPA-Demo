package com.banking.banking_system.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.banking_system.models.Account;
import com.banking.banking_system.models.Transaction;
import com.banking.banking_system.repo.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	//record transaction
	public Transaction recordTransaction(String type, Double amount, String fromAccount, String toAccount, Account account) {
		Transaction t = new Transaction();
		t.setType(type);
		t.setAmount(amount);
		t.setFromAccount(fromAccount);
		t.setToAccount(toAccount);
		t.setDate(LocalDateTime.now());
		t.setAccount(account);
		
		return transactionRepository.save(t);
	}
	
	//get transaction history for an account
	public List<Transaction> getTransactionByAccount(Account acount){
		return transactionRepository.findByAccount(acount);
	}
}
