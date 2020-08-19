package com.coffesoft.financeapplication.repository.monobank;

import com.coffesoft.financeapplication.model.monobank.AccountMono;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountMonoRepository extends JpaRepository<AccountMono, String> {
    List<AccountMono> findByUserMonoId(String userMonoId);
}
