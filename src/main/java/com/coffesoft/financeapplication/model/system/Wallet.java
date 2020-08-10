package com.coffesoft.financeapplication.model.system;

import com.coffesoft.financeapplication.model.personal.PersonalCash;
import com.coffesoft.financeapplication.model.personal.UserCard;

import javax.persistence.*;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_card_id", nullable = false)
    private UserCard userCard;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "personal_cash_id", nullable = false)
    private PersonalCash personalCash;
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "wallet")
    private User user;

    public Wallet() {
    }

    public Wallet(Integer id, UserCard userCard, PersonalCash personalCash, User user) {
        this.id = id;
        this.userCard = userCard;
        this.personalCash = personalCash;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
