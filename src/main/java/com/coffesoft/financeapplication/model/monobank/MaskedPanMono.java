package com.coffesoft.financeapplication.model.monobank;

import javax.persistence.*;

@Entity
@Table(name = "masked_card_mono")
public class MaskedPanMono {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "masked_pan")
    private String maskedPan;
    @Column(name = "curt_number")
    private String cartNumber;
    @Column(name = "expiration_date")
    private String expirationDate;
    private Integer cvv;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_mono_id")
    private AccountMono accountMono;

    public MaskedPanMono() {
    }

    public MaskedPanMono(String maskedPan, AccountMono accountMono) {
        this.maskedPan = maskedPan;
        this.accountMono = accountMono;
    }

    public MaskedPanMono(Long id, String maskedPan, String cartNumber, String expirationDate, Integer cvv, AccountMono accountMono) {
        this.id = id;
        this.maskedPan = maskedPan;
        this.cartNumber = cartNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.accountMono = accountMono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public AccountMono getAccountMono() {
        return accountMono;
    }

    public void setAccountMono(AccountMono accountMono) {
        this.accountMono = accountMono;
    }
}
