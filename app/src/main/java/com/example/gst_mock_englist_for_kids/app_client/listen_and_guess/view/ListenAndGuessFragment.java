package com.example.gst_mock_englist_for_kids.app_client.listen_and_guess.view;


import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.listen_and_guess.model.ListenAnswer;
import com.example.gst_mock_englist_for_kids.app_database.executors.MyExecutors;
import com.example.gst_mock_englist_for_kids.app_database.create_database.Database;
import com.example.gst_mock_englist_for_kids.app_client.common.Constants;
import com.example.gst_mock_englist_for_kids.app_client.callback.MyDialogListener;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListenAndGuessFragment extends Fragment {
    private MyDialogListener mDialogListener;


    private MediaPlayer mpCorrect;

    private MediaPlayer mpInCorrect;

    private TextToSpeech mTextToSpeech;


    private ImageButton mBtnHome, mBtnListen, mBtnNext;

    private ImageView mImgA, mImgB, mImgC, mImgD;

    private TextView mTvName;

    private Database mDatabase;

    private int mQuestionCounter;

    private int mQuestionCountTotal;

    private ListenAnswer mCurrentAnswer;

    private List<ListenAnswer> mList;

    @SuppressWarnings("FieldCanBeLocal")
    private final boolean mAnswer = false;

    private final View.OnClickListener mBtnHomeClick = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            final ValueAnimator value = ValueAnimator.ofFloat(1.3f, 1f);
            value.setDuration(100);
            value.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float progress = (float) value.getAnimatedValue();
                    v.setScaleX(progress);
                    v.setScaleY(progress);
                }
            });
            value.start();
            if (getFragmentManager() != null) {
                getFragmentManager().popBackStack(Constants.BACK_STACK_HOME_FRAGMENT, Constants.FLAG_HOME_FRAGMENT);
            }
        }
    };

    private final View.OnClickListener mBtnListenClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final ValueAnimator value = ValueAnimator.ofFloat(1.3f, 1f);
            value.setDuration(100);
            value.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float progress = (float) value.getAnimatedValue();
                    mBtnListen.setScaleX(progress);
                    mBtnListen.setScaleY(progress);
                }
            });
            value.start();
            String tts = mTvName.getText().toString();
            mTextToSpeech.speak(tts, TextToSpeech.QUEUE_FLUSH, null);

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

    private final View.OnClickListener mImgAClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (checkAnswer(mCurrentAnswer.getImgA(), mCurrentAnswer.getAnswer())) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        mImgA.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                                R.drawable.custom_image_correct));
                    }
                }
                mBtnNext.setVisibility(View.VISIBLE);
                mpCorrect.start();
                mImgB.setEnabled(false);
                mImgC.setEnabled(false);
                mImgD.setEnabled(false);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        mImgA.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                                R.drawable.custom_image_incorrect));
                    }
                }
                mpInCorrect.start();
            }
        }
    };

    private final View.OnClickListener mImgBClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (checkAnswer(mCurrentAnswer.getImgB(), mCurrentAnswer.getAnswer())) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        mImgB.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                                R.drawable.custom_image_correct));
                    }
                }
                mBtnNext.setVisibility(View.VISIBLE);
                mpCorrect.start();
                mImgA.setEnabled(false);
                mImgC.setEnabled(false);
                mImgD.setEnabled(false);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        mImgB.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                                R.drawable.custom_image_incorrect));
                    }
                }
                mpInCorrect.start();
            }
        }
    };

    private final View.OnClickListener mImgCClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (checkAnswer(mCurrentAnswer.getImgC(), mCurrentAnswer.getAnswer())) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        mImgC.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                                R.drawable.custom_image_correct));
                    }
                }
                mBtnNext.setVisibility(View.VISIBLE);
                mpCorrect.start();
                mImgB.setEnabled(false);
                mImgA.setEnabled(false);
                mImgD.setEnabled(false);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    mImgC.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                            R.drawable.custom_image_incorrect));
                }
                mpInCorrect.start();
            }
        }
    };

    private final View.OnClickListener mImgDClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (checkAnswer(mCurrentAnswer.getImgD(), mCurrentAnswer.getAnswer())) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    mImgD.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                            R.drawable.custom_image_correct));
                }
                mBtnNext.setVisibility(View.VISIBLE);
                mpCorrect.start();
                mImgB.setEnabled(false);
                mImgC.setEnabled(false);
                mImgA.setEnabled(false);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    mImgD.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),
                            R.drawable.custom_image_incorrect));
                }
                mpInCorrect.start();
            }
        }
    };

    public ListenAndGuessFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listen_and_guess, container, false);
        initViews(view);
        refreshFragment();
        addEvents();
        return view;
    }

    private void addEvents() {
        mBtnHome.setOnClickListener(mBtnHomeClick);
        mBtnListen.setOnClickListener(mBtnListenClick);
        mBtnNext.setOnClickListener(mBtnNextClick);

        mImgA.setOnClickListener(mImgAClick);
        mImgB.setOnClickListener(mImgBClick);
        mImgC.setOnClickListener(mImgCClick);
        mImgD.setOnClickListener(mImgDClick);
    }

    private void initViews(View view) {

        mBtnHome = view.findViewById(R.id.btnHome);
        mBtnListen = view.findViewById(R.id.btnListen);
        mBtnNext = view.findViewById(R.id.btnNext);

        mImgA = view.findViewById(R.id.imgA);
        mImgB = view.findViewById(R.id.imgB);
        mImgC = view.findViewById(R.id.imgC);
        mImgD = view.findViewById(R.id.imgD);

        mTvName = view.findViewById(R.id.tvName);

        mpCorrect = MediaPlayer.create(getActivity(), R.raw.correct);
        mpInCorrect = MediaPlayer.create(getActivity(), R.raw.wrong);

        mDatabase = Database.getInstance(getContext());

        mTextToSpeech = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                mTextToSpeech.setLanguage(Locale.US);
            }
        });

        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mList = mDatabase.iTopicDao().getListListenAnswer();
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

    private void refreshViews() {
        mBtnNext.setVisibility(View.GONE);

        mImgA.setEnabled(true);
        mImgB.setEnabled(true);
        mImgC.setEnabled(true);
        mImgD.setEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mImgA.setBackground(null);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mImgB.setBackground(null);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mImgC.setBackground(null);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mImgD.setBackground(null);
        }
    }

    private boolean checkAnswer(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }

    @SuppressLint("SetTextI18n")
    private void showNextQuestion() {
        if (!mAnswer) {
            mBtnNext.setVisibility(View.GONE);
        }
        if (mQuestionCounter < mQuestionCountTotal) {

            mCurrentAnswer = mList.get(mQuestionCounter);

            mTvName.setText(mCurrentAnswer.getName() + " ?");

            mImgA.setImageBitmap(getBitmapFromAssets(mCurrentAnswer.getImgA()));
            mImgB.setImageBitmap(getBitmapFromAssets(mCurrentAnswer.getImgB()));
            mImgC.setImageBitmap(getBitmapFromAssets(mCurrentAnswer.getImgC()));
            mImgD.setImageBitmap(getBitmapFromAssets(mCurrentAnswer.getImgD()));

            String tts = mCurrentAnswer.getName();
            mTextToSpeech.speak(tts, TextToSpeech.QUEUE_FLUSH, null);

            mQuestionCounter++;
        } else {
            finishQuiz();
        }
    }

    private void finishQuiz() {
        if (getFragmentManager() != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            DialogFragment resultFragment = new ResultListenFragment(mDialogListener);
            resultFragment.show(ft, Constants.TAG_FRAGMENT_DIALOG_LISTEN);
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
                        mList = mDatabase.iTopicDao().getListListenAnswer();
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
