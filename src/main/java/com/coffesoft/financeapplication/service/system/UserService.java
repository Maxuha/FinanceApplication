package com.coffesoft.financeapplication.service.system;

import com.coffesoft.financeapplication.exception.UserNotFoundException;
import com.coffesoft.financeapplication.model.system.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    User findByIdUser(Long id) throws UserNotFoundException;
    User saveUser(User user);
    User updateUser(User user) throws UserNotFoundException;
    void deleteUser(User user) throws UserNotFoundException;
}
