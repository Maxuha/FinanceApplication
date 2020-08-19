package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.model.monobank.UserMono;
import com.coffesoft.financeapplication.util.GetRequest;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserMonoApiServiceImpl implements UserMonoApiService {
    private static final String url = "https://api.monobank.ua/personal/client-info";
    private final GetRequest getRequest;

    public UserMonoApiServiceImpl(GetRequest getRequest) {
        this.getRequest = getRequest;
    }

    @Override
    public UserMono getUserMonoByTokenFromMonoApi(String token) {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Token", token);
        String response = getRequest.getWithHeaderRequest(url, headers);
        return new Gson().fromJson(response, UserMono.class);
    }
}
