package com.coffesoft.financeapplication.controller;

import com.coffesoft.financeapplication.exception.NotFoundException;
import com.coffesoft.financeapplication.exception.WalletNotFoundException;
import com.coffesoft.financeapplication.model.system.Wallet;
import com.coffesoft.financeapplication.service.system.WalletService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {
    private static final Logger logger = Logger.getLogger(WalletController.class);
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping(value = "/wallet", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Wallet>> getAll() {
        return new ResponseEntity<>(walletService.findAllWallet(), HttpStatus.OK);
    }

    @GetMapping(value = "/wallet/{walletId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Wallet> getById(@PathVariable Long walletId) {
        try {
            return new ResponseEntity<>(walletService.findByIdWallet(walletId), HttpStatus.OK);
        } catch (WalletNotFoundException e) {
            logger.warn("Get request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/wallet", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Wallet> create(@RequestBody Wallet wallet) {
        return new ResponseEntity<>(walletService.saveWallet(wallet), HttpStatus.OK);
    }

    @PutMapping(value = "/wallet", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Wallet> update(@RequestBody Wallet wallet) {
        try {
            return new ResponseEntity<>(walletService.updateWallet(wallet), HttpStatus.OK);
        } catch (WalletNotFoundException e) {
            logger.warn("Put request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping(value = "/wallet", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> delete(@RequestBody Wallet wallet) {
        try {
            walletService.deleteWallet(wallet);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (WalletNotFoundException e) {
            logger.warn("Delete request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/user/{userId}/wallet", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Wallet> getByUserId(@PathVariable Long userId) {
        try {
            return new ResponseEntity<>(walletService.findByUserIdWallet(userId), HttpStatus.OK);
        } catch (NotFoundException e) {
            logger.warn("Get request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
