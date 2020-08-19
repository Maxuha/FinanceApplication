package com.coffesoft.financeapplication.model.monobank.api;

import java.util.List;

public class UserMonoApi {
    private String clientId;
    private String name;
    private String webHookUrl;
    private List<AccountMonoApi> accounts;

    public UserMonoApi() {
    }

    public UserMonoApi(String clientId, String name, String webHookUrl, List<AccountMonoApi> accounts) {
        this.clientId = clientId;
        this.name = name;
        this.webHookUrl = webHookUrl;
        this.accounts = accounts;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebHookUrl() {
        return webHookUrl;
    }

    public void setWebHookUrl(String webHookUrl) {
        this.webHookUrl = webHookUrl;
    }

    public List<AccountMonoApi> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountMonoApi> accounts) {
        this.accounts = accounts;
    }
}
