package com.example.bikeraceapplication.view.approveSponsorship;

import androidx.lifecycle.ViewModel;

import com.example.bikeraceapplication.memorydao.RaceDAOMemory;

public class ApproveSponsorshipViewModel extends ViewModel {

    private ApproveSponsorshipPresenter presenter;

    public ApproveSponsorshipViewModel(){
        presenter = new ApproveSponsorshipPresenter();
        presenter.setRaceDAO(new RaceDAOMemory());
    }

    public ApproveSponsorshipPresenter getPresenter(){return presenter;}

}
