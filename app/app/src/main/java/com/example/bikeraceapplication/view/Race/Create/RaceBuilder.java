package com.example.bikeraceapplication.view.Race.Create;
import com.example.bikeraceapplication.model.Organizer;
import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.model.RaceType;
import com.example.bikeraceapplication.util.Money;
import com.example.bikeraceapplication.util.Place;

import java.util.Date;

public class RaceBuilder {

    private String _name;
    private Place _place;
    private Date _date;
    private RaceType _type;
    private int _distance;
    private Date _dueTime;
    private Organizer _organizer;
    private Money _cost;
    private Money _minGatheredAmount;

    public RaceBuilder(){}


    public RaceBuilder name(String name){
        _name = name;
        return this;
    }

    public RaceBuilder place(Place place){
        _place = place;
        return this;
    }

    public RaceBuilder date(Date date){
        _date = date;
        return this;
    }

    public RaceBuilder type(RaceType type){
        _type = type;
        return this;
    }

    public RaceBuilder distance(int distance){
        _distance = distance;
        return this;
    }

    public RaceBuilder dueTime(Date dueTime){
        _dueTime = dueTime;
        return this;
    }

    public RaceBuilder organizer(Organizer organizer){
        _organizer = organizer;
        return this;
    }

    public RaceBuilder cost(Money cost){
        _cost = cost;
        return this;
    }

    public RaceBuilder minGatheredAmount(Money minGatheredAmount){
        _minGatheredAmount = minGatheredAmount;
        return this;
    }

    public Race build(){
        return new Race(_name,_place,_date,_type,_distance,_dueTime,_organizer,_cost,_minGatheredAmount);
    }

}
