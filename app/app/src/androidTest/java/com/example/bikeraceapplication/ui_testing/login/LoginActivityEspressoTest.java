package com.example.bikeraceapplication.ui_testing.login;


import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.view.login.LoginActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class LoginActivityEspressoTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> mActivityRule = new ActivityScenarioRule<>(LoginActivity.class);

    private Context context;
    private LoginActivityObject loginActivity;

    @Before
    public void setUp(){

        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        loginActivity = new LoginActivityObject(context);
    }


    @Test
    public void testInvalidCredentials(){

        loginActivity
                .fillUserName("p3190071@aueb.gr")
                .fillPassword("tolis12")
                .login()
                .assertInvalidCredentials();
    }

    @Test
    public void testInvalidUserNameCompletion(){

        loginActivity
                .fillPassword("123")
                .login()
                .assertInvalidFormCompletion();
    }

    @Test
    public void testInvalidPasswordCompletion(){

        loginActivity
                .fillUserName("tolis")
                .login()
                .assertInvalidFormCompletion();

    }

}
