package com.example.bikeraceapplication.view.Race.Create;
import android.content.Intent;
import android.util.Log;

import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.dao.OrganizerDAO;
import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.model.Organizer;
import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.model.RaceType;
import com.example.bikeraceapplication.util.DateChecker;
import com.example.bikeraceapplication.util.Money;
import com.example.bikeraceapplication.util.Place;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;


public class CreateRacePresenter {

    private RaceDAO raceDAO;
    private OrganizerDAO organizerDAO;
    private CreateRaceView view;

    public void setRaceDao(RaceDAO raceDAO){this.raceDAO = raceDAO;}

    public void setOrganizerDAO(OrganizerDAO organizerDAO){this.organizerDAO = organizerDAO;}

    public void setView(CreateRaceView view) { this.view = view; }

    public CreateRaceView getView(){return this.view;}

    public void createRace(String organizerID,String raceName, String racePlace, String raceDate, String raceType, String raceDistance,
                           String deadLine,String raceAmt, String minRaceAmt) {

        /*here id is passed from the previous activity*/
        Organizer organizer = organizerDAO.findById(organizerID);

        if(!validateFieldsNotMissing(raceName,racePlace,raceDate,raceType,raceDistance,deadLine,raceAmt,minRaceAmt)) {
            view.showError("some fields are missing");
            return;
        }

        if(!validateInputData(racePlace,raceType,raceDistance,raceAmt,minRaceAmt)) {
            view.showError("invalid form completion");
            return;
        }


        Date[] dateInputs = validateDateInput(raceDate,deadLine);
        Date date;
        Date dueDate;

        if(dateInputs == null){
            view.showError("invalid form completion");
            return;
        }

        date = dateInputs[0];
        dueDate = dateInputs[1];

        if(!validateNotAnotherRaceSameDatePlace(racePlace,date)){
            view.showError("another race is conducted at\n"+racePlace+"\non "+ raceDate);
            return;
        }


        /*everything is okay race can be created*/
        String[] cityAndLocation = racePlace.split(",");
        String city = cityAndLocation[0];
        String location = cityAndLocation[1];
        Place place = new Place(city,location);
        Money raceAmount = new Money(Float.parseFloat(raceAmt));
        Money minRaceAmount = new Money(Float.parseFloat(minRaceAmt));
        String id = UUID.randomUUID().toString();

        /*create race and save it*/
        RaceBuilder raceBuilder = new RaceBuilder();

        Race race = raceBuilder.
                    name(raceName).
                    place(place).
                    date(date).
                    type(RaceType.valueOf(raceType.toUpperCase())).
                    distance(Integer.valueOf(raceDistance)).
                    dueTime(dueDate).
                    organizer(organizer).
                    cost(raceAmount).
                    minGatheredAmount(minRaceAmount).
                    build();

        race.setId(id);
        raceDAO.save(race);
        view.showStatus("race created successfully");
    }

    private boolean validateFieldsNotMissing(String raceName, String racePlace, String raceDate, String raceType, String raceDistance,
                                             String deadLine,String raceAmt, String minRaceAmt){

        if(raceName.isEmpty()) return false;

        if(racePlace.isEmpty()) return false;

        if(raceDate.isEmpty()) return false;

        if(raceType.isEmpty()) return false;

        if(raceDistance.isEmpty()) return false;

        if(deadLine.isEmpty()) return false;

        if(raceAmt.isEmpty()) return false;

        if(minRaceAmt.isEmpty()) return false;

        return true;
    }

    private boolean validateInputData(String racePlace, String raceType, String raceDistance,
                                      String raceAmt, String minRaceAmt){

        if(!racePlace.contains(",") || racePlace.endsWith(",")) return false;

        boolean validType = false;
        for(RaceType type: RaceType.values()){
            if(type.toString().equalsIgnoreCase(raceType)){
                validType = true;
                break;
            }
        }
        if(!validType) return false;

        try {
            int distance = Integer.parseInt(raceDistance);
            float amount = Float.parseFloat(raceAmt);
            float minAmount = Float.parseFloat(minRaceAmt);

            if( distance <= 0 || amount <= 0 || minAmount <=0 ) //these values should be only positive
                return false;
        }
        catch (NumberFormatException e){
            return false;
        }

        return true;
    }

    private Date[] validateDateInput(String raceDate, String raceDueDate){

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date;
        Date dueDate;

        try {

            if(!DateChecker.isValidateDate(raceDate,"-"))
                return null;
            if(!DateChecker.isValidateDate(raceDueDate,"-"))
                return null;




            date = format.parse(raceDate);
            dueDate = format.parse(raceDueDate);
            Date today = new Date();

            if(!DateChecker.isBefore(today,date))  /*check if raceDate is before current date*/
                return null;

            if(!DateChecker.isBefore(dueDate,date))  /*check if deadline is before race date*/
                return null;

            return new Date[] {date,dueDate};
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    private boolean validateNotAnotherRaceSameDatePlace(String racePlace, Date raceDate){

        String[] cityAndLocation = racePlace.split(",");
        String city = cityAndLocation[0];
        String location = cityAndLocation[1];
        if(location.charAt(0) == ' ')
            location = location.substring(1);

        if(raceDAO.findByPlaceDate(city,location,raceDate).size() > 0)
            return false;
        return true;
    }
}
