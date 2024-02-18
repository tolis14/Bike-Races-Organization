package com.example.bikeraceapplication.model;
import com.example.bikeraceapplication.contacts.Email;

import java.util.UUID;

public class User {
    private String firstName;
    private String lastName;
    private String password;
    private Email email;
    private String id;
    private Role role;

    public User() {
    }

    public User(String firstName, String lastName, Email email, String password,Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role=role;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){return this.id;}

    public Role getRole(){return this.role;}

    public void setRole(Role role) {
        this.role=role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(Email email){
        this.email = email;
    }

    public Email getEmail(){
        return this.email;
    }

    public void setPassword(String password){this.password = password;}

    public String getPassword(){return password;}

}
