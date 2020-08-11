package com.coffesoft.financeapplication.service.personal;

import com.coffesoft.financeapplication.exception.PersonalCashNotFoundException;
import com.coffesoft.financeapplication.model.personal.PersonalCash;

import java.util.List;
import java.util.Optional;

public interface PersonalCashService {
    List<PersonalCash> findAllPersonalCash();
    Optional<PersonalCash> findByIdPersonalCash(Long id) throws PersonalCashNotFoundException;
    PersonalCash savePersonalCash(PersonalCash personalCash);
    PersonalCash updatePersonalCash(PersonalCash personalCash) throws PersonalCashNotFoundException;
    void deletePersonalCash(PersonalCash personalCash) throws PersonalCashNotFoundException;
}
