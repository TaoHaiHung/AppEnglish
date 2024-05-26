package com.example.gst_mock_englist_for_kids.app_client.home.view;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.classfive.ExampleClassFiveActivity;
import com.example.gst_mock_englist_for_kids.app_client.classone.ClassOneActivity;
import com.example.gst_mock_englist_for_kids.app_client.other.OtherActivity;
import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private CardView mBtnStart, mBtnClassTwo, mBtnClass3, mBtnClass4, mBtnClass5, mBtnOther;

    private Button mBtnViewAndChoose;

    private Button mBtnListenAndGuess;

    private Button mBtnMiniGame;

    private Button mBtnWatchVideo;

    private CircleImageView mBtnLanguage;

    private DrawerLayout mDrawerLayout;

    private Toolbar mToolbar;

    private ImageView mImageFlowerOne, mImageFlowerTwo, mImageFlowerThree, mImageFlowerFour;

    private NavigationView mNavigationView;

    @SuppressWarnings("FieldCanBeLocal")
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    private final View.OnClickListener mBtnStartOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), ClassOneActivity.class);
            intent.putExtra("class1", "Class 1");
            startActivity(intent);
//            changeFragment(new TopicFragment(), null, null);
        }
    };





//    private final View.OnClickListener mBtnLockAndChooseOnClick = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            changeFragment(new LookAndChooseFragment(), Constants.BACK_STACK_HOME_FRAGMENT, Constants.TAG_FRAGMENT_LOOK);
//        }
//    };
//
//    private final View.OnClickListener mBtnListenAndGuessOnClick = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            changeFragment(new ListenAndGuessFragment(), Constants.BACK_STACK_HOME_FRAGMENT, Constants.TAG_FRAGMENT_LISTEN);
//        }
//    };
//
//    private final View.OnClickListener mBtnMiniGameOnClick = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            changeFragment(new GuessThePictureFragment(), null, null);
//        }
//    };
//
//    private final View.OnClickListener mBtnWatchVideoOnClick = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            changeFragment(new LearnByVideoFragment(), Constants.BACK_STACK_HOME_FRAGMENT, Constants.TAG_FRAGMENT_VIDEO);
//        }
//    };
//
//    private final View.OnClickListener mBtnLanguageOnclick = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            showDialogLanguage();
//        }
//    };

//    private final NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//            if (menuItem.getItemId() == R.id.navHome) {
//                mDrawerLayout.closeDrawer(GravityCompat.START);
//            }
//
//            if (menuItem.getItemId() == R.id.navAgeFromThreeToTwelve) {
//                mDrawerLayout.closeDrawer(GravityCompat.START);
//               Intent intent = new Intent(getActivity(), EBookActivity.class);
//               startActivity(intent);
//
//            }
//            if (menuItem.getItemId() == R.id.navGame) {
//                mDrawerLayout.closeDrawer(GravityCompat.START);
//                changeFragment(new GamerFragment(), Constants.BACK_STACK_HOME_FRAGMENT, Constants.TAG_FRAGMENT_GAME);
//            }
//            if (menuItem.getItemId() == R.id.navTimer) {
//                mDrawerLayout.closeDrawer(GravityCompat.START);
//                changeFragment(new TimerFragment(), null, null);
//
//            }
//            if (menuItem.getItemId() == R.id.navShare) {
//                mDrawerLayout.closeDrawer(GravityCompat.START);
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_SEND);
//                intent.putExtra(Intent.EXTRA_TEXT, Constants.URL);
//                intent.setType("text/plain");
//                Intent shareIntent = Intent.createChooser(intent, null);
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                    Objects.requireNonNull(getActivity()).startActivity(shareIntent);
//                }
//
//            }
//            if (menuItem.getItemId() == R.id.navReview) {
//                mDrawerLayout.closeDrawer(GravityCompat.START);
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                    if (NetworkConnection.isNetworkAvailable(Objects.requireNonNull(getContext()))) {
//                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.URL));
//                        Objects.requireNonNull(getActivity()).startActivity(intent);
//                    } else {
//                        showDialog();
//                    }
//                }
//            }
//            if (menuItem.getItemId() == R.id.navAdvisory) {
//                mDrawerLayout.closeDrawer(GravityCompat.START);
//                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts(Constants.SCHEME, Constants.CALL_PHONE, null));
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                    Objects.requireNonNull(getActivity()).startActivity(callIntent);
//                }
//            }
//
//            return true;
//        }
//    };

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(view);
        addEvents();
//        loadLocale();
        return view;
    }

//    private void showDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//        builder.setTitle(R.string.check_internet);
//        builder.setMessage(R.string.check_your_internet);
//        builder.setCancelable(false);
//        builder.setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                if (getFragmentManager() != null) {
//                    getFragmentManager().popBackStack(Constants.BACK_STACK_HOME_FRAGMENT, Constants.FLAG_HOME_FRAGMENT);
//                    dialog.dismiss();
//                }
//            }
//        });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }

    private void initViews(View view) {
        mBtnStart = view.findViewById(R.id.cvClassOne);
        mBtnClassTwo = view.findViewById(R.id.cvClassTwo);
        mBtnClass3 = view.findViewById(R.id.cvClass3);
        mBtnClass4 = view.findViewById(R.id.cvClass4);
        mBtnClass5 = view.findViewById(R.id.cvClass5);
        mBtnOther = view.findViewById(R.id.cvOther);
//        mBtnViewAndChoose = view.findViewById(R.id.btnViewAndChoose);
//
//        mBtnListenAndGuess = view.findViewById(R.id.btnListenAndGuess);
//
//        mBtnMiniGame = view.findViewById(R.id.btnMiniGame);
//
//        mBtnWatchVideo = view.findViewById(R.id.btnWatchVideo);
//
//        mBtnLanguage = view.findViewById(R.id.btnLanguage);
//
//        mToolbar = view.findViewById(R.id.toolbar_home);
//
//        mDrawerLayout = view.findViewById(R.id.draw_layout);
//
//        mNavigationView = view.findViewById(R.id.nvMenu);
//
//        mImageFlowerOne = view.findViewById(R.id.img_flower_one);
//
//        mImageFlowerTwo = view.findViewById(R.id.img_flower_two);
//
//        mImageFlowerThree = view.findViewById(R.id.img_three);
//
//        mImageFlowerFour = view.findViewById(R.id.img_four);

//        actionToolbar();
//        setAnimation();
    }

