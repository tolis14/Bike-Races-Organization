package com.example.bikeraceapplication.model;

import com.example.bikeraceapplication.contacts.Email;
import com.example.bikeraceapplication.util.Card;

public class Competitor extends User{
    private Card card;

    public Competitor() {
        setRole(Role.COMPETITOR);
    }

    public Competitor(String firstName, String lastName, Email email, String password,Card card) {
        super(firstName, lastName, email,password,Role.COMPETITOR);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
