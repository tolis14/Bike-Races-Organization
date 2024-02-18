package com.example.bikeraceapplication.dao;

import com.example.bikeraceapplication.model.Competitor;

import java.util.List;

public interface CompetitorDAO {

    void delete(Competitor competitor);

    void save(Competitor competitor);

    List<Competitor> findAll();

    Competitor findById(String id);

    void clear();
}
