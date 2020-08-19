package com.coffesoft.financeapplication.exception;

public class EnvelopeNotFoundException extends NotFoundException {
    public EnvelopeNotFoundException(Long id) {
        super(String.format("Envelope is not found with id : '%s'", id));
    }
}
