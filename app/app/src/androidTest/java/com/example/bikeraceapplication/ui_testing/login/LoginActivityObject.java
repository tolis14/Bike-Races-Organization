package com.example.bikeraceapplication.ui_testing.login;

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
import androidx.test.espresso.action.ViewActions;

import com.example.bikeraceapplication.R;

public class LoginActivityObject {

    Context context;

    public LoginActivityObject(Context context){ this.context = context; }

    public LoginActivityObject fillUserName(String value){

        fillEdiTextWithHint("Email",value);
        return this;
    }

    public LoginActivityObject fillPassword(String value){

        fillEdiTextWithHint("password",value);
        return this;
    }

    public LoginActivityObject login(){

        Espresso.closeSoftKeyboard();
        onView(withId(R.id.login_button)).perform(click());
        return this;
    }

    public LoginActivityObject assertInvalidCredentials(){

        onView(withId(R.id.error)).check(matches(withText("This user doesn't exist")));
        return this;
    }

    public LoginActivityObject assertInvalidFormCompletion(){

        onView(withId(R.id.error)).check(matches(withText("Invalid Input")));
        return this;
    }

    private void fillEdiTextWithHint(String hint, String value){

        onView(withHint(hint)).perform(ViewActions.scrollTo());
        onView(withHint(hint)).perform(clearText());
        onView(withHint(hint)).perform(typeText(value));
    }
}
