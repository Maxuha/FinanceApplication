package com.coffesoft.financeapplication.service.system;

import com.coffesoft.financeapplication.exception.NotFoundException;
import com.coffesoft.financeapplication.exception.WalletNotFoundException;
import com.coffesoft.financeapplication.model.system.Wallet;

import java.util.List;

public interface WalletService {
    List<Wallet> findAllWallet();
    Wallet findByIdWallet(Long id) throws WalletNotFoundException;
    Wallet findByUserIdWallet(Long userId) throws NotFoundException;
    Wallet saveWallet(Wallet wallet);
    Wallet updateWallet(Wallet wallet) throws WalletNotFoundException;
    void deleteWallet(Wallet wallet) throws WalletNotFoundException;
}
