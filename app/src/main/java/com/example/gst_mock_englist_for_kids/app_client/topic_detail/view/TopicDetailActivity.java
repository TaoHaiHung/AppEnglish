package com.example.gst_mock_englist_for_kids.app_client.topic_detail.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.common.Constants;
import com.example.gst_mock_englist_for_kids.app_client.topic_detail.model.TopicDetails;
import com.example.gst_mock_englist_for_kids.app_database.create_database.Database;
import com.example.gst_mock_englist_for_kids.app_database.executors.MyExecutors;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class TopicDetailActivity extends AppCompatActivity {
    private TopicDetailsAdapter mTopicDetailsAdapter;

    private RecyclerView mRcvTopicDetails;

    private Database mDatabase;

    private TextToSpeech mTextToSpeech;

    private int idTopic = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);
        initViews();
    }

    private void initViews() {
        mDatabase = Database.getInstance(getApplicationContext());

        mRcvTopicDetails = findViewById(R.id.rcvTopicDetails);

        mTextToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                mTextToSpeech.setLanguage(Locale.US);
            }
        });

        Intent bundle = getIntent();
        if (bundle != null) {
            idTopic = bundle.getIntExtra(Constants.KEY_ID_TOPIC, 0);
        }
        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<TopicDetails> list = mDatabase.iTopicDao().getListTopicDetails(idTopic);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                  runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (list != null) {
                                mTopicDetailsAdapter = new TopicDetailsAdapter(Objects.requireNonNull(getApplicationContext()), list);
                                mRcvTopicDetails.setAdapter(mTopicDetailsAdapter);
                                mRcvTopicDetails.setHasFixedSize(true);
                                mTopicDetailsAdapter.onItemClickListener(new TopicDetailsAdapter.ClickItemTopicDetails() {
                                    @Override
                                    public void onClickItem(final View view, int position) {
                                        final ValueAnimator value = ValueAnimator.ofFloat(1.3f, 1f);
                                        value.setDuration(600);
                                        value.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                            @Override
                                            public void onAnimationUpdate(ValueAnimator animation) {
                                                float progress = (float) value.getAnimatedValue();
                                                view.setScaleX(progress);
                                                view.setScaleY(progress);
                                            }
                                        });
                                        value.start();
                                        String tts = list.get(position).getName();
                                        mTextToSpeech.speak(tts, TextToSpeech.QUEUE_FLUSH, null);
                                    }
                                });
                            } else {
                                throw new NullPointerException();
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTextToSpeech != null) {
            mTextToSpeech.shutdown();
            mTextToSpeech.stop();
        }
    }
}