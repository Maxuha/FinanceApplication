package com.coffesoft.financeapplication.model.monobank;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mono_currency")
public class CurrencyMono {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "currency_code_a")
    private Integer currencyCodeA;
    @Column(name = "currency_code_b")
    private Integer currencyCodeB;
    private LocalDateTime date;
    @Column(name = "rate_buy")
    private Float rateBuy;
    @Column(name = "rate_sell")
    private Float rateSell;
    @Column(name = "rate_cross")
    private Float rateCross;

    public CurrencyMono() {
    }

    public CurrencyMono(Long id, Integer currencyCodeA, Integer currencyCodeB, LocalDateTime date, Float rateBuy, Float rateSell, Float reteCross) {
        this.id = id;
        this.currencyCodeA = currencyCodeA;
        this.currencyCodeB = currencyCodeB;
        this.date = date;
        this.rateBuy = rateBuy;
        this.rateSell = rateSell;
        this.rateCross = rateCross;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCurrencyCodeA() {
        return currencyCodeA;
    }

    public void setCurrencyCodeA(Integer currencyA) {
        this.currencyCodeA = currencyA;
    }

    public Integer getCurrencyCodeB() {
        return currencyCodeB;
    }

    public void setCurrencyCodeB(Integer currencyB) {
        this.currencyCodeB = currencyB;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Float getRateBuy() {
        return rateBuy;
    }

    public void setRateBuy(Float rateBuy) {
        this.rateBuy = rateBuy;
    }

    public Float getRateSell() {
        return rateSell;
    }

    public void setRateSell(Float rateSell) {
        this.rateSell = rateSell;
    }

    public Float getRateCross() {
        return rateCross;
    }

    public void setRateCross(Float rateCross) {
        this.rateCross = rateCross;
    }
}
