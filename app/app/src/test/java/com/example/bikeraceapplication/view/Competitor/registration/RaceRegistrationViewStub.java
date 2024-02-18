package com.example.bikeraceapplication.view.Competitor.registration;


/*this class will imitate the behavior of the true view. */

import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.memorydao.RaceDAOMemory;
import com.example.bikeraceapplication.view.Race.Search.RaceSearchPresenter;



public class RaceRegistrationViewStub implements RaceRegistrationView{

    private int errorCount = 0;
    private String errorMsg;

    private int statusCount = 0;
    private String statusMsg;


    @Override
    public void showSearchDialog(String raceName, String racePlace, String raceDate, String raceType, String raceDistance) {

        RaceSearchPresenter presenter = new RaceSearchPresenter();
        RaceDAO raceDAO = new RaceDAOMemory();
        presenter.setRaceDAO(raceDAO);
        presenter.search(raceName,racePlace,raceDate,raceType,raceDistance);

        if(presenter.getSearchResult().size() == 0 )
            showError("races not found");
    }

    @Override
    public void showStatus(String statusMsg) {
        this.statusMsg = statusMsg;
        this.statusCount++;
    }

    @Override
    public void showError(String errorMsg) {
        this.errorMsg = errorMsg;
        this.errorCount++;
    }

    public int getErrorCount(){return this.errorCount;}

    public int getStatusCount(){return this.statusCount;}

    public String getErrorMsg(){return errorMsg;}

    public String getStatusMsg(){return statusMsg;}
}
