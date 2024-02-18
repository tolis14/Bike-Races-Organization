package com.example.bikeraceapplication.ui_testing.sponsor_race;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.espresso.Espresso;

import com.example.bikeraceapplication.R;

public class SponsorActivityObject {

    Context context;

    public SponsorActivityObject(Context context){
        this.context = context;
    }

    public SponsorActivityObject fillMoney(String value){

        fillEdtTextWithHint("money for sponsorship",value);
        return this;
    }

    public SponsorActivityObject sponsor(){

        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sponsor_button)).perform(click());
        return this;
    }

    public SponsorActivityObject assertNotEnoughMoney(){

        onView(withId(R.id.error_sponsor)).check(matches(withText("Not enough money")));
        return this;
    }

    public SponsorActivityObject assertMoneyBoxOkay(String amount){

        onView(withId(R.id.sponsor_card_amount)).check(matches(withText("Balance: "+amount)));
        return this;
    }

    public SponsorActivityObject assertInvalidInput(){

        onView(withId(R.id.error_sponsor)).check(matches(withText("INVALID INPUTS")));
        return this;
    }

    private void fillEdtTextWithHint(String hint,String value){

        onView(withHint(hint)).perform(clearText());
        onView(withHint(hint)).perform(typeText(value));
    }
}
