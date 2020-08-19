package com.coffesoft.financeapplication.service.monobank;

import com.coffesoft.financeapplication.model.monobank.AccountMono;
import com.coffesoft.financeapplication.model.monobank.api.StatementMonoApi;
import com.coffesoft.financeapplication.util.GetRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatementMonoApiServiceImpl implements StatementMonoApiService {
    private static final String DOMAIN = "https://api.monobank.ua/personal/statement";
    private final GetRequest getRequest;

    public StatementMonoApiServiceImpl(GetRequest getRequest) {
        this.getRequest = getRequest;
    }

    @Override
    public List<StatementMonoApi> getStatementMonoByTokenForAccountOfMouthFromMonoApi(String token, AccountMono accountMono,
                                                                                   Long from, Long to) {
        Map<String, String> header = new HashMap<>();
        header.put("X-Token", token);
        String url = String.format("%s/%s/%s/%s", DOMAIN, accountMono.getId(), from, to);
        String json = getRequest.getWithHeaderRequest(url, header);
        System.out.println(json);
        return new Gson().fromJson(json, new TypeToken<List<StatementMonoApi>>() {}.getType() );
    }
}
