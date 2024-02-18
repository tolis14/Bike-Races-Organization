package com.example.bikeraceapplication.ui_testing.sponsor_race;


import android.content.Context;
import android.content.Intent;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.dao.SponsorDAO;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.memorydao.SponsorDAOMemory;
import com.example.bikeraceapplication.view.Sponsor.SponsorActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SponsorActivityEspressoTest {

    private SponsorDAO sponsorDAO;
    static Intent intent;
    static Initializer initializer;
    static {
        intent = new Intent(ApplicationProvider.getApplicationContext(),SponsorActivity.class);
        intent.putExtra("sponId","spons1");
        initializer = new MemoryInitializer();
        initializer.prepareData();
    }

    @Rule
    public ActivityScenarioRule<SponsorActivity> mActivityRule = new ActivityScenarioRule<>(intent);

    private Context context;
    private SponsorActivityObject sponsorActivity;

    @Before
    public void setUp(){
        sponsorDAO = new SponsorDAOMemory();
        initializer.prepareData();
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        sponsorActivity = new SponsorActivityObject(context);
    }

    @Test
    public void checkNotEnoughMoney(){
        sponsorActivity
                .fillMoney("700")
                .sponsor()
                .assertNotEnoughMoney();
    }

    @Test
    public void checkBalanceTextBox(){
        String amount = String.valueOf(sponsorDAO.findbyid("spons1").getCard().getBalance().getAmount());
        sponsorActivity.assertMoneyBoxOkay(amount);
    }

    @Test
    public void checkInvalidInput(){
        sponsorActivity
                .sponsor()
                .assertInvalidInput();
    }
}
