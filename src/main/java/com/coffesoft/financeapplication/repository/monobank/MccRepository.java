package com.coffesoft.financeapplication.repository.monobank;

import com.coffesoft.financeapplication.model.monobank.Mcc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MccRepository extends JpaRepository<Mcc, Long> {
}
