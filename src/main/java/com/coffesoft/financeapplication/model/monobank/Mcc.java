package com.coffesoft.financeapplication.model.monobank;

import javax.persistence.*;

@Entity
@Table(name = "mcc")
public class Mcc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Integer mcc;
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "mcc")
    private StatementMono statementMono;

    public Mcc() {
    }

    public Mcc(StatementMono statementMono) {
        this.statementMono = statementMono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
