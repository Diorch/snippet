package com.example.spi.domain;

import lombok.ToString;

import java.time.LocalDate;

/**
 * @author DechuYe
 * @date 7/2/20 1:33 AM
 */

@ToString
public class Quote {

    private String currency;
    private LocalDate date;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
