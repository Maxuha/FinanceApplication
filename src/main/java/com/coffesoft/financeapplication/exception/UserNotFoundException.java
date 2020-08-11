package com.coffesoft.financeapplication.exception;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(Long id) {
        super(String.format("Book is not found with id : '%s'", id));
    }
}
