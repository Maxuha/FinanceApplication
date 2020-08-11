package com.coffesoft.financeapplication.exception;

public class AccountMonoNotFoundException extends NotFoundException {
    public AccountMonoNotFoundException(Long id) {
        super(String.format("Account mono is not found with id : '%s'", id));
    }
}
