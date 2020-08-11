package com.coffesoft.financeapplication.service.personal;

import com.coffesoft.financeapplication.exception.UserCardNotFoundException;
import com.coffesoft.financeapplication.model.personal.UserCard;
import com.coffesoft.financeapplication.repository.personal.UserCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCardServiceImpl implements UserCardService {
    private final UserCardRepository userCardRepository;

    public UserCardServiceImpl(UserCardRepository userCardRepository) {
        this.userCardRepository = userCardRepository;
    }

    @Override
    public List<UserCard> findAllUserCard() {
        return userCardRepository.findAll();
    }

    @Override
    public UserCard findByIdUserCard(Long id) throws UserCardNotFoundException {
        Optional<UserCard> userCardDb = userCardRepository.findById(id);
        return userCardDb.orElseThrow(() -> new UserCardNotFoundException(id));
    }

    @Override
    public UserCard saveUserCard(UserCard userCard) {
        return userCardRepository.save(userCard);
    }

    @Override
    public UserCard updateUserCard(UserCard userCard) throws UserCardNotFoundException {
        Optional<UserCard> userCardDb = userCardRepository.findById(userCard.getId());
        if (userCardDb.isPresent()) {
            return userCardRepository.save(userCard);
        }
        throw new UserCardNotFoundException(userCard.getId());
    }

    @Override
    public void deleteUserCard(UserCard userCard) throws UserCardNotFoundException {
        userCardRepository.delete(findByIdUserCard(userCard.getId()));
    }
}
