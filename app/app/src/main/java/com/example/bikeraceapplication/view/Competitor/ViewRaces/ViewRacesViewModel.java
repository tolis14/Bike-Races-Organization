package com.example.bikeraceapplication.view.Competitor.ViewRaces;

import androidx.lifecycle.ViewModel;

import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.memorydao.RaceDAOMemory;


public class ViewRacesViewModel extends ViewModel {

    private ViewRacesPresenter presenter;

    public ViewRacesViewModel(){

        presenter = new ViewRacesPresenter();
        presenter.setRaceDAO(new RaceDAOMemory());
    }

    public ViewRacesPresenter getPresenter(){
        return presenter;
    }

    @Override
    protected void onCleared(){
        super.onCleared();
    }
}
