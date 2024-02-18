package com.example.bikeraceapplication.view.login;


public class LoginViewStub implements LoginView {

    private int errorCount;
    private String errorMsg;

    public LoginViewStub(){
        this.errorCount = 0;
        this.errorMsg = "";
    }

    @Override
    public void showError(String errorMsg){
        this.errorMsg = errorMsg;
        this.errorCount++;
    }

    public int getErrorCount(){return this.errorCount;}

    public String getErrorMsg(){return this.errorMsg;}
}
