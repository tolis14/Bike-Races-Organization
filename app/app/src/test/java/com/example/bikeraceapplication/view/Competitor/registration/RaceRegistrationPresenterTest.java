package com.example.bikeraceapplication.view.Competitor.registration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.bikeraceapplication.dao.CompetitorDAO;
import com.example.bikeraceapplication.dao.EmailDAO;
import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.memorydao.CompetitorDAOMemory;
import com.example.bikeraceapplication.memorydao.EmailDAOMemory;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.memorydao.RaceDAOMemory;
import com.example.bikeraceapplication.model.Participation;
import com.example.bikeraceapplication.model.Race;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

public class RaceRegistrationPresenterTest {

    private RaceRegistrationViewStub viewStub;
    private RaceRegistrationPresenter presenter;
    private RaceDAO raceDAO;
    private CompetitorDAO competitorDAO;
    private EmailDAO emailDAO;

    @Before
    public void setUp(){

        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        viewStub = new RaceRegistrationViewStub();
        presenter = new RaceRegistrationPresenter();
        presenter.setView(viewStub);
        raceDAO = new RaceDAOMemory();
        competitorDAO = new CompetitorDAOMemory();
        emailDAO = new EmailDAOMemory();
        presenter.setRaceDAO(raceDAO);
        presenter.setCompetitorDAO(competitorDAO);
    }

    @Test
    public void viewOkay(){
        Assert.assertNotNull(presenter.getView());
    }

    @Test
    public void errorWhenNoRacesConformToCriteria(){

        presenter.search("","A place that does not match anything","","","");
        Assert.assertEquals(1,viewStub.getErrorCount());
        Assert.assertEquals("races not found",viewStub.getErrorMsg());
    }

    @Test
    public void errorWhenAlreadyRegisteredInSuchRace(){

        //nikos has already registered in race1Id
        presenter.registerToRace("race1Id","competitor_nikos");
        Assert.assertEquals(1,viewStub.getErrorCount());
        Assert.assertEquals("already registered in this race",viewStub.getErrorMsg());

        //stathis has already registered in race2Id
        presenter.registerToRace("race2Id","competitor_stathis");
        Assert.assertEquals(2,viewStub.getErrorCount());
        Assert.assertEquals("already registered in this race",viewStub.getErrorMsg());

    }

    @Test
    public void errorWhenCardHasNotEnoughFunds(){
        //dummy competitor can not afford any race

        presenter.registerToRace("race1Id","competitor_dummy");
        Assert.assertEquals(1,viewStub.getErrorCount());
        Assert.assertEquals("not enough money in your card",viewStub.getErrorMsg());

        presenter.registerToRace("race3Id","competitor_dummy");
        Assert.assertEquals(2,viewStub.getErrorCount());
        Assert.assertEquals("not enough money in your card", viewStub.getErrorMsg());
    }

    @Test
    public void errorWhenWrongIdProvided(){

        presenter.registerToRace("wrong race id","wrong competitor id");
        Assert.assertEquals(1,viewStub.getErrorCount());
        Assert.assertEquals("invalid options", viewStub.getErrorMsg());

        presenter.registerToRace("race1Id","wrong competitor id");
        Assert.assertEquals(2,viewStub.getErrorCount());
        Assert.assertEquals("invalid options", viewStub.getErrorMsg());

        presenter.registerToRace("wrong race id","competitor_tolis");
        Assert.assertEquals(3,viewStub.getErrorCount());
        Assert.assertEquals("invalid options", viewStub.getErrorMsg());
    }

    @Test
    public void successfulRegistration(){

        String targetExistingId = "race4Id";

        Race race = raceDAO.findById(targetExistingId);
        String raceName = race.getName();
        int beforeRegister = race.getNumParticipations(); // keep the number of participations before.

        presenter.registerToRace("race4Id","competitor_tolis");

        Assert.assertEquals(1,viewStub.getStatusCount());
        Assert.assertEquals("successfully registered to "+raceName,viewStub.getStatusMsg());

        int afterRegister = race.getNumParticipations();

        assertTrue(beforeRegister == afterRegister - 1);


        Set<Participation> participations = raceDAO.findById(targetExistingId).getParticipations();
        Assert.assertEquals(1,participations.size());


        presenter.registerToRace("race4Id","competitor_nikos");
        Assert.assertEquals(2,viewStub.getStatusCount());
        Assert.assertEquals("successfully registered to "+raceName,viewStub.getStatusMsg());

        participations = raceDAO.findById(targetExistingId).getParticipations();
        Assert.assertEquals(2,participations.size());


        /*check if participations get the correct increasing id*/

        ArrayList<Integer> ids = new ArrayList<>();

        for(Participation participation : participations)
            ids.add(participation.getId());

        Assert.assertTrue(ids.contains(1));
        Assert.assertTrue(ids.contains(2));
    }

    @Test
    public void checkEmailSent(){


        int mailsBefore = emailDAO.findAll().size();

        presenter.registerToRace("race4Id","competitor_tolis");
        presenter.registerToRace("race4Id","competitor_nikos");

        int mailsAfter = emailDAO.findAll().size();

        Assert.assertEquals(mailsAfter,mailsBefore + 2);

    }

    @Test
    public void checkMoneyBind(){

        double amountBeforeRegistration = competitorDAO.findById("competitor_tolis").getCard().getBalance().getAmount();

        presenter.registerToRace("race4Id","competitor_tolis");

        double raceCost = raceDAO.findById("race4Id").getCost().getAmount();

        double amountAfterRegistration = competitorDAO.findById("competitor_tolis").getCard().getBalance().getAmount();

        Assert.assertEquals(amountAfterRegistration,amountBeforeRegistration - raceCost,0.00001);
    }

}
