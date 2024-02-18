package com.example.bikeraceapplication.model;

import com.example.bikeraceapplication.contacts.Email;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class OrganizerTest {
    private Organizer test;

    @Before
    public void setUp() {
        Email email = new Email("abc@def.gr");
        test = new Organizer("firstName", "lastName", email, "password","team02");
    }

    /**
     * Tests if Organizer constructor is working as intended
     * Checks if Organizer object test is not null
     */
    @Test
    public void testNull() {
        Assert.assertNotNull(test);
    }

    /**
     * Tests if Organizer constructor is working as intended
     * Checks if Organizer object test has all its values
     * set correctly by the constructor
     */
    @Test
    public void testConstructor() {
        Assert.assertEquals(test.getEmail().getAddress(), "abc@def.gr");
        Assert.assertEquals(test.getFirstName(), "firstName");
        Assert.assertEquals(test.getLastName(), "lastName");
        Assert.assertEquals(test.getTeam(),"team02");

    }

    /**
     * Tests if setTeam and getTeam are working correctly
     * Constructs a new Organizer and sets Team with the name "noTeam"
     * Checks if team name is "noTeam"
     */
    @Test
    public void testTeam() {
        test=new Organizer();
        test.setTeam("noTeam");
        Assert.assertEquals(test.getTeam(),"noTeam");

    }
}
