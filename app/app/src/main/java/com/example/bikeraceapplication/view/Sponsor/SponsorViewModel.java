package com.example.bikeraceapplication.view.Sponsor;

import androidx.lifecycle.ViewModel;

import com.example.bikeraceapplication.memorydao.RaceDAOMemory;
import com.example.bikeraceapplication.memorydao.SponsorDAOMemory;

public class SponsorViewModel extends ViewModel {

    private SponsorPresenter presenter;

    public SponsorViewModel() {
        presenter = new SponsorPresenter();
        presenter.setSponsorDAO(new SponsorDAOMemory());
        presenter.setRaceDAO(new RaceDAOMemory());
    }

    public SponsorPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}