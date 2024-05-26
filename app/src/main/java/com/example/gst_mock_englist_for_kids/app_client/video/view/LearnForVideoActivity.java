package com.example.gst_mock_englist_for_kids.app_client.video.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.common.Constants;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

@SuppressLint("Registered")
public class LearnForVideoActivity extends YouTubeBaseActivity {

    private YouTubePlayerView mYouTubePlayerView;

    private String mID = "";

    private final int REQUEST_VIDEO = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_learn_for_video);

        mYouTubePlayerView = findViewById(R.id.myYoutube);

        Intent intent = getIntent();
        mID = intent.getStringExtra(Constants.DATA_FOR_VIDEO);
        mYouTubePlayerView.initialize(Constants.API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(mID);
                youTubePlayer.setFullscreen(true);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                if (youTubeInitializationResult.isUserRecoverableError()) {
                    youTubeInitializationResult.getErrorDialog(LearnForVideoActivity.this, REQUEST_VIDEO);
                } else {
                    Toast.makeText(LearnForVideoActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_VIDEO) {
            mYouTubePlayerView.initialize(Constants.API_KEY, (YouTubePlayer.OnInitializedListener) LearnForVideoActivity.this);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
