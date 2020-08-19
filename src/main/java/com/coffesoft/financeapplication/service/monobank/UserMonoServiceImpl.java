package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.NotFoundException;
import com.coffesoft.financeapplication.exception.UserMonoNotFoundException;
import com.coffesoft.financeapplication.model.monobank.UserMono;
import com.coffesoft.financeapplication.repository.monobank.UserMonoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserMonoServiceImpl implements UserMonoService {
    private final UserMonoRepository userMonoRepository;

    public UserMonoServiceImpl(UserMonoRepository userMonoRepository) {
        this.userMonoRepository = userMonoRepository;
    }

    @Override
    public List<UserMono> findAllUserMono() {
        return userMonoRepository.findAll();
    }

    @Override
    public UserMono findByIdUserMono(String id) throws UserMonoNotFoundException {
        Optional<UserMono> userMonoDb = userMonoRepository.findById(id);
        return userMonoDb.orElseThrow(() -> new UserMonoNotFoundException(id));
    }

    @Override
    public UserMono findByUserCardIdUserMono(Long userCardId) throws NotFoundException {
        Optional<UserMono> userMonoDb = userMonoRepository.findByUserCardId(userCardId);
        return userMonoDb.orElseThrow(() -> new NotFoundException(String.format("user mono is not found by user card id '%s'", userCardId)));
    }

    @Override
    public UserMono saveUserMono(UserMono userMono) {
        return userMonoRepository.save(userMono);
    }

    @Override
    public UserMono updateUserMono(UserMono userMono) throws UserMonoNotFoundException {
        Optional<UserMono> userMonoDb = userMonoRepository.findById(userMono.getId());
        if (userMonoDb.isPresent()) {
            return userMonoRepository.save(userMono);
        }
        throw new UserMonoNotFoundException(userMono.getId());
    }

    @Override
    public void deleteUserMono(UserMono userMono) throws UserMonoNotFoundException {
        userMonoRepository.delete(findByIdUserMono(userMono.getId()));
    }
}
