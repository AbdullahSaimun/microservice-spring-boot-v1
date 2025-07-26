package com.saimun.wallet_service.repository;

import com.saimun.wallet_service.model.WalletAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletAccountRepository extends JpaRepository<WalletAccount, Long> {
}