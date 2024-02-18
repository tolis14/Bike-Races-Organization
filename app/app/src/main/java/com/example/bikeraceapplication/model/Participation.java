package com.example.bikeraceapplication.model;

import java.util.Date;

public class Participation {
    private int id;
    private Date date;
    private boolean isPaid;
    private int place;
    private Competitor competitor;
    private Race race;
    private Payment payment;

    public Participation() {}

    public Participation(Competitor competitor, Race race) {
        this.date = new Date();
        this.setPaid(false);
        this.competitor = competitor;
        this.race = race;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public void generateId() {
        this.id = race.getNumParticipations();
    }

    public Date getDate() {
        return date;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public Race getRace() { return race; }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString(){
        return "ID: "+getId()+"\n Name: "+this.getCompetitor().getFirstName();
    }
}


