package com.coffesoft.financeapplication.model.personal;

import com.coffesoft.financeapplication.model.system.Wallet;

import javax.persistence.*;

@Entity
@Table(name = "personal_cash")
public class PersonalCash {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private Integer balance;
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "personalCash")
    private Wallet wallet;

    public PersonalCash() {
    }

    public PersonalCash(Long id, Integer balance, Wallet wallet) {
        this.id = id;
        this.balance = balance;
        this.wallet = wallet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
