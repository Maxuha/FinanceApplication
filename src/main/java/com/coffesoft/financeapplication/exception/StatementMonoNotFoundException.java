package com.coffesoft.financeapplication.exception;

public class StatementMonoNotFoundException extends NotFoundException {
    public StatementMonoNotFoundException(Long id) {
        super(String.format("Statement mono is not found with id : '%s'", id));
    }
}
