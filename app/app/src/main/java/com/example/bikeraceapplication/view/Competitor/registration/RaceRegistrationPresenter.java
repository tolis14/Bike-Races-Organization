package com.example.bikeraceapplication.view.Competitor.registration;

import android.util.Log;

import com.example.bikeraceapplication.contacts.Email;
import com.example.bikeraceapplication.contacts.EmailMessage;
import com.example.bikeraceapplication.dao.CompetitorDAO;
import com.example.bikeraceapplication.dao.EmailDAO;
import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.model.Competitor;
import com.example.bikeraceapplication.model.Participation;
import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.service.EmailProvider;
import com.example.bikeraceapplication.service.MailServer;
import com.example.bikeraceapplication.util.IllegalMoneySub;

public class RaceRegistrationPresenter {

    private RaceRegistrationView view;

    private RaceDAO raceDAO;
    private CompetitorDAO competitorDAO;

    private Race race;
    private Competitor competitor;

    public RaceRegistrationView getView(){ return view; }


    public void setView(RaceRegistrationView view) { this.view  = view; }


    /**
     *
     * @param raceName name of the race that was given from user in search form
     * @param racePlace place that was given from user in search form
     * @param raceDate
     * @param raceType
     * @param raceDistance
     */
    public void search(String raceName, String racePlace, String raceDate, String raceType, String raceDistance){
        view.showSearchDialog(raceName,racePlace,raceDate,raceType,raceDistance);
    }

    /**
     *
     * @param raceId id of the race that was selected after search
     * @param competitorId id of the competitor that wants to register to the race
     */
    public void registerToRace(String raceId, String competitorId){

        race = raceDAO.findById(raceId);

        competitor = competitorDAO.findById(competitorId);

        if(race == null || competitor == null){ //something went wrong display error message
            view.showError("invalid options");
            return;
        }

        if(alreadyRegistered(race,competitor)) {
            view.showError("already registered in this race");
            return;
        }

        if(validateCardAmount(race,competitor)){

            Participation participation = new Participation(competitor,race);
            participation.setId(race.getNumParticipations() + 1);
            race.addParticipant(participation);
            view.showStatus("successfully registered to " + race.getName());

            /*bind the money and if then race is cancelled take them back*/
            double cost = race.getCost().getAmount();

            competitor.getCard().removeFromBalance(cost);

            EmailProvider emailProvider = MailServer.getInstance();
            EmailMessage message = createEmail(emailProvider.getAddress(),competitor.getEmail(),competitor.getFirstName(),race);
            emailProvider.sendEmail(message);

        }
        else{
            view.showError("not enough money in your card");
        }
    }

    /**
     *
     * @param race An instance of race object
     * @param competitor An instance of competitor object
     * @return true if competitor has already been registered to this race false otherwise
     */

    private boolean alreadyRegistered(Race race, Competitor competitor){

        for(Participation participation:race.getParticipations()){
            if(participation.getCompetitor().getId().equals(competitor.getId()) && participation.getRace().getId().equals(race.getId()))
                return true;
        }
        return false;
    }

    private EmailMessage createEmail(Email from, Email to,String competitorName,Race race){

        String raceName = race.getName();
        String raceDate = race.getDate().toString();
        String racePlace = race.getPlace().toString();

        String subject = "Race Registration Information";

        String body = "Dear "+ competitorName+"\n"+"we would like to inform you that your registration " +
                "in bike race "+raceName+" at "+racePlace+" on " + raceDate + "have been successfully completed.";

        EmailMessage message = new EmailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setBody(body);
        return message;
    }

    /**
     *
     * @param race An instance of race object
     * @param competitor An instance of competitor object
     * @return true if money of competitor are enough to afford race amount otherwise false
     */
    private boolean validateCardAmount(Race race, Competitor competitor){
        return competitor.getCard().getBalance().compareTo(race.getCost()) >= 0;
    }

    public void setRaceDAO(RaceDAO raceDAO){
        this.raceDAO = raceDAO;
    }

    public void setCompetitorDAO(CompetitorDAO competitorDAO){ this.competitorDAO = competitorDAO; }
}
