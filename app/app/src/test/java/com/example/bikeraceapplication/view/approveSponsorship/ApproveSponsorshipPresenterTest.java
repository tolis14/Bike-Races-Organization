package com.example.bikeraceapplication.view.approveSponsorship;

import com.example.bikeraceapplication.dao.EmailDAO;
import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.dao.RaceDAO;
import com.example.bikeraceapplication.memorydao.EmailDAOMemory;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.memorydao.RaceDAOMemory;
import com.example.bikeraceapplication.model.Sponsor;
import com.example.bikeraceapplication.model.Sponsorship;
import com.example.bikeraceapplication.model.SponsorshipApplication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ApproveSponsorshipPresenterTest {

    private ApproveSponsorshipPresenter presenter;
    private EmailDAO emailDAO;

    @Before
    public void setUp(){

        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        emailDAO = new EmailDAOMemory();
        presenter = new ApproveSponsorshipPresenter();
        presenter.setRaceDAO(new RaceDAOMemory());
    }


    @Test
    public void checkFindApplicationsForOrganizerNotExisting(){
        String organizerID = "not existing organizer";
        ArrayList<SponsorshipApplication> applicationsForOrganizer = presenter.findApplications(organizerID);
        Assert.assertEquals(0,applicationsForOrganizer.size());
    }

    @Test
    public void checkFindApplicationsOfOrganizer(){

        String organizerID = "org1";
        /*2 applications for this organizer*/
        ArrayList<SponsorshipApplication> applicationsForOrganizer = presenter.findApplications(organizerID);
        Assert.assertEquals(2,applicationsForOrganizer.size());

        organizerID = "org0";
        /*0 applications for this organizer*/
        applicationsForOrganizer = presenter.findApplications(organizerID);
        Assert.assertEquals(0,applicationsForOrganizer.size());
    }

    @Test
    public void checkHandleApplications(){

        String organizerID = "org1";
        /*2 applications for this organizer*/
        ArrayList<SponsorshipApplication> applicationsForOrganizer = presenter.findApplications(organizerID);

        int sizeOfApplicationsBeforeHandling = applicationsForOrganizer.size();

        List<SponsorshipApplication> approved = new ArrayList<>();
        List<SponsorshipApplication> rejected = new ArrayList<>();

        /*organizer approve the first application*/
        SponsorshipApplication approvedApplication = applicationsForOrganizer.get(0);
        approved.add(approvedApplication);

        /*organizer rejects the second application*/
        SponsorshipApplication rejectedApplication = applicationsForOrganizer.get(1);
        rejected.add(rejectedApplication);

        /*call the method to handle the applications*/
        presenter.handleApplications(approved,rejected);

        /*after the handling approved and rejected list should be empty*/
        Assert.assertEquals(0,approved.size());
        Assert.assertEquals(0,rejected.size());


        /*the second applications should have been removed from the race and the first one has been approved so it is not return anymore
        * only those applications that are not yet approved are displayed.*/
        int sizeOfApplicationsAfterHandling = presenter.findApplications(organizerID).size();
        Assert.assertEquals(0,sizeOfApplicationsAfterHandling);

        /*approval status of the application that have been approved should be true*/
        Assert.assertTrue(approvedApplication.isApproved());

        /*application that was rejected should not exist in the applications of this race*/
        boolean exists = presenter.findApplications(organizerID).contains(rejectedApplication);
        Assert.assertFalse(exists);

        /*application that was approved should not be returned anymore*/
        boolean returned = presenter.findApplications(organizerID).contains(approvedApplication);
        Assert.assertFalse(returned);
    }

    @Test
    /*test when the user did not approve of rejected anything and just pressed the button*/
    public void checkEmptyChoice(){

        String organizerID = "org1";

        List<SponsorshipApplication> approved = new ArrayList<>();
        List<SponsorshipApplication> rejected = new ArrayList<>();

        List<SponsorshipApplication> applicationsBeforeHandling = presenter.findApplications(organizerID);

        presenter.handleApplications(approved,rejected);

        List<SponsorshipApplication> applicationsAfterHandling = presenter.findApplications(organizerID);

        /*applications before and after the empty submitting should be exactly the same*/
        for(SponsorshipApplication application: applicationsBeforeHandling)
            Assert.assertTrue(applicationsAfterHandling.contains(application));
    }


    @Test
    public void checkCreationOfSponsorship(){

        String organizerID = "org1";

        List<SponsorshipApplication> approved = new ArrayList<>();
        List<SponsorshipApplication> rejected = new ArrayList<>();

        ArrayList<SponsorshipApplication> applicationsForOrganizer = presenter.findApplications(organizerID);

        SponsorshipApplication approvedSponsorshipApplication = applicationsForOrganizer.get(0);
        approved.add(approvedSponsorshipApplication);

        presenter.handleApplications(approved,rejected);

        Sponsorship sponsorshipCreated = approvedSponsorshipApplication.getSponsorship();

        Assert.assertNotNull(sponsorshipCreated);
    }

    @Test
    public void checkEmail(){

        String organizerID = "org1";
        List<SponsorshipApplication> approved = new ArrayList<>();
        List<SponsorshipApplication> rejected = new ArrayList<>();

        ArrayList<SponsorshipApplication> applicationsForOrganizer = presenter.findApplications(organizerID);

        SponsorshipApplication approvedSponsorshipApplication = applicationsForOrganizer.get(0);
        approved.add(approvedSponsorshipApplication);

        SponsorshipApplication rejectedSponsorshipApplication = applicationsForOrganizer.get(1);
        rejected.add(rejectedSponsorshipApplication);

        presenter.handleApplications(approved,rejected);

        Assert.assertEquals(2,emailDAO.findAll().size());

    }

    @Test
    public void checkMoneyReturnedAfterRejection(){

        String organizerID = "org1";

        List<SponsorshipApplication> accepted = new ArrayList<>();
        List<SponsorshipApplication> rejected = new ArrayList<>();

        ArrayList<SponsorshipApplication> applicationsForOrganizer = presenter.findApplications(organizerID);

        SponsorshipApplication rejectedSponsorshipApplication = applicationsForOrganizer.get(1);

        Sponsor sponsorWhoApplied =  rejectedSponsorshipApplication.getSponsor();

        double moneyOfSponsorBeforeRejected = sponsorWhoApplied.getCard().getBalance().getAmount();

        rejected.add(rejectedSponsorshipApplication);
        presenter.handleApplications(accepted,rejected);

        double moneyOfSponsorAfterRejected = sponsorWhoApplied.getCard().getBalance().getAmount();

        double amountOfApplication = rejectedSponsorshipApplication.getAmount().getAmount();

        Assert.assertEquals(moneyOfSponsorAfterRejected,moneyOfSponsorBeforeRejected+amountOfApplication,0.000001);

    }

}
