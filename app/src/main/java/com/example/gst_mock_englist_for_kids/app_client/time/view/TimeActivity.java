package com.example.gst_mock_englist_for_kids.app_client.time.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.gst_mock_englist_for_kids.R;

public class TimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        changeFragment(new TimerFragment());
    }

    private void changeFragment(Fragment fragment) {
        if (getFragmentManager() != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frContent, fragment);
            transaction.commit();
        }
    }
}