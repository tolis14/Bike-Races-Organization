package com.example.bikeraceapplication.util;

import java.util.UUID;

public class Card {
    private String id;
    private Money balance;

    public Card() {
        this.setId();
        this.balance = new Money(0.0);
    }

    private void setId(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId(){
        return  this.id;
    }

    public void setBalance(double amount){
        if(this.balance != null)
            this.balance.setAmount(amount);
    }

    public void addToBalance(double amount){ balance = balance.plus(new Money(amount));}

    public void removeFromBalance(double amount){

        try {
            balance = balance.minus(new Money(amount));
        }
        catch (IllegalMoneySub e){
            e.printStackTrace();
        }
    }

    public Money getBalance(){
        return this.balance;
    }

}
