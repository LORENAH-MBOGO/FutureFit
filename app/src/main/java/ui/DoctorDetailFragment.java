package ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.skylar.futurefit.R;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import models.Doctor;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DoctorDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DoctorDetailFragment extends Fragment implements View.OnClickListener {

        @BindView(R.id.doctorImageView)
        ImageView mImageLabel;
        @BindView(R.id.doctorNameTextView)
        TextView mNameLabel;
        @BindView(R.id.specialtyTextView)
        TextView mSpecialtyLabel;
        @BindView(R.id.websiteTextView)
        TextView mWebsiteLabel;
        @BindView(R.id.phoneTextView)
        TextView mPhoneLabel;
        @BindView(R.id.addressTextView)
        TextView mAddressLabel;
        @BindView(R.id.bioTextView)
        TextView mBioLabel;
        @BindView(R.id.saveDoctorButton)
        Button mSaveDoctorButton;

        private Doctor mDoctor;

        public static DoctorDetailFragment newInstance(Doctor doctor) {
            DoctorDetailFragment doctorDetailFragment = new DoctorDetailFragment();
            Bundle args = new Bundle();
            args.putParcelable("doctor", Parcels.wrap(doctor));
            doctorDetailFragment.setArguments(args);
            return doctorDetailFragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mDoctor = Parcels.unwrap(getArguments().getParcelable("doctor"));
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_doctor_detail, container, false);
            ButterKnife.bind(this, view);

            mNameLabel.setText(mDoctor.getName());
            mSpecialtyLabel.setText(mDoctor.getSpecialty());
            mPhoneLabel.setText(android.text.TextUtils.join(", ", mDoctor.getPhone()));
            mAddressLabel.setText(mDoctor.getAddress());
            mBioLabel.setText(mDoctor.getBio());

            mAddressLabel.setOnClickListener(this);

            return view;
        }
    @Override
    public void onClick(View v) {
        if(v == mAddressLabel) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + mDoctor.getLatitude() + "," + mDoctor.getLongitude() + "?q=(" + mDoctor.getName() + ")"));
            startActivity(mapIntent);
        }
    }

}