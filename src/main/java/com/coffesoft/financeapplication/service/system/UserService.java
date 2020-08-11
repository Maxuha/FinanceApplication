package com.coffesoft.financeapplication.service.system;

import com.coffesoft.financeapplication.exception.UserNotFoundException;
import com.coffesoft.financeapplication.model.system.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUser();
    Optional<User> findByIdUser(Long id) throws UserNotFoundException;
    User saveUser(User user);
    User updateUser(User user) throws UserNotFoundException;
    void deleteUser(User user) throws UserNotFoundException;
}
