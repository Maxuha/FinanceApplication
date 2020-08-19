package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.model.monobank.UserMono;
import com.coffesoft.financeapplication.model.monobank.api.UserMonoApi;

public interface UserMonoApiService {
    UserMonoApi getUserMonoByTokenFromMonoApi(String token);
}
