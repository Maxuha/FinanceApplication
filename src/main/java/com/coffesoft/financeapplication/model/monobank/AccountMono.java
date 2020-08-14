package com.coffesoft.financeapplication.model.monobank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account_mono")
public class AccountMono {
    @Id
    private String id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "currency_code_id", nullable = false)
    private CurrencyCode currencyCode;
    @Column(name = "cashback_type")
    private String cashbackType;
    @Column
    private Integer balance;
    @Column(name = "credit_limit")
    private Integer creditLimit;
    @Column
    private String type;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "masked_pan_id")
    private MaskedPanMono maskedPanMono;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_mono_id")
    private UserMono userMono;
    @OneToMany(mappedBy = "accountMono", fetch = FetchType.EAGER)
    private List<StatementMono> statementMonoList;

    public AccountMono() {
    }

    public AccountMono(String id, CurrencyCode currencyCode, String cashbackType, Integer balance, Integer creditLimit, String type, MaskedPanMono maskedPanMono, UserMono userMono, List<StatementMono> statementMonoList) {
        this.id = id;
        this.currencyCode = currencyCode;
        this.cashbackType = cashbackType;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.type = type;
        this.maskedPanMono = maskedPanMono;
        this.userMono = userMono;
        this.statementMonoList = statementMonoList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MaskedPanMono getMaskedPanMono() {
        return maskedPanMono;
    }

    public void setMaskedPanMono(MaskedPanMono maskedPanMono) {
        this.maskedPanMono = maskedPanMono;
    }

    public UserMono getUserMono() {
        return userMono;
    }

    public void setUserMono(UserMono userMono) {
        this.userMono = userMono;
    }

    public List<StatementMono> getStatementMonoList() {
        return statementMonoList;
    }

    public void setStatementMonoList(List<StatementMono> statementMonoList) {
        this.statementMonoList = statementMonoList;
    }
}
