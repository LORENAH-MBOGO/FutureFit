package com.skylar.futurefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppointmentsActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.appointmentsListView)
    ListView mAppointmentsListView;
    @BindView(R.id.newAppointmentButton)
    Button mNewAppointmentButton;

    private String[] appointments = new String[] {"Doctor A - Jan 1st 2017", "Doctor B - Feb 5th 2017", "Doctor C - Feb 19th 2017", "Doctor D - March 1st 2017"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
        ButterKnife.bind(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, appointments);
        mAppointmentsListView.setAdapter(adapter);
        mNewAppointmentButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(AppointmentsActivity.this, AppointmentFormActivity.class);
        startActivity(intent);
    }
}