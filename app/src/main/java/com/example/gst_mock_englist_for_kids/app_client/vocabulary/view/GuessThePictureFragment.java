package com.example.gst_mock_englist_for_kids.app_client.vocabulary.view;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.topic_detail.model.TopicDetails;
import com.example.gst_mock_englist_for_kids.app_database.executors.MyExecutors;
import com.example.gst_mock_englist_for_kids.app_database.create_database.Database;

import java.util.List;
import java.util.Objects;

public class GuessThePictureFragment extends Fragment {

    private GuessThePictureAdapter mGuessThePictureAdapter;

    private List<TopicDetails> mListGuess;

    private RecyclerView mRvGuessThePicture;

    private View view;

    private Database mDatabase;

    @SuppressWarnings("FieldCanBeLocal")
    private ImageView btnReplay;

    private final View.OnClickListener onClickRandomListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addEvenRandom();
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_guess_the_picture, container, false);
        initViewFromFragment();
        return view;
    }

    private void initViewFromFragment() {

        mRvGuessThePicture = view.findViewById(R.id.rv_guess_picture);
        btnReplay = view.findViewById(R.id.btn_rePlay);
        btnReplay.setOnClickListener(onClickRandomListener);
        mDatabase = Database.getInstance(getContext());
        addEvenRandom();

    }

    private void addEvenRandom() {
        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mListGuess = mDatabase.iTopicDao().getListGuessThePicture();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (mListGuess != null) {
                                mGuessThePictureAdapter = new GuessThePictureAdapter(getContext(), mListGuess);
                                mRvGuessThePicture.setAdapter(mGuessThePictureAdapter);
                                mRvGuessThePicture.setHasFixedSize(true);
                                mGuessThePictureAdapter.onItemCLickListener(new GuessThePictureAdapter.OnItemClickItemForGuessThePicture() {
                                    @Override
                                    public void onClickItemImage(final ImageView imgItemPicture, final ImageView imgTickTrueOrFalse, int position) {
                                        final ValueAnimator value = ValueAnimator.ofFloat(1.3f, 1f);
                                        value.setDuration(600);
                                        value.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                            @Override
                                            public void onAnimationUpdate(ValueAnimator animation) {
                                                float progress = (float) value.getAnimatedValue();
                                                imgItemPicture.setScaleX(progress);
                                                imgItemPicture.setScaleY(progress);
                                            }
                                        });
                                        value.start();

                                        Bundle bundle = new Bundle();
                                        bundle.putSerializable("data", mListGuess.get(position));
                                        CheckAnswerDialogFragment checkAnswerFragment = new CheckAnswerDialogFragment(new CheckAnswerDialogFragment.CheckAnswerListener() {
                                            @Override
                                            public void onCheckItem() {
                                                imgItemPicture.setImageAlpha(300);
                                                imgTickTrueOrFalse.setImageResource(R.drawable.ic_tick_true);
                                                imgItemPicture.setClickable(true);
                                                imgItemPicture.setEnabled(false);
                                            }

                                            @Override
                                            public void onCheckedItemFalse() {
                                                imgItemPicture.setImageAlpha(300);
                                                imgTickTrueOrFalse.setImageResource(R.drawable.ic_tick_false);
                                                imgItemPicture.setClickable(true);
                                                imgItemPicture.setEnabled(false);
                                            }

                                        });
                                        if (getFragmentManager() != null) {
                                            checkAnswerFragment.setArguments(bundle);
                                            checkAnswerFragment.show(getFragmentManager(), "dialog");
                                            checkAnswerFragment.setCancelable(false);
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
    }


}
