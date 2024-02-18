package com.example.bikeraceapplication.ui_testing.sign_up;


import android.app.Activity;
import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.view.SignUp.SignUpActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SignUpActivityEspressoTest {

    @Rule
    public ActivityScenarioRule<SignUpActivity> mActivityRule = new ActivityScenarioRule<SignUpActivity>(SignUpActivity.class);

    private Context context;
    private SignUpActivityObject signUpActivity;


    @Before
    public void setUp(){
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        signUpActivity = new SignUpActivityObject(context);
    }

    @Test
    public void checkMissingFields(){

        signUpActivity
                .fillFirstName("tolis")
                .fillLastName("")
                .fillEmail("tolisk37@gmail.com")
                .fillPassword("1234")
                .fillConfirmPassword("1234")
                .selectRole("Competitor")
                .singUp()
                .assertMissingField();
    }

    @Test
    public void checkNotMatchingPasswords(){

        signUpActivity
                .fillFirstName("tolis")
                .fillLastName("kapetis")
                .fillEmail("tolisk37@gmail.com")
                .fillPassword("1234")
                .fillConfirmPassword("123")
                .selectRole("Competitor")
                .singUp()
                .assertNotMatchingPasswords();
    }

    @Test
    public void checkOrganizerMissingTeam(){

        signUpActivity
                .fillFirstName("tolis")
                .fillLastName("kapetis")
                .fillEmail("tolisk37@gmail.com")
                .fillPassword("1234")
                .fillConfirmPassword("1234")
                .selectRole("Organizer")
                .singUp()
                .assertMissingField();
    }

    @Test
    public void checkSponsorMissingCompany(){

        signUpActivity
                .fillFirstName("tolis")
                .fillLastName("kapetis")
                .fillEmail("tolisk37@gmail.com")
                .fillPassword("1234")
                .fillConfirmPassword("1234")
                .selectRole("Sponsor")
                .singUp()
                .assertMissingField();
    }

    @Test
    public void checkUserAlreadyExists(){

        signUpActivity
                .fillFirstName("tolis")
                .fillLastName("kapetis")
                .fillEmail("p3190071@aueb.gr")
                .fillPassword("1234")
                .fillConfirmPassword("1234")
                .selectRole("Competitor")
                .singUp()
                .assertUserExists();
    }
}
