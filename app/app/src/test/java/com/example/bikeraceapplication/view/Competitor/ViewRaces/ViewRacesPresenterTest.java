package com.example.bikeraceapplication.view.Competitor.ViewRaces;

import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.memorydao.RaceDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ViewRacesPresenterTest {

    private ViewRacesPresenter presenter;
    private ViewRacesStub view;

    @Before
    public void setUp(){

        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        RaceDAO raceDAO = new RaceDAOMemory();
        view = new ViewRacesStub();
        presenter = new ViewRacesPresenter();
        presenter.setRaceDAO(raceDAO);
        presenter.setView(view);
    }

    /**
     * Tests if getHistory is working as intended
     * for users with >0 races in history
     *
     * checks if competitor with id="competitor_nikos" has 2 races in history
     * checks if competitor with id="competitor_tolis" has 1 race in history
     * checks if competitor with id="competitor_stathis" has 1 race in history
     */
    @Test
    public void testHistory(){
        Assert.assertEquals(2,presenter.getHistory("competitor_nikos").size());
        Assert.assertEquals(1,presenter.getHistory("competitor_tolis").size());
        Assert.assertEquals(1,presenter.getHistory("competitor_stathis").size());
    }

    /**
     * Tests if getHistory is working as intended
     * for users with 0 races in history
     *
     * checks if competitor with id="competitor_dummy" has 0 races in history
     */
    @Test
    public void testZeroHistory() {

        Assert.assertTrue(presenter.getHistory("competitor_dummy").isEmpty());
        Assert.assertEquals("you have not participated to any races yet",view.getErrorMsg());
        Assert.assertEquals(1,view.getErrorCount());
    }

    /**
     * Tests if getOngoing is working as intended
     * for users with 0 races in history
     *
     * checks if competitor with id="competitor_tolis" has 0 races in ongoing races
     * therefore an error with the message "no on going races" is being displayed
     */
    @Test
    public void testZeroOnGoing(){
        Assert.assertNull(presenter.getOngoing("competitor_tolis"));
        Assert.assertEquals("no on going races",view.getErrorMsg());
        Assert.assertEquals(1,view.getErrorCount());
    }

    /**
     * Tests if getOngoing is working as intended
     * for users with >0 races in history
     *
     * checks if competitor with id="competitor_nikos" has 1 race in ongoing races
     * and the same for competitor with id="competitor_stathis"
     */
    @Test
    public void testOngoing(){
        Assert.assertEquals(1,presenter.getOngoing("competitor_nikos").size());
        Assert.assertEquals(1,presenter.getOngoing("competitor_stathis").size());
    }

}
