package com.example.bikeraceapplication.view.Referee;

import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.memorydao.RaceDAOMemory;
import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.model.Referee;
import com.example.bikeraceapplication.view.Referee.race.RefereeRacePresenter;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

public class RefereeRaceTest {

    private RefereeRacePresenter presenter;
    private RefereeViewStub view;

    @Before
    public void setUp() {

        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        RaceDAO raceDAO = new RaceDAOMemory();
        view = new RefereeViewStub();
        presenter = new RefereeRacePresenter();
        presenter.setRaceDAO(raceDAO);
        presenter.setView(view);
    }


    /**
     * Tests if GetRaces is working as intended
     * Calls GetRaces with "ref1" as a parameter
     * And checks if the size of the returned array is =1
     * (Referee with id=ref1 only has 1 race)
     */
    @Test
    public void testGetRacesExists() {
        Referee ref1 = new Referee();
        ref1.setId("ref1");
        Assert.assertEquals(1, presenter.getRaces(ref1.getId()).size());
    }

    /**
     * Tests if GetRaces is working as intended
     * Calls GetRaces with "noone" and "noone2" as a parameter
     * And checks if the size of the returned array is =0
     * (There are no referees with id=noone or id=noone2)
     * <p>
     * Then it calls GetRaces with "ref1" as a parameter
     * And checks if the size of the returned array is =1
     * (Referee with id=ref1 only has 1 race)
     */
    @Test
    public void testGetRacesDoesntExists() {
        Referee ref1 = new Referee();
        ref1.setId("noone");
        Assert.assertNotNull(presenter.getRaces(ref1.getId()).size());
        Assert.assertEquals("no races", view.getErrorMsg());
        Assert.assertEquals(1, view.getErrorCount());

        ref1.setId("noone2");
        Assert.assertNotNull(presenter.getRaces(ref1.getId()).size());
        Assert.assertEquals("no races", view.getErrorMsg());
        Assert.assertEquals(2, view.getErrorCount());

        ref1.setId("ref1");
        Assert.assertEquals(1, presenter.getRaces(ref1.getId()).size());
        Assert.assertEquals(2, view.getErrorCount());
    }


    /**
     * Tests if GetRacesStr is working as intended
     * Calls GetRacesStr with "ref1" and "ref0" as a parameter
     * And checks if the size of the returned array is =1
     * (Referee with id=ref1 and id=ref2 have 1 race)
     */
    @Test
    public void testGetRacesStr() {
        ArrayList<Race> races = presenter.getRaces("ref1");
        ArrayList<String> racesStr = presenter.getRacesStr(races);
        Assert.assertEquals(1, racesStr.size());

        races = presenter.getRaces("ref0");
        racesStr = presenter.getRacesStr(races);
        Assert.assertEquals(1, racesStr.size());

    }

    /**
     * Tests if GetRacesStr is working as intended
     * Calls GetRacesStr with "noone" as a parameter
     * And checks if the size of the returned array is =0
     * (There is no referee with id="noone" so the array size should be =0)
     */
    @Test
    public void testGetRacesStrDontExist() {
        ArrayList<Race> races = presenter.getRaces("noone");
        ArrayList<String> racesStr = presenter.getRacesStr(races);
        Assert.assertEquals(0, racesStr.size());

    }

}
