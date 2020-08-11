package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.exception.MccNotFoundException;
import com.coffesoft.financeapplication.model.monobank.Mcc;

import java.util.List;

public interface MccService {
    List<Mcc> findAllMcc();
    Mcc findByIdMcc(Long id) throws MccNotFoundException;
    Mcc saveMcc(Mcc mcc);
    Mcc updateMcc(Mcc mcc) throws MccNotFoundException;
    void deleteMcc(Mcc mcc) throws MccNotFoundException;
}
