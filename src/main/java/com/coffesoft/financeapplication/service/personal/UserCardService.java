package com.coffesoft.financeapplication.service.personal;

import com.coffesoft.financeapplication.exception.UserCardNotFoundException;
import com.coffesoft.financeapplication.model.personal.UserCard;

import java.util.List;

public interface UserCardService {
    List<UserCard> findAllUserCard();
    UserCard findByIdUserCard(Long id) throws UserCardNotFoundException;
    UserCard saveUserCard(UserCard userCard);
    UserCard updateUserCard(UserCard userCard) throws UserCardNotFoundException;
    void deleteUserCard(UserCard userCard) throws UserCardNotFoundException;
}
