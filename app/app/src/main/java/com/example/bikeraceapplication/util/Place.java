package com.example.bikeraceapplication.util;

public class Place {

    private String city;
    private String location;

    public Place(String city, String location) {
        this.city = city;
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString(){
        return this.city + "," +this.location;
    }
}
