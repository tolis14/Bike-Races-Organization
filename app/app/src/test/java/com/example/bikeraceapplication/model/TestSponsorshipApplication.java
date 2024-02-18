package com.example.bikeraceapplication.model;

import com.example.bikeraceapplication.contacts.Email;
import com.example.bikeraceapplication.util.Card;
import com.example.bikeraceapplication.util.Money;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestSponsorshipApplication {
    private SponsorshipApplication sponsorshipApplication;

    @Before
    public void setUp(){
        sponsorshipApplication = new SponsorshipApplication();
    }

    @Test
    public void testSponsor(){
        Sponsor sponsor = new Sponsor("tolis","kapetis",new Email("tolisk37@gmail.com"),"zzz","Microsoft",new Card());
        this.sponsorshipApplication = new SponsorshipApplication(500.0,sponsor);
        Assert.assertSame(this.sponsorshipApplication.getSponsor(), sponsor);
    }


    @Test
    public void checkApproved(){
        Assert.assertEquals(this.sponsorshipApplication.isApproved(),false);
        this.sponsorshipApplication.setApproved(true);
        Assert.assertEquals(this.sponsorshipApplication.isApproved(),true);
    }

    @Test
    public void sponsorshipAppWithoutApproval(){
        Sponsorship sponsorship = new Sponsorship("This is a sponsorship for the race");
        Payment payment = new Payment(this.sponsorshipApplication.getAmount());

        this.sponsorshipApplication.setSponsorship(sponsorship);
        this.sponsorshipApplication.setPayment(payment);

        Assert.assertNull(this.sponsorshipApplication.getSponsorship());
        Assert.assertNull(this.sponsorshipApplication.getPayment());
    }

    @Test
    public void sponsorshipAfterApproval(){

        this.sponsorshipApplication.setAmount(200.0);
        this.sponsorshipApplication.setApproved(true);
        Sponsorship sponsorship = new Sponsorship("This is a sponsorship for the race");
        Payment payment = new Payment(this.sponsorshipApplication.getAmount());

        this.sponsorshipApplication.setSponsorship(sponsorship);
        this.sponsorshipApplication.setPayment(payment);


        Sponsorship sponsorship2 = new Sponsorship("This is a new sponsorship for the race");
        Payment payment2 = new Payment(this.sponsorshipApplication.getAmount());

        this.sponsorshipApplication.setSponsorship(sponsorship2);
        this.sponsorshipApplication.setPayment(payment2);


        Assert.assertNotNull(this.sponsorshipApplication.getSponsorship());
        Assert.assertSame(this.sponsorshipApplication.getSponsorship(),sponsorship);

        Assert.assertNotNull(this.sponsorshipApplication.getPayment());
        Assert.assertSame(this.sponsorshipApplication.getPayment(),payment);
    }


    @Test
    public void testPositiveAmount(){
        this.sponsorshipApplication.setAmount(500.0);
        Assert.assertEquals(this.sponsorshipApplication.getAmount().getAmount(),500.0,0.0001);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeAmount(){
        this.sponsorshipApplication.setAmount(-2.0);
    }

    @Test
    public void checkPaymentAmount(){
        this.sponsorshipApplication.setAmount(200.0);
        this.sponsorshipApplication.setApproved(true);
        Sponsorship sponsorship = new Sponsorship("This is a sponsorship for the race");
        Payment payment = new Payment(this.sponsorshipApplication.getAmount());

        this.sponsorshipApplication.setSponsorship(sponsorship);
        this.sponsorshipApplication.setPayment(payment);

        Assert.assertEquals(this.sponsorshipApplication.getAmount(),payment.getAmount());
        Assert.assertNotNull(this.sponsorshipApplication.getPayment().getTransactionId());
        Assert.assertNotNull(this.sponsorshipApplication.getPayment().getDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongAmountPayment(){
        this.sponsorshipApplication.setAmount(200.0);
        this.sponsorshipApplication.setApproved(true);

        Sponsorship sponsorship = new Sponsorship("This is a sponsorship for the race");
        Payment payment = new Payment(new Money(150.0));

        this.sponsorshipApplication.setSponsorship(sponsorship);
        this.sponsorshipApplication.setPayment(payment);
    }

    @Test
    public void checkDate(){
        Sponsor sponsor = new Sponsor("tolis","kapetis",new Email("tolisk37@gmail.com"),"zzz","Microsoft",new Card());
        this.sponsorshipApplication = new SponsorshipApplication(500.0,sponsor);
        Assert.assertNotNull(this.sponsorshipApplication.getDate());
    }
}
