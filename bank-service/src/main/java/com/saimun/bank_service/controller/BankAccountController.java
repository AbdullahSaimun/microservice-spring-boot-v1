package com.saimun.bank_service.controller;

import com.saimun.bank_service.dto.BankAccountSaveDto;
import com.saimun.bank_service.model.BankAccount;
import com.saimun.bank_service.service.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/bank/accounts")
public class BankAccountController {
	private final BankAccountService  bankAccountService;

	@PostMapping("/save")
	public ResponseEntity<String> create(@RequestBody BankAccountSaveDto account) {
		return bankAccountService.createBankAccount(account);
	}

	@GetMapping("/get-all")
	public ResponseEntity<List<BankAccount>> getAll() {

		return bankAccountService.getAllBankAccount();
	}

	@GetMapping("/{id}")
	public ResponseEntity<BankAccount> getById(@PathVariable Long id) {
		return bankAccountService.getBankAccountById(id);
	}

	@PutMapping("/{id}/balance-update")
	public ResponseEntity<BankAccount> updateBalance(@PathVariable Long id, @RequestBody Double newBalance) {
		return bankAccountService.updateBalanceById(id, newBalance);
	}

}
