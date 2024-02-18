package com.example.bikeraceapplication.model;

import com.example.bikeraceapplication.contacts.Email;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RefereeTest {
    private Referee test;

    @Before
    public void setUp() {
        test = new Referee();
        Email email = new Email("abc@def.gr");
        test = new Referee("firstName", "lastName", email, "password");
        test.setId("testId");
    }

    /**
     * Tests if Referee constructor is working as intended
     * Checks if Referee object test is not null
     */
    @Test
    public void testNull() {
        Assert.assertNotNull(test);
    }

    /**
     * Tests if Referee constructor is working as intended
     * Checks if Referee object test has all its values
     * set correctly by the constructor
     */
    @Test
    public void testConstructor() {
        Assert.assertEquals(test.getEmail().getAddress(), "abc@def.gr");
        Assert.assertEquals(test.getFirstName(), "firstName");
        Assert.assertEquals(test.getLastName(), "lastName");

    }

    /**
     * Tests if getId is working correctly
     * Checks if the id of test is not null
     */
    @Test
    public void testGetId() {
        Assert.assertNotNull(test.getId());

    }
}