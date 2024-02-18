package com.example.bikeraceapplication.view.login;


import com.example.bikeraceapplication.dao.UserDAO;
import com.example.bikeraceapplication.model.User;


/**
 * <h5>Presenter for LoginActivity</h5><p>
 *
 * retrieves and combines data from ActivityLogin and
 * UserDAO and returns results back to ActivityLogin.
 */
public class LoginPresenter {

    private LoginView view;
    private UserDAO userDAO;


    /**
     * <h5>Checks if a field is not-empty</h5><p>
     *
     * @param input input (String) from the user (could be mail or password)
     * @return true if input is not empty /else false is returned
     */
    private boolean validateUserInput(String input) {

        if (input.isEmpty())
            return false;
        return true;

    }


    /**
     * <h5>Checks if users input is valid</h5><p>
     *
     * Checks if both inputs (mail and password) are not empty
     *
     * @param mail mail (String) of the user who wants to login
     * @param password password (String) of the user who wants to login
     * @return true if both inputs are not empty /else false is returned
     */
    public boolean validateInput(String mail ,String password){
        boolean result=true;
        if(!validateUserInput(mail)){result=false;}
        if(!validateUserInput(password)){result=false;}
        return result;
    }



    /**
     * <h5>Authorizes users in order to access the application</h5><p>
     *
     * If user input is invalid (e.g. the password field is not filled) error:"Invalid Input" is displayed.<p>
     * If the input is valid the method checks if a user exists with the given credentials. If not error:"This user doesn't exist" is displayed.
     *
     * @param mail mail (String) of the user who wants to login
     * @param password password (String) of the user who wants to login
     * @return User object if the user exits /if the user doesn't exist or the input is invalid null is returned
     */
    public User login(String mail,String password){
        if(!validateInput(mail ,password)){
            view.showError("Invalid Input");
            return null;
        }
        User user=userDAO.find(mail,password);
        if(user==null) {
            view.showError("This user doesn't exist");
            return null;
        }
        view.showError("");
        return user;

    }

    /**
     * <h5>Setter for userDAO</h5>
     *
     * @param userDAO (UserDAO object) a simple setter for userDAO
     */
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    /**
     * <h5>Setter for view</h5>
     *
     * @param view (LoginView object) a simple setter for view
     */
    public void setView(LoginView view) { this.view  = view; }

}
