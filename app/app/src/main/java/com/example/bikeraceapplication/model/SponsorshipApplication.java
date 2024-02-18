package com.example.bikeraceapplication.model;
import com.example.bikeraceapplication.util.Money;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class SponsorshipApplication {
    private String id;
    private Money amount;
    private Date date;
    private boolean isApproved;
    private Sponsor sponsor;
    private Sponsorship sponsorship;
    private Payment payment;

    public SponsorshipApplication(){}

    public SponsorshipApplication(double amount, Sponsor sponsor){
        this.setId();
        this.setAmount(amount);
        this.date = new Date();
        this.setApproved(false);
        this.sponsor = sponsor;
    }

    private void setId(){
        this.id = UUID.randomUUID().toString();
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(double amount){
        if(amount <= 0)
            throw new IllegalArgumentException("Sponsorship's amount should be greater than 0");
        this.amount = new Money(amount);
    }

    public String getId(){return this.id;}

    public Date getDate() {
        return date;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public Sponsorship getSponsorship() {
        return sponsorship;
    }

    public void setSponsorship(Sponsorship sponsorship) {
        if(this.sponsorship == null && this.isApproved)
            this.sponsorship = sponsorship;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {

        if(this.payment != null || !this.isApproved) return;

        if(payment.getAmount().compareTo(this.amount) != 0)
            throw new IllegalArgumentException("Payment is not accepted. Invalid amount of money");

        this.payment = payment;
    }
}
