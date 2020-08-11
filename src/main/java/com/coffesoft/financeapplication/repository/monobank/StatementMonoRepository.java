package com.coffesoft.financeapplication.repository.monobank;

import com.coffesoft.financeapplication.model.monobank.StatementMono;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementMonoRepository extends JpaRepository<StatementMono, String> {
}
