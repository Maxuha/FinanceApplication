package com.coffesoft.financeapplication.model.system;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_details")
public class UserDetails {
    @Id
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    @Column
    private String email;
    @Column(name = "date_register")
    private LocalDateTime dateTimeRegister;
    @Column(name = "last_date")
    private LocalDateTime lastDateTime;
    @OneToOne
    private User user;

    public UserDetails() {
    }

    public UserDetails(Integer id, String fullName, String email, LocalDateTime dateTimeRegister, LocalDateTime lastDateTime, User user) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.dateTimeRegister = dateTimeRegister;
        this.lastDateTime = lastDateTime;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateTimeRegister() {
        return dateTimeRegister;
    }

    public void setDateTimeRegister(LocalDateTime dateTimeRegister) {
        this.dateTimeRegister = dateTimeRegister;
    }

    public LocalDateTime getLastDateTime() {
        return lastDateTime;
    }

    public void setLastDateTime(LocalDateTime lastDateTime) {
        this.lastDateTime = lastDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
