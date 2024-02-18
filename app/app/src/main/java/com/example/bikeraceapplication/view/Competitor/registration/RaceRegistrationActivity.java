package com.example.bikeraceapplication.view.Competitor.registration;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.view.Race.Search.RaceSearchActivity;
import com.example.bikeraceapplication.view.startingScreens.CompetitorStartingActivity;


public class RaceRegistrationActivity extends AppCompatActivity implements RaceRegistrationView{

    private RaceRegistrationViewModel viewModel;
    private Button searchButton;


    public static final String COMPETITOR_ID = "competitor_id";
    private String callerId="";

    /*fields to get the search criteria*/
    private EditText edtRaceName;
    private EditText edtRacePlace;
    private EditText edtRaceDate;
    private EditText edtRaceType;
    private EditText edtRaceDistance;

    /*status and error texts*/
    private TextView statusMessage;
    private TextView errorMessage;


    ActivityResultLauncher<Intent> searchForRace =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if(result.getResultCode() == Activity.RESULT_OK){
                                Intent intent = result.getData();
                                viewModel.getPresenter().registerToRace(intent.getStringExtra(RaceSearchActivity.RACE_ID_RESULT),callerId);
                            }
                            else if(result.getResultCode() == RaceSearchActivity.NO_SEARCH_RESULTS){
                                showError("races not found");
                            }
                        }
                    }
            );

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_registration);

        /*Set the view model and initialize the presenter*/
        viewModel = new ViewModelProvider(this).get(RaceRegistrationViewModel.class);
        RaceRegistrationPresenter presenter = viewModel.getPresenter();
        presenter.setView(this);

        callerId = getIntent().getStringExtra(COMPETITOR_ID); // find which competitor called us

        /*Access interface's object*/
        edtRaceName = findViewById(R.id.edtRaceName);
        edtRacePlace = findViewById(R.id.edtRacePlace);
        edtRaceDate = findViewById(R.id.edtRaceDate);
        edtRaceType = findViewById(R.id.edtRaceType);
        edtRaceDistance = findViewById(R.id.edtRaceDistance);
        searchButton = findViewById(R.id.search_button);
        statusMessage = findViewById(R.id.race_registration_status);
        errorMessage = findViewById(R.id.race_registration_error_message);

        /*handle on click requests*/
        searchButton.setOnClickListener(v->searchRace());
    }

    private void searchRace(){
        clearMessages();
        String raceName = edtRaceName.getText().toString();
        String racePlace = edtRacePlace.getText().toString();
        String raceDate = edtRaceDate.getText().toString();
        String raceType = edtRaceType.getText().toString();
        String raceDistance = edtRaceDistance.getText().toString();
        viewModel.getPresenter().search(raceName,racePlace,raceDate,raceType,raceDistance);
    }

    private void clearMessages(){
        statusMessage.setText("");
        errorMessage.setText("");
    }

    @Override
    public void showSearchDialog(String raceName, String racePlace, String raceDate, String raceType, String raceDistance) {
        Intent intent = new Intent(this, RaceSearchActivity.class);
        intent.putExtra(RaceSearchActivity.RACE_NAME_EXTRA,raceName);
        intent.putExtra(RaceSearchActivity.RACE_PLACE_EXTRA,racePlace);
        intent.putExtra(RaceSearchActivity.RACE_DATE_EXTRA,raceDate);
        intent.putExtra(RaceSearchActivity.RACE_TYPE_EXTRA,raceType);
        intent.putExtra(RaceSearchActivity.RACE_DISTANCE_EXTRA,raceDistance);
        intent.putExtra(RaceSearchActivity.RACE_TYPE_EXTRA,raceType);
        intent.putExtra(RaceSearchActivity.ROLE,"Competitor");
        searchForRace.launch(intent);
    }


    @Override
    public void showStatus(String statusMsg) {
        statusMessage.setText(statusMsg);
        statusMessage.setTextColor(Color.GREEN);
    }

    @Override
    public void showError(String errorMsg) {
        errorMessage.setText(errorMsg);
        errorMessage.setTextColor(Color.RED);
    }

}