package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.component.MonoApiComponent;
import com.coffesoft.financeapplication.model.monobank.AccountMono;

public class StatementMonoServiceThread extends Thread {
    private final MonoApiComponent monoApiComponent;
    private String token;
    private AccountMono accountMono;

    public StatementMonoServiceThread(MonoApiComponent monoApiComponent) {
        this.monoApiComponent = monoApiComponent;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setAccountMono(AccountMono accountMono) {
        this.accountMono = accountMono;
    }

    @Override
    public void run() {
        monoApiComponent.createStatementMono(token, accountMono);
    }
}
