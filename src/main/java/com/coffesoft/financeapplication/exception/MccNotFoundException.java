package com.coffesoft.financeapplication.exception;

public class MccNotFoundException extends NotFoundException {
    public MccNotFoundException(Long id) {
        super(String.format("mcc is not found with id : '%s'", id));
    }
}
