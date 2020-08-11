package com.coffesoft.financeapplication.exception;

public class MaskedPanMonoNotFoundException extends NotFoundException {
    public MaskedPanMonoNotFoundException(Long id) {
        super(String.format("Masked pan mono is not found with id : '%s'", id));
    }
}
