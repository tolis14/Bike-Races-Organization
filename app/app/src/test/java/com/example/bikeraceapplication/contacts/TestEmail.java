package com.example.bikeraceapplication.contacts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestEmail {

    private Email email;
    @Before
    public void setUp(){
        this.email = new Email("tolisk37@gmail.com");
    }

    @Test
    public void equalsAndCode(){
        Email other =  new Email("tolisk37@gmail.com");

        Assert.assertNotSame(this.email,other);
        Assert.assertEquals(this.email,other);

        int code = this.email.hashCode();
        int otherCode = other.hashCode();

        Assert.assertEquals(code,otherCode);

        other = new Email("test@gmail.com");
        Assert.assertNotEquals(this.email,other);

    }
}
