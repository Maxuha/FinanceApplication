package com.coffesoft.financeapplication.model.monobank;

import com.coffesoft.financeapplication.model.monobank.api.UserMonoApi;
import com.coffesoft.financeapplication.model.personal.UserCard;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@Entity
@Table(name = "user_mono")
public class UserMono {
    @Id
    @Column
    private String id;
    @Column
    private String token;
    @Column
    private String name;
    @Column(name = "webhook_url")
    private String webHookUrl;
    @JsonIgnore
    @XmlTransient
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "userMono")
    private UserCard userCard;
    @JsonIgnore
    @XmlTransient
    @OneToMany(mappedBy = "userMono", fetch = FetchType.EAGER)
    private List<AccountMono> accountMonoList;

    public UserMono() {
    }

    public UserMono(UserMonoApi userMonoApi, String token) {
        this.token = token;
        id = userMonoApi.getClientId();
        name = userMonoApi.getName();
        webHookUrl = userMonoApi.getWebHookUrl();
    }

    public UserMono(String id, String token, String name, String webHookUrl, UserCard userCard, List<AccountMono> accountMonoList) {
        this.id = id;
        this.token = token;
        this.name = name;
        this.webHookUrl = webHookUrl;
        this.userCard = userCard;
        this.accountMonoList = accountMonoList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public UserCard getUserCard() {
        return userCard;
    }

    public void setUserCard(UserCard userCard) {
        this.userCard = userCard;
    }

    public List<AccountMono> getAccountMonoList() {
        return accountMonoList;
    }

    public void setAccountMonoList(List<AccountMono> accountMonoList) {
        this.accountMonoList = accountMonoList;
    }
}
