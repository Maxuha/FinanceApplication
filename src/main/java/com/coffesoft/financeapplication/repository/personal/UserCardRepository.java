package com.coffesoft.financeapplication.repository.personal;

import com.coffesoft.financeapplication.model.personal.UserCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCardRepository extends JpaRepository<UserCard, Long> {
        Optional<UserCard> findByWalletId(Long walletId);
}
