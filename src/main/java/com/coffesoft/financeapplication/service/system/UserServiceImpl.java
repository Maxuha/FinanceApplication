package com.coffesoft.financeapplication.service.system;

import com.coffesoft.financeapplication.exception.NotFoundException;
import com.coffesoft.financeapplication.exception.UserNotFoundException;
import com.coffesoft.financeapplication.model.system.User;
import com.coffesoft.financeapplication.repository.system.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByIdUser(Long id) throws UserNotFoundException {
        Optional<User> userDb = userRepository.findById(id);
        if (userDb.isPresent()) {
            return userDb;
        }
        throw new UserNotFoundException(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        Optional<User> userDb = userRepository.findById(user.getId());
        if (userDb.isPresent()) {
            return userRepository.save(user);
        }
        throw new UserNotFoundException(user.getId());
    }

    @Override
    public void deleteUser(User user) throws UserNotFoundException {
        Optional<User> userDb = userRepository.findById(user.getId());
        if (userDb.isPresent()) {
            userRepository.delete(user);
        } else {
            throw new UserNotFoundException(user.getId());
        }
    }
}
