package com.example.bikeraceapplication.view.Race.Search;


import androidx.lifecycle.ViewModel;

import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.memorydao.RaceDAOMemory;

public class RaceSearchViewModel extends ViewModel {

    private RaceSearchPresenter presenter;

    public RaceSearchViewModel(){
        RaceDAO raceDAO = new RaceDAOMemory();
        presenter = new RaceSearchPresenter();
        presenter.setRaceDAO(raceDAO);

    }

    public RaceSearchPresenter getPresenter(){
        return presenter;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
