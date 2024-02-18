package com.example.bikeraceapplication.view.Sponsor;

public class SponsorViewStub implements SponsorView{

    private String message;
    private int color;

    @Override
    public void ShowMessage(String text) {
        this.message = text;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    public String getMessage(){
        return message;
    }

    public int getColor(){return this.color;}
}
