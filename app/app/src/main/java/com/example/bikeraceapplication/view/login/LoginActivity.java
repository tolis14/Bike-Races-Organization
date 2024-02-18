package com.example.bikeraceapplication.view.login;

import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.dao.Initializer;
import com.example.bikeraceapplication.memorydao.MemoryInitializer;

import com.example.bikeraceapplication.model.Role;

import com.example.bikeraceapplication.model.User;
import com.example.bikeraceapplication.service.CheckRaceService;
import com.example.bikeraceapplication.view.Referee.race.RefereeRaceActivity;
import com.example.bikeraceapplication.view.SignUp.SignUpActivity;
import com.example.bikeraceapplication.view.Sponsor.SponsorActivity;

import com.example.bikeraceapplication.view.startingScreens.CompetitorStartingActivity;
import com.example.bikeraceapplication.view.startingScreens.OrganizerStartingActivity;
import com.google.android.material.button.MaterialButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This class is responsible for the GUI of Login screen
 */
public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginViewModel viewModel;
    private EditText edtEmail ;
    private EditText edtPassword ;
    private MaterialButton login_button;
    private TextView signUp;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(savedInstanceState == null) {
            Initializer initializer = new MemoryInitializer();
            initializer.prepareData();
            scheduleJob();
        }

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        LoginPresenter presenter = viewModel.getPresenter();
        presenter.setView(this);


        login_button = (MaterialButton) findViewById(R.id.login_button);
        edtPassword=findViewById(R.id.password);
        edtEmail=findViewById(R.id.email);
        signUp = findViewById(R.id.SignUp);
        error = findViewById(R.id.error);

        login_button.setOnClickListener(v -> login());


        SpannableString ss = new SpannableString("Sign Up");
        ClickableSpan clickableSpan1 = new ClickableSpan() {

            @Override
            public void onClick(View widget) {
                openActivitySignUp();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };
        ss.setSpan(clickableSpan1, 0, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signUp.setText(ss);
        signUp.setMovementMethod(LinkMovementMethod.getInstance());


    }

    /**
     * checks the role of the user who wants to connect and
     * sends the user to the correct activity according to
     * the role
     */

    private void login(){

        String username=edtEmail.getText().toString();
        String password=edtPassword.getText().toString();
        User user= viewModel.getPresenter().login(username,password);
        if (user!=null){
            if (user.getRole().equals(Role.COMPETITOR))
                openActivityComp(user.getId());
            else if (user.getRole().equals(Role.ORGANIZER))
                openActivityOrg(user.getId());
            else if (user.getRole().equals(Role.SPONSOR))
                openActivitySpons(user.getId());
            else if (user.getRole().equals(Role.REFEREE))
                openActivityRef(user.getId());
        }
    }

    /**
     * starts SignUp activity
     */
    public void openActivitySignUp() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    /**
     * starts Competitor activity giving Extra arg COMPETITOR_ID to the (new) activity
     * @param id id of the user that wants to login (is needed to keep track of the users profile)
     */
    public void openActivityComp(String id){
        Intent intent=new Intent(this, CompetitorStartingActivity.class);
        intent.putExtra(CompetitorStartingActivity.COMPETITOR_ID,id);
        startActivity(intent);
    }

    /**
     * starts Organizer activity giving Extra arg ORGANIZER_ID to the (new) activity
     * @param id id of the user that wants to login (is needed to keep track of the users profile)
     */
    public void openActivityOrg(String id){
        Intent intent=new Intent(this, OrganizerStartingActivity.class);
        intent.putExtra(OrganizerStartingActivity.ORGANIZER_ID,id);
        startActivity(intent);
    }


    /**
     * starts Sponsor activity giving Extra arg SPONSOR_ID to the (new) activity
     * @param id id of the user that wants to login (is needed to keep track of the users profile)
     */
    public void openActivitySpons(String id){
        Intent intent=new Intent(this, SponsorActivity.class);
        intent.putExtra("sponId",id);
        startActivity(intent);
    }

    /**
     * starts Referee activity giving Extra arg REFEREE_ID to the (new) activity
     * @param id id of the user that wants to login (is needed to keep track of the users profile)
     */
    public void openActivityRef(String id){
        Intent intent=new Intent(this, RefereeRaceActivity.class);
        intent.putExtra("refId",id);
        startActivity(intent);

    }

    /**
     * Displays errorMsg on the GUI colored red
     *
     * @param errorMsg error message that is displayed
     */
    @Override
    public void showError(String errorMsg) {
        error.setText(errorMsg);
        error.setTextColor(Color.RED);
    }

    /*service to check if races should be conducted*/
    public void scheduleJob(){

        long secondsOfADay = 86400;

        ComponentName componentName = new ComponentName(this, CheckRaceService.class);
        JobInfo info = new JobInfo.Builder(123,componentName)
                .setPersisted(true)
                .setPeriodic(secondsOfADay * 1000)
                .build();

        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.schedule(info);
    }
}