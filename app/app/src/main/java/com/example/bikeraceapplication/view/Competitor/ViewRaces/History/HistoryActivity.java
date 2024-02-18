package com.example.bikeraceapplication.view.Competitor.ViewRaces.History;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.view.Competitor.ViewRaces.ViewRacesPresenter;
import com.example.bikeraceapplication.view.Competitor.ViewRaces.ViewRacesView;
import com.example.bikeraceapplication.view.Competitor.ViewRaces.ViewRacesViewModel;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity implements ViewRacesView {

    private ViewRacesViewModel viewModel;
    private TextView errorMessageHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Bundle extras = getIntent().getExtras();
        String value = "";
        if (extras != null) {
            value = extras.getString("competitor_id");
        }

        ListView listView = findViewById(R.id.history);


        errorMessageHistory = findViewById(R.id.errorMessageHistory);

        viewModel = new ViewModelProvider(this).get(ViewRacesViewModel.class);
        ViewRacesPresenter presenter = viewModel.getPresenter();
        presenter.setView(this);


        ArrayList<String> racesStr= presenter.getHistory(value);

        if(racesStr != null){
            ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, racesStr);
            listView.setAdapter(arrayAdapter);
        }
    }

    @Override
    public void showError(String errorMsg) {
        errorMessageHistory.setText(errorMsg);
    }
}