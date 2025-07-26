package com.saimun.wallet_service.service;

import com.saimun.wallet_service.model.WalletAccount;
import com.saimun.wallet_service.repository.WalletAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WalletService {
	private final WalletAccountRepository  walletAccountRepository;


	public ResponseEntity<WalletAccount> createWallet(WalletAccount account) {
		WalletAccount walletAccount = walletAccountRepository.save(account);
		return ResponseEntity.ok(walletAccount);
	}

	public ResponseEntity<List<WalletAccount>> getAllWallet() {
		return ResponseEntity.ok(walletAccountRepository.findAll());
	}

	public ResponseEntity<WalletAccount> getWalletById(Long id) {
		Optional<WalletAccount> walletAccount = walletAccountRepository.findById(id);
		return walletAccount.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	public ResponseEntity<WalletAccount> updateWalletBalance(Long id, Double newBalance) {
		Optional<WalletAccount> walletAccount = walletAccountRepository.findById(id);
		if (walletAccount.isPresent()) {
			walletAccount.get().setBalance(newBalance);
			walletAccountRepository.save(walletAccount.get());
			return ResponseEntity.ok(walletAccount.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
