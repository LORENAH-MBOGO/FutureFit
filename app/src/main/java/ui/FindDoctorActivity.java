package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.skylar.futurefit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindDoctorActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.specialtySearchButton)
    Button mSpecialtySearchButton;
    @BindView(R.id.specialtyEditText)
    EditText mSpecialtyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        ButterKnife.bind(this);
        mSpecialtySearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSpecialtySearchButton) {
            String specialty = mSpecialtyEditText.getText().toString();
            Intent intent = new Intent(FindDoctorActivity.this, DoctorListActivity.class);
            intent.putExtra("specialty", specialty);
            startActivity(intent);
        }
    }
}