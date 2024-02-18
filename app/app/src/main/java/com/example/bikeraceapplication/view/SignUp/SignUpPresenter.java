package com.example.bikeraceapplication.view.SignUp;

import android.util.Log;

import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.contacts.Email;
import com.example.bikeraceapplication.dao.CompetitorDAO;
import com.example.bikeraceapplication.dao.OrganizerDAO;
import com.example.bikeraceapplication.dao.RefereeDAO;
import com.example.bikeraceapplication.dao.SponsorDAO;
import com.example.bikeraceapplication.dao.UserDAO;
import com.example.bikeraceapplication.model.Competitor;
import com.example.bikeraceapplication.model.Organizer;
import com.example.bikeraceapplication.model.Referee;
import com.example.bikeraceapplication.model.Role;
import com.example.bikeraceapplication.model.Sponsor;
import com.example.bikeraceapplication.model.User;
import com.example.bikeraceapplication.util.Card;

import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class SignUpPresenter {

    private User user;
    private SignUpView view;
    private UserDAO UserDAO;
    private CompetitorDAO competitorDao;
    private SponsorDAO sponsorDAO;
    private OrganizerDAO organizerDAO;
    private RefereeDAO refereeDAO;

    public SignUpView getView(){ return view; }

    public void setView(SignUpView view) { this.view  = view; }

    public SignUpPresenter(){}

    public boolean validateUser(String first_name, String last_name, String email, String password, String confirm_password, String state, String company_name, String team_name) {

        Role role = Role.valueOf(state.toUpperCase());

        if (password.equals(confirm_password) & !password.equals("") & !first_name.equals("")
                & !last_name.equals("") & !email.equals("")) {


            if(role.toString().equalsIgnoreCase("Organizer") && team_name.equals("")){
                view.showError("INVALID INPUTS");
                return false;
            }

            if(role.toString().equalsIgnoreCase("Sponsor") && company_name.equals("")){
                view.showError("INVALID INPUTS");
                return false;
            }

            if (this.UserNOTExists(first_name,last_name,email,password,role,company_name,team_name)) {
                if(view != null) {
                    view.ShowMessage("SIGN UP SUCCESSFUL");
                }
                return true;
            }
            else {
                if(view != null) {
                    view.showError("USER ALREADY EXISTS");
                }
                return false;
            }
        }
        else {
            if(view != null) {
                if(password.equals(confirm_password))
                    view.showError("INVALID INPUTS");
                else
                    view.showError("PASSWORDS NOT MATCHING");
            }
            return false;
        }

    }

    public boolean UserNOTExists(String first_name, String last_name, String email, String password, Role role,String company_name,String team_name) {

        if (UserDAO.findByEmail(email) != null) {
            return false;
        }
        else {
            Email o_email = new Email(email);
            user = new User(first_name,last_name,o_email,password,role);
            save_to_daos(user,role,company_name,team_name);
            return true;
        }

    }

    public void setUserDAO(UserDAO UserDAO) {
        this.UserDAO = UserDAO;
    }

    public void setOrganizerDAO(OrganizerDAO organizerDAO){this.organizerDAO=organizerDAO;}

    public void setCompetitorDao(CompetitorDAO competitorDAO){this.competitorDao = competitorDAO;}

    public void setSponsorDAO(SponsorDAO sponsorDAO){this.sponsorDAO = sponsorDAO;}

    public void setRefereeDAO(RefereeDAO refereeDAO){this.refereeDAO = refereeDAO;}


    public void save_to_daos(User user,Role role,String company_name,String team_name) {

        user.setId(UUID.randomUUID().toString());
        UserDAO.save(user);

        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        Email email = user.getEmail();
        String id = user.getId();
        String password = user.getPassword();

        if(role.toString().equalsIgnoreCase("Competitor")){

            Competitor competitor = new Competitor(firstName,lastName,email,password,setUpCard());
            competitor.setId(id);
            competitorDao.save(competitor);

        }
        else if(role.toString().equalsIgnoreCase("Organizer")){

            Organizer organizer = new Organizer(firstName,lastName,email,password,team_name);
            organizer.setId(id);
            organizer.setTeam(team_name);
            organizerDAO.save(organizer);
        }
        else if(role.toString().equalsIgnoreCase("Referee")){
            Referee referee = new Referee(firstName,lastName,email,password);
            referee.setId(id);
            refereeDAO.save(referee);
        }
        else if(role.toString().equalsIgnoreCase("Sponsor")){
            Sponsor sponsor = new Sponsor(firstName,lastName,email,password,company_name,setUpCard());
            sponsor.setId(id);
            sponsor.setCompany(company_name);
            sponsorDAO.save(sponsor);
        }
    }

    /*assigning a random amount between 500 and 1000 euros for every new competitor*/
    private Card setUpCard(){

        Random random = new Random();
        int amount = random.nextInt(1000 - 500 + 1) + 500;
        Card card = new Card();
        card.setBalance(amount);
        return card;
    }

}
