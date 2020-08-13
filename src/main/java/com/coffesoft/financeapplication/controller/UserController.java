package com.coffesoft.financeapplication.controller;

import com.coffesoft.financeapplication.exception.UserNotFoundException;
import com.coffesoft.financeapplication.model.system.User;
import com.coffesoft.financeapplication.service.system.UserService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getById(@PathVariable Long userId) {
        try {
            return new ResponseEntity<>(userService.findByIdUser(userId), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            logger.warn("Get request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<User> update(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            logger.warn("Put request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/user")
    public ResponseEntity<?> delete(@RequestBody User user) {
        try {
            userService.deleteUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserNotFoundException e) {
            logger.warn("Delete request: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
