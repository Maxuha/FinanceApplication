package com.coffesoft.financeapplication.model.monobank;

import javax.persistence.*;

@Entity
@Table(name = "currency_code")
public class CurrencyCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String code;
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "currencyCode")
    private AccountMono accountMono;
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "currencyCode")
    private StatementMono statementMono;

    public CurrencyCode() {
    }

    public CurrencyCode(String code) {
        this.code = code;
    }

    public CurrencyCode(Long id, String code, AccountMono accountMono, StatementMono statementMono) {
        this.id = id;
        this.code = code;
        this.accountMono = accountMono;
        this.statementMono = statementMono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AccountMono getAccountMono() {
        return accountMono;
    }

    public void setAccountMono(AccountMono accountMono) {
        this.accountMono = accountMono;
    }

    public StatementMono getStatementMono() {
        return statementMono;
    }

    public void setStatementMono(StatementMono statementMono) {
        this.statementMono = statementMono;
    }
}
