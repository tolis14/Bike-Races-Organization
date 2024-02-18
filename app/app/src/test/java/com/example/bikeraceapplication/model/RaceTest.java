package com.example.bikeraceapplication.model;

import com.example.bikeraceapplication.contacts.Email;
import com.example.bikeraceapplication.util.Money;
import com.example.bikeraceapplication.util.Place;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Ref;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


public class RaceTest {
    private Race race;

    @Before
    public void setUp() {
        Date date = new Date();
        Date dueTime = new Date();
        Email mail = new Email("babisvovos@mail.gr");
        Organizer organizer = new Organizer("babis", "vovos", mail , "123456","babisvovos.inc");
        Money cost = new Money(15);
        Money  minGatheredAmount = new Money(45);
        Place place = new Place("Athens","Marousi");
        race = new Race("name",place, date, RaceType.OFFROAD, 100,
                 dueTime , organizer, cost,  minGatheredAmount);
        race.setId("raceID");
    }

    @Test
    public void testNull(){
        Assert.assertNotNull(race);
    }

    @Test
    public void testConstructor(){
        Assert.assertEquals(race.getName(),"name");
        Assert.assertEquals(race.getPlace().getLocation(), "Marousi");
        Assert.assertEquals(race.getPlace().getCity(),"Athens");
        Assert.assertEquals(race.getType(),RaceType.OFFROAD);
        Assert.assertEquals(race.getDistance(),100);
        Assert.assertEquals(race.getOrganizer().getFirstName(),"babis");
        Assert.assertEquals(race.getMinGatheredAmount().getAmount(),45.0,0.00001);
        Assert.assertEquals(race.getCost().getAmount(),15,0.000001);
        Assert.assertNotNull(race.getId());
        Assert.assertNotNull(race.getParticipations());

    }

    @Test
    public void testSetters(){
        Race race=new Race();
        race.setDate(new Date());
        race.setDistance(22);
        race.setDueTime(new Date());
        race.setOrganizer(new Organizer());
        race.setReferee(new Referee());
        race.setMinGatheredAmount(new Money(70));

        Assert.assertNotNull(race.getDate());
        Assert.assertEquals(race.getDistance(),22);
        Assert.assertNotNull(race.getDueTime());
        Assert.assertNotNull(race.getOrganizer());
        Assert.assertNotNull(race.getReferee());
        Assert.assertNotNull(race.getMinGatheredAmount());

    }


    @Test
    public void testAddSponsorshipApplication(){
        Assert.assertEquals(0,race.getSponsorshipApplications().size());
        SponsorshipApplication sponsorshipApplication = new SponsorshipApplication(20.0,new Sponsor());
        race.addSponsorshipApplication(sponsorshipApplication);
        Assert.assertEquals(1,race.getSponsorshipApplications().size());
        SponsorshipApplication sponsorshipApplication2 = new SponsorshipApplication(30.0,new Sponsor());
        race.addSponsorshipApplication(sponsorshipApplication2);
        Assert.assertEquals(2,race.getSponsorshipApplications().size());
    }


    @Test
    public void testGetNumParticipations(){
        Assert.assertEquals(0,race.getNumParticipations());

        for(int i=0; i<4;i++)
            race.addParticipant(new Participation());
        Assert.assertEquals(4,race.getNumParticipations());

        for(int i=0; i<6;i++)
            race.addParticipant(new Participation());
        Assert.assertEquals(10,race.getNumParticipations());

    }

    @Test
    public void testHasMinCostComplete(){
        Assert.assertFalse(race.hasMinCostComplete());
        race.addParticipant(new Participation());

        SponsorshipApplication sponsorshipApplication=new SponsorshipApplication(60.0, new Sponsor());
        race.addSponsorshipApplication(sponsorshipApplication);
        Assert.assertFalse(race.hasMinCostComplete());

        sponsorshipApplication.setApproved(true);
        Assert.assertTrue(race.hasMinCostComplete());
    }

    @Test
    public void raceConductionWithoutMinAmount() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String dueTimeString = "10-05-2022";
        Date dueTime = format.parse(dueTimeString);
        this.race.setDueTime(dueTime);

        this.race.addParticipant(new Participation());
        this.race.addParticipant(new Participation());

        Assert.assertFalse(this.race.shouldRaceBeConducted());
    }

    @Test
    public void raceConductionWithMinAmount() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String dueTimeString = "10-05-2022";
        Date dueTime = format.parse(dueTimeString);
        this.race.setDueTime(dueTime);

        this.race.addParticipant(new Participation());
        this.race.addParticipant(new Participation());

        SponsorshipApplication sponsorshipApplication = new SponsorshipApplication(50.0,new Sponsor());
        sponsorshipApplication.setApproved(true);
        this.race.addSponsorshipApplication(sponsorshipApplication);

        Assert.assertTrue(this.race.shouldRaceBeConducted());

    }

    @Test
    public void addNull(){

        this.race.addSponsorshipApplication(null);
        Assert.assertEquals(this.race.getSponsorshipApplications().size(),0);

        this.race.addParticipant(null);
        Assert.assertEquals(this.race.getNumParticipations(),0);
    }

    @Test
    public void checkDeepCopyReturn(){
        Set<SponsorshipApplication> actualSetApplication = this.race.sponsorshipApplications;
        Set<SponsorshipApplication> copySetApplication = this.race.getSponsorshipApplications();

        Assert.assertNotSame(actualSetApplication,copySetApplication);

        Set<Participation> actualSetParticipation = this.race.participations;
        Set<Participation> copySetParticipation = this.race.getParticipations();

        Assert.assertNotSame(actualSetParticipation, copySetParticipation);
    }

}