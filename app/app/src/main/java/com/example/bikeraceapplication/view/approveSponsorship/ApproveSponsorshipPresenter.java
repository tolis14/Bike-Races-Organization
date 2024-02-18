package com.example.bikeraceapplication.view.approveSponsorship;

import android.util.Log;

import com.example.bikeraceapplication.contacts.Email;
import com.example.bikeraceapplication.contacts.EmailMessage;
import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.model.Sponsor;
import com.example.bikeraceapplication.model.Sponsorship;
import com.example.bikeraceapplication.model.SponsorshipApplication;
import com.example.bikeraceapplication.service.EmailProvider;
import com.example.bikeraceapplication.service.MailServer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ApproveSponsorshipPresenter {

    private ApproveSponsorshipView view;
    private RaceDAO raceDAO;
    private Set<Race> organizerRaces = new HashSet<>();


    public void setView(ApproveSponsorshipView view){ this.view = view; }

    public void setRaceDAO(RaceDAO raceDAO){this.raceDAO = raceDAO;}


    /**
     *
     * @param organizerID the id of the organizer that logged into the application
     * @return An ArrayList object that contains all sponsorship applications for this organizer
     */

    public ArrayList<SponsorshipApplication> findApplications(String organizerID){

        ArrayList<SponsorshipApplication> applications = new ArrayList<>();

        organizerRaces = raceDAO.findByOrganizer(organizerID); //all races that have been created from this competitor

        for(Race race: organizerRaces){

            Set<SponsorshipApplication> applicationsForRace = race.getSponsorshipApplications();
            for(SponsorshipApplication application : applicationsForRace){
                if(!application.isApproved())
                    applications.add(application);
            }
        }
        return applications;
    }

    /**
     *
     * @param approved A list that contains all the applications that this organizer approved
     * @param rejected A list that contains all the applications that this organizer rejected
     */

    public void handleApplications(List<SponsorshipApplication> approved, List<SponsorshipApplication> rejected) {

        EmailProvider emailProvider = MailServer.getInstance();

        for (Race race : organizerRaces) {

            Set<SponsorshipApplication> applications = race.getSponsorshipApplications();

            for (SponsorshipApplication application : applications) {

                Sponsor sponsorWhoApplied = application.getSponsor(); // keep the sponsor who applied this application

                Email sponsorsEmail = sponsorWhoApplied.getEmail();

                if (approved.contains(application)) { // if the organizer approved the application we need to create a new sponsorship from it.
                    application.setApproved(true);


                    String raceThatBeingSponsored = race.getName();
                    String sponsorCompany = sponsorWhoApplied.getCompany();
                    String sponsorshipAmount = String.valueOf(application.getAmount().getAmount());

                    String sponsorshipDescription = "This is a sponsorship for "+ raceThatBeingSponsored+" from the " + sponsorCompany
                            + " with an amount of " + sponsorshipAmount;

                    Sponsorship sponsorship = new Sponsorship(sponsorshipDescription);
                    application.setSponsorship(sponsorship);

                    EmailMessage message = createEmail(emailProvider.getAddress(),sponsorsEmail,race,true);
                    emailProvider.sendEmail(message);

                } else if (rejected.contains(application)) { // if the organizer rejected the application then it should be removed from the race.

                    race.removeSponsorshipApplication(application);
                    double amountOfApplication = application.getAmount().getAmount();
                    sponsorWhoApplied.getCard().addToBalance(amountOfApplication);

                    EmailMessage message = createEmail(emailProvider.getAddress(),sponsorsEmail,race,false);
                    emailProvider.sendEmail(message);
                }
            }
        }
        approved.clear();
        rejected.clear();
    }

    /**
     *
     * @param from sender of the Email
     * @param to receiver of the Email
     * @param race Instance of race object
     * @param wasApproved explains if the application was approved or rejected
     * @return an instance of EmailMessage that informs the applicant about the status of his application
     */

    private EmailMessage createEmail(Email from, Email to,Race race,boolean wasApproved) {

        String subject = "Sponsorship Application status update";
        String body = "";

        if(wasApproved)
            body = "Your application for "+race.getName()+" has been approved.";
        else
            body = "Your application for "+race.getName()+" has been rejected.";

        EmailMessage message = new EmailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setBody(body);
        return message;
    }
}
