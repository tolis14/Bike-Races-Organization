package com.example.bikeraceapplication.view.startingScreens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.dao.OrganizerDAO;
import com.example.bikeraceapplication.memorydao.OrganizerDAOMemory;
import com.example.bikeraceapplication.model.Organizer;
import com.example.bikeraceapplication.view.Race.Create.CreateRaceActivity;
import com.example.bikeraceapplication.view.approveSponsorship.ApproveSponsorshipActivity;


public class OrganizerStartingActivity extends AppCompatActivity {

    public static final String ORGANIZER_ID = "organizer_id";
    private String organizerId;
    private OrganizerDAO organizerDao = new OrganizerDAOMemory();


    private Button createRaceButton;
    private Button approveSponsorshipButton;
    private TextView firstName;
    private TextView lastName;
    private TextView email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer_starting);

        organizerId = getIntent().getStringExtra(ORGANIZER_ID);

        /*UI fields*/
        firstName = findViewById(R.id.organizer_first_name);
        lastName = findViewById(R.id.organizer_last_name);
        email = findViewById(R.id.organizer_email);

        createRaceButton = findViewById(R.id.organizer_create_race_button);
        approveSponsorshipButton = findViewById(R.id.organizer_approve_sponsorship_button);

        createRaceButton.setOnClickListener(v->createRace());
        approveSponsorshipButton.setOnClickListener(v->approveSponsorships());

        setDetails(organizerId);

    }

    private void createRace(){

        Intent intent = new Intent(this, CreateRaceActivity.class);
        intent.putExtra(CreateRaceActivity.ORGANIZER_ID,organizerId);
        startActivity(intent);
    }

    private void approveSponsorships(){

        Intent intent = new Intent(this, ApproveSponsorshipActivity.class);
        intent.putExtra(ApproveSponsorshipActivity.ORGANIZER_ID,organizerId);
        startActivity(intent);
    }

    private void setDetails(String organizerId){

        Organizer organizer = organizerDao.findById(organizerId);
        firstName.setText(organizer.getFirstName());
        lastName.setText(organizer.getLastName());
        email.setText(organizer.getEmail().toString());
    }
}