package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.MccNotFoundException;
import com.coffesoft.financeapplication.model.monobank.Mcc;
import com.coffesoft.financeapplication.repository.monobank.MccRepository;
import org.springframework.stereotype.Service;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

@Service
public class MccServiceImpl implements MccService {
    private final MccRepository mccRepository;

    public MccServiceImpl(MccRepository mccRepository) {
        this.mccRepository = mccRepository;
    }

    @Override
    public List<Mcc> findAllMcc() {
        return mccRepository.findAll();
    }

    @Override
    public Mcc findByIdMcc(Long id) throws MccNotFoundException {
        Optional<Mcc> mccBd = mccRepository.findById(id);
        return mccBd.orElseThrow(() -> new MccNotFoundException(id));
    }

    @Override
    public Mcc saveMcc(Mcc mcc) {
        return mccRepository.save(mcc);
    }

    @Override
    public Mcc updateMcc(Mcc mcc) throws MccNotFoundException {
        Optional<Mcc> mccBd = mccRepository.findById(mcc.getId());
        if (mccBd.isPresent()) {
            return mccRepository.save(mcc);
        }
        throw new MccNotFoundException(mcc.getId());
    }

    @Override
    public void deleteMcc(Mcc mcc) throws MccNotFoundException {
        mccRepository.delete(findByIdMcc(mcc.getId()));
    }
}
