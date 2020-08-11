package com.coffesoft.financeapplication.repository.monobank;

import com.coffesoft.financeapplication.model.monobank.AccountMono;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountMonoRepository extends JpaRepository<AccountMono, String> {
}
