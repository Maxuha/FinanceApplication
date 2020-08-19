package com.coffesoft.financeapplication.model.monobank.api;

import java.util.List;

public class AccountMonoApi {
    private String id;
    private Integer currencyCode;
    private String cashbackType;
    private Integer balance;
    private Integer creditLimit;
    private List<String> maskedPan;
    private String type;

    public AccountMonoApi() {
    }

    public AccountMonoApi(String id, Integer currencyCode, String cashbackType, Integer balance, Integer creditLimit, List<String> maskedPan, String type) {
        this.id = id;
        this.currencyCode = currencyCode;
        this.cashbackType = cashbackType;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.maskedPan = maskedPan;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(Integer currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCashbackType() {
        return cashbackType;
    }

    public void setCashbackType(String cashbackType) {
        this.cashbackType = cashbackType;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public List<String> getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(List<String> maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
