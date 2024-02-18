package com.example.bikeraceapplication.model;
import com.example.bikeraceapplication.util.*;
import com.example.bikeraceapplication.contacts.Email;

public class Sponsor extends User{

    private String company;
    private Card card;

    public Sponsor(){
        setRole(Role.SPONSOR);
    }

    public Sponsor(String firstName, String lastName, Email email, String password,String company, Card card) {
        super(firstName, lastName, email, password,Role.SPONSOR);
        this.company = company;
        this.card = card;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}
