package com.coffesoft.financeapplication.repository.monobank;

import com.coffesoft.financeapplication.model.monobank.UserMono;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserMonoRepository extends JpaRepository<UserMono, String> {
    Optional<UserMono> findByUserCardId(Long userCardId);
}
