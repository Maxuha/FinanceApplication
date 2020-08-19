package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.StatementMonoNotFoundException;
import com.coffesoft.financeapplication.model.monobank.StatementMono;
import com.coffesoft.financeapplication.repository.monobank.StatementMonoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatementMonoServiceImpl implements StatementMonoService {
    private final StatementMonoRepository statementMonoRepository;

    public StatementMonoServiceImpl(StatementMonoRepository statementMonoRepository) {
        this.statementMonoRepository = statementMonoRepository;
    }

    @Override
    public List<StatementMono> findAllStatementMono() {
        return statementMonoRepository.findAll();
    }

    @Override
    public StatementMono findByIdStatementMono(String id) throws StatementMonoNotFoundException {
        Optional<StatementMono> statementMonoDb = statementMonoRepository.findById(id);
        return statementMonoDb.orElseThrow(() -> new StatementMonoNotFoundException(id));
    }

    @Override
    public StatementMono saveStatementMono(StatementMono statementMono) {
        return statementMonoRepository.save(statementMono);
    }

    @Override
    public List<StatementMono> saveStatementListForAccountMono(List<StatementMono> statementMonoList) {
        return statementMonoRepository.saveAll(statementMonoList);
    }

    @Override
    public StatementMono updateStatementMono(StatementMono statementMono) throws StatementMonoNotFoundException {
        Optional<StatementMono> statementMonoDb = statementMonoRepository.findById(statementMono.getId());
        if (statementMonoDb.isPresent()) {
            return statementMonoRepository.save(statementMono);
        }
        throw new StatementMonoNotFoundException(statementMono.getId());
    }

    @Override
    public void deleteStatementMono(StatementMono statementMono) throws StatementMonoNotFoundException {
        statementMonoRepository.delete(findByIdStatementMono(statementMono.getId()));
    }
}
