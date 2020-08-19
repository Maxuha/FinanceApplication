package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.model.monobank.AccountMono;
import com.coffesoft.financeapplication.model.monobank.api.StatementMonoApi;

import java.util.List;

public interface StatementMonoApiService {
    List<StatementMonoApi> getStatementMonoByTokenForAccountOfMouthFromMonoApi(String token, AccountMono accountMono, Long from, Long to);
}
