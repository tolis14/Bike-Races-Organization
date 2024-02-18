package com.example.bikeraceapplication.memorydao;

import com.example.bikeraceapplication.dao.OrganizerDAO;
import com.example.bikeraceapplication.model.Organizer;

import java.util.ArrayList;
import java.util.List;

public class OrganizerDAOMemory implements OrganizerDAO {

    private static ArrayList<Organizer> organizers = new ArrayList<>();

    @Override
    public void save(Organizer entity)  {
        organizers.add(entity);
    }

    @Override
    public List<Organizer> findAll() {
        return organizers;
    }


    @Override
    public Organizer find(String userName, String Password,String mail) {
        for(Organizer org: organizers) {
            if (org.getFirstName().equals(userName) && org.getPassword().equals(Password) && org.getEmail().getAddress().equals(mail))
                return org;
        }
        return null;
    }

    @Override
    public Organizer findById(String id) {
        for(Organizer organizer:organizers){
            if(organizer.getId().equalsIgnoreCase(id))
                return organizer;
        }
        return null;
    }

    @Override
    public void clear() {
        organizers.clear();
    }
}
