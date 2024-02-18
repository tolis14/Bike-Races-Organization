package com.example.bikeraceapplication.model;

import com.example.bikeraceapplication.contacts.Email;

import com.example.bikeraceapplication.util.Card;
import com.example.bikeraceapplication.util.Money;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompetitorTest {
    private Card card;
    private Competitor competitor;
    private Email email;

    @Before
    public void setUp() {
        card = new Card();
        email = new Email("default");
        competitor = new Competitor("firstName", "lastName", email, "password",card);
    }


    /**
     * Tests if Competitor constructor is working as intended
     * Checks if Competitor object competitor is not null
     */
    @Test
    public void testNull() {
        Assert.assertNotNull(competitor);
    }


    /**
     * Tests if Competitor constructor is working as intended
     * Checks if Competitor object competitor has all its values
     * set correctly by the constructor
     */
    @Test
    public void testConstructor() {
        Assert.assertEquals(competitor.getEmail().getAddress(), "default");
        Assert.assertEquals(competitor.getFirstName(), "firstName");
        Assert.assertEquals(competitor.getLastName(), "lastName");
        Assert.assertNotNull(competitor.getCard());
    }

    /**
     * Tests if setCard and getCard are working correctly
     * Constructs a new Competitor and sets card with balance=22
     * Checks if balance amount=22
     */
    @Test
    public void testGetCard() {
        competitor = new Competitor();
        Money money=new Money(22);
        card = new Card();
        card.setBalance(22);
        competitor.setCard(card);
        Assert.assertEquals(money.getAmount(),competitor.getCard().getBalance().getAmount(),0.001);
    }

}