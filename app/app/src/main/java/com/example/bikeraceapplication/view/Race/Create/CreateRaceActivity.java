package com.example.bikeraceapplication.view.Race.Create;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bikeraceapplication.R;

public class CreateRaceActivity extends AppCompatActivity implements CreateRaceView{

    public static final String ORGANIZER_ID = "organizer_id";

    private String organizerId;

    /*fields of from to be used by the user*/
    private EditText edtCreateRaceName;
    private EditText edtCreateRacePlace;
    private EditText edtCreateRaceDate;
    private EditText edtCreateRaceType;
    private EditText edtCreateRaceDistance;
    private EditText edtDeadLine;
    private EditText edtRaceCreateAmt;
    private EditText edtRaceCreateMinGatheredAmt;
    private TextView status;
    private TextView error;

    /*button to submit race creation*/
    private Button submitButton;

    private CreateRaceViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_race);

        organizerId = getIntent().getStringExtra(ORGANIZER_ID);

        /*initializing view model and create the presenter*/
        viewModel = viewModel = new ViewModelProvider(this).get(CreateRaceViewModel.class);
        CreateRacePresenter presenter = viewModel.getPresenter();
        presenter.setView(this);

        /*get form's fields*/
        edtCreateRaceName = findViewById(R.id.edtCreateRaceName);
        edtCreateRacePlace = findViewById(R.id.edtCreateRacePlace);
        edtCreateRaceDate = findViewById(R.id.edtCreateRaceDate);
        edtCreateRaceType = findViewById(R.id.edtCreateRaceType);
        edtCreateRaceDistance = findViewById(R.id.edtCreateRaceDistance);
        edtDeadLine = findViewById(R.id.edtDeadLine);
        edtRaceCreateAmt = findViewById(R.id.edtRaceCreateAmt);
        edtRaceCreateMinGatheredAmt = findViewById(R.id.edtRaceCreateMinGatheredAmt);
        status = findViewById(R.id.createRaceStatus);
        error = findViewById(R.id.createRaceError);

        /*get submit button*/
        submitButton = findViewById(R.id.createRaceButton);

        /*handle on click events*/
        submitButton.setOnClickListener(v->createRace());

    }

    private void createRace(){
        clearMessages();
        String raceName = edtCreateRaceName.getText().toString();
        String racePlace = edtCreateRacePlace.getText().toString();
        String raceDate = edtCreateRaceDate.getText().toString();
        String raceType = edtCreateRaceType.getText().toString();
        String raceDistance = edtCreateRaceDistance.getText().toString();
        String raceDeadLine = edtDeadLine.getText().toString();
        String raceAmt = edtRaceCreateAmt.getText().toString();
        String raceMinAmt = edtRaceCreateMinGatheredAmt.getText().toString();
        viewModel.getPresenter().createRace(organizerId,raceName, racePlace, raceDate, raceType, raceDistance, raceDeadLine,raceAmt,raceMinAmt);
    }

    @Override
    public void showError(String errorMsg) {
        error.setText(errorMsg);
        error.setTextColor(Color.RED);
    }

    @Override
    public void showStatus(String statusMsg) {
        status.setText(statusMsg);
        status.setTextColor(Color.GREEN);
    }

    private void clearMessages(){
        error.setText("");
        status.setText("");
    }
}