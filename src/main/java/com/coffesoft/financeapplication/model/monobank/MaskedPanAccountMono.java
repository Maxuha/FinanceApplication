package com.coffesoft.financeapplication.model.monobank;

import javax.persistence.*;

@Entity
@Table(name = "masked_pan_account_mono")
public class MaskedPanAccountMono {
    @Id
    private Integer id;
    @Column(name = "masked_pan")
    private String maskedPan;
    @Column(name = "full_number")
    private String fullNumber;
    @Column(name = "expiration_rate")
    private String expirationDate;
    private Integer cvv;
    @ManyToOne
    private AccountMono accountMonoId;

    public MaskedPanAccountMono() {
    }

    public MaskedPanAccountMono(Integer id, String maskedPan, String fullNumber, String expirationDate, Integer cvv, AccountMono accountMonoId) {
        this.id = id;
        this.maskedPan = maskedPan;
        this.fullNumber = fullNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.accountMonoId = accountMonoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getFullNumber() {
        return fullNumber;
    }

    public void setFullNumber(String fullNumber) {
        this.fullNumber = fullNumber;
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

    public AccountMono getAccountMonoId() {
        return accountMonoId;
    }

    public void setAccountMonoId(AccountMono accountMonoId) {
        this.accountMonoId = accountMonoId;
    }
}
