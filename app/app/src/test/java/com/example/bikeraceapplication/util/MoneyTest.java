package com.example.bikeraceapplication.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoneyTest {

    private Money money;

    @Before
    public void setUp(){
        money = null;
    }

    @Test
    public void testAmount(){
        money = new Money(20.0);
        Assert.assertEquals(money.getAmount(),20.0,0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeAmountMoney(){
        money = new Money(-5.0);
    }

    @Test
    public void testPlus(){
        Money money1 = new Money(15.0);
        Money money2 = new Money(50.0);
        money = money1.plus(money2);
        Assert.assertEquals(money.getAmount(),65.0,0.00001);
    }

    @Test
    public void testMinus() throws IllegalMoneySub {
        Money money1 = new Money(45.0);
        Money money2 = new Money(15.0);
        money = money1.minus(money2);
        Assert.assertEquals(money.getAmount(),30.0,0.00001);
    }

    @Test(expected = IllegalMoneySub.class)
    public void testGreaterAmountMinus() throws IllegalMoneySub{
        Money money1 = new Money(15.0);
        Money money2 = new Money(45.0);
        money = money1.minus(money2);
    }

    @Test
    public void checkEqualitySameObject(){
        money = new Money(10.0);
        Money money1 = money;
        Assert.assertEquals(money,money1);
    }

    @Test
    public void checkEqualitySameAmount(){
        money = new Money(20.0);
        Money money1 = new Money(20.0);
        Assert.assertEquals(money,money1);
    }

    @Test
    public void checkEqualityDifferentAmount(){
        money = new Money(20.0);
        Money money1 = new Money(10.0);
        Assert.assertNotEquals(money,money1);
    }

    @Test
    public void checkComparisons(){
        money = new Money(20.0);
        Money other = new Money(15.0);

        int res = money.compareTo(other);
        Assert.assertEquals(res > 0,true);

        other.setAmount(25.0);
        res = money.compareTo(other);
        Assert.assertEquals(res<0, true);

        other.setAmount(20.0);
        res = money.compareTo(other);
        Assert.assertEquals(res,0);

    }
}
