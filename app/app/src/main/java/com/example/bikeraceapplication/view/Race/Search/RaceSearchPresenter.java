package com.example.bikeraceapplication.view.Race.Search;


import android.util.Log;

import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.model.RaceType;
import com.example.bikeraceapplication.util.DateChecker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RaceSearchPresenter {

    private RaceSearchView view;
    private RaceDAO raceDAO;
    private Set<Race> searchResult = new HashSet<>();

    public RaceSearchPresenter(){}

    public RaceDAO getRaceDAO(){
        return this.raceDAO;
    }

    public Set<Race> getSearchResult(){
        return this.searchResult;
    }

    public void setRaceDAO(RaceDAO raceDAO){
        this.raceDAO = raceDAO;
    }

    public void setView(RaceSearchView view){
        this.view = view;
    }

    public void search(String raceName, String racePlace, String raceDate, String raceType, String raceDistance){

        /*one call to database and check fields*/
        searchResult.clear();

        /*if a field is null just initialize it to default string*/
        if(raceName == null) raceName = "";

        if(racePlace == null) racePlace = "";

        if(raceDate == null) raceDate = "";

        if(raceType == null) raceType = "";

        if(raceDistance == null) raceDistance = "";


        /*location's input*/
        String city = "";
        String location = "";

        if (!racePlace.contains(",") || racePlace.endsWith(",")) //assume that user was not interested for a specific place
            city = racePlace.replace(",", "");
        else {
            String[] cityAndLocation = racePlace.split(",");
            city = cityAndLocation[0].replace(" ", "");
            location = cityAndLocation[1];
            if (location.charAt(0) == ' ')
                location = location.substring(1);
        }


        /*date's input*/
        Date targetDate = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            targetDate = formatter.parse(raceDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        /*race type input*/
        RaceType targetType = null;
        for(RaceType type: RaceType.values()){
            if(type.toString().equalsIgnoreCase(raceType))
                targetType = type;
        }

        /*distance input*/
        int distance;
        try {
            distance = Integer.parseInt(raceDistance);
        }
        catch (NumberFormatException e) {
            distance = -1;
        }

        Set<Race> races = raceDAO.find(raceName,city,location,targetDate,targetType,distance);

        for(Race race : races){

            Date deadLineOfRace = race.getDueTime();
            Date dateToday = new Date();
            if(DateChecker.isBefore(dateToday,deadLineOfRace))
                searchResult.add(race);
        }
    }

}
