package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.CurrencyCodeNotFoundException;
import com.coffesoft.financeapplication.model.monobank.CurrencyCode;
import com.coffesoft.financeapplication.repository.monobank.CurrencyCodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyCodeServiceImpl implements CurrencyCodeService {
    private final CurrencyCodeRepository currencyCodeRepository;

    public CurrencyCodeServiceImpl(CurrencyCodeRepository currencyCodeRepository) {
        this.currencyCodeRepository = currencyCodeRepository;
    }

    @Override
    public List<CurrencyCode> findAllCurrencyCode() {
        return currencyCodeRepository.findAll();
    }

    @Override
    public Optional<CurrencyCode> findByIdCurrencyCode(Long id) throws CurrencyCodeNotFoundException {
        Optional<CurrencyCode> currencyCodeDb = currencyCodeRepository.findById(id);
        if (currencyCodeDb.isPresent()) {
            return currencyCodeDb;
        }
        throw new CurrencyCodeNotFoundException(id);
    }

    @Override
    public CurrencyCode saveCurrencyCode(CurrencyCode currencyCode) {
        return currencyCodeRepository.save(currencyCode);
    }

    @Override
    public CurrencyCode updateCurrencyCode(CurrencyCode currencyCode) throws CurrencyCodeNotFoundException {
        Optional<CurrencyCode> currencyCodeDb = currencyCodeRepository.findById(currencyCode.getId());
        if (currencyCodeDb.isPresent()) {
            return currencyCodeRepository.save(currencyCode);
        }
        throw new CurrencyCodeNotFoundException(currencyCode.getId());
    }

    @Override
    public void deleteCurrencyCode(CurrencyCode currencyCode) throws CurrencyCodeNotFoundException {
        Optional<CurrencyCode> currencyCodeDb = currencyCodeRepository.findById(currencyCode.getId());
        if (currencyCodeDb.isPresent()) {
            currencyCodeRepository.delete(currencyCode);
        } else {
            throw new CurrencyCodeNotFoundException(currencyCode.getId());
        }
    }
}
