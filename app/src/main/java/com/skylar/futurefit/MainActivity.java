package com.skylar.futurefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.appointmentsButton)
    Button mAppointmentsButton;
    @BindView(R.id.loginButton)
    Button mLoginButton;
    @BindView(R.id.healthButton)
    Button mHealthButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mAppointmentsButton.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
        mHealthButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == mAppointmentsButton) {
            Intent intent = new Intent(MainActivity.this, AppointmentsActivity.class);
            startActivity(intent);
        } else if(v == mHealthButton) {
            Intent intent = new Intent(MainActivity.this, HealthActivity.class);
            startActivity(intent);
        } else if(v == mLoginButton) {
            Intent intent = new Intent(MainActivity.this, LogInActivity.class);
            startActivity(intent);
        }
    }
}
