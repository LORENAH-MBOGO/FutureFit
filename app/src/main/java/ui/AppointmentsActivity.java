package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.skylar.futurefit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppointmentsActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.appointmentsListView)
    ListView mAppointmentsListView;
    @BindView(R.id.newAppointmentButton)
    Button mNewAppointmentButton;
    @BindView(R.id.findDoctorButton)
    Button mFindDoctorButton;

    private String[] appointments = new String[] {"Doctor A - Jan 1st 2021", "Doctor B - Dec 5th 2020", "Doctor C - Nov 22nd 2020", "Doctor D - March 1st 2020"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
        ButterKnife.bind(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, appointments);
        mAppointmentsListView.setAdapter(adapter);
        mNewAppointmentButton.setOnClickListener(this);
        mFindDoctorButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == mNewAppointmentButton) {
            Intent intent = new Intent(AppointmentsActivity.this, AppointmentFormActivity.class);
            startActivity(intent);
        } else if (v == mFindDoctorButton) {
            Intent intent = new Intent(AppointmentsActivity.this, FindDoctorActivity.class);
            startActivity(intent);
        }
    }
}