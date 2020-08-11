package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.MaskedPanMonoNotFoundException;
import com.coffesoft.financeapplication.model.monobank.MaskedPanMono;
import com.coffesoft.financeapplication.repository.monobank.MaskedPanMonoRepository;

import java.util.List;
import java.util.Optional;

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
    public Optional<MaskedPanMono> findByIdMaskedPanMono(Long id) throws MaskedPanMonoNotFoundException {
        Optional<MaskedPanMono> maskedPanMonoDb = maskedPanMonoRepository.findById(id);
        if (maskedPanMonoDb.isPresent()) {
            return maskedPanMonoDb;
        }
        throw new MaskedPanMonoNotFoundException(id);
    }

    @Override
    public MaskedPanMono saveMaskedPanMono(MaskedPanMono maskedPanMono) {
        return maskedPanMonoRepository.save(maskedPanMono);
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
        Optional<MaskedPanMono> maskedPanMonoDb = maskedPanMonoRepository.findById(maskedPanMono.getId());
        if (maskedPanMonoDb.isPresent()) {
            maskedPanMonoRepository.delete(maskedPanMono);
        } else {
            throw new MaskedPanMonoNotFoundException(maskedPanMono.getId());
        }
    }
}
