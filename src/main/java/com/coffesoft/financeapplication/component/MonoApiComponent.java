package com.coffesoft.financeapplication.component;

import com.coffesoft.financeapplication.model.monobank.AccountMono;
import com.coffesoft.financeapplication.model.monobank.StatementMono;
import com.coffesoft.financeapplication.model.monobank.UserMono;

import java.util.List;

public interface MonoApiComponent {
    List<StatementMono> createStatementMono(String token, AccountMono accountMono);
    List<StatementMono> createStatementMonoOfMonth(String token, AccountMono accountMono,
                                                   Long from, Long to);
    UserMono createUserMono(String token);
}
