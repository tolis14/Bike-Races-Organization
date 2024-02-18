package com.example.bikeraceapplication.view.Race.Search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.model.Race;

import java.util.ArrayList;
import java.util.List;

public class RaceSearchActivity extends AppCompatActivity implements RaceSearchView,
       RaceRecyclerViewAdapter.ItemSelectionListener{

    public static final String RACE_NAME_EXTRA = "race_name";
    public static final String RACE_PLACE_EXTRA = "race_place";
    public static final String RACE_DATE_EXTRA = "race_date";
    public static final String RACE_TYPE_EXTRA = "race_type";
    public static final String RACE_DISTANCE_EXTRA = "race_distance";
    public static final String RACE_ID_RESULT = "race_id_result";
    public static final String ROLE = "role";
    public static final int NO_SEARCH_RESULTS = 10;

    protected static String roleCalledSearch = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_search);

        /*initialize presenter and set view*/
        RaceSearchViewModel viewModel = new ViewModelProvider(this).get(RaceSearchViewModel.class);
        viewModel.getPresenter().setView(this);


        /*get user's search criteria*/
         Intent intent = getIntent();
         String nameCriterion = intent.getStringExtra(RACE_NAME_EXTRA);
         String placeCriterion = intent.getStringExtra(RACE_PLACE_EXTRA);
         String dateCriterion = intent.getStringExtra(RACE_DATE_EXTRA);
         String typeCriterion = intent.getStringExtra(RACE_TYPE_EXTRA);
         String distanceCriterion = intent.getStringExtra(RACE_DISTANCE_EXTRA);
         roleCalledSearch = intent.getStringExtra(ROLE);

         /*search for available races given the above criteria*/
        viewModel.getPresenter().search(nameCriterion,placeCriterion,dateCriterion,typeCriterion,distanceCriterion);

        if(viewModel.getPresenter().getSearchResult().size() == 0)
            onZeroResults();

        /*code here for showing the results*/
        RecyclerView recyclerView = findViewById(R.id.raceRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Race> raceList = new ArrayList<>(viewModel.getPresenter().getSearchResult());
        recyclerView.setAdapter(new RaceRecyclerViewAdapter(raceList,this));
    }

    @Override
    //lister will call this method given the selection on the array adapter list.
    public void selectRace(Race race) {
        Intent intent = new Intent();
        intent.putExtra(RACE_ID_RESULT,race.getId());
        setResult(RESULT_OK,intent);
        finish();
    }

    private void onZeroResults(){
        Intent intent = new Intent();;
        setResult(NO_SEARCH_RESULTS,intent);
        finish();
    }
}