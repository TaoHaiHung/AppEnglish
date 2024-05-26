package com.example.gst_mock_englist_for_kids.app_client.topic_detail.view;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.topic_detail.model.TopicDetails;
import com.example.gst_mock_englist_for_kids.app_database.executors.MyExecutors;
import com.example.gst_mock_englist_for_kids.app_database.create_database.Database;
import com.example.gst_mock_englist_for_kids.app_client.common.Constants;

import java.util.List;
import java.util.Locale;
import java.util.Objects;


public class TopicDetailsFragment extends Fragment {

    private TopicDetailsAdapter mTopicDetailsAdapter;

    private RecyclerView mRcvTopicDetails;

    private Database mDatabase;

    private TextToSpeech mTextToSpeech;

    private int idTopic = 0;

    public TopicDetailsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic_details, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        mDatabase = Database.getInstance(getContext());

        mRcvTopicDetails = view.findViewById(R.id.rcvTopicDetails);

        mTextToSpeech = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                mTextToSpeech.setLanguage(Locale.US);
            }
        });

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            idTopic = bundle.getInt(Constants.KEY_ID_TOPIC);
        }
        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<TopicDetails> list = mDatabase.iTopicDao().getListTopicDetails(idTopic);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (list != null) {
                                mTopicDetailsAdapter = new TopicDetailsAdapter(Objects.requireNonNull(getContext()), list);
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


