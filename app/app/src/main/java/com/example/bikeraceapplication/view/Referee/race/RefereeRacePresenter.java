package com.example.bikeraceapplication.view.Referee.race;

import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.model.Organizer;
import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.model.RaceType;
import com.example.bikeraceapplication.model.Referee;
import com.example.bikeraceapplication.util.Money;
import com.example.bikeraceapplication.util.Place;

import java.util.ArrayList;
import java.util.Date;

public class RefereeRacePresenter {

    private RefereeRaceView view;
    private RaceDAO RaceDAO;


    /**
     * Returns all races that are refereed by referee with refId=id
     *
     * @param id id of Referee
     * @return ArrayList of all races that have referee with refId=id
     */
    public ArrayList<Race> getRaces(String id) {
        ArrayList<Race> races = RaceDAO.findByRef(id);
        if (races.isEmpty()) {
            view.showError("no races");
        }
        return races;
    }

    /**
     * Transforms ArrayList<Race> into ArrayList<String>
     * with proper form
     *
     * @param races ArrayList<Race> of races
     * @return String "Name: raceName
     *                 Date: raceDate Distance: raceDistance"
     */
    public ArrayList<String> getRacesStr(ArrayList<Race> races){
       ArrayList<String> list=new ArrayList<String>();
       for(Race race: races){
           list.add("Name: "+race.getName()+" \nDate: "+race.getDate()+" Distance: "+race.getDistance());
       }
       return list;
    }

    public void setRaceDAO(RaceDAO raceDAO){
        this.RaceDAO = raceDAO;
    }

    public void setView(RefereeRaceView view) { this.view  = view; }
}
