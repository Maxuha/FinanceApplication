package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.AccountMonoNotFoundException;
import com.coffesoft.financeapplication.model.monobank.AccountMono;
import com.coffesoft.financeapplication.repository.monobank.AccountMonoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountMonoServiceImpl implements AccountMonoService {
    private final AccountMonoRepository accountMonoRepository;

    public AccountMonoServiceImpl(AccountMonoRepository accountMonoRepository) {
        this.accountMonoRepository = accountMonoRepository;
    }

    @Override
    public List<AccountMono> findAllAccountMono() {
        return accountMonoRepository.findAll();
    }

    @Override
    public Optional<AccountMono> findByIdAccountMono(String id) throws AccountMonoNotFoundException {
        Optional<AccountMono> accountMonoDb = accountMonoRepository.findById(id);
        if (accountMonoDb.isPresent()) {
            return accountMonoDb;
        }
        throw new AccountMonoNotFoundException(id);
    }

    @Override
    public AccountMono saveAccountMono(AccountMono accountMono) {
        return accountMonoRepository.save(accountMono);
    }

    @Override
    public AccountMono updateAccountMono(AccountMono accountMono) throws AccountMonoNotFoundException {
        Optional<AccountMono> accountMonoDb = accountMonoRepository.findById(accountMono.getId());
        if (accountMonoDb.isPresent()) {
            return accountMonoRepository.save(accountMono);
        }
        throw new AccountMonoNotFoundException(accountMono.getId());
    }

    @Override
    public void deleteAccountMono(AccountMono accountMono) {
        accountMonoRepository.delete(accountMono);
    }
}
