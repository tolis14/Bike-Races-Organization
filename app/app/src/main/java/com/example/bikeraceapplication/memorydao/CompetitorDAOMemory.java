package com.example.bikeraceapplication.memorydao;

import com.example.bikeraceapplication.dao.CompetitorDAO;
import com.example.bikeraceapplication.model.Competitor;

import java.util.ArrayList;
import java.util.List;

public class CompetitorDAOMemory implements CompetitorDAO {

    private static ArrayList<Competitor> entities = new ArrayList<>();

    @Override
    public void delete(Competitor competitor) {
        entities.remove(competitor);
    }

    @Override
    public void save(Competitor competitor) {
        entities.add(competitor);
    }

    @Override
    public List<Competitor> findAll() { return entities; }

    @Override
    public Competitor findById(String id) {
        for(Competitor competitor : entities){
            if(competitor.getId().equals(id))
                return competitor;
        }
        return null;
    }

    @Override
    public void clear() {
        entities.clear();
    }
}
