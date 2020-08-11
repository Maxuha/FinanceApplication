package com.coffesoft.financeapplication.service.system;

import com.coffesoft.financeapplication.exception.UserCardNotFoundException;
import com.coffesoft.financeapplication.exception.UserMonoNotFoundException;
import com.coffesoft.financeapplication.model.personal.UserCard;

import java.util.List;
import java.util.Optional;

public interface UserCardService {
    List<UserCard> findAllUserCard();
    Optional<UserCard> findByIdUserCard(Long id) throws UserCardNotFoundException;
    UserCard saveUserCard(UserCard userCard);
    UserCard updateUserCard(UserCard userCard) throws UserCardNotFoundException;
    void deleteUserCard(UserCard userCard) throws UserMonoNotFoundException;
}
