package com.coffesoft.financeapplication.repository.system;

import com.coffesoft.financeapplication.model.system.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
