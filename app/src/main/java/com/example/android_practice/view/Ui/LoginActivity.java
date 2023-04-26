package com.example.android_practice.view.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android_practice.R;
import com.example.android_practice.viewModel.LoginViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    LoginViewModel loginViewModel;
    ProgressBar progressBar;
    TextInputEditText email;
    TextInputEditText pass;
    TextView result;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar=findViewById(R.id.progressBar);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        submit=findViewById(R.id.sButton);
        result=findViewById(R.id.t);
        init();
        submit.setOnClickListener(this::onClick);
    }
    public void init(){
        loginViewModel= new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.getProgress().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                progressBar.setVisibility(integer);
            }
        });
        loginViewModel.getLogin().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                result.setText(s);
            }
        });


    }

    private void onClick(View view) {
        loginViewModel.login(email.getText().toString(),pass.getText().toString());

    }
}