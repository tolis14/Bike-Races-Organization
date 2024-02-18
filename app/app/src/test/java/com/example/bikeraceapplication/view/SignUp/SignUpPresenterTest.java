package com.example.bikeraceapplication.view.SignUp;


import com.example.bikeraceapplication.dao.CompetitorDAO;
import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.dao.OrganizerDAO;
import com.example.bikeraceapplication.dao.RefereeDAO;
import com.example.bikeraceapplication.dao.SponsorDAO;
import com.example.bikeraceapplication.dao.UserDAO;
import com.example.bikeraceapplication.memorydao.CompetitorDAOMemory;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.memorydao.OrganizerDAOMemory;
import com.example.bikeraceapplication.memorydao.RefereeDAOMemory;
import com.example.bikeraceapplication.memorydao.SponsorDAOMemory;
import com.example.bikeraceapplication.memorydao.UserDAOMemory;
import com.example.bikeraceapplication.model.Competitor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class SignUpPresenterTest {

    private SignUpPresenter presenter;
    private UserDAO userDAO;
    private CompetitorDAO competitorDAO;
    private OrganizerDAO organizerDAO;
    private RefereeDAO refereeDAO;
    private SponsorDAO sponsorDAO;
    private SignUpViewStub view;
    private String role;

    @Before
    public void setUp() {

        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        userDAO = new UserDAOMemory();
        competitorDAO = new CompetitorDAOMemory();
        organizerDAO = new OrganizerDAOMemory();
        refereeDAO = new RefereeDAOMemory();
        sponsorDAO = new SponsorDAOMemory();

        view = new SignUpViewStub();

        presenter = new SignUpPresenter();
        presenter.setUserDAO(userDAO);
        presenter.setOrganizerDAO(organizerDAO);
        presenter.setSponsorDAO(sponsorDAO);
        presenter.setRefereeDAO(refereeDAO);
        presenter.setCompetitorDao(competitorDAO);
        presenter.setView(view);
    }

    @Test
    public void checkView(){

        Assert.assertNotNull(presenter.getView());
    }

    @Test
    public void checkEmptyFields(){

        String userName = "";
        String lastName = "ioannou";
        String email = "ioannou@gmail.com";
        String password = "123";
        String confirmPassword = "123";

        boolean result = presenter.validateUser(userName,lastName,email,password,confirmPassword,"Competitor","","");

        Assert.assertFalse(result);

        Assert.assertEquals(1,view.getErrorCount());
        Assert.assertEquals(view.getErrorMsg(),"INVALID INPUTS");
    }

    @Test
    public void notSamePassword(){

        //Create a competitor and give not matching passwords during form completion
        String userName = "jim";
        String lastName = "ioannou";
        String email = "ioannou@gmail.com";
        String password = "1234";
        String confirmPassword = "123";

        boolean result = presenter.validateUser(userName,lastName,email,password,confirmPassword,"Competitor","","");

        Assert.assertFalse(result);

        Assert.assertEquals(1,view.getErrorCount());
        Assert.assertEquals(view.getErrorMsg(),"PASSWORDS NOT MATCHING");

    }

    @Test
    public void organizerUncompletedTeamField(){

        String userName = "jim";
        String lastName = "ioannou";
        String email = "ioannou@gmail.com";
        String password = "1234";
        String confirmPassword = "1234";
        String role = "Organizer";
        String company = "";

        boolean result = presenter.validateUser(userName,lastName,email,password,confirmPassword,role,company,"");

        Assert.assertFalse(result);
        Assert.assertEquals(1,view.getErrorCount());
        Assert.assertEquals(view.getErrorMsg(),"INVALID INPUTS");

    }

    @Test
    public void sponsorUncompletedCompanyField(){

        String userName = "jim";
        String lastName = "ioannou";
        String email = "ioannou@gmail.com";
        String password = "1234";
        String confirmPassword = "1234";
        String role = "Sponsor";
        String team = "";

        boolean result = presenter.validateUser(userName,lastName,email,password,confirmPassword,role,"",team);

        Assert.assertFalse(result);
        Assert.assertEquals(1,view.getErrorCount());
        Assert.assertEquals(view.getErrorMsg(),"INVALID INPUTS");
    }

    @Test
    public void userAlreadyExists(){

        String userName = "tolis";
        String lastName = "kapetis";
        String password = "tolis12";
        String confirmPassword = "tolis12";
        String email = "p3190071@aueb.gr";
        String role = "Competitor";
        String team = "";
        String company = "";

        boolean result = presenter.validateUser(userName,lastName,email,password,confirmPassword,role,company,team);

        Assert.assertFalse(result);
        Assert.assertEquals(1,view.getErrorCount());
        Assert.assertEquals(view.getErrorMsg(),"USER ALREADY EXISTS");

    }

    @Test
    public void normalSignUpProcessCompetitor(){

        role = "Competitor";
        normalSignUpProcess();
    }

    @Test
    public void normalSignUpProcessOrganizer(){

        role = "Organizer";
        normalSignUpProcess();
    }

    @Test
    public void normalSignUpProcessSponsor(){

        role = "Sponsor";
        normalSignUpProcess();
    }

    @Test
    public void normalSignUpProcessReferee(){

        role = "Referee";
        normalSignUpProcess();
    }


    @Test
    public void checkCardSetUp(){

        String userName = "kostas";
        String lastName = "kostas";
        String password = "123456";
        String confirmPassword = "123456";
        String email = "kostas123@gmail.com";
        String role = "Competitor";

        presenter.validateUser(userName,lastName,email,password,confirmPassword,role,"","");

        /*getting the id of the new user --- this user signed up as competitor so this id
        * should also be existing to competitors
        * */

        String id = userDAO.findByEmail("kostas123@gmail.com").getId();

        Competitor competitor = competitorDAO.findById(id);

        Assert.assertNotNull(competitor.getCard()); // his card was initialized okay.
        double amount = competitor.getCard().getBalance().getAmount();
        Assert.assertTrue(amount<1000 && amount > 500); // cards are initialized with money in ( 500 , 1000).
    }


    private void normalSignUpProcess(){

        String userName = "kostas";
        String lastName = "kostas";
        String password = "123456";
        String confirmPassword = "123456";
        String email = "kostas123@gmail.com";
        String team = "";
        String company = "";

        if(role.equals("Organizer"))
            team = "team";

        if(role.equals("Sponsor"))
            company = "company";

        int usersInTheSystemBefore = userDAO.findAll().size();
        int targetRoleUsersBefore = 0;

        if(role.equals("Competitor"))
            targetRoleUsersBefore = competitorDAO.findAll().size();
        else if(role.equals("Sponsor"))
            targetRoleUsersBefore = sponsorDAO.findAll().size();
        else if(role.equals("Organizer"))
            targetRoleUsersBefore = organizerDAO.findAll().size();
        else if(role.equals("Referee"))
            targetRoleUsersBefore = refereeDAO.findAll().size();


        boolean result = presenter.validateUser(userName,lastName,email,password,confirmPassword,role,company,team);
        Assert.assertTrue(result);
        Assert.assertEquals(1,view.getStatusCount());
        Assert.assertEquals(view.getStatusMsg(),"SIGN UP SUCCESSFUL");


        int usersInTheSystemAfter = userDAO.findAll().size();
        int targetRoleUsersAfter = 0;

        if(role.equals("Competitor"))
            targetRoleUsersAfter = competitorDAO.findAll().size();
        else if(role.equals("Sponsor"))
            targetRoleUsersAfter = sponsorDAO.findAll().size();
        else if(role.equals("Organizer"))
            targetRoleUsersAfter = organizerDAO.findAll().size();
        else if(role.equals("Referee"))
            targetRoleUsersAfter = refereeDAO.findAll().size();


        Assert.assertEquals(targetRoleUsersAfter, targetRoleUsersBefore + 1);
        Assert.assertEquals(usersInTheSystemAfter,usersInTheSystemBefore+1);

    }

}