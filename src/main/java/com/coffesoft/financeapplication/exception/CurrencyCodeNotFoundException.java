package com.coffesoft.financeapplication.exception;

public class CurrencyCodeNotFoundException extends NotFoundException {
    public CurrencyCodeNotFoundException(Long id) {
        super(String.format("Currency code is not found with id : '%s'", id));
    }
}
