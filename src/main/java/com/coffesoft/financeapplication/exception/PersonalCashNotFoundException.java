package com.coffesoft.financeapplication.exception;

public class PersonalCashNotFoundException extends NotFoundException{
    public PersonalCashNotFoundException(Long id) {
        super(String.format("Personal cash is not found with id : '%s'", id));
    }
}
