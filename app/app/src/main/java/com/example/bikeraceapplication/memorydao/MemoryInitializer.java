package com.example.bikeraceapplication.memorydao;

import com.example.bikeraceapplication.dao.CompetitorDAO;
import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.dao.OrganizerDAO;
import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.dao.RefereeDAO;
import com.example.bikeraceapplication.dao.SponsorDAO;
import com.example.bikeraceapplication.dao.UserDAO;

public class MemoryInitializer extends Initializer {

    @Override
    public RaceDAO getRaceDao() {
        return new RaceDAOMemory();
    }

    @Override
    public CompetitorDAO getCompetitorDao() {
        return new CompetitorDAOMemory();
    }

    @Override
    protected OrganizerDAO getOrganizerDAO() {
        return new OrganizerDAOMemory();
    }

    @Override
    protected RefereeDAO getRefereeDAO() {
        return new RefereeDAOMemory();
    }

    @Override
    protected SponsorDAO getSponsorDAO() {
        return new SponsorDAOMemory();
    }

    @Override
    protected UserDAO getUserDAO() {
        return new UserDAOMemory();
    }

}
