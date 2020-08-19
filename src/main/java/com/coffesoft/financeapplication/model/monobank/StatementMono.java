package com.coffesoft.financeapplication.model.monobank;

import com.coffesoft.financeapplication.model.monobank.api.StatementMonoApi;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "statement_mono")
public class StatementMono {
    @Id
    @Column
    private String id;
    @Column(name = "time")
    private LocalDateTime dateTime;
    @Column
    private String description;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "mcc_id", nullable = false)
    private Mcc mcc;
    @Column
    private Integer amount;
    @Column(name = "operation_amount")
    private Integer operationAmount;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "currency_code_id", nullable = false)
    private CurrencyCode currencyCode;
    @Column(name = "commission_rate")
    private Integer commissionRate;
    @Column(name = "cashback_amount")
    private Integer cashbackAmount;
    private Boolean hold;
    @ManyToOne(optional = false)
    @JoinColumn(name = "account_mono_id")
    private AccountMono accountMono;

    public StatementMono() {
    }

    public StatementMono(StatementMonoApi statementMonoApi, Mcc mcc, CurrencyCode currencyCode, AccountMono accountMono) {
        id = statementMonoApi.getId();
        dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(statementMonoApi.getTime()), ZoneId.systemDefault());
        description = statementMonoApi.getDescription();
        amount = statementMonoApi.getAmount();
        operationAmount = statementMonoApi.getOperationAmount();
        commissionRate = statementMonoApi.getCommissionRate();
        cashbackAmount = statementMonoApi.getCashbackAmount();
        this.mcc = mcc;
        this.currencyCode = currencyCode;
        this.accountMono = accountMono;
    }

    public StatementMono(String id, LocalDateTime dateTime, String description, Mcc mcc, Integer amount,
                         Integer operationAmount, CurrencyCode currencyCode, Integer commissionRate,
                         Integer cashbackAmount, AccountMono accountMono, Boolean hold) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.mcc = mcc;
        this.amount = amount;
        this.operationAmount = operationAmount;
        this.currencyCode = currencyCode;
        this.commissionRate = commissionRate;
        this.cashbackAmount = cashbackAmount;
        this.accountMono = accountMono;
        this.hold = hold;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Mcc getMcc() {
        return mcc;
    }

    public void setMcc(Mcc mcc) {
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

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
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

    public Boolean getHold() {
        return hold;
    }

    public void setHold(Boolean hold) {
        this.hold = hold;
    }

    public AccountMono getAccountMono() {
        return accountMono;
    }

    public void setAccountMono(AccountMono accountMono) {
        this.accountMono = accountMono;
    }
}
