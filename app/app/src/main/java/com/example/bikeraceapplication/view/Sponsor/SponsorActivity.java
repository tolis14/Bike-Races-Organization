package com.example.bikeraceapplication.view.Sponsor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.model.Sponsor;
import com.example.bikeraceapplication.view.Race.Search.RaceSearchActivity;
import com.google.android.material.button.MaterialButton;

public class SponsorActivity extends AppCompatActivity implements SponsorView {

    /**
     * This is the class for the UI
     */
    private MaterialButton sponsor_button;
    private TextView sponsorship_money_view;
    private TextView statusMessage;
    private SponsorViewModel viewModel;
    private String returnValue;
    private String sponsorship_money;
    private TextView sponsorBalance;
    private String id;

    ActivityResultLauncher<Intent> searchForRace =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if(result.getResultCode() == Activity.RESULT_OK){
                                Intent intent = result.getData();
                                returnValue = intent.getStringExtra(RaceSearchActivity.RACE_ID_RESULT);

                                Boolean answer = viewModel.getPresenter().validatemoney(returnValue, Float.parseFloat(sponsorship_money));
                                if (answer) {
                                    ShowMessage("SPONSORSHIP ADDED");
                                    Sponsor sponsor = viewModel.getPresenter().getSponsor();
                                    double amount = sponsor.getCard().getBalance().getAmount();
                                    setColor(Color.GREEN);
                                    sponsorBalance.setText("Balance: "+String.valueOf(amount));
                                } else {
                                    setColor(Color.RED);
                                    ShowMessage("NOT ENOUGH MONEY OR RACE ALREADY IS SPONSORED");

                                }
                            }
                            else if(result.getResultCode() == RaceSearchActivity.NO_SEARCH_RESULTS){
                                ShowMessage("races not found");
                            }
                        }
                    }
            );

    @Override
    public void ShowMessage(String text) {
        /**
         * Method that shows the string in the screen passed as a parameter
         * @param text text (String) of the object that called this method
         */
        statusMessage.setText(text);
    }

    @Override
    public void setColor(int color) {
        statusMessage.setTextColor(color);
    }


    public void go_to_search() {

        /**
         * Method that calls the openRaceSearch() method to search for a race to sponsor
         */
        sponsorship_money = sponsorship_money_view.getText().toString();
        Boolean result = viewModel.getPresenter().validateSponsor(sponsorship_money);
        if(result) {
            openRaceSearch();
        }
    }

    public void openRaceSearch() {

        /**
         * Opens the RaceSearchActivity and passes the "Sponsor" parameter
         */
        Intent intent = new Intent(this, RaceSearchActivity.class);
        intent.putExtra(RaceSearchActivity.ROLE,"Sponsor");
        searchForRace.launch(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);

        viewModel = new ViewModelProvider(this).get(SponsorViewModel.class);
        SponsorPresenter presenter = viewModel.getPresenter();
        presenter.setView(this);

        sponsor_button = (MaterialButton) findViewById(R.id.sponsor_button);

        sponsorship_money_view = (TextView) findViewById(R.id.sponsor_money);

        statusMessage = (TextView) findViewById(R.id.error_sponsor);

        sponsorBalance = (TextView) findViewById(R.id.sponsor_card_amount);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getString("sponId");
            viewModel.getPresenter().createsponsor(id);
        }

        Sponsor sponsor = viewModel.getPresenter().getSponsor();
        double amount = sponsor.getCard().getBalance().getAmount();
        sponsorBalance.setText("Balance: "+String.valueOf(amount));
        sponsor_button.setOnClickListener(v -> go_to_search());
    }
}
