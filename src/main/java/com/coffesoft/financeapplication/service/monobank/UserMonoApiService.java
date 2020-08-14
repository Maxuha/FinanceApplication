package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.model.monobank.UserMono;

public interface UserMonoApiService {
    UserMono getUserMonoByTokenFromMonoApi(String token);
}
