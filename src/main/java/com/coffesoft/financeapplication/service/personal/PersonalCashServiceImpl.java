package com.coffesoft.financeapplication.service.personal;

import com.coffesoft.financeapplication.exception.PersonalCashNotFoundException;
import com.coffesoft.financeapplication.model.personal.PersonalCash;
import com.coffesoft.financeapplication.repository.personal.PersonalCashRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalCashServiceImpl implements PersonalCashService {
    private final PersonalCashRepository personalCashRepository;

    public PersonalCashServiceImpl(PersonalCashRepository personalCashRepository) {
        this.personalCashRepository = personalCashRepository;
    }

    @Override
    public List<PersonalCash> findAllPersonalCash() {
        return personalCashRepository.findAll();
    }

    @Override
    public Optional<PersonalCash> findByIdPersonalCash(Long id) throws PersonalCashNotFoundException {
        Optional<PersonalCash> personalCashDb = personalCashRepository.findById(id);
        if (personalCashDb.isPresent()) {
            return personalCashDb;
        }
        throw new PersonalCashNotFoundException(id);
    }

    @Override
    public PersonalCash savePersonalCash(PersonalCash personalCash) {
        return personalCashRepository.save(personalCash);
    }

    @Override
    public PersonalCash updatePersonalCash(PersonalCash personalCash) throws PersonalCashNotFoundException {
        Optional<PersonalCash> personalCashDb = personalCashRepository.findById(personalCash.getId());
        if (personalCashDb.isPresent()) {
            return personalCashRepository.save(personalCash);
        }
        throw new PersonalCashNotFoundException(personalCash.getId());
    }

    @Override
    public void deletePersonalCash(PersonalCash personalCash) {
        personalCashRepository.delete(personalCash);
    }
}
