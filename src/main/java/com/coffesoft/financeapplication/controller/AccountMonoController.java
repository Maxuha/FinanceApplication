package com.coffesoft.financeapplication.controller;

import com.coffesoft.financeapplication.exception.AccountMonoNotFoundException;
import com.coffesoft.financeapplication.exception.NotFoundException;
import com.coffesoft.financeapplication.model.monobank.AccountMono;
import com.coffesoft.financeapplication.service.monobank.AccountMonoService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountMonoController {
    private static final Logger logger = Logger.getLogger(WalletController.class);
    private final AccountMonoService accountMonoService;

    public AccountMonoController(AccountMonoService accountMonoService) {
        this.accountMonoService = accountMonoService;
    }

    @GetMapping(value = "/mono/account", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AccountMono>> getAll() {
        return new ResponseEntity<>(accountMonoService.findAllAccountMono(), HttpStatus.OK);
    }

    @GetMapping(value = "/mono/account/{accountMonoId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AccountMono> getById(@PathVariable String accountMonoId) {
        try {
            return new ResponseEntity<>(accountMonoService.findByIdAccountMono(accountMonoId), HttpStatus.OK);
        } catch (AccountMonoNotFoundException e) {
            logger.warn("Get request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/user/{userId}/wallet/{walletId}/personal/card/{userCardId}/mono/user/{userMonoId}/account", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AccountMono>> getByUserMonoId(@PathVariable Long userId, @PathVariable Long walletId, @PathVariable Long userCardId, @PathVariable String userMonoId) {
        try {
            return new ResponseEntity<>(accountMonoService.findByUserMonoIdAccountMono(userMonoId), HttpStatus.OK);
        } catch (NotFoundException e) {
            logger.warn(String.format("Get request for user mono id %s: %s", userId, e.getMessage()));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/mono/account", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AccountMono> create(@RequestBody AccountMono accountMono) {
        return new ResponseEntity<>(accountMonoService.saveAccountMono(accountMono), HttpStatus.OK);
    }

    @PostMapping(value = "/mono/accounts", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AccountMono>> createForUserMono(@RequestBody List<AccountMono> accountMonoList) {
        return new ResponseEntity<>(accountMonoService.saveAccountsMonoForUserMono(accountMonoList), HttpStatus.OK);
    }

    @PutMapping(value = "/mono/account", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AccountMono> update(@RequestBody AccountMono accountMono) {
        try {
            return new ResponseEntity<>(accountMonoService.updateAccountMono(accountMono), HttpStatus.OK);
        } catch (AccountMonoNotFoundException e) {
            logger.warn("Put request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping(value = "/mono/account", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> delete(@RequestBody AccountMono accountMono) {
        try {
            accountMonoService.deleteAccountMono(accountMono);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (AccountMonoNotFoundException e) {
            logger.warn("Delete request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}