package com.coffesoft.financeapplication.exception;

public class UserCardNotFoundException extends NotFoundException {
    public UserCardNotFoundException(Long id) {
        super(String.format("User card is not found with id : '%s'", id));
    }
}
