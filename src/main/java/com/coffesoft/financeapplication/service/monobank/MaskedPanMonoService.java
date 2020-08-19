package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.MaskedPanMonoNotFoundException;
import com.coffesoft.financeapplication.model.monobank.MaskedPanMono;

import java.util.List;

public interface MaskedPanMonoService {
    List<MaskedPanMono> findAllMaskedPanMono();
    MaskedPanMono findByIdMaskedPanMono(Long id) throws MaskedPanMonoNotFoundException;
    MaskedPanMono saveMaskedPanMono(MaskedPanMono maskedPanMono);
    List<MaskedPanMono> saveMaskedPanMonoListForAccountMono(List<MaskedPanMono> maskedPanMonoList);
    MaskedPanMono updateMaskedPanMono(MaskedPanMono maskedPanMono) throws MaskedPanMonoNotFoundException;
    void deleteMaskedPanMono(MaskedPanMono maskedPanMono) throws MaskedPanMonoNotFoundException;
}
