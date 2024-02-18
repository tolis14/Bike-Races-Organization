package com.example.bikeraceapplication.view.Referee.rate;


import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.model.Participation;
import com.example.bikeraceapplication.model.Race;

import java.util.ArrayList;
import java.util.Set;

/**
 * <h5>Presenter for RefereeRate</h5><p>
 *
 * retrieves and combines data from ActivityLogin and
 * UserDAO and returns results back to ActivityLogin.
 */
public class RefereeRatePresenter {

    private RefereeRateView view;
    private RaceDAO RaceDAO;

    public void setRaceDAO(RaceDAO raceDAO){
        this.RaceDAO = raceDAO;
    }


    /**
     * <h5>getParticipants</h5><p>
     *
     * returns the participants of the race with id=parameter id
     *
     * @param id id of the race that the Referee wants to rate
     * @return a list with all the participants of the race
     */
    public ArrayList<Participation> getParticipants(String id){
        ArrayList<Participation> list=new ArrayList<Participation>();
        for(Participation part: RaceDAO.getParticipants(id))
            list.add(part);
        return list;
    }

    /**
     * <h5>setPlace</h5><p>
     *
     * sets Place=place in race with id=raceId of participant with partID=id
     *
     * @param raceId race that the participant is in
     * @param id id of the participant
     * @param place place of the participant
     * @return a list with all the participants of the race
     */
    public void setPlace(String raceId,int id,int place){
        for(Participation part: RaceDAO.getParticipants(raceId)){
            if(part.getId()==id){
                part.setPlace(place);
            }
        }
    }

    public void setView(RefereeRateView view) { this.view  = view; }


}
