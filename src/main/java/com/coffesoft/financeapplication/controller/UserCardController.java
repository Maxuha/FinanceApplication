package com.coffesoft.financeapplication.controller;

import com.coffesoft.financeapplication.exception.NotFoundException;
import com.coffesoft.financeapplication.exception.PersonalCashNotFoundException;
import com.coffesoft.financeapplication.exception.UserCardNotFoundException;
import com.coffesoft.financeapplication.model.personal.PersonalCash;
import com.coffesoft.financeapplication.model.personal.UserCard;
import com.coffesoft.financeapplication.model.system.User;
import com.coffesoft.financeapplication.service.personal.UserCardService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserCardController {
    private static final Logger logger = Logger.getLogger(WalletController.class);
    private final UserCardService userCardService;

    public UserCardController(UserCardService userCardService) {
        this.userCardService = userCardService;
    }

    @GetMapping(value = "/personal/card", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UserCard>> getAll() {
        return new ResponseEntity<>(userCardService.findAllUserCard(), HttpStatus.OK);
    }

    @GetMapping(value = "/personal/card/{cardId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserCard> getById(@PathVariable Long cardId) {
        try {
            return new ResponseEntity<>(userCardService.findByIdUserCard(cardId), HttpStatus.OK);
        } catch (UserCardNotFoundException e) {
            logger.warn("Get request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/user/{userId}/wallet/{walletId}/personal/card", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserCard> getByWalletId(@PathVariable Long userId, @PathVariable Long cardId) {
        try {
            return new ResponseEntity<>(userCardService.findByWalletIdUserCard(cardId), HttpStatus.OK);
        } catch (NotFoundException e) {
            logger.warn(String.format("Get request for user id %s: %s", userId, e.getMessage()));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/personal/card", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserCard> create(@RequestBody UserCard userCard) {
        return new ResponseEntity<>(userCardService.saveUserCard(userCard), HttpStatus.OK);
    }

    @PutMapping(value = "/personal/card", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserCard> update(@RequestBody UserCard userCard) {
        try {
            return new ResponseEntity<>(userCardService.updateUserCard(userCard), HttpStatus.OK);
        } catch (UserCardNotFoundException e) {
            logger.warn("Put request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping(value = "/personal/card", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> delete(@RequestBody UserCard userCard) {
        try {
            userCardService.deleteUserCard(userCard);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserCardNotFoundException e) {
            logger.warn("Delete request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
