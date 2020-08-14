package com.coffesoft.financeapplication.controller;

import com.coffesoft.financeapplication.exception.NotFoundException;
import com.coffesoft.financeapplication.exception.UserMonoNotFoundException;
import com.coffesoft.financeapplication.model.monobank.UserMono;
import com.coffesoft.financeapplication.service.monobank.UserMonoService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserMonoController {
    private static final Logger logger = Logger.getLogger(WalletController.class);
    private final UserMonoService userMonoService;

    public UserMonoController(UserMonoService userMonoService) {
        this.userMonoService = userMonoService;
    }


    @GetMapping(value = "/mono/user", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UserMono>> getAll() {
        return new ResponseEntity<>(userMonoService.findAllUserMono(), HttpStatus.OK);
    }

    @GetMapping(value = "/mono/user/{userMonoId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserMono> getById(@PathVariable String userMonoId) {
        try {
            return new ResponseEntity<>(userMonoService.findByIdUserMono(userMonoId), HttpStatus.OK);
        } catch (UserMonoNotFoundException e) {
            logger.warn("Get request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/user/{userId}/wallet/{walletId}/personal/card/{userCardId}/mono/user", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserMono> getByUserCardId(@PathVariable Long userId, @PathVariable Long walletId, @PathVariable Long userCardId) {
        try {
            return new ResponseEntity<>(userMonoService.findByUserCardIdUserMono(userCardId), HttpStatus.OK);
        } catch (NotFoundException e) {
            logger.warn(String.format("Get request for user id: %s and wallet id: %s %s", userId, walletId, e.getMessage()));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/mono/user", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserMono> create(@RequestBody UserMono userMono) {
        return new ResponseEntity<>(userMonoService.saveUserMono(userMono), HttpStatus.OK);
    }

    @PutMapping(value = "/mono/user", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserMono> update(@RequestBody UserMono userMono) {
        try {
            return new ResponseEntity<>(userMonoService.updateUserMono(userMono), HttpStatus.OK);
        } catch (UserMonoNotFoundException e) {
            logger.warn("Put request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping(value = "/mono/user", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> delete(@RequestBody UserMono userMono) {
        try {
            userMonoService.deleteUserMono(userMono);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserMonoNotFoundException e) {
            logger.warn("Delete request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
