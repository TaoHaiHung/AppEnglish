package com.example.gst_mock_englist_for_kids.app_client.look_and_choose.view;


import android.animation.ValueAnimator;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.look_and_choose.model.ImageAnswer;
import com.example.gst_mock_englist_for_kids.app_database.executors.MyExecutors;
import com.example.gst_mock_englist_for_kids.app_database.create_database.Database;
import com.example.gst_mock_englist_for_kids.app_client.common.Constants;
import com.example.gst_mock_englist_for_kids.app_client.callback.MyDialogListener;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class LookAndChooseFragment extends Fragment {

    private MyDialogListener mDialogListener;

    private MediaPlayer mpCorrect;

    private MediaPlayer mpInCorrect;

    private TextView mTvA, mTvB, mTvC, mTvD;

    private ImageButton mBtnHome, mBtnNext;

    private ImageView mImgAnswer;

    private Database mDatabase;

    private int mQuestionCounter;

    private int mQuestionCountTotal;

    private ImageAnswer mCurrentAnswer;

    @SuppressWarnings("FieldCanBeLocal")
    private final boolean mAnswered = false;

    private List<ImageAnswer> mList;

    private final View.OnClickListener mTvAClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (checkAnswer(mCurrentAnswer.getAnswer(), mTvA)) {
                mpCorrect.start();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    mTvA.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                            R.drawable.text_view_true));
                }
                mBtnNext.setVisibility(View.VISIBLE);
                mTvB.setEnabled(false);
                mTvC.setEnabled(false);
                mTvD.setEnabled(false);
            } else {
                mpInCorrect.start();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    mTvA.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                            R.drawable.text_view_false));
                }
            }
        }
    };

    private final View.OnClickListener mTvBClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (checkAnswer(mCurrentAnswer.getAnswer(), mTvB)) {
                mpCorrect.start();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    mTvB.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                            R.drawable.text_view_true));
                }
                mBtnNext.setVisibility(View.VISIBLE);
                mTvA.setEnabled(false);
                mTvC.setEnabled(false);
                mTvD.setEnabled(false);
            } else {
                mpInCorrect.start();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    mTvB.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                            R.drawable.text_view_false));
                }
            }
        }
    };

    private final View.OnClickListener mTvCClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (checkAnswer(mCurrentAnswer.getAnswer(), mTvC)) {
                mpCorrect.start();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    mTvC.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                            R.drawable.text_view_true));
                }
                mBtnNext.setVisibility(View.VISIBLE);
                mTvA.setEnabled(false);
                mTvB.setEnabled(false);
                mTvD.setEnabled(false);
            } else {
                mpInCorrect.start();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    mTvC.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                            R.drawable.text_view_false));
                }
            }
        }
    };

    private final View.OnClickListener mTvDClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (checkAnswer(mCurrentAnswer.getAnswer(), mTvD)) {
                mpCorrect.start();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    mTvD.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                            R.drawable.text_view_true));
                }
                mBtnNext.setVisibility(View.VISIBLE);
                mTvA.setEnabled(false);
                mTvB.setEnabled(false);
                mTvC.setEnabled(false);
            } else {
                mpInCorrect.start();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    mTvD.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                            R.drawable.text_view_false));
                }
            }
        }
    };

    private final View.OnClickListener mBtnHomeClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final ValueAnimator value = ValueAnimator.ofFloat(1.3f, 1f);
            value.setDuration(100);
            value.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float progress = (float) value.getAnimatedValue();
                    mBtnHome.setScaleX(progress);
                    mBtnHome.setScaleY(progress);
                }
            });
            value.start();
            if (getFragmentManager() != null) {
                getFragmentManager().popBackStack(Constants.BACK_STACK_HOME_FRAGMENT, Constants.FLAG_HOME_FRAGMENT);
            }
        }
    };

    private final View.OnClickListener mBtnNextClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final ValueAnimator value = ValueAnimator.ofFloat(1.3f, 1f);
            value.setDuration(100);
            value.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float progress = (float) value.getAnimatedValue();
                    mBtnNext.setScaleX(progress);
                    mBtnNext.setScaleY(progress);
                }
            });
            value.start();
            showNextQuestion();
            refreshViews();
        }
    };

    private boolean checkAnswer(String patten, TextView textView) {
        return patten.equalsIgnoreCase(textView.getText().toString());
    }

    private void refreshViews() {
        mBtnNext.setVisibility(View.GONE);
        mTvA.setEnabled(true);
        mTvB.setEnabled(true);
        mTvC.setEnabled(true);
        mTvD.setEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mTvA.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                    R.drawable.custom_textview));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mTvB.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.custom_textview));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mTvC.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.custom_textview));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mTvD.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.custom_textview));
        }
    }


    public LookAndChooseFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_look_and_choose, container, false);
        initViews(view);
        refreshFragment();
        addEvents();
        return view;
    }


    private void addEvents() {
        mBtnHome.setOnClickListener(mBtnHomeClick);
        mTvA.setOnClickListener(mTvAClick);
        mTvB.setOnClickListener(mTvBClick);
        mTvC.setOnClickListener(mTvCClick);
        mTvD.setOnClickListener(mTvDClick);
        mBtnNext.setOnClickListener(mBtnNextClick);
    }

    private void initViews(View view) {
        mpCorrect = MediaPlayer.create(getContext(), R.raw.correct);

        mpInCorrect = MediaPlayer.create(getContext(), R.raw.wrong);

        mDatabase = Database.getInstance(getContext());

        mImgAnswer = view.findViewById(R.id.imgAnswer);
        mTvA = view.findViewById(R.id.tvA);
        mTvB = view.findViewById(R.id.tvB);
        mTvC = view.findViewById(R.id.tvC);
        mTvD = view.findViewById(R.id.tvD);
        mBtnHome = view.findViewById(R.id.btnHome);
        mBtnNext = view.findViewById(R.id.btnNext);

        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mList = mDatabase.iTopicDao().getListImageAnswer();
                mQuestionCountTotal = mList.size();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showNextQuestion();
                        }
                    });
                }
            }
        });
    }

    private void showNextQuestion() {
        if (!mAnswered) {
            mBtnNext.setVisibility(View.GONE);
        }
        if (mQuestionCounter < mQuestionCountTotal) {
            mCurrentAnswer = mList.get(mQuestionCounter);
            mImgAnswer.setImageBitmap(getBitmapFromAssets(mCurrentAnswer.getImg()));
            mTvA.setText(mCurrentAnswer.getA());
            mTvB.setText(mCurrentAnswer.getB());
            mTvC.setText(mCurrentAnswer.getC());
            mTvD.setText(mCurrentAnswer.getD());
            mQuestionCounter++;
        } else {
            finishQuiz();
        }
    }

    private void finishQuiz() {
        if (getFragmentManager() != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            DialogFragment resultFragment = new ResultLookFragment(mDialogListener);
            resultFragment.show(ft, Constants.RESULT_FRAGMENT);
            resultFragment.setCancelable(false);
        }
    }

    private Bitmap getBitmapFromAssets(String fileName) {
        AssetManager am = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            am = Objects.requireNonNull(getActivity()).getAssets();
        }
        InputStream is = null;
        try {
            is = am != null ? am.open(fileName) : null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BitmapFactory.decodeStream(is);
    }

    private void refreshFragment() {
        mDialogListener = new MyDialogListener() {
            @Override
            public void onCloseDialog() {
                mQuestionCounter = 0;
                MyExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        mList = mDatabase.iTopicDao().getListImageAnswer();
                        mQuestionCountTotal = mList.size();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    showNextQuestion();
                                }
                            });
                        }
                    }
                });
            }
        };
    }

}
