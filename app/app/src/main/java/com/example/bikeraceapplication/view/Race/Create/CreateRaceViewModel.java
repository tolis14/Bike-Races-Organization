package com.example.bikeraceapplication.view.Race.Create;

import androidx.lifecycle.ViewModel;

import com.example.bikeraceapplication.memorydao.OrganizerDAOMemory;
import com.example.bikeraceapplication.memorydao.RaceDAOMemory;


public class CreateRaceViewModel extends ViewModel {

    private CreateRacePresenter presenter;

    public CreateRaceViewModel(){

        /*init presenter and his required DAOS*/
        presenter = new CreateRacePresenter();
        presenter.setRaceDao(new RaceDAOMemory());
        presenter.setOrganizerDAO(new OrganizerDAOMemory());
    }

    public CreateRacePresenter getPresenter(){ return this.presenter; }

    @Override
    protected void onCleared(){
        super.onCleared();
    }

}
