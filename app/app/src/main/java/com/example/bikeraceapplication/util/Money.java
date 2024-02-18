package com.example.bikeraceapplication.util;

import com.example.bikeraceapplication.contacts.Email;

import java.util.Currency;
import java.util.Locale;

public class Money implements Comparable<Money>{

    private Currency currency;
    private double amount;

    public Money(double amount) {
        this.currency = Currency.getInstance(new Locale("en","gr"));
        this.setAmount(amount);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if(amount < 0)
            throw new IllegalArgumentException("Cannot assign negative amount");

        this.amount = amount;
    }

    public Money plus(Money other){
        return new Money(this.amount + other.amount);
    }


    public Money minus(Money other) throws IllegalMoneySub {
        if(this.amount < other.amount){
            throw new IllegalMoneySub("Can not subtract larger amount");
        }
        return new Money(this.amount - other.amount);
    }


    @Override
    public boolean equals(Object other){
        if(other == null) return false;

        if(other == this) return true;

        if(!(other instanceof Money)) return false;

        return this.amount == ((Money) other).amount;
    }

    @Override
    public int compareTo(Money other){
        return Double.compare(this.amount, other.amount);
    }
}
