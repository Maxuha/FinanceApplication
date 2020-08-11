package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.UserMonoNotFoundException;
import com.coffesoft.financeapplication.model.monobank.UserMono;

import java.util.List;

public interface UserMonoService {
    List<UserMono> findAllUserMono();
    UserMono findByIdUserMono(String id) throws UserMonoNotFoundException;
    UserMono saveUserMono(UserMono userMono);
    UserMono updateUserMono(UserMono userMono) throws UserMonoNotFoundException;
    void deleteUserMono(UserMono userMono) throws UserMonoNotFoundException;
}
