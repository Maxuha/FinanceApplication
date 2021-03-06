package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.AccountMonoNotFoundException;
import com.coffesoft.financeapplication.exception.NotFoundException;
import com.coffesoft.financeapplication.model.monobank.AccountMono;

import java.util.List;

public interface AccountMonoService {
    List<AccountMono> findAllAccountMono();
    List<AccountMono> findByUserMonoIdAccountMono(String userMonoId) throws NotFoundException;
    AccountMono findByIdAccountMono(String id) throws AccountMonoNotFoundException;
    AccountMono saveAccountMono(AccountMono accountMono);
    List<AccountMono> saveAccountsMonoForUserMono(List<AccountMono> accountMonoList);
    AccountMono updateAccountMono(AccountMono accountMono) throws AccountMonoNotFoundException;
    void deleteAccountMono(AccountMono accountMono) throws AccountMonoNotFoundException;
}
