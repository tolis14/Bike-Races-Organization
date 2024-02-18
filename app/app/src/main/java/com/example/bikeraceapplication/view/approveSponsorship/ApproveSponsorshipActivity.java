package com.example.bikeraceapplication.view.approveSponsorship;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;
import com.example.bikeraceapplication.model.SponsorshipApplication;

import java.util.ArrayList;
import java.util.List;

public class ApproveSponsorshipActivity extends AppCompatActivity implements ApproveSponsorshipView,
        SponsorshipApplicationRecyclerViewAdapter.ItemSelectionListener{

    public static final String ORGANIZER_ID = "organizer_id";

    private String organizerId;

    private ApproveSponsorshipViewModel viewModel;
    private Button submitButton;

    private List<SponsorshipApplication> approved;
    private List<SponsorshipApplication> rejected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_sponsorship);

        organizerId = getIntent().getStringExtra(ORGANIZER_ID);


        /*initialize view and presenter*/
        viewModel = new ViewModelProvider(this).get(ApproveSponsorshipViewModel.class);
        ApproveSponsorshipPresenter presenter = viewModel.getPresenter();
        presenter.setView(this);

        /*initialize private fields*/
        approved = new ArrayList<>();
        rejected = new ArrayList<>();

        /*find ui fields*/
        submitButton = findViewById(R.id.applications_submit_button);
        submitButton.setOnClickListener(v->submit());

        RecyclerView recyclerView = findViewById(R.id.approveRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        /*fill our recycler adapter*/
        List<SponsorshipApplication> sponsorshipApplicationsList = presenter.findApplications(organizerId); //here presenter query the database for my applications
        recyclerView.setAdapter(new SponsorshipApplicationRecyclerViewAdapter(sponsorshipApplicationsList,this));

    }


    public void approveApplications(List<SponsorshipApplication> approved, List<SponsorshipApplication> rejected) {
        viewModel.getPresenter().handleApplications(approved,rejected);
    }

    @Override
    public void addApproved(SponsorshipApplication application){
        approved.add(application);
    }

    @Override
    public void addRejected(SponsorshipApplication application){
        rejected.add(application);
    }

    @Override
    public void showInfo(String date, String amount, String firstName, String lastName, String company){

        Intent intent = new Intent(ApproveSponsorshipActivity.this,PopUpWindow.class);

        intent.putExtra(PopUpWindow.APPLICATION_DATE,date);
        intent.putExtra(PopUpWindow.APPLICATION_AMOUNT,amount);
        intent.putExtra(PopUpWindow.SPONSOR_FIRST_NAME,firstName);
        intent.putExtra(PopUpWindow.SPONSOR_LAST_NAME,lastName);
        intent.putExtra(PopUpWindow.SPONSOR_COMPANY,company);

        startActivity(intent);

    }


    private void submit(){

        viewModel.getPresenter().handleApplications(approved,rejected);
        /*nothing more to submit --- button should stay inactive*/
        submitButton.setEnabled(false);
    }
}