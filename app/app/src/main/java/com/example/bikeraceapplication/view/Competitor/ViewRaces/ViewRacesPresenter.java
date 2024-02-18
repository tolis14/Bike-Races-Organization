package com.example.bikeraceapplication.view.Competitor.ViewRaces;




import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.model.Race;


import java.util.ArrayList;


public class ViewRacesPresenter {

    private ViewRacesView view;
    private RaceDAO raceDAO;

    public ArrayList<String> getHistory(String id) {

        ArrayList<Race> history = raceDAO.getHistory(id);

        if(history.size() == 0) {
            view.showError("you have not participated to any races yet");
        }

        ArrayList<String> list=new ArrayList<String>();
        for(Race race:history){
            list.add("Name: "+race.getName()+" \nDate: "+ race.getDate()+" \nDistance: "+race.getDistance()+" \tPlace: "+raceDAO.getPlace(race.getId(),id));
        }
        return list;
    }

    public ArrayList<Race> getOngoing(String id) {

        ArrayList<Race> onGoing = raceDAO.getOngoing(id);

        if(onGoing.size() == 0) {
            view.showError("no on going races");
            return null;
        }
        return onGoing;
    }

    public void setView(ViewRacesView view) { this.view  = view; }
    public void setRaceDAO(RaceDAO raceDAO){
        this.raceDAO = raceDAO;
    }
}
