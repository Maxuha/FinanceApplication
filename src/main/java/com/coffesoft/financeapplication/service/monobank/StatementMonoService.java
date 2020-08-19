package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.StatementMonoNotFoundException;
import com.coffesoft.financeapplication.model.monobank.StatementMono;

import java.util.List;

public interface StatementMonoService {
    List<StatementMono> findAllStatementMono();
    StatementMono findByIdStatementMono(String id) throws StatementMonoNotFoundException;
    StatementMono saveStatementMono(StatementMono statementMono);
    List<StatementMono> saveStatementListForAccountMono(List<StatementMono> statementMonoList);
    StatementMono updateStatementMono(StatementMono statementMono) throws StatementMonoNotFoundException;
    void deleteStatementMono(StatementMono statementMono) throws StatementMonoNotFoundException;
}
