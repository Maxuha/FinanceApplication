package com.coffesoft.financeapplication.repository.personal;

import com.coffesoft.financeapplication.model.personal.Envelope;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnvelopeRepository extends JpaRepository<Envelope, Long> {
    List<Envelope> findByUserId(Long userId);
}
