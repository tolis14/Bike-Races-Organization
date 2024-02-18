package com.example.bikeraceapplication.view.Competitor.ViewRaces.Ongoing;

import android.os.Bundle;

import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.view.Competitor.ViewRaces.ViewRacesPresenter;
import com.example.bikeraceapplication.view.Competitor.ViewRaces.ViewRacesView;
import com.example.bikeraceapplication.view.Competitor.ViewRaces.ViewRacesViewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;
import com.example.bikeraceapplication.R;

import java.util.ArrayList;

public class OngoingActivity extends AppCompatActivity implements ViewRacesView {

    private ViewRacesViewModel viewModel;
    private TextView errorMessageOngoing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing);

        Bundle extras = getIntent().getExtras();
        String value = "";
        if (extras != null) {
            value = extras.getString("competitor_id");
        }

        ListView listView = findViewById(R.id.ongoing);


        errorMessageOngoing = findViewById(R.id.errorMessageOngoing);

        viewModel = new ViewModelProvider(this).get(ViewRacesViewModel.class);
        ViewRacesPresenter presenter = viewModel.getPresenter();
        presenter.setView(this);

        ArrayList<Race> races = presenter.getOngoing(value);

        if(races != null){
            ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, races);
            listView.setAdapter(arrayAdapter);
        }

    }

    @Override
    public void showError(String errorMsg) {
        errorMessageOngoing.setText(errorMsg);
    }
}