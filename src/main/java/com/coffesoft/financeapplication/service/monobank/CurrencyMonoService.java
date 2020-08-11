package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.CurrencyMonoNotFoundException;
import com.coffesoft.financeapplication.model.monobank.CurrencyMono;

import java.util.List;
import java.util.Optional;

public interface CurrencyMonoService {
    List<CurrencyMono> findAllCurrencyMono();
    Optional<CurrencyMono> findIdCurrencyMono(Long id) throws CurrencyMonoNotFoundException;
    CurrencyMono saveCurrencyMono(CurrencyMono currencyMono);
    CurrencyMono updateCurrencyMono(CurrencyMono currencyMono) throws CurrencyMonoNotFoundException;
    void deleteCurrencyMono(CurrencyMono currencyMono);
}
