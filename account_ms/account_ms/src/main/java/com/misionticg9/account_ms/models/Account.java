package com.misionticg9.account_ms.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Account{
    @Id
    private String username;
    private Integer balance;
    private Date lastChange;

    public Account(String username, Integer balance, Date lastChange) {
        this.username = username;
        this.balance = balance;
        this.lastChange = lastChange;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }
}

