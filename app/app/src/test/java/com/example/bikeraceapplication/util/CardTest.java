package com.example.bikeraceapplication.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardTest {
    private Card card;

    @Before
    public void setUp(){
        card = new Card();
    }

    @Test
    public void createFirstTimeAmount(){
        Assert.assertEquals(card.getBalance(),new Money(0.0));
    }

    @Test
    public void testBalanceAmount(){
        card.setBalance(50.0);
        Assert.assertEquals(card.getBalance(),new Money(50.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeSetAmount(){
        card.setBalance(-10.0);
    }

    @Test
    public void initId(){
        Assert.assertNotNull(card.getId());
    }

    @Test
    public void checkAddToBalance(){

        card.addToBalance(200);
        Assert.assertEquals(200,card.getBalance().getAmount(),0.00001);

        card.addToBalance(100);
        Assert.assertEquals(300,card.getBalance().getAmount(),0.00001);
    }

    @Test
    public void checkMinusFromBalance() throws IllegalMoneySub{

        card.setBalance(100);
        card.removeFromBalance(50);
        Assert.assertEquals(50,card.getBalance().getAmount(),0.00001);

        card.removeFromBalance(200);

    }
}
