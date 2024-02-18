package com.example.bikeraceapplication.model;

import com.example.bikeraceapplication.contacts.Email;

import java.util.UUID;

public class Referee extends User{

    public Referee(){
        setRole(Role.REFEREE);
    }

    public Referee(String firstName, String lastName, Email email, String password) {
        super(firstName, lastName, email, password,Role.REFEREE);
    }
}
