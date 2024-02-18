package com.example.bikeraceapplication.view.Referee;

import com.example.bikeraceapplication.view.Referee.race.RefereeRaceView;

public class RefereeViewStub  implements RefereeRaceView {

    private int errorCount;
    private String errorMsg;

    public RefereeViewStub(){
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

