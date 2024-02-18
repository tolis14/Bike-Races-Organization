package com.example.bikeraceapplication.model;

import com.example.bikeraceapplication.contacts.Email;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class UserTest {
    private User test;

    @Before
    public void setUp() {
        Email email=new Email("abc@def.gr");

        test = new User("firstName", "lastName", email, "password",Role.COMPETITOR);

    }

    /**
     * Tests if User constructor is working as intended
     * Checks if User object test is not null
     */
    @Test
    public void testNull(){
        Assert.assertNotNull(test);
    }

    /**
     * Tests if User constructor is working as intended
     * Checks if User object test has all its values
     * set correctly by the constructor
     */
    @Test
    public void testConstructor(){
        Assert.assertEquals(test.getEmail().getAddress(),"abc@def.gr");
        Assert.assertEquals(test.getFirstName(),"firstName");
        Assert.assertEquals(test.getLastName(),"lastName");

    }

    /**
     * Tests if setters and getters are working correctly
     * Constructs a new User and uses all the setters
     * Checks if fields are set correctly
     */
    @Test
    public void testSetters(){
        test=new User();
        test.setEmail(new Email("testmail@testmail.tm"));
        test.setFirstName("testName");
        test.setLastName("TestLast");
        test.setPassword("testPassword");

        Assert.assertEquals(test.getEmail().getAddress(),"testmail@testmail.tm");
        Assert.assertEquals(test.getFirstName(),"testName");
        Assert.assertEquals(test.getLastName(),"TestLast");

    }

}
