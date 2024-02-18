package com.example.bikeraceapplication.view.login;

import androidx.lifecycle.ViewModel;


import com.example.bikeraceapplication.dao.UserDAO;

import com.example.bikeraceapplication.memorydao.UserDAOMemory;


public class LoginViewModel extends ViewModel {

    private LoginPresenter presenter;

    public LoginViewModel(){

        presenter = new LoginPresenter();
        presenter.setUserDAO(new UserDAOMemory());

    }


    public LoginPresenter getPresenter(){
        return presenter;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
