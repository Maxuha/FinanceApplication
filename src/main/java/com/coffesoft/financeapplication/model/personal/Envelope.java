package com.coffesoft.financeapplication.model.personal;

import com.coffesoft.financeapplication.model.system.User;

import javax.persistence.*;

@Entity
@Table(name = "envelope")
public class Envelope {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;
    @Column
    private Integer percent;
    @Column
    private Integer balanceMax;
    @Column
    private Integer balanceCurrent;
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Envelope() {
    }

    public Envelope(Long id, String title, Integer percent, Integer balanceMax, Integer balanceCurrent, User user) {
        this.id = id;
        this.title = title;
        this.percent = percent;
        this.balanceMax = balanceMax;
        this.balanceCurrent = balanceCurrent;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public Integer getBalanceMax() {
        return balanceMax;
    }

    public void setBalanceMax(Integer balanceMax) {
        this.balanceMax = balanceMax;
    }

    public Integer getBalanceCurrent() {
        return balanceCurrent;
    }

    public void setBalanceCurrent(Integer balanceCurrent) {
        this.balanceCurrent = balanceCurrent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
