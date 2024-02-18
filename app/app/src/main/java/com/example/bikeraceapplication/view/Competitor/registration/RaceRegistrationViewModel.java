package com.example.bikeraceapplication.view.Competitor.registration;

import androidx.lifecycle.ViewModel;

import com.example.bikeraceapplication.memorydao.CompetitorDAOMemory;
import com.example.bikeraceapplication.memorydao.EmailDAOMemory;
import com.example.bikeraceapplication.memorydao.RaceDAOMemory;

public class RaceRegistrationViewModel extends ViewModel {

    private RaceRegistrationPresenter presenter;

    public RaceRegistrationViewModel(){

        presenter = new RaceRegistrationPresenter();
        presenter.setRaceDAO(new RaceDAOMemory());
        presenter.setCompetitorDAO(new CompetitorDAOMemory());
    }

    public RaceRegistrationPresenter getPresenter(){
        return presenter;
    }

    @Override
    protected void onCleared(){
        super.onCleared();
    }
}
