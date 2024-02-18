package com.example.bikeraceapplication.dao;

import com.example.bikeraceapplication.model.Participation;
import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.model.RaceType;
import com.example.bikeraceapplication.model.Sponsorship;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface RaceDAO {

    /*Simple interface that gives access to the database*/

    void delete(Race entity);

    void save(Race entity);

    List<Race> findAll();

    Set<Race> find(String raceName, String city, String location, Date date, RaceType type, int distance);

    Race findById(String id);

    Set<Race> findByOrganizer(String organizerID);

    Set<Race> findByPlaceDate(String city, String location, Date date);

    ArrayList<Race> findByRef(String id);

    Set<Participation> getParticipants(String id);

    ArrayList<Race> getHistory(String id);

    int getPlace(String raceId,String partID);

    ArrayList<Race> getOngoing(String id);

    void clear();

}
