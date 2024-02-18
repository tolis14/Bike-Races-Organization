package com.example.bikeraceapplication.memorydao;

import com.example.bikeraceapplication.dao.SponsorDAO;
import com.example.bikeraceapplication.model.Sponsor;
import java.util.ArrayList;
import java.util.List;

public class SponsorDAOMemory implements SponsorDAO {

    private static ArrayList<Sponsor> sponsors = new ArrayList<>();


    @Override
    public void save(Sponsor entity) {
        sponsors.add(entity);
    }

    @Override
    public List<Sponsor> findAll() {
        return sponsors;
    }

    @Override
    public Sponsor findbyid(String id) {
        for(Sponsor sponsor: sponsors) {
            if (sponsor.getId().equals(id))
                return sponsor;
        }
        return null;
    }

    @Override
    public Sponsor find(String userName, String Password,String mail) {
        for(Sponsor sponsor: sponsors) {
            if (sponsor.getFirstName().equals(userName) && sponsor.getPassword().equals(Password) && sponsor.getEmail().getAddress().equals(mail))
                return sponsor;
        }
        return null;
    }

    @Override
    public void clear() {
        sponsors.clear();
    }


}
