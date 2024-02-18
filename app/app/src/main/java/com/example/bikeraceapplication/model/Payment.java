package com.example.bikeraceapplication.model;
import com.example.bikeraceapplication.util.Money;
import java.util.Date;
import java.util.UUID;

public class Payment {
    private String transactionId;
    private Date date;
    private Money amount;

    public Payment(Money amount) {
        this.setTransactionId();
        this.date = new Date();
        this.amount = amount;
    }

    private void setTransactionId(){
        this.transactionId= UUID.randomUUID().toString();
    }

    public String getTransactionId(){
        return this.transactionId;
    }

    public Date getDate() {
        return date;
    }

    public Money getAmount() {
        return amount;
    }
}
