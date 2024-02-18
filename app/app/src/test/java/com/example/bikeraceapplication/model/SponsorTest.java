package com.example.bikeraceapplication.model;

import com.example.bikeraceapplication.contacts.Email;
import com.example.bikeraceapplication.util.Card;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SponsorTest {
    private Sponsor sponsor;

    @Before
    public void setUp(){
        this.sponsor = new Sponsor();
    }

    @Test
    public void testConstruction(){
        this.sponsor = new Sponsor("john","michailidhs",new Email("john@test.com"),"zzz","john company", new Card());
        Assert.assertNotNull(this.sponsor.getEmail());
        Assert.assertNotNull(this.sponsor.getCard());
        Assert.assertEquals(this.sponsor.getCompany(),"john company");
        Assert.assertEquals(this.sponsor.getFirstName(),"john");
        Assert.assertEquals(this.sponsor.getLastName(),"michailidhs");
    }

    @Test
    public void changeFields(){
        this.sponsor = new Sponsor("john","michailidhs",new Email("john@test.com"),"zzz","john company", new Card());
        Card newCard = new Card();
        this.sponsor.setCard(newCard);
        Assert.assertNotNull(this.sponsor.getCard());
        Assert.assertSame(this.sponsor.getCard(),newCard);

        String oldCompany = this.sponsor.getCompany();
        this.sponsor.setCompany("new company");

        Assert.assertNotNull(this.sponsor.getCompany());
        Assert.assertNotEquals(this.sponsor.getCompany(),oldCompany);

    }
}
