package com.coffesoft.financeapplication.controller;

import com.coffesoft.financeapplication.exception.NotFoundException;
import com.coffesoft.financeapplication.exception.PersonalCashNotFoundException;
import com.coffesoft.financeapplication.model.personal.PersonalCash;
import com.coffesoft.financeapplication.service.personal.PersonalCashService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonalCashController {
    private static final Logger logger = Logger.getLogger(WalletController.class);
    private final PersonalCashService personalCashService;

    public PersonalCashController(PersonalCashService personalCashService) {
        this.personalCashService = personalCashService;
    }

    @GetMapping(value = "/personal/cash", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PersonalCash>> getAll() {
        return new ResponseEntity<>(personalCashService.findAllPersonalCash(), HttpStatus.OK);
    }

    @GetMapping(value = "/personal/cash/{cashId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PersonalCash> getById(@PathVariable Long cashId) {
        try {
            return new ResponseEntity<>(personalCashService.findByIdPersonalCash(cashId), HttpStatus.OK);
        } catch (PersonalCashNotFoundException e) {
            logger.warn("Get request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/user/{userId}/wallet/{walletId}/personal/cash", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PersonalCash> getByWalletId(@PathVariable Long userId, @PathVariable Long walletId) {
        try {
            return new ResponseEntity<>(personalCashService.findByWalletIdPersonalCash(walletId), HttpStatus.OK);
        } catch (NotFoundException e) {
            logger.warn(String.format("Get request for user id %s: %s", userId, e.getMessage()));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/personal/cash", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PersonalCash> create(@RequestBody PersonalCash personalCash) {
        return new ResponseEntity<>(personalCashService.savePersonalCash(personalCash), HttpStatus.OK);
    }

    @PutMapping(value = "/personal/cash", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PersonalCash> update(@RequestBody PersonalCash personalCash) {
        try {
            return new ResponseEntity<>(personalCashService.updatePersonalCash(personalCash), HttpStatus.OK);
        } catch (PersonalCashNotFoundException e) {
            logger.warn("Put request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping(value = "/personal/cash", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> delete(@RequestBody PersonalCash personalCash) {
        try {
            personalCashService.deletePersonalCash(personalCash);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (PersonalCashNotFoundException e) {
            logger.warn("Delete request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
