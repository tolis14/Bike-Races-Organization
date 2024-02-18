package com.example.bikeraceapplication.view.Referee;

import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.memorydao.RaceDAOMemory;

import com.example.bikeraceapplication.model.Participation;
import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.view.Referee.race.RefereeRaceView;
import com.example.bikeraceapplication.view.Referee.rate.RefereeRatePresenter;
import com.example.bikeraceapplication.view.Referee.rate.RefereeRateView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class RefereeRateTest implements RefereeRateView {


    private RefereeRatePresenter presenter;

    @Before
    public void setUp(){
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        RaceDAO raceDAO = new RaceDAOMemory();
        presenter = new RefereeRatePresenter();
        presenter.setRaceDAO(raceDAO);
        presenter.setView(this);
    }

    /**
     * Tests if GetParticipants is working as intended
     * Calls GetParticipants with race1Id as a parameter
     * And checks if the size of the returned array is =2
     * (Participants in the the race with id=race1Id are 2)
     */
    @Test
    public void testGetParticipantsExists(){
        Race race=new Race();
        race.setId("race1Id");
        Assert.assertEquals(presenter.getParticipants(race.getId()).size(),2);
    }

    /**
     * Tests if GetParticipants is working as intended
     * Calls GetParticipants with "notARace" as a parameter
     * And checks if the size of the returned array is =0
     * (there is no race with id="notARace")
     */
    @Test
    public void testGetParticipantsDontExists() {
        Race race=new Race();
        race.setId("notARace");
        Assert.assertTrue( presenter.getParticipants(race.getId()).size()==0);
    }

    /**
     * Tests if setPlace and getPlace are working correctly
     * sets participant with id=2 --> place=1
     * and participant with id=1 --> place=2
     *
     * Then searches for them and checks if the correct places are set
     * in the corresponding participants
     */
    @Test
    public void testSetPlace() {
        presenter.setPlace("race1Id",2,1);
        presenter.setPlace("race1Id",1,2);
        ArrayList<Participation> part=presenter.getParticipants("race1Id");
        for(Participation participation: part){
            if(participation.getId()==2)
                Assert.assertEquals(1,participation.getPlace());
            if(participation.getId()==1)
                Assert.assertEquals(2,participation.getPlace());
        }
    }

}
