package com.coffesoft.financeapplication.service.personal;

import com.coffesoft.financeapplication.exception.NotFoundException;
import com.coffesoft.financeapplication.exception.PersonalCashNotFoundException;
import com.coffesoft.financeapplication.model.personal.PersonalCash;

import java.util.List;

public interface PersonalCashService {
    List<PersonalCash> findAllPersonalCash();
    PersonalCash findByIdPersonalCash(Long id) throws PersonalCashNotFoundException;
    PersonalCash findByWalletIdPersonalCash(Long userId, Long walletId) throws NotFoundException;
    PersonalCash savePersonalCash(PersonalCash personalCash);
    PersonalCash updatePersonalCash(PersonalCash personalCash) throws PersonalCashNotFoundException;
    void deletePersonalCash(PersonalCash personalCash) throws PersonalCashNotFoundException;
}
