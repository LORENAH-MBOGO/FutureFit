package com.skylar.futurefit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HealthActivity extends AppCompatActivity {
    @BindView(R.id.ailmentsListView)
    ListView mAilmentsListView;

    private String[] ailments = new String[] {"Suspicious mole on arm", "Cannot fall asleep easily", "Cold that won't go away"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        ButterKnife.bind(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ailments);
        mAilmentsListView.setAdapter(adapter);
    }
}