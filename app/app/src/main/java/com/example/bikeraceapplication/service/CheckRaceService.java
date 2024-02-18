package com.example.bikeraceapplication.service;


import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.memorydao.RaceDAOMemory;
import com.example.bikeraceapplication.model.Competitor;
import com.example.bikeraceapplication.model.Participation;
import com.example.bikeraceapplication.model.Payment;
import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.model.Sponsor;
import com.example.bikeraceapplication.model.SponsorshipApplication;
import com.example.bikeraceapplication.util.Money;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class CheckRaceService extends JobService {


    private boolean jobCancelled = false;
    private RaceDAO raceDAO;


    @Override
    public boolean onStartJob(JobParameters params) {

        raceDAO = new RaceDAOMemory();
        checkEveryRaceStatus(params);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {

        jobCancelled = true;
        return false;
    }

    private void checkEveryRaceStatus(final JobParameters params){

        new Thread(() -> {
            Date currentDate = new Date();
            List<Race> racesToBeDeleted = new ArrayList<>();
            for(Race race : raceDAO.findAll()){

                Set<Participation> participations = race.getParticipations();
                Set<SponsorshipApplication> applications = race.getSponsorshipApplications();

                if(currentDate.after(race.getDueTime())) {
                    /*race should be canceled and money should be returned to everyone*/
                    if (!race.shouldRaceBeConducted()) {

                        this.returnMoneyToCompetitors(participations, race);
                        this.returnMoneyToSponsors(applications);
                        racesToBeDeleted.add(race);

                    } else {
                        this.redeemPayments(participations, applications, race.getCost());
                    }
                }
            }
            for(Race race:racesToBeDeleted) {
                raceDAO.delete(race);
            }

            jobFinished(params,false);
        }).start();
    }

    private void returnMoneyToCompetitors(Set<Participation> participations, Race race){

        for(Participation participation:participations){
            double participationCost = race.getCost().getAmount();
            Competitor competitor = participation.getCompetitor();
            competitor.getCard().addToBalance(participationCost);
        }
    }

    private void returnMoneyToSponsors(Set<SponsorshipApplication> applications){

        for(SponsorshipApplication application: applications){
            double applicationAmount = application.getAmount().getAmount();
            Sponsor sponsor = application.getSponsor();
            if(application.isApproved())
                sponsor.getCard().addToBalance(applicationAmount);
        }
    }

    private void redeemPayments(Set<Participation> participations, Set<SponsorshipApplication> applications, Money raceCost){

        for(Participation participation:participations){
            Payment payment = new Payment(raceCost);
            participation.setPayment(payment);
        }

        for(SponsorshipApplication application:applications){
            Payment payment = new Payment(application.getAmount());
            application.setPayment(payment);
            if(application.isApproved())
                application.getSponsorship().setPaid(true);
        }
    }
}
