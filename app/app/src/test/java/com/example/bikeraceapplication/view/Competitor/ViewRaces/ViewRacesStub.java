package com.example.bikeraceapplication.view.Competitor.ViewRaces;


public class ViewRacesStub implements ViewRacesView {

    private int errorCount;
    private String errorMsg;

    public ViewRacesStub(){
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
