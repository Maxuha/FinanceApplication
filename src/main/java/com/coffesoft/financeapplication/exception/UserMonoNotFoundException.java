package com.coffesoft.financeapplication.exception;

public class UserMonoNotFoundException extends NotFoundException {
    public UserMonoNotFoundException(String id) {
        super(String.format("User mono is not found with id : '%s'", id));
    }
}
