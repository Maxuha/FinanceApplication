package com.coffesoft.financeapplication.model.personal;

import com.coffesoft.financeapplication.model.monobank.UserMono;
import com.coffesoft.financeapplication.model.system.Wallet;

import javax.persistence.*;

@Entity
@Table(name = "user_card")
public class UserCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "userCard")
    private Wallet wallet;
    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_mono_id", nullable = false)
    private UserMono userMono;

    public UserCard() {
    }

    public UserCard(Long id, Wallet wallet, UserMono userMono) {
        this.id = id;
        this.wallet = wallet;
        this.userMono = userMono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public UserMono getUserMono() {
        return userMono;
    }

    public void setUserMono(UserMono userMono) {
        this.userMono = userMono;
    }
}
