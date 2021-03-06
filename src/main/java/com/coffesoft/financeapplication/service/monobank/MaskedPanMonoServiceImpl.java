package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.MaskedPanMonoNotFoundException;
import com.coffesoft.financeapplication.model.monobank.MaskedPanMono;
import com.coffesoft.financeapplication.repository.monobank.MaskedPanMonoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaskedPanMonoServiceImpl implements MaskedPanMonoService {
    private final MaskedPanMonoRepository maskedPanMonoRepository;

    public MaskedPanMonoServiceImpl(MaskedPanMonoRepository maskedPanMonoRepository) {
        this.maskedPanMonoRepository = maskedPanMonoRepository;
    }

    @Override
    public List<MaskedPanMono> findAllMaskedPanMono() {
        return maskedPanMonoRepository.findAll();
    }

    @Override
    public MaskedPanMono findByIdMaskedPanMono(Long id) throws MaskedPanMonoNotFoundException {
        Optional<MaskedPanMono> maskedPanMonoDb = maskedPanMonoRepository.findById(id);
        return maskedPanMonoDb.orElseThrow(() -> new MaskedPanMonoNotFoundException(id));
    }

    @Override
    public MaskedPanMono saveMaskedPanMono(MaskedPanMono maskedPanMono) {
        return maskedPanMonoRepository.save(maskedPanMono);
    }

    @Override
    public List<MaskedPanMono> saveMaskedPanMonoListForAccountMono(List<MaskedPanMono> maskedPanMonoList) {
        return maskedPanMonoRepository.saveAll(maskedPanMonoList);
    }

    @Override
    public MaskedPanMono updateMaskedPanMono(MaskedPanMono maskedPanMono) throws MaskedPanMonoNotFoundException {
        Optional<MaskedPanMono> maskedPanMonoDb = maskedPanMonoRepository.findById(maskedPanMono.getId());
        if (maskedPanMonoDb.isPresent()) {
            return maskedPanMonoRepository.save(maskedPanMono);
        }
        throw new MaskedPanMonoNotFoundException(maskedPanMono.getId());
    }

    @Override
    public void deleteMaskedPanMono(MaskedPanMono maskedPanMono) throws MaskedPanMonoNotFoundException {
        maskedPanMonoRepository.delete(findByIdMaskedPanMono(maskedPanMono.getId()));
    }
}
