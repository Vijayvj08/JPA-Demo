package com.banking.banking_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.banking_system.models.Account;
import com.banking.banking_system.models.User;
import com.banking.banking_system.services.AccountService;
import com.banking.banking_system.services.UserService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserService userService;
	
	//create new account for user
	@PostMapping("/create/{username}")
	public ResponseEntity<Account> createAccount(@PathVariable String username, @RequestBody Account account){
		User user = userService.getUserByUsername(username)
				    .orElseThrow(()-> new RuntimeException("UserName not found"));
		account.setUser(user);
		return ResponseEntity.ok(accountService.createAccount(account));
	}
	
	//Get all accounts of a user
	@GetMapping("/user/{username}")
	public ResponseEntity<List<Account>> getUserAccounts(@PathVariable String username){
		User user = userService.getUserByUsername(username)
					.orElseThrow(()-> new RuntimeException("User Not Found"));
		return ResponseEntity.ok(accountService.findAccountsByUser(user));
	}
	
	//Get all account by acc number
		@GetMapping("/account/{accountNumber}")
		public ResponseEntity<Optional<Account>> getAccount(@PathVariable String accountNumber){
			return ResponseEntity.ok(accountService.findAccountByNumber(accountNumber));
		}
	
	//Deposit
	@PostMapping("/deposit/{accountNumber}")
	public ResponseEntity<Account> deposit(@PathVariable String accountNumber, @RequestParam Double amount){
		return ResponseEntity.ok(accountService.deposit(accountNumber, amount));
	}
	
	//Withdraw
	@PostMapping("/withdraw/{accountNumber}")
	public ResponseEntity<Account> withdraw(@PathVariable String accountNumber, @RequestParam Double amount){
		return ResponseEntity.ok(accountService.withdraw(accountNumber, amount));
	}
	
	//Transfer
	@PostMapping("/transfer")
	public ResponseEntity<String> transfer(@RequestParam String fromAccNo, @RequestParam String toAccNo, @RequestParam Double amount){
		accountService.transfer(fromAccNo, toAccNo, amount);
		return ResponseEntity.ok("Transfer Successful");
	}
	
}
