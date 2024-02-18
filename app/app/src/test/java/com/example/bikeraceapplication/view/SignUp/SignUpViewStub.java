package com.example.bikeraceapplication.view.SignUp;

public class SignUpViewStub implements SignUpView{


    private int errorCount;
    private int statusCount;

    private String errorMsg;
    private String statusMsg;

    public SignUpViewStub(){

        this.errorCount = 0;
        this.statusCount = 0;
        this.errorMsg = "";
        this.statusMsg = "";
    }

    @Override
    public void ShowMessage(String text) {

        this.statusCount++;
        this.statusMsg = text;
    }

    @Override
    public void showError(String text) {

        this.errorCount++;
        this.errorMsg = text;
    }

    public String getErrorMsg(){return this.errorMsg;}

    public String getStatusMsg(){return this.statusMsg;}

    public int getErrorCount(){return this.errorCount;}

    public int getStatusCount(){return this.statusCount;}

}
