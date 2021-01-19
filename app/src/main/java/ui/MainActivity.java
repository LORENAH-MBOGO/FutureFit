package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.skylar.futurefit.R;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
  private   Button mAppointmentsButton, mLoginButton, mAboutButton, mHealthButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

         mAppointmentsButton = findViewById(R.id.appointmentsButton);
         mLoginButton = findViewById(R.id.loginButton);
         mHealthButton = findViewById(R.id.healthButton);
         mAboutButton = findViewById(R.id.aboutButton);

        mAppointmentsButton.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
        mHealthButton.setOnClickListener(this);
        mAboutButton.setOnClickListener(this);
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
        } else if(v == mAboutButton) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
    }
}
