package com.example.bikeraceapplication.ui_testing.create_race;

import android.content.Context;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;

import com.example.bikeraceapplication.R;

public class CreateRaceActivityObject {


    Context context;

    public CreateRaceActivityObject(Context context){this.context = context;}

    public CreateRaceActivityObject fillRaceName(String value){

        fillEdiTextWithHint("Race Name",value);
        return this;
    }


    public CreateRaceActivityObject fillPlace(String value){

        fillEdiTextWithHint("Place: \"City,Location\"",value);
        return this;
    }

    public CreateRaceActivityObject fillDate(String value){

        fillEdiTextWithHint("Race Date: \"dd-mm-yyyy\"",value);
        return this;
    }

    public CreateRaceActivityObject fillType(String value){

        fillEdiTextWithHint("Type: \"STREET-OFFROAD\"",value);
        return this;
    }


    public CreateRaceActivityObject fillDistance(String value){

        fillEdiTextWithHint("Race Distance",value);
        return this;
    }

    public CreateRaceActivityObject fillDeadLine(String value){

        fillEdiTextWithHint("DeadLine \"dd-mm-yyyy\"",value);
        return this;
    }

    public CreateRaceActivityObject fillParticipationAmount(String value){

        fillEdiTextWithHint("Participation Amount",value);
        return this;
    }

    public CreateRaceActivityObject fillMinAmount(String value){

        fillEdiTextWithHint("Min Required Amount",value);
        return this;
    }

    public CreateRaceActivityObject submitForm(){

        Espresso.closeSoftKeyboard();
        onView(withId(R.id.createRaceButton)).perform(click());
        return this;
    }


    public CreateRaceActivityObject assertCreatedSuccessfully(){

        onView(withId(R.id.createRaceStatus)).check(matches(withText("race created successfully")));
        return this;
    }

    public CreateRaceActivityObject assertMissingField(){

        onView(withId(R.id.createRaceError)).check(matches(withText("some fields are missing")));
        return this;
    }

    public CreateRaceActivityObject assertInvalidFormCompletion(){

        onView(withId(R.id.createRaceError)).check(matches(withText("invalid form completion")));
        return this;
    }


    private void fillEdiTextWithHint(String hint, String value){

        Espresso.closeSoftKeyboard();
        onView(withHint(hint)).perform(clearText());
        onView(withHint(hint)).perform(typeText(value));
    }

}
