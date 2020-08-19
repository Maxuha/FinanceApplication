package com.coffesoft.financeapplication.model.monobank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "mcc")
public class Mcc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Integer mcc;
    @JsonIgnore
    @XmlTransient
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "mcc")
    private StatementMono statementMono;

    public Mcc() {
    }

    public Mcc(Integer mcc) {
        this.mcc = mcc;
    }

    public Mcc(Long id, Integer mcc, StatementMono statementMono) {
        this.id = id;
        this.mcc = mcc;
        this.statementMono = statementMono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMcc() {
        return mcc;
    }

    public void setMcc(Integer mcc) {
        this.mcc = mcc;
    }

    public StatementMono getStatementMono() {
        return statementMono;
    }

    public void setStatementMono(StatementMono statementMono) {
        this.statementMono = statementMono;
    }
}
