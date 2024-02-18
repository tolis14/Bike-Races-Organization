package com.example.bikeraceapplication.view.SignUp;

import androidx.lifecycle.ViewModel;

import com.example.bikeraceapplication.memorydao.CompetitorDAOMemory;
import com.example.bikeraceapplication.memorydao.OrganizerDAOMemory;
import com.example.bikeraceapplication.memorydao.RefereeDAOMemory;
import com.example.bikeraceapplication.memorydao.SponsorDAOMemory;
import com.example.bikeraceapplication.memorydao.UserDAOMemory;

public class SignUpViewModel extends ViewModel {

    private SignUpPresenter presenter;

    public SignUpViewModel() {

            presenter = new SignUpPresenter();
            presenter.setUserDAO(new UserDAOMemory());
            presenter.setCompetitorDao(new CompetitorDAOMemory());
            presenter.setOrganizerDAO(new OrganizerDAOMemory());
            presenter.setRefereeDAO(new RefereeDAOMemory());
            presenter.setSponsorDAO(new SponsorDAOMemory());
    }

    public SignUpPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

}
