package com.example.bikeraceapplication.view.Sponsor;

import android.graphics.Color;

import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.dao.SponsorDAO;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.memorydao.RaceDAOMemory;
import com.example.bikeraceapplication.memorydao.SponsorDAOMemory;
import com.example.bikeraceapplication.model.Sponsor;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SponsorPresenterTest {

    /**
     * Test class for SponsorPresenter
     */

    private SponsorDAO SponsorDAO;
    private RaceDAO RaceDAO;
    private SponsorPresenter sponsorPresenter;
    private SponsorViewStub viewStub;

    @Before
    public void setUp() {
        /**
         * This is a method that runs before every test
         */
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        viewStub = new SponsorViewStub();
        sponsorPresenter = new SponsorPresenter();
        SponsorDAO = new SponsorDAOMemory();
        RaceDAO = new RaceDAOMemory();
        sponsorPresenter.setView(viewStub);
        sponsorPresenter.setSponsorDAO(SponsorDAO);
        sponsorPresenter.setRaceDAO(RaceDAO);
        sponsorPresenter.createsponsor("spons1");
    }

    @Test
    public void viewOkay(){

        Assert.assertNotNull(sponsorPresenter.getView());
    }

    @Test
    public void testvalidatemoney() {
        /**
         * This is a test for the validatemoney method
         *
         * Checks if the race has been sponsored
         */
        Assert.assertFalse(sponsorPresenter.validatemoney("race4Id",10));
        Assert.assertTrue(sponsorPresenter.validatemoney("race3Id",10));

    }

    @Test
    public void testgetSponsor() {
        /**
         * This is a test for the getSponsor method
         *
         * Checks if the sponsor is added correctly
         */
        Assert.assertEquals("sponsor0",sponsorPresenter.getSponsor().getFirstName());
    }

    @Test
    public void testaddsponsorshipapplication() {
        /**
         * This is a test for the addsponsorshipapplication method
         *
         * Checks if the sponsorship application has been added properly to the race
         */
        sponsorPresenter.addsponsorshipapplication("race3Id",20);
        Assert.assertEquals(1,sponsorPresenter.getRaceDAO().findById("race3Id").getSponsorshipApplications().size());
    }

    @Test
    public void testvalidateSponsor() {
        /**
         * This is a test for the addsponsorshipapplication method
         *
         * Checks if the amount of money for the sponsorship is valid
         */
        Assert.assertTrue(sponsorPresenter.validateSponsor("10"));
        Assert.assertFalse(sponsorPresenter.validateSponsor("-10"));
        Assert.assertFalse(sponsorPresenter.validateSponsor(""));
    }

    @Test
    public void testsetSponsorDAO() {
        /**
         * This is a test for the setSponsorDAO method
         *
         * Checks if the SponsorDAO was set correctly
         */
        sponsorPresenter.setSponsorDAO(SponsorDAO);
        Assert.assertNotNull(sponsorPresenter.getSponsorDAO());
    }

    @Test
    public void testsetRaceDAO() {
        /**
         * This is a test for the setRaceDAO method
         *
         * Checks if the RaceDAO was set correctly
         */
        sponsorPresenter.setRaceDAO(RaceDAO);
        Assert.assertNotNull(sponsorPresenter.getRaceDAO());
    }

    @Test
    public void testNotEnoughmoney(){

        boolean result = sponsorPresenter.validateSponsor("800");
        Assert.assertFalse(result);
        Assert.assertEquals("Not enough money",viewStub.getMessage());
        Assert.assertEquals(Color.RED,viewStub.getColor());
    }

    @Test
    public void takeMoney(){

        Sponsor sponsor = sponsorPresenter.getSponsor();

        double amountBeforeSponsorshipApplication = sponsor.getCard().getBalance().getAmount();

        double amountOfApplication = 100;

        sponsorPresenter.addsponsorshipapplication("race3Id",amountOfApplication);

        double amountAfterSponsorshipApplication = sponsor.getCard().getBalance().getAmount();

        Assert.assertEquals(amountAfterSponsorshipApplication,amountBeforeSponsorshipApplication - amountOfApplication,0.00001);

    }

}