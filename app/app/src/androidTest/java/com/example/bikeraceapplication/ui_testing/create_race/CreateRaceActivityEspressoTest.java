package com.example.bikeraceapplication.ui_testing.create_race;


import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.view.Race.Create.CreateRaceActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CreateRaceActivityEspressoTest {

    @Rule
    public ActivityScenarioRule<CreateRaceActivity> mActivityRule = new ActivityScenarioRule<>(CreateRaceActivity.class);

    private Context context;
    private CreateRaceActivityObject createRaceActivity;

    @Before
    public void setUp(){

        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        createRaceActivity = new CreateRaceActivityObject(context);
    }

    @Test
    public void testSuccessfulCreation() throws Throwable{

        createRaceActivity
                .fillRaceName("bike mountain 2022")
                .fillPlace("Athens,Faliro")
                .fillDate("20-08-2022")
                .fillType("OFFROAD")
                .fillDistance("80")
                .fillDeadLine("10-08-2022")
                .fillParticipationAmount("15")
                .fillMinAmount("750")
                .submitForm()
                .assertCreatedSuccessfully();
    }

    @Test
    public void testMissingField() throws Throwable{

        createRaceActivity
                .fillRaceName("bike mountain 2022")
                .fillPlace("Athens,Faliro")
                .fillDate("20-08-2022")
                .fillType("OFFROAD")
                .fillDeadLine("10-08-2022")
                .fillParticipationAmount("15")
                .fillMinAmount("750")
                .submitForm()
                .assertMissingField();
    }

    @Test
    public void testInvalidFormCompletion() throws Throwable{

        createRaceActivity
                .fillRaceName("bike mountain 2022")
                .fillPlace("Athens,Faliro")
                .fillDate("20-08-2022")
                .fillType("OFFROAD")
                .fillDistance("80")
                .fillDeadLine("25-08-2022")
                .fillParticipationAmount("15")
                .fillMinAmount("750")
                .submitForm()
                .assertInvalidFormCompletion();
    }

}
