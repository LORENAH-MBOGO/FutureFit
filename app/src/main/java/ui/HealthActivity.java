package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.skylar.futurefit.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HealthActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.newAilmentInput)
    EditText mNewAilmentInput;
    @BindView(R.id.addAilmentButton)
    Button mAddAilmentButton;

    private  ListView mAilmentsListView;

    private final String[] ailments = new String[] {"Suspicious mole on arm", "Cannot fall asleep easily", "Cold that won't go away"};
    private final ArrayList<String> allUserAilments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        ButterKnife.bind(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ailments);
        mAilmentsListView = findViewById(R.id.ailmentsListView);
        mAilmentsListView.setAdapter(adapter);
    }
        @Override
        public void onClick(View v) {
            if(v == mAddAilmentButton) {
                String ailment = mNewAilmentInput.getText().toString();
                allUserAilments.add(ailment);
                mNewAilmentInput.setText("");
            }
        }
    }