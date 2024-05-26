package com.example.gst_mock_englist_for_kids.app_client.other;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.TogetherActivity;
import com.example.gst_mock_englist_for_kids.app_client.ebook.view.EBookActivity;
import com.example.gst_mock_englist_for_kids.app_client.game.view.GameTogetherActivity;
import com.example.gst_mock_englist_for_kids.app_client.time.view.TimeActivity;
import com.example.gst_mock_englist_for_kids.app_client.video.view.LearnByVideoActivity;

public class OtherActivity extends AppCompatActivity {
    Button btnGame, btnEBook, btnTime, btnVideo, btnTogether;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        initView();

    }

    private void initView() {

        btnGame = findViewById(R.id.btnListenAndGuess);
        btnEBook = findViewById(R.id.btnStart);
        btnTime = findViewById(R.id.btnViewAndChoose);
        btnVideo = findViewById(R.id.btnMiniGame);
        btnTogether = findViewById(R.id.btnWatchVideo);

        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtherActivity.this, GameTogetherActivity.class));
            }
        });

        btnEBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherActivity.this, EBookActivity.class);
               startActivity(intent);
            }
        });


        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtherActivity.this, TimeActivity.class));
            }
        });
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtherActivity.this, LearnByVideoActivity.class));
            }
        });

        btnTogether.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtherActivity.this, TogetherActivity.class));
            }
        });
    }
}