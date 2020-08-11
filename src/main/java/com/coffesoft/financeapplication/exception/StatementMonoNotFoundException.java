package com.coffesoft.financeapplication.exception;

public class StatementMonoNotFoundException extends NotFoundException {
    public StatementMonoNotFoundException(String id) {
        super(String.format("Statement mono is not found with id : '%s'", id));
    }
}
