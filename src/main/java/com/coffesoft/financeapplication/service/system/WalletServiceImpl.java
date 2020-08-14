package com.coffesoft.financeapplication.service.system;

import com.coffesoft.financeapplication.exception.NotFoundException;
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
    public Wallet findByIdWallet(Long id) throws WalletNotFoundException {
        Optional<Wallet> walletDb = walletRepository.findById(id);
        return walletDb.orElseThrow(() -> new WalletNotFoundException(id));
    }

    @Override
    public Wallet findByUserIdWallet(Long userId) throws NotFoundException {
        Optional<Wallet> walletDb = walletRepository.findByUserId(userId);
        return walletDb.orElseThrow(() -> new NotFoundException(String.format("wallet is not found by user id '%s' ", userId)));
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
        walletRepository.delete(findByIdWallet(wallet.getId()));
    }
}
