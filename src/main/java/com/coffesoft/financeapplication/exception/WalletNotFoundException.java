package com.coffesoft.financeapplication.exception;

public class WalletNotFoundException extends NotFoundException {
    public WalletNotFoundException(Long id) {
        super(String.format("Wallet is not found with id : '%s'", id));
    }
}
