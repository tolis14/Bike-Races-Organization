package com.example.bikeraceapplication.dao;

import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.model.Sponsor;
import com.example.bikeraceapplication.model.Sponsorship;

import java.util.List;

public interface SponsorDAO {

    void save(Sponsor entity);

    List<Sponsor> findAll();

    Sponsor findbyid(String id);

    Sponsor find(String userName, String Password,String mail);

    void clear();
}
