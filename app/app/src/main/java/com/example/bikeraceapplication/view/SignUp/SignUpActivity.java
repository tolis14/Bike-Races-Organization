package com.example.bikeraceapplication.view.SignUp;

import com.example.bikeraceapplication.R;
import com.example.bikeraceapplication.view.login.LoginActivity;
import com.google.android.material.button.MaterialButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity implements  SignUpView{

    private TextView first_name;
    private TextView last_name;
    private TextView email;
    private TextView password;
    private TextView confirm_password;
    private MaterialButton sign_up_button;
    private MaterialButton go_to_log_in_button;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    private SignUpViewModel viewModel;
    private TextView statusMessage;
    private TextView company_name;
    private TextView team_name;

    public void go_to_log_in() {
        openActivityLogin();
    }

    public void openActivityLogin() {
        finish();
    }

    @Override
    public void ShowMessage(String text) {

        statusMessage.setTextColor(Color.GREEN);
        statusMessage.setText(text);
    }

    @Override
    public void showError(String text){

        statusMessage.setTextColor(Color.RED);
        statusMessage.setText(text);
    }

    public void go_to_sign_up() {

        String state = spinner.getSelectedItem().toString();
        Boolean result = viewModel.getPresenter().validateUser(first_name.getText().toString(), last_name.getText().toString(),
                email.getText().toString(), password.getText().toString(), confirm_password.getText().toString(),state,
                company_name.getText().toString(),team_name.getText().toString());
        if(result) {
            openActivityLogin();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        viewModel = new ViewModelProvider(this).get(SignUpViewModel.class);
        SignUpPresenter presenter = viewModel.getPresenter();
        presenter.setView(this);

        first_name = (TextView) findViewById(R.id.first_name);
        last_name = (TextView) findViewById(R.id.last_name);
        email = (TextView) findViewById(R.id.email);
        password = (TextView) findViewById(R.id.password);
        confirm_password = (TextView) findViewById(R.id.confirm_password);
        sign_up_button = (MaterialButton) findViewById(R.id.sign_up_button);
        go_to_log_in_button = (MaterialButton) findViewById(R.id.button_to_go_to_log_in);
        statusMessage = (TextView) findViewById(R.id.sign_up_status_message);
        company_name = (TextView) findViewById(R.id.company_name_sign_up);
        team_name = (TextView) findViewById(R.id.team_name_sign_up);

        spinner =findViewById(R.id.spinner);

        adapter=ArrayAdapter.createFromResource(this, R.array.Roles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        sign_up_button.setOnClickListener(v -> go_to_sign_up());

        go_to_log_in_button.setOnClickListener(v -> go_to_log_in());

    }

}
