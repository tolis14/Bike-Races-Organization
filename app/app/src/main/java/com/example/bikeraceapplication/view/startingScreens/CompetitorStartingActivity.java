package com.example.bikeraceapplication.view.startingScreens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.dao.CompetitorDAO;
import com.example.bikeraceapplication.memorydao.CompetitorDAOMemory;
import com.example.bikeraceapplication.model.Competitor;
import com.example.bikeraceapplication.view.Competitor.ViewRaces.History.HistoryActivity;
import com.example.bikeraceapplication.view.Competitor.ViewRaces.Ongoing.OngoingActivity;
import com.example.bikeraceapplication.view.Competitor.registration.RaceRegistrationActivity;

public class CompetitorStartingActivity extends AppCompatActivity {


    public static final String COMPETITOR_ID = "competitor_id";
    private String competitorId;


    private TextView firstName;
    private TextView lastName;
    private TextView email;
    private TextView accountBalance;
    private Button registerToRaceButton;
    private Button historyButton;
    private Button onHoldButton;
    private CompetitorDAO competitorDAO = new CompetitorDAOMemory();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitor_starting_acitvity);

        /*find ui fields*/
        firstName = findViewById(R.id.competitor_first_name);
        lastName = findViewById(R.id.competitor_last_name);
        email = findViewById(R.id.competitor_email);
        accountBalance = findViewById(R.id.competitor_card_balance);
        registerToRaceButton = findViewById(R.id.competitor_register_to_race_button);
        historyButton = findViewById(R.id.competitor_history_button);
        onHoldButton = findViewById(R.id.competitor_onGoing_races_button);

        competitorId = getIntent().getStringExtra(COMPETITOR_ID);

        registerToRaceButton.setOnClickListener(v->registerToRace());
        historyButton.setOnClickListener(v->viewHistory());
        onHoldButton.setOnClickListener(v->viewOnHoldRaces());

        setDetails(competitorId);

    }

    private void registerToRace(){

        Intent intent = new Intent(this, RaceRegistrationActivity.class);
        intent.putExtra(RaceRegistrationActivity.COMPETITOR_ID,competitorId);
        startActivity(intent);

    }

    private void viewHistory(){
        Intent intent = new Intent(this, HistoryActivity.class);
        intent.putExtra(RaceRegistrationActivity.COMPETITOR_ID,competitorId);
        startActivity(intent);
    }

    private void viewOnHoldRaces(){
        Intent intent = new Intent(this, OngoingActivity.class);
        intent.putExtra(RaceRegistrationActivity.COMPETITOR_ID,competitorId);
        startActivity(intent);
    }

    void setDetails(String competitorId){

        Competitor competitor = competitorDAO.findById(competitorId);
        firstName.setText(competitor.getFirstName());
        lastName.setText(competitor.getLastName());
        email.setText(competitor.getEmail().toString());
        accountBalance.setText("Current balance\n"+competitor.getCard().getBalance().getAmount());
    }

    @Override
    public void onResume() {
        super.onResume();
        setDetails(competitorId);
    }
}