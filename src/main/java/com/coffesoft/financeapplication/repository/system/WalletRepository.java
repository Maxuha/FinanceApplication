package com.coffesoft.financeapplication.repository.system;

import com.coffesoft.financeapplication.model.system.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByUserId(Long userId);
}
