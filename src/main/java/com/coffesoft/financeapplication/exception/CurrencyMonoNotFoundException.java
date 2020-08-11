package com.coffesoft.financeapplication.exception;

public class CurrencyMonoNotFoundException extends NotFoundException {
    public CurrencyMonoNotFoundException(Long id) {
        super(String.format("Currency mono is not found with id : '%s'", id));
    }
}
