package com.example.bikeraceapplication.memorydao;

import com.example.bikeraceapplication.dao.RaceDAO;

import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.model.RaceType;

import com.example.bikeraceapplication.model.Participation;
import com.example.bikeraceapplication.model.Sponsorship;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RaceDAOMemory implements RaceDAO {

    private static ArrayList<Race> entities = new ArrayList<>();

    public RaceDAOMemory(){}

    @Override
    public void delete(Race entity) {
        entities.remove(entity);
    }

    @Override
    public List<Race> findAll() {
        ArrayList<Race> result = new ArrayList<>();
        result.addAll(entities);
        return result;
    }

    @Override
    public void save(Race entity) {
        entities.add(entity);
    }

    @Override
    public Set<Race> find(String raceName, String city, String location, Date date, RaceType type, int distance) {
        Set<Race> result = new HashSet<>();
        for(Race race: entities){
            if(shouldRecordBeReturned(race,raceName,city,location,date,type,distance))
                result.add(race);
        }
        return result;
    }

    @Override
    public Race findById(String id) {
        for(Race race: entities){
            if(race.getId().equals(id))
                return race;
        }
        return null;
    }

    @Override
    public Set<Race> findByOrganizer(String organizerID) {

        Set<Race> result = new HashSet<>();
        for(Race race: entities){
            if(race.getOrganizer().getId().equals(organizerID)) {
                result.add(race);
            }
        }
        return result;
    }

    @Override
    public Set<Race> findByPlaceDate(String city, String location, Date date) {

        Set<Race> result = new HashSet<>();
        for(Race race: entities){
            if(matchDate(race,date) && matchCity(race,city) && matchLocation(race,location))
                result.add(race);
        }
        return result;
    }

    @Override
    public ArrayList<Race> findByRef(String id) {
        ArrayList<Race> result = new ArrayList<Race>();
        for(Race race: entities){
            if(race.getReferee() !=  null) {
                if (id.equals(race.getReferee().getId()) && race.getDate().before(new Date()))
                    result.add(race);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Race> getHistory(String id){

        ArrayList<Race> result = new ArrayList<Race>();
        for(Race race: entities) {
            for(Participation participation: race.getParticipations()) {
                if(participation.getCompetitor().getId().equals(id) && race.getDate().before(new Date()) ){
                    result.add(race);
                }
            }
        }
        return result;
    }

    @Override
    public ArrayList<Race> getOngoing(String id){

        ArrayList<Race> result = new ArrayList<Race>();
        for(Race race: entities) {
            for(Participation participation: race.getParticipations()) {
                if(participation.getCompetitor().getId().equals(id) && race.getDate().after(new Date()) ){
                    result.add(race);
                }
            }
        }
        return result;

    }

    @Override
    public int getPlace(String raceId,String partID){
        for(Race race: entities) {
            for(Participation participation: race.getParticipations()) {
                if(participation.getCompetitor().getId().equals(partID) && raceId.equals(race.getId())){
                    return participation.getPlace();
                }
            }
        }
        return  0;
    }


    @Override
    public Set<Participation> getParticipants(String id) {

        for(Race race: entities){
            if(race.getId().equals(id))
                return race.getParticipations();
        }
        return new HashSet<>();
    }

    @Override
    public void clear() {
        entities.clear();
    }


    private boolean shouldRecordBeReturned(Race race, String raceName, String city, String location, Date date, RaceType type, int distance){
        return matchName(race,raceName) && matchCity(race,city) && matchLocation(race, location) && matchDate(race,date) &&
               matchType(race,type) && matchDistance(race,distance);
    }

    private boolean matchName(Race race,String raceName){
        if(raceName.equals(""))
            return true;

        return race.getName().equalsIgnoreCase(raceName);
    }

    private boolean matchCity(Race race, String city){
        if(city.equals(""))
            return true;

        return race.getPlace().getCity().equalsIgnoreCase(city);
    }

    private boolean matchLocation(Race race, String location){
        if(location.equals(""))
            return true;

        return race.getPlace().getLocation().equalsIgnoreCase(location);
    }

    private boolean matchDate(Race race, Date date){
        if(date == null)
            return true;

        return race.getDate().equals(date);
    }

    private boolean matchType(Race race, RaceType type){
        if(type == null)
            return true;

        return race.getType().equals(type);
    }

    private boolean matchDistance(Race race, int distance){
        if(distance == -1)
            return true;

        return race.getDistance() == distance;
    }
}
