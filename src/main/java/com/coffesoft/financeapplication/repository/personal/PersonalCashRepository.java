package com.coffesoft.financeapplication.repository.personal;

import com.coffesoft.financeapplication.model.personal.PersonalCash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonalCashRepository extends JpaRepository<PersonalCash, Long> {
    Optional<PersonalCash> findByWalletId(Long walletId);
}
