package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.AccountMonoNotFoundException;
import com.coffesoft.financeapplication.model.monobank.AccountMono;

import java.util.List;
import java.util.Optional;

public interface AccountMonoService {
    List<AccountMono> findAllAccountMono();
    Optional<AccountMono> findByIdAccountMono(String id) throws AccountMonoNotFoundException;
    AccountMono saveAccountMono(AccountMono accountMono);
    AccountMono updateAccountMono(AccountMono accountMono) throws AccountMonoNotFoundException;
    void deleteAccountMono(AccountMono accountMono);
}
