package com.coffesoft.financeapplication.repository.monobank;

import com.coffesoft.financeapplication.model.monobank.CurrencyCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyCodeRepository extends JpaRepository<CurrencyCode, Long> {
}
