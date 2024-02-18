package com.example.bikeraceapplication.view.Referee.race;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.model.Referee;
import com.example.bikeraceapplication.view.Referee.rate.RefereeRateActivity;


import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class RefereeRaceActivity extends AppCompatActivity implements RefereeRaceView {

    private RefereeRaceViewModel viewModel;
    private TextView errorMessageRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referee_race);
        Bundle extras = getIntent().getExtras();
        String value = "";
        if (extras != null) {
            value = extras.getString("refId");
        }

        ListView listView = findViewById(R.id.refereeRaces);


        errorMessageRef = findViewById(R.id.errorMessageRef);

        viewModel = new ViewModelProvider(this).get(RefereeRaceViewModel.class);
        RefereeRacePresenter presenter = viewModel.getPresenter();
        presenter.setView(this);

        ArrayList<Race> races=presenter.getRaces(value);
        ArrayList<String> racesStr=presenter.getRacesStr(races);
        if(!races.isEmpty()){
            ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,racesStr);
            listView.setAdapter(arrayAdapter);
        }




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openActRate(races.get(position));
            }
        });
    }

    /**
     * starts RefereeRate activity giving Extra arg race_ID to the (new) activity
     * @param race id of the race that the referee wants to rate
     */
    private void openActRate(Race race){
        Intent intent=new Intent(this, RefereeRateActivity.class);
        intent.putExtra("race", race.getId());
        startActivity(intent);
    }

    /**
     * Displays errorMsg on the GUI colored red
     *
     * @param errorMsg error message that is displayed
     */
    @Override
    public void showError(String errorMsg) {
        errorMessageRef.setText(errorMsg);
    }
}






