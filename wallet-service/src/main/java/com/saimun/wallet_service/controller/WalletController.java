package com.saimun.wallet_service.controller;

import com.saimun.wallet_service.model.WalletAccount;
import com.saimun.wallet_service.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wallet/accounts")
@RequiredArgsConstructor
public class WalletController {

	private final WalletService service;

	@PostMapping("/create")
	public ResponseEntity<WalletAccount> create(@RequestBody WalletAccount account) {
		return service.createWallet(account);
	}

	@GetMapping("get-all")
	public ResponseEntity<List<WalletAccount>> getAll() {
		return service.getAllWallet();
	}

	@GetMapping("/{id}")
	public ResponseEntity<WalletAccount> getById(@PathVariable Long id) {
		return service.getWalletById(id);
	}

	@PutMapping("/{id}/balance")
	public ResponseEntity<WalletAccount> updateBalance(@PathVariable Long id, @RequestBody Double newBalance) {
		return service.updateWalletBalance(id,newBalance);
	}
}
