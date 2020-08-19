package com.coffesoft.financeapplication.model.monobank.api;

public class StatementMonoApi {
    private String id;
    private Long time;
    private String description;
    private Integer mcc;
    private Integer amount;
    private Integer operationAmount;
    private Integer currencyCode;
    private Integer commissionRate;
    private Integer cashbackAmount;
    private Integer balance;
    private Boolean hold;

    public StatementMonoApi() {
    }

    public StatementMonoApi(String id, Long time, String description, Integer mcc, Integer amount,
                            Integer operationAmount, Integer currencyCode, Integer commissionRate, Integer cashbackAmount,
                            Integer balance, Boolean hold) {
        this.id = id;
        this.time = time;
        this.description = description;
        this.mcc = mcc;
        this.amount = amount;
        this.operationAmount = operationAmount;
        this.currencyCode = currencyCode;
        this.commissionRate = commissionRate;
        this.cashbackAmount = cashbackAmount;
        this.balance = balance;
        this.hold = hold;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMcc() {
        return mcc;
    }

    public void setMcc(Integer mcc) {
        this.mcc = mcc;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getOperationAmount() {
        return operationAmount;
    }

    public void setOperationAmount(Integer operationAmount) {
        this.operationAmount = operationAmount;
    }

    public Integer getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(Integer currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Integer commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Integer getCashbackAmount() {
        return cashbackAmount;
    }

    public void setCashbackAmount(Integer cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Boolean getHold() {
        return hold;
    }

    public void setHold(Boolean hold) {
        this.hold = hold;
    }
}
