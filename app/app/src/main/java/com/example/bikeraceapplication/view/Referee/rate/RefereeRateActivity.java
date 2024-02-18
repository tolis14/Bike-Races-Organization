package com.example.bikeraceapplication.view.Referee.rate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.model.Competitor;
import com.example.bikeraceapplication.model.Participation;
import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.view.Referee.race.RefereeRaceActivity;
import com.example.bikeraceapplication.view.Referee.race.RefereeRaceViewModel;
import com.google.android.material.button.MaterialButton;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RefereeRateActivity extends AppCompatActivity implements RefereeRateView {

    private RefereeRateViewModel viewModel;
    private TextView id;
    private TextView place;
    private Button setButton;
    private String raceId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referee_rate);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            raceId = extras.getString("race");
        }


        viewModel = new ViewModelProvider(this).get(RefereeRateViewModel.class);
        RefereeRatePresenter presenter = viewModel.getPresenter();
        presenter.setView(this);

        setButton = findViewById(R.id.setPlace);
        id=findViewById(R.id.partId);
        place=findViewById(R.id.place);

        ListView listView = findViewById(R.id.racePart);



        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,presenter.getParticipants(raceId));
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            this.id.setText(parent.getAdapter().getItem(position).toString().split(" ")[1]);

        });

        setButton.setOnClickListener(v -> {

            try{
                int placeInt = Integer.parseInt(place.getText().toString().trim());
                int idInt = Integer.parseInt(id.getText().toString().trim());
                presenter.setPlace(raceId, placeInt, idInt);
                Toast.makeText(this, "Successfully set place", Toast.LENGTH_LONG).show();
                id.setText("");
                place.setText("");
            }catch(Exception e){
                Toast.makeText(this, "Both fields require a number each", Toast.LENGTH_LONG).show();
                id.setText("");
                place.setText("");
            }

        });

    }
}

