package com.example.bikeraceapplication.memorydao;

import com.example.bikeraceapplication.dao.RefereeDAO;
import com.example.bikeraceapplication.model.Referee;

import java.util.ArrayList;
import java.util.List;

public class RefereeDAOMemory implements RefereeDAO {


    private static ArrayList<Referee> referees = new ArrayList<>();

    @Override
    public void save(Referee entity) {
        referees.add(entity);
    }

    @Override
    public List<Referee> findAll() {
        return referees;
    }

    @Override
    public Referee find(String userName, String Password,String mail) {
        for(Referee ref: referees) {
            if (ref.getFirstName().equals(userName) && ref.getPassword().equals(Password) && ref.getEmail().getAddress().equals(mail))
                return ref;
        }
        return null;
    }

    @Override
    public void clear() {
        referees.clear();
    }
}
