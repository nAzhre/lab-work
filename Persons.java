package com.example.demo7;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Persons {
    @NotNull
    private LocalDate birthday;

    @NotNull
    private BigDecimal balance;

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Persons() {
    }

    public Persons(LocalDate birthday, BigDecimal balance) {
        this.birthday = birthday;
        this.balance = balance;
    }
}
