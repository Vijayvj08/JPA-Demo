package com.banking.banking_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.banking_system.models.Account;
import com.banking.banking_system.models.Transaction;
import com.banking.banking_system.services.AccountService;
import com.banking.banking_system.services.TransactionService;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private AccountService accountService;
	
	//get transaction history by account number
	@GetMapping("/{accountNumber}")
	public ResponseEntity<List<Transaction>> getTransaction(@PathVariable String accountNumber){
		Account account = accountService.findAccountByNumber(accountNumber)
						  .orElseThrow(()-> new RuntimeException("Account not found"));
		return ResponseEntity.ok(transactionService.getTransactionByAccount(account));
	}
}
