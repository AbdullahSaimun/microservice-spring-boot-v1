package com.saimun.bank_service.service;

import com.saimun.bank_service.dto.BankAccountSaveDto;
import com.saimun.bank_service.model.BankAccount;
import com.saimun.bank_service.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BankAccountService {
	private final BankAccountRepository bankAccountRepository;


	public ResponseEntity<String> createBankAccount(BankAccountSaveDto account) {
		BankAccount bankAccount = new BankAccount();
		BeanUtils.copyProperties(account, bankAccount);
		bankAccount = bankAccountRepository.save(bankAccount);
		return ResponseEntity.ok().body(bankAccount.getAccountHolder());
	}

	public ResponseEntity<List<BankAccount>> getAllBankAccount() {
		List<BankAccount> bankAccounts = bankAccountRepository.findAll();
		return ResponseEntity.ok().body(bankAccounts);
	}

	public ResponseEntity<BankAccount> getBankAccountById(Long id) {
		Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);
		return bankAccount.map(account -> ResponseEntity.ok().body(account))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	public ResponseEntity<BankAccount> updateBalanceById(Long id, Double newBalance) {
		Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);
		if (bankAccount.isPresent()) {
			bankAccount.get().setBalance(newBalance);
			BankAccount updatedBankAccount = bankAccountRepository.save(bankAccount.get());
			return ResponseEntity.ok().body(updatedBankAccount);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
}
