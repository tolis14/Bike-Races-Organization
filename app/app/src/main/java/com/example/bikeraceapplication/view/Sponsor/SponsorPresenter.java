package com.example.bikeraceapplication.view.Sponsor;

import android.graphics.Color;
import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.dao.SponsorDAO;
import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.model.Sponsor;
import com.example.bikeraceapplication.model.SponsorshipApplication;

public class SponsorPresenter {

    /**
     * This is the class for executing the logic of the SponsorActivity class
     */
    private Race race;
    private Sponsor sponsor;
    private SponsorView view;
    private SponsorDAO sponsorDAO;
    private RaceDAO RaceDAO;

    public SponsorView getView(){ return view; }

    public void setView(SponsorView view) { this.view  = view; }

    public SponsorPresenter(){}

    public boolean validatemoney(String race_id, double sponsor_money) {

        /**
         * Checks if users input is valid
         *
         * Checks if both inputs (mail and password) are not empty
         *
         * @param race_id race_id (String) of the race who we want to find if it has sponsorship applications
         * @param sponsor_money sponsor_money (double) of the sponsor who wants to add to the sponsorship
         * @return true if they are no sponsorship applications to the race /else false is returned
         */

        Race race = RaceDAO.findById(race_id);
        for(SponsorshipApplication application:race.getSponsorshipApplications()){
            if(application.getSponsor().getId().equals(sponsor.getId()))
                return false;
        }
        addsponsorshipapplication(race_id,sponsor_money);
        return true;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void createsponsor(String id) {
        sponsor = sponsorDAO.findbyid(id);
    }

    public void addsponsorshipapplication(String race_id, double sponsor_money) {
        /**
         * Adds the sponsorship application to the race
         * @param race_id race_id (String) of the race who we want to find to add the sponsorship applications
         * @param sponsor_money sponsor_money (double) of the sponsor who wants to add to the sponsorship
         */
        race = RaceDAO.findById(race_id);
        SponsorshipApplication sponsorshipApplication = new SponsorshipApplication(sponsor_money,sponsor);
        race.addSponsorshipApplication(sponsorshipApplication);
        double oldBalance = sponsor.getCard().getBalance().getAmount();
        double newBalance = oldBalance - sponsor_money;
        sponsor.getCard().setBalance(newBalance);
    }

    public boolean validateSponsor(String money) {

        double amount = 0.0;

        try{
            amount = Double.parseDouble(money);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            view.ShowMessage("INVALID INPUTS");
            view.setColor(Color.RED);
            return false;
        }

        if(amount > sponsor.getCard().getBalance().getAmount()) {
            view.ShowMessage("Not enough money");
            view.setColor(Color.RED);
            return false;
        }

        if(amount > 0) {
            return true;
        }
        else {
            view.ShowMessage("INVALID INPUTS");
            view.setColor(Color.RED);
            return false;
        }
    }

    public void setSponsorDAO(SponsorDAO SponsorDAO) {
        this.sponsorDAO = SponsorDAO;
    }

    public SponsorDAO getSponsorDAO() {
        return this.sponsorDAO;
    }

    public void setRaceDAO(RaceDAO RaceDAO) {
        this.RaceDAO = RaceDAO;
    }

    public RaceDAO getRaceDAO() {
        return this.RaceDAO;
    }

}