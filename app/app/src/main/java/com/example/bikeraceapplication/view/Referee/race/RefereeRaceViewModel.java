package com.example.bikeraceapplication.view.Referee.race;

import androidx.lifecycle.ViewModel;

import com.example.bikeraceapplication.dao.RefereeDAO;

import com.example.bikeraceapplication.memorydao.RaceDAOMemory;
import com.example.bikeraceapplication.memorydao.RefereeDAOMemory;


public class RefereeRaceViewModel extends ViewModel {

    private RefereeRacePresenter presenter;

    public RefereeRaceViewModel(){
        RefereeDAO refereeDAO = new RefereeDAOMemory();
        presenter = new RefereeRacePresenter();
        presenter.setRaceDAO(new RaceDAOMemory());

    }


    public RefereeRacePresenter getPresenter(){
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
