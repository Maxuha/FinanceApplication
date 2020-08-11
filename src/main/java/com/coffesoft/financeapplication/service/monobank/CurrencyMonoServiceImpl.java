package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.CurrencyMonoNotFoundException;
import com.coffesoft.financeapplication.model.monobank.CurrencyMono;
import com.coffesoft.financeapplication.repository.monobank.CurrencyMonoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyMonoServiceImpl implements CurrencyMonoService {
    private final CurrencyMonoRepository currencyMonoRepository;

    public CurrencyMonoServiceImpl(CurrencyMonoRepository currencyMonoRepository) {
        this.currencyMonoRepository = currencyMonoRepository;
    }

    @Override
    public List<CurrencyMono> findAllCurrencyMono() {
        return currencyMonoRepository.findAll();
    }

    @Override
    public CurrencyMono findIdCurrencyMono(Long id) throws CurrencyMonoNotFoundException {
        Optional<CurrencyMono> currencyMonoDb = currencyMonoRepository.findById(id);
        return currencyMonoDb.orElseThrow(() -> new CurrencyMonoNotFoundException(id));
    }

    @Override
    public CurrencyMono saveCurrencyMono(CurrencyMono currencyMono) {
        return currencyMonoRepository.save(currencyMono);
    }

    @Override
    public CurrencyMono updateCurrencyMono(CurrencyMono currencyMono) throws CurrencyMonoNotFoundException {
        Optional<CurrencyMono> currencyMonoDb = currencyMonoRepository.findById(currencyMono.getId());
        if (currencyMonoDb.isPresent()) {
            return currencyMonoRepository.save(currencyMono);
        }
        throw new CurrencyMonoNotFoundException(currencyMono.getId());
    }


    @Override
    public void deleteCurrencyMono(CurrencyMono currencyMono) throws CurrencyMonoNotFoundException {
        currencyMonoRepository.delete(findIdCurrencyMono(currencyMono.getId()));
    }
}
