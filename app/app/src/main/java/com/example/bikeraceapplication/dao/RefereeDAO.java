package com.example.bikeraceapplication.dao;

import com.example.bikeraceapplication.model.Referee;

import java.util.List;

public interface RefereeDAO {

    void save(Referee entity);

    List<Referee> findAll();

    Referee find(String userName, String Password,String mail);

    void clear();

}
