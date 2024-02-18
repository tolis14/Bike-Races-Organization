package com.example.bikeraceapplication.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSponsorship {

    private Sponsorship sponsorship;

    @Before
    public void setUp(){

        this.sponsorship = new Sponsorship();
        this.sponsorship.setDescription("This is a description for the sponsorship");
    }

    @Test
    public void newSponsorshipNotPaid(){
        Assert.assertEquals(this.sponsorship.isPaid(),false);
    }

    @Test
    public void descriptionModificationCheck(){
        this.sponsorship.setDescription("modifications to description");
        Assert.assertEquals(this.sponsorship.getDescription(),"modifications to description");
    }

    @Test
    public void paymentStatusChange(){
        this.sponsorship.setPaid(true);
        Assert.assertEquals(this.sponsorship.isPaid(),true);
    }
}
