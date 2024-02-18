package com.example.bikeraceapplication.dao;

import com.example.bikeraceapplication.model.Organizer;

import java.util.List;

public interface OrganizerDAO {

    void save(Organizer entity);

    List<Organizer> findAll();

    Organizer find(String userName, String Password,String mail);

    Organizer findById(String id);

    void clear();

}
