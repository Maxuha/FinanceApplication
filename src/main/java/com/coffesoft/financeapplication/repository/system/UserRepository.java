package com.coffesoft.financeapplication.repository.system;

import com.coffesoft.financeapplication.model.system.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
