package com.example.bikeraceapplication.view.Race.Create;

public class CreateRaceViewStub implements CreateRaceView{

    private int errorCount = 0;
    private String errorMsg;

    private int statusCount = 0;
    private String statusMsg;

    @Override
    public void showError(String errorMsg) {
        this.errorMsg = errorMsg;
        this.errorCount++;
    }

    @Override
    public void showStatus(String status) {
        this.statusMsg = status;
        this.statusCount++;
    }

    public String getErrorMsg(){
        return this.errorMsg;
    }

    public String getStatusMsg(){
        return this.statusMsg;
    }

    public int getErrorCount(){
        return this.errorCount;
    }

    public int getStatusCount(){
        return this.statusCount;
    }
}
