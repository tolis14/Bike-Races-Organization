package com.example.bikeraceapplication.model;
import com.example.bikeraceapplication.contacts.Email;


public class Organizer extends User{
    private String team;

    public Organizer(){
        setRole(Role.ORGANIZER);
    }

    public Organizer(String firstName, String lastName, Email email, String password,String team) {
        super(firstName, lastName, email, password,Role.ORGANIZER);
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


}
