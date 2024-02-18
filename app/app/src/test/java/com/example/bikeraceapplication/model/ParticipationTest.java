package com.example.bikeraceapplication.model;

import com.example.bikeraceapplication.util.Money;
import com.example.bikeraceapplication.util.Place;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class ParticipationTest {
    private Participation participation;

    @Before
    public void setUp() {
        Competitor competitor = new Competitor();
        Race race = new Race("name", new Place("city","location"), new Date(),RaceType.STREET,1000, new Date() , new Organizer(), new Money(0.0), new Money(0.0));
        participation = new Participation(competitor,race);
    }

    @Test
    public void testConstructor() {
        Assert.assertNotNull(participation.getDate());
        Assert.assertFalse(participation.isPaid());
        Assert.assertNotNull(participation.getCompetitor());
        Assert.assertNotNull(participation.getRace());
    }

    @Test
    public void generateId() {
        Competitor competitor = new Competitor();
        Race race = new Race("name", new Place("city","location"), new Date(),RaceType.STREET,1000,new Date() ,
                new Organizer(), new Money(0.0), new Money(0.0));
        participation = new Participation(competitor,race);
        race.addParticipant(participation);
        this.participation.generateId();
        Assert.assertEquals(1,participation.getId());

    }

    @Test
    public void testGetDate() {
        Assert.assertNotNull(participation.getDate());
    }

    @Test
    public void testIsPaid() {
        participation.setPaid(true);
        Assert.assertTrue(participation.isPaid());
    }

   @Test
    public void testGetFinishTime() {
        participation = new Participation();
        participation.setPlace(5);
        Assert.assertEquals(5,participation.getPlace());
    }

    @Test
    public void testGetCompetitor() {
        Assert.assertNotNull(participation.getCompetitor());
    }

    @Test
    public void testGetRace() {
        Assert.assertNotNull(participation.getRace());
    }

    @Test
    public void testGetPayment() {
        Payment payment = new Payment(new Money(10.0));
        participation.setPayment(payment);
        Assert.assertNotNull(participation.getPayment());
    }

}