package com.example.gst_mock_englist_for_kids.app_client.splash;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_database.data.DataForDatabase;
import com.example.gst_mock_englist_for_kids.app_client.home.view.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        insertDataToDatabase();
        changeFragment(new HomeFragment());
    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frContent, fragment);
        transaction.commit();
    }

    private void insertDataToDatabase() {
        DataForDatabase mDataForDatabase = new DataForDatabase(this);
        mDataForDatabase.addDataTopicTable();
        mDataForDatabase.addDataTopicDetailsTable();
        mDataForDatabase.addDataListenAnswerTable();
        mDataForDatabase.addDataImageAnswerTable();
    }

}
