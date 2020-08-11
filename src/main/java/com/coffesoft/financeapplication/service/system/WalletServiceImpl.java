package com.coffesoft.financeapplication.service.system;

import com.coffesoft.financeapplication.exception.WalletNotFoundException;
import com.coffesoft.financeapplication.model.system.Wallet;
import com.coffesoft.financeapplication.repository.system.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public List<Wallet> findAllWallet() {
        return walletRepository.findAll();
    }

    @Override
    public Optional<Wallet> findByIdWallet(Long id) throws WalletNotFoundException {
        Optional<Wallet> walletDb = walletRepository.findById(id);
        if (walletDb.isPresent()) {
            return walletDb;
        }
        throw new WalletNotFoundException(id);
    }

    @Override
    public Wallet saveWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet updateWallet(Wallet wallet) throws WalletNotFoundException {
        Optional<Wallet> walletDb = walletRepository.findById(wallet.getId());
        if (walletDb.isPresent()) {
            return walletRepository.save(wallet);
        }
        throw new WalletNotFoundException(wallet.getId());
    }

    @Override
    public void deleteWallet(Wallet wallet) throws WalletNotFoundException {
        Optional<Wallet> walletDb = walletRepository.findById(wallet.getId());
        if (walletDb.isPresent()) {
            walletRepository.delete(wallet);
        } else {
            throw new WalletNotFoundException(wallet.getId());
        }
    }
}
