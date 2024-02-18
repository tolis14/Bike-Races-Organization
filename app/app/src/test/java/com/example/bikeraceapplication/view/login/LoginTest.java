package com.example.bikeraceapplication.view.login;


import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;

import com.example.bikeraceapplication.memorydao.UserDAOMemory;
import com.example.bikeraceapplication.dao.UserDAO;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest {

    private LoginPresenter presenter;
    private UserDAO UserDAO;
    private LoginViewStub view;

    @Before
    public void setUp(){
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        UserDAO = new UserDAOMemory();
        view= new LoginViewStub();
        presenter = new LoginPresenter();
        presenter.setUserDAO(UserDAO);
        presenter.setView(view);
    }

    /**
     * Tests if ValidateInput is working correctly for invalid inputs
     * every possible invalid input combination is being tested
     */
    @Test
    public void testValidateInputInvalid(){
        Assert.assertFalse(presenter.validateInput("",""));
        Assert.assertFalse(presenter.validateInput("","A"));
        Assert.assertFalse(presenter.validateInput("A",""));
    }

    /**
     * Tests if ValidateInput is working correctly for valid inputs
     * Here both fields are filled so the input is considered valid
     */
    @Test
    public void testValidateInputValid() {
        Assert.assertTrue(presenter.validateInput("A", "A"));
    }

    /**
     * Tests if Login is working as intend for invalid inputs
     * multiple invalid input combination are being tested
     */
    @Test
    public void testLoginInvalid(){
        Assert.assertNull(presenter.login("",""));
        Assert.assertEquals("Invalid Input",view.getErrorMsg());
        Assert.assertEquals(1,view.getErrorCount());
        Assert.assertNull(presenter.login("","A"));
        Assert.assertNull(presenter.login("A",""));
        Assert.assertNull(presenter.login("A","A"));
        Assert.assertNull(presenter.login("user0",""));
        Assert.assertNull(presenter.login("","user0"));
        Assert.assertEquals(6,view.getErrorCount());
    }

    /**
     * Tests if Login is working as intend for valid inputs
     * First an existing email and password are being tested but the test
     * should fail because their combination is not correct
     *
     * Afterwards a correct combination is tested
     * that should return a User object (not null)
     */
    @Test
    public void testLoginValid(){
        Assert.assertNull(presenter.login("p3190146@aueb.gr","tolis123"));
        Assert.assertEquals(1,view.getErrorCount());
        Assert.assertEquals("This user doesn't exist",view.getErrorMsg());
        Assert.assertNotNull(presenter.login("p3190146@aueb.gr","nikos123"));
        Assert.assertEquals(2,view.getErrorCount());

    }


}
