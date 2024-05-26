package com.example.gst_mock_englist_for_kids.app_client.topic.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.common.Constants;
import com.example.gst_mock_englist_for_kids.app_client.topic.model.Topic;
import com.example.gst_mock_englist_for_kids.app_client.topic_detail.view.TopicDetailActivity;
import com.example.gst_mock_englist_for_kids.app_client.topic_detail.view.TopicDetailsFragment;
import com.example.gst_mock_englist_for_kids.app_database.create_database.Database;
import com.example.gst_mock_englist_for_kids.app_database.executors.MyExecutors;

import java.util.List;
import java.util.Objects;

public class TopicActivity extends AppCompatActivity {

    private RecyclerView mRcvTopic;

    private TopicAdapter mTopicAdapter;


    private Database mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        initViews();
    }

    private void initViews() {

        mDatabase = Database.getInstance(getApplicationContext());

        mRcvTopic = findViewById(R.id.rcvTopic);
        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<Topic> list = mDatabase.iTopicDao().getTopicList();
                if (list != null) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                       runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mTopicAdapter = new TopicAdapter(Objects.requireNonNull(getApplicationContext()), list);
                                mRcvTopic.setAdapter(mTopicAdapter);
                                mRcvTopic.setHasFixedSize(true);
                                mTopicAdapter.setOnItemClickListener(new TopicAdapter.ClickListener() {
                                    @Override
                                    public void onItemClick(final View view, int position) {
                                        final ValueAnimator value = ValueAnimator.ofFloat(1.3f, 1f);
                                        value.setDuration(100);
                                        value.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                            @Override
                                            public void onAnimationUpdate(ValueAnimator animation) {
                                                float progress = (float) value.getAnimatedValue();
                                                view.setScaleX(progress);
                                                view.setScaleY(progress);
                                            }
                                        });
                                        value.start();
                                        final Intent bundle = new Intent(TopicActivity.this, TopicDetailActivity.class);
                                        bundle.putExtra(Constants.KEY_ID_TOPIC, list.get(position).getId());
                                        startActivity(bundle);
                                    }
                                });
                            }
                        });
                    }
                } else {
                    throw new NullPointerException();
                }
            }
        });


    }
}