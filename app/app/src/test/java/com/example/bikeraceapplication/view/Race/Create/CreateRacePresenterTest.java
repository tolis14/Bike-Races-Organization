package com.example.bikeraceapplication.view.Race.Create;

import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.dao.OrganizerDAO;
import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.memorydao.EmailDAOMemory;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.memorydao.OrganizerDAOMemory;
import com.example.bikeraceapplication.memorydao.RaceDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateRacePresenterTest {

    private CreateRaceViewStub viewStub;
    private CreateRacePresenter presenter;
    private RaceDAO raceDAO;
    private OrganizerDAO organizerDAO;

    private String raceName;
    private String racePlace;
    private String raceDate;
    private String raceType;
    private String raceDistance;
    private String deadLine;
    private String raceAmt;
    private String minRaceAmt;
    private String organizerID;

    @Before
    public void setUp(){
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        raceName = "race";
        racePlace = "City,Location";
        raceDate = "20-06-2022";
        raceType = "Street";
        raceDistance = "100";
        deadLine = "15-06-2022";
        raceAmt = "15";
        minRaceAmt = "500";
        organizerID = "org0id";
        viewStub = new CreateRaceViewStub();
        presenter = new CreateRacePresenter();
        raceDAO = new RaceDAOMemory();
        organizerDAO = new OrganizerDAOMemory();
        presenter.setView(viewStub);
        presenter.setRaceDao(raceDAO);
        presenter.setOrganizerDAO(organizerDAO);
    }

    @Test
    public void viewOkay(){
        Assert.assertNotNull(presenter.getView());
    }


    @Test
    public void checkMissingField(){

        raceName = "";
        raceDate = "";

        //assert that race did not created new size should be equal to the previous size
        int racesBeforeAttemptToCreate = raceDAO.findAll().size();
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        int racesAfterAttemptToCreate = raceDAO.findAll().size();
        Assert.assertEquals(racesBeforeAttemptToCreate,racesAfterAttemptToCreate);

        //assert view's messages
        Assert.assertEquals("some fields are missing",viewStub.getErrorMsg());
        Assert.assertEquals(1,viewStub.getErrorCount());

        raceName = "race";
        raceDate = "20-06-2022";
        racePlace = "";
        raceAmt = "";

        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("some fields are missing",viewStub.getErrorMsg());
        Assert.assertEquals(2,viewStub.getErrorCount());


    }

    @Test
    public void checkInvalidDateInput(){

        raceDate = "10-05-";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(1,viewStub.getErrorCount());

        raceDate = "-5-2022";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(2,viewStub.getErrorCount());


        /*days could not be greater than 31 and months could not be greater than 12*/
        raceDate = "32-06-2022";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(3,viewStub.getErrorCount());

        raceDate = "25-15-2022";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(4,viewStub.getErrorCount());

        raceDate = "40-40-2022";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(5,viewStub.getErrorCount());

        /*race of date has to be after the race of deadline for participations*/
        raceDate = "15-06-2022";
        deadLine = "16-06-2022";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(6,viewStub.getErrorCount());

        raceDate = "15-06-2022";
        deadLine = "15-06-2022";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(7,viewStub.getErrorCount());
    }



    @Test
    public void checkInvalidTypeInput(){

        raceType = "offroadd";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(1,viewStub.getErrorCount());

        raceType = "streeet";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(2,viewStub.getErrorCount());

        raceType = "some invalid type";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(3,viewStub.getErrorCount());
    }

    @Test
    public void checkInvalidDistanceInput(){

        raceDistance = "0";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(1,viewStub.getErrorCount());

        raceDistance = "-2";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(2,viewStub.getErrorCount());

    }

    @Test
    public void checkInvalidMoneyAmountsInput(){

        raceAmt = "0";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(1,viewStub.getErrorCount());

        raceAmt = "not float";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(2,viewStub.getErrorCount());

        raceAmt = "20";
        minRaceAmt = "0";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(3,viewStub.getErrorCount());

        minRaceAmt = "-5";
        raceAmt = "-3";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(4,viewStub.getErrorCount());

    }

    @Test
    public void checkInvalidPlaceInput(){

        racePlace = "Athens";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(1,viewStub.getErrorCount());

        racePlace = "Crete,";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("invalid form completion",viewStub.getErrorMsg());
        Assert.assertEquals(2,viewStub.getErrorCount());
    }


    @Test
    public void checkAnotherRaceAtSamePlaceOnSameDate(){

        int sizeOfRacesBeforeAttempts = raceDAO.findAll().size();

        racePlace = "Athens,Hrakleio";
        raceDate = "15-06-2022";
        deadLine = "10-06-2022";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("another race is conducted at\n"+racePlace+"\non "+ raceDate,viewStub.getErrorMsg());
        Assert.assertEquals(1,viewStub.getErrorCount());

        racePlace = "Piraeus, Palia Ionia";
        raceDate = "30-07-2022";
        deadLine = "20-07-2022";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("another race is conducted at\n"+racePlace+"\non "+ raceDate,viewStub.getErrorMsg());
        Assert.assertEquals(2,viewStub.getErrorCount());


        racePlace = "Litoxwro,Litoxwro";
        raceDate = "03-07-2022";
        deadLine = "28-06-2022";
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        Assert.assertEquals("another race is conducted at\n"+racePlace+"\non "+ raceDate,viewStub.getErrorMsg());
        Assert.assertEquals(3,viewStub.getErrorCount());

        int sizeOfRacesAfterAttempts = raceDAO.findAll().size();

        Assert.assertEquals(sizeOfRacesBeforeAttempts,sizeOfRacesAfterAttempts); // no race should have been added
    }


    @Test
    public void checkNormalRaceCreationProcess(){

        //assert that race did not created new size should be equal to the previous size
        int racesBeforeAttemptToCreate = raceDAO.findAll().size();
        presenter.createRace(organizerID,raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt);
        int racesAfterAttemptToCreate = raceDAO.findAll().size();
        Assert.assertEquals(racesBeforeAttemptToCreate,racesAfterAttemptToCreate-1);

        //assert view's messages
        Assert.assertEquals("race created successfully",viewStub.getStatusMsg());
        Assert.assertEquals(1,viewStub.getStatusCount());

        Assert.assertEquals(null, viewStub.getErrorMsg());
        Assert.assertEquals(0,viewStub.getErrorCount());
    }

}
