package com.example.bikeraceapplication.view.Race.Search;

import static org.junit.Assert.assertEquals;

import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.memorydao.RaceDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*Test case for search presenter*/

public class RaceSearchPresenterTest  {


    private RaceSearchPresenter presenter;
    private RaceDAO raceDAO;

    /*create a presenter and initialize the race dao where the presenter is going to search for races */
    @Before
    public void setUp(){
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        raceDAO = new RaceDAOMemory();
        presenter = new RaceSearchPresenter();
        presenter.setRaceDAO(raceDAO);
    }

    @Test
    public void settersOkay(){
        Assert.assertNotNull(presenter.getRaceDAO());
    }

    @Test
    public void searchWithoutCriteria(){


        presenter.search("","","","","");
        assertEquals(presenter.getSearchResult().size(),3);

        presenter.search(null,null,null,null,null);
        assertEquals(presenter.getSearchResult().size(),3);
    }

    @Test
    public void searchWithSubSetCriteria(){

        /*search with just city and distance*/
        presenter.search("","Athens","","","150");
        assertEquals(0,presenter.getSearchResult().size());

        presenter.search("","Athens","","","100");
        assertEquals(0,presenter.getSearchResult().size());

        /*search with just type*/
        presenter.search("","","","StrEet","");
        assertEquals(2,presenter.getSearchResult().size());

        presenter.search("","","","offroad","");
        assertEquals(1,presenter.getSearchResult().size());

        presenter.search("","","","invalid race type","");
        assertEquals(3,presenter.getSearchResult().size());

        /*search with just date*/
        presenter.search("","","15-06-2022","","");
        assertEquals(1,presenter.getSearchResult().size());

        /*search with place- city or both city and region*/
        presenter.search("","Athens, Nea Ionia","","","");
        assertEquals(0,presenter.getSearchResult().size());

        presenter.search("","Athens, Peiraias","","","");
        assertEquals(0,presenter.getSearchResult().size());

        presenter.search("","Giannena, Litharitsia","","","");
        assertEquals(0,presenter.getSearchResult().size());

    }

    @Test
    public void searchWithFullyCriteria(){

        presenter.search("freestyle biking","Athens","30-04-2022","street","150");
        assertEquals(0,presenter.getSearchResult().size());

        presenter.search("street lights","athens","30-05-2022","offroad","100");
        assertEquals(0,presenter.getSearchResult().size());

        presenter.search("above earth","litoxwro","offroad","03-07-2022","125");
        assertEquals(1,presenter.getSearchResult().size());
    }


}
