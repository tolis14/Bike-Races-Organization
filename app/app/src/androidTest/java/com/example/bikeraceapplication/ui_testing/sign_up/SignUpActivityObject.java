package com.example.bikeraceapplication.ui_testing.sign_up;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.is;
import static java.util.EnumSet.allOf;

import android.content.Context;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;

import com.example.bikeraceapplication.R;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class SignUpActivityObject {

    Context context;

    public SignUpActivityObject(Context context){this.context = context;}

    public SignUpActivityObject fillFirstName(String value){

        fillEdtTextWithHint("first name",value);
        return this;
    }

    public SignUpActivityObject fillLastName(String value){

        fillEdtTextWithHint("last name",value);
        return this;
    }

    public SignUpActivityObject fillEmail(String value){

        fillEdtTextWithHint("email",value);
        return this;
    }

    public SignUpActivityObject fillPassword(String value){

        fillEdtTextWithHint("password",value);
        return this;
    }

    public SignUpActivityObject fillConfirmPassword(String value){

        fillEdtTextWithHint("confirm password",value);
        return this;
    }

    public SignUpActivityObject fillCompany(String value){

        fillEdtTextWithHint("company name",value);
        return this;
    }

    public SignUpActivityObject fillTeam(String value){

        fillEdtTextWithHint("team name",value);
        return this;
    }

    public SignUpActivityObject singUp(){

        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_button)).perform(ViewActions.scrollTo());
        onView(withId(R.id.sign_up_button)).perform(click());
        return this;
    }

    public SignUpActivityObject selectRole(String role){

        Espresso.closeSoftKeyboard();
        onView(withId(R.id.spinner)).perform(ViewActions.scrollTo());
        onView(withId(R.id.spinner)).perform(click());
        onData(hasToString(role)).perform(click());
        return this;
    }


    public SignUpActivityObject assertMissingField(){

        onView(withId(R.id.sign_up_status_message)).check(matches(withText("INVALID INPUTS")));
        return this;
    }

    public SignUpActivityObject assertNotMatchingPasswords(){

        onView(withId(R.id.sign_up_status_message)).check(matches(withText("PASSWORDS NOT MATCHING")));
        return this;
    }


    public SignUpActivityObject assertUserExists(){

        onView(withId(R.id.sign_up_status_message)).check(matches(withText("USER ALREADY EXISTS")));
        return this;
    }


    private void fillEdtTextWithHint(String hint,String value){

        onView(withHint(hint)).perform(ViewActions.scrollTo());
        onView(withHint(hint)).perform(clearText());
        onView(withHint(hint)).perform(typeText(value));
    }

    private Matcher<? extends Object> hasToString(String role) {

        return new BaseMatcher<Object>() {
            @Override
            public boolean matches(Object item) {
                return item.toString().equals(role);
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }

}
