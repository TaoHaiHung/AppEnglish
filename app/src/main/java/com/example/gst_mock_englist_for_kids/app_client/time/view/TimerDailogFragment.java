package com.example.gst_mock_englist_for_kids.app_client.time.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.time.model.MyTimer;
import com.example.gst_mock_englist_for_kids.app_client.callback.TimerListener;

import java.util.Calendar;


public class TimerDailogFragment extends DialogFragment {

    private View view;

    private TimePicker mTimePicker;

    private Button btnCancel, btnAgree;

    private int key = -1;

    private TimerListener listener;

    public static TimerDailogFragment newInstance(TimerListener listener) {

        Bundle args = new Bundle();
        TimerDailogFragment fragment = new TimerDailogFragment();
        fragment.setArguments(args);
        fragment.listener = listener;

        return fragment;
    }

    private final View.OnClickListener onClickCancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();
        }
    };

    private final View.OnClickListener onClickAgreeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, mTimePicker.getCurrentHour());
            calendar.set(Calendar.MINUTE, mTimePicker.getCurrentMinute());
            int hour = mTimePicker.getCurrentHour();
            int minute = mTimePicker.getCurrentMinute();

            String mHour;
            String mMinute;

            if (minute < 10 ) {
                mMinute = "0" + minute;

            } else {

                mMinute = String.valueOf(minute);
            }
            if (hour < 10){
                mHour = "0" + hour;
            }
            else {
                mHour = String.valueOf(hour);
            }
            listener.sendData(new MyTimer(mHour, mMinute), key);
            dismiss();

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_fragment_timer, container, false);
        initView();
        return view;
    }

    public void setKey(int key) {
        this.key = key;
    }

    private void initView() {
        btnCancel = view.findViewById(R.id.btn_cancel);
        btnAgree = view.findViewById(R.id.btn_agree);
        mTimePicker = view.findViewById(R.id.time_picker);
        btnAgree.setOnClickListener(onClickAgreeListener);
        btnCancel.setOnClickListener(onClickCancelListener);

    }


}
