package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.CurrencyCodeNotFoundException;
import com.coffesoft.financeapplication.model.monobank.CurrencyCode;

import java.util.List;
import java.util.Optional;

public interface CurrencyCodeService {
    List<CurrencyCode> findAllCurrencyCode();
    Optional<CurrencyCode> findByIdCurrencyCode(Long id) throws CurrencyCodeNotFoundException;
    CurrencyCode saveCurrencyCode(CurrencyCode currencyCode);
    CurrencyCode updateCurrencyCode(CurrencyCode currencyCode) throws CurrencyCodeNotFoundException;
    void deleteCurrencyCode(CurrencyCode currencyCode) throws CurrencyCodeNotFoundException;
}
