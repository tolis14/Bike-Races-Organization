package com.example.bikeraceapplication.view.approveSponsorship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bikeraceapplication.R;




public class PopUpWindow extends AppCompatActivity {

    public static final String APPLICATION_DATE = "application_date";
    public static final String APPLICATION_AMOUNT = "application_amount";
    public static final String SPONSOR_FIRST_NAME = "sponsor_first_name";
    public static final String SPONSOR_LAST_NAME = "sponsor_last_name";
    public static final String SPONSOR_COMPANY = "sponsor_company";


    private TextView sponsorshipDetails;
    private TextView applicationDate;
    private TextView applicationAmount;
    private TextView sponsorDetails;
    private TextView sponsorFirstName;
    private TextView sponsorLastName;
    private TextView sponsorCompany;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window);


        /*finding ui components*/
        sponsorshipDetails = findViewById(R.id.sponsorship_details);
        applicationDate = findViewById(R.id.sponsorship_date);
        applicationAmount = findViewById(R.id.sponsorship_amount);
        sponsorshipDetails = findViewById(R.id.sponsor_details);
        sponsorFirstName = findViewById(R.id.sponsor_first_name);
        sponsorLastName = findViewById(R.id.sponsor_last_name);
        sponsorCompany = findViewById(R.id.sponsor_company);


        /*getting the extra fields from intent*/
        Intent intent = getIntent();
        applicationDate.setText("Date: "+intent.getStringExtra(APPLICATION_DATE));
        applicationAmount.setText("Amount: "+ intent.getStringExtra(APPLICATION_AMOUNT));
        sponsorFirstName.setText("First Name: "+intent.getStringExtra(SPONSOR_FIRST_NAME));
        sponsorLastName.setText("Last Name: "+intent.getStringExtra(SPONSOR_LAST_NAME));
        sponsorCompany.setText("Company: "+intent.getStringExtra(SPONSOR_COMPANY));

    }
}