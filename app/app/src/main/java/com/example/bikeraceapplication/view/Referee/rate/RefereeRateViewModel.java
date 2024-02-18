package com.example.bikeraceapplication.view.Referee.rate;

import androidx.lifecycle.ViewModel;


import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.memorydao.RaceDAOMemory;


public class RefereeRateViewModel extends ViewModel {

    private RefereeRatePresenter presenter;

    public RefereeRateViewModel(){
        RaceDAO refereeDAO = new RaceDAOMemory();
        presenter = new RefereeRatePresenter();
        presenter.setRaceDAO(new RaceDAOMemory());

    }


    public RefereeRatePresenter getPresenter(){
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