//    private void setAnimation() {
//        final ValueAnimator value = ValueAnimator.ofFloat(1.2f, 0.5f, 0.5f, 0f);
//        value.setDuration(3000);
//        value.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float progress = (float) value.getAnimatedValue();
//                mImageFlowerOne.setScaleX(progress);
//                mImageFlowerOne.setScaleY(progress);
//                mImageFlowerTwo.setScaleX(progress);
//                mImageFlowerTwo.setScaleY(progress);
//                mImageFlowerThree.setScaleX(progress);
//                mImageFlowerThree.setScaleY(progress);
//                mImageFlowerFour.setScaleX(progress);
//                mImageFlowerFour.setScaleY(progress);
//            }
//        });
//        value.start();
//        value.setRepeatCount(ValueAnimator.INFINITE);
//    }

//    private void actionToolbar() {
//        if (getActivity() != null) {
//            ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setTitle("");
//            }
//            mNavigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener);
//            mActionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//            mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
//            mActionBarDrawerToggle.syncState();
//        }
//    }


    private void addEvents() {
        mBtnStart.setOnClickListener(mBtnStartOnClick);
        mBtnClassTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClassOneActivity.class);
                intent.putExtra("class2", "Class 2");
                startActivity(intent);
            }
        });

        mBtnClass3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClassOneActivity.class);
                intent.putExtra("class3", "Class 3");
                startActivity(intent);
            }
        });

        mBtnClass4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClassOneActivity.class);
                intent.putExtra("class4", "Class 4");
                startActivity(intent);
            }
        });

        mBtnClass5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClassOneActivity.class);
                intent.putExtra("class5", "Class 5");
                startActivity(intent);
            }
        });

        mBtnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OtherActivity.class);
                startActivity(intent);
            }
        });


    }
//
//        mBtnViewAndChoose.setOnClickListener(mBtnLockAndChooseOnClick);
//
//        mBtnListenAndGuess.setOnClickListener(mBtnListenAndGuessOnClick);
//
//        mBtnMiniGame.setOnClickListener(mBtnMiniGameOnClick);
//
//        mBtnWatchVideo.setOnClickListener(mBtnWatchVideoOnClick);
//
//        mBtnLanguage.setOnClickListener(mBtnLanguageOnclick);
//
       ;
//
//    }
//
//    private void changeFragment(Fragment fragment, String backStack, String tag) {
//        if (getFragmentManager() != null) {
//            FragmentTransaction transaction = getFragmentManager().beginTransaction();
//            transaction.replace(R.id.frContent, fragment, tag);
//            transaction.addToBackStack(backStack);
//            transaction.commit();
//        }
//    }
//
//    private void showDialogLanguage() {
//        int position = -1;
//        final String[] listItem = {Constants.LIST_ITEM_VN, Constants.LIST_ITEM_EN};
//        final AlertDialog.Builder mbBuilder = new AlertDialog.Builder(getActivity());
//        mbBuilder.setTitle(Constants.TITLE_DIALOG_LANGUAGE);
//
//        mbBuilder.setSingleChoiceItems(listItem, position, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                if (which == 0) {
//                    setLocale(Constants.LOCALE_VI);
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                        Objects.requireNonNull(getActivity()).recreate();
//                    }
//                }
//                if (which == 1) {
//                    setLocale(Constants.LOCALE_EN);
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                        Objects.requireNonNull(getActivity()).recreate();
//                    }
//                }
//                dialog.dismiss();
//            }
//        });
//        AlertDialog mDialog = mbBuilder.create();
//        mDialog.show();
//    }
//
//    private void setLocale(String lang) {
//        Locale locale = new Locale(lang);
//        Locale.setDefault(locale);
//        Configuration config = new Configuration();
//        config.locale = locale;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Objects.requireNonNull(getContext()).getResources().updateConfiguration(config, getContext().getResources().getDisplayMetrics());
//        }
//        SharedPreferences.Editor editor = null;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
//            editor = Objects.requireNonNull(getContext()).getSharedPreferences(Constants.KEY_SHAREDPRRFERENCES, Context.MODE_PRIVATE).edit();
//        }
//        editor.putString(Constants.KEY_SHARED_STRING, lang);
//        editor.apply();
//
//    }
//
//    private void loadLocale() {
//        SharedPreferences prefs = null;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
//            prefs = Objects.requireNonNull(getContext()).getSharedPreferences(Constants.KEY_SHAREDPRRFERENCES, Context.MODE_PRIVATE);
//        }
//        String language = prefs.getString(Constants.KEY_SHARED_STRING, "");
//        if (language != null) {
//            if (language.equals(Constants.LOCALE_VI)) {
//                mBtnLanguage.setImageResource(R.drawable.ic_vn);
//                setLocale(language);
//            }
//            if (language.equals(Constants.LOCALE_EN)) {
//                mBtnLanguage.setImageResource(R.drawable.ic_england);
//                setLocale(language);
//            }
//        }
//    }


}
