package com.example.gst_mock_englist_for_kids.app_client.classone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.classfive.ExampleClassFiveActivity;
import com.example.gst_mock_englist_for_kids.app_client.listen_and_guess.view.ListenAndGuessActivity;
import com.example.gst_mock_englist_for_kids.app_client.look_and_choose.view.LookAndChooseActivity;
import com.example.gst_mock_englist_for_kids.app_client.topic.view.TopicActivity;
import com.example.gst_mock_englist_for_kids.app_client.vocabulary.view.GuessThePictureActivity;

public class ClassOneActivity extends AppCompatActivity {

    private CardView cvSGK, cvExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_one);
        cvSGK = findViewById(R.id.cvSGK);
        cvExample = findViewById(R.id.cvExample);
        Intent intent = getIntent();
        String value = intent.getStringExtra("class1");
        String value2 = intent.getStringExtra("class2");
        String value3 = intent.getStringExtra("class3");
        String value4 = intent.getStringExtra("class4");
        String value5 = intent.getStringExtra("class5");

        if (value != null && value.equalsIgnoreCase("Class 1")) {
            actionClick("SGK1", "https://drive.google.com/file/d/13BFVyYi1NYRUfOwDMWQQ-Nsj_esBKwRG/view");
            keyScreen(TopicActivity.class);
        }

        if (value2 != null && value2.equalsIgnoreCase("Class 2")) {
            actionClick("SGK2", "https://drive.google.com/file/d/1ABzUgjJZnwVsO7qZfurnLVR6ZbiCU828/view");
            keyScreen(LookAndChooseActivity.class);
        }
        if (value3 != null && value3.equalsIgnoreCase("Class 3")) {
            actionClick("SGK3", "https://drive.google.com/file/d/1aKUZPLCrltwy3AOstnQFkYqudJRD7LSY/view");
            keyScreen(ListenAndGuessActivity.class);
        }
        if (value4 != null && value4.equalsIgnoreCase("Class 4")) {
            actionClick("SGK4", "https://drive.google.com/file/d/1d1sVJxxBiSl0mqHsPBSdyxzHbhUEUNKQ/view");
            keyScreen(GuessThePictureActivity.class);
        }
        if (value5 != null && value5.equalsIgnoreCase("Class 5")) {
            actionClick("SGK5", "https://drive.google.com/file/d/1K_3vFxQCeB3E-KKiZ7DV7YcHlS3_EWkj/view?usp=sharing");
            keyScreen(ExampleClassFiveActivity.class);
        }


    }

    private void actionClick(final String key, final String value) {
        cvSGK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClassOneActivity.this, SGKActivity.class);
                intent.putExtra(key, value);
                startActivity(intent);
            }
        });
    }

    private void keyScreen(final Class<?> T) {
        cvExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClassOneActivity.this, T);
                startActivity(intent);
            }
        });
    }
}