package com.coffesoft.financeapplication.model.system;

import com.coffesoft.financeapplication.model.personal.PersonalCash;
import com.coffesoft.financeapplication.model.personal.UserCard;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_card_id")
    private UserCard userCard;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "personal_cash_id", nullable = false)
    private PersonalCash personalCash;
    @JsonIgnore
    @XmlTransient
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "wallet")
    private User user;

    public Wallet() {
    }

    public Wallet(Long id, UserCard userCard, PersonalCash personalCash, User user) {
        this.id = id;
        this.userCard = userCard;
        this.personalCash = personalCash;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserCard getUserCard() {
        return userCard;
    }

    public void setUserCard(UserCard userCard) {
        this.userCard = userCard;
    }

    public PersonalCash getPersonalCash() {
        return personalCash;
    }

    public void setPersonalCash(PersonalCash personalCash) {
        this.personalCash = personalCash;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
