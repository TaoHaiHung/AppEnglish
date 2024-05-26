package com.example.gst_mock_englist_for_kids.app_client.time.view;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.callback.OnClickItem;
import com.example.gst_mock_englist_for_kids.app_client.time.model.MyTimer;
import com.example.gst_mock_englist_for_kids.app_database.create_database.Database;
import com.example.gst_mock_englist_for_kids.app_client.time.utils.AlarmUtils;
import com.example.gst_mock_englist_for_kids.app_client.callback.TimerListener;

import java.util.ArrayList;
import java.util.List;


public class TimerFragment extends Fragment implements TimerListener {

    private View view;

    private TimerAdapter mTimerAdapter;

    private List<MyTimer> mListTimer = new ArrayList<>();

    private ListView mListView;

    private ImageView btnAdd;

    private Database mDatabase;

    private final TimerDailogFragment dialog = TimerDailogFragment.newInstance(this);

    private final View.OnClickListener onClickAddListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            dialog.show(getFragmentManager(), "timer dialog");
            dialog.setKey(-1);
            dialog.setCancelable(false);
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_timer, container, false);

        initView();
        getDataRoomData();
        return view;
    }


    private void initView() {
        mDatabase = Database.getInstance(getContext());
        mListView = view.findViewById(R.id.lv_timer);
        btnAdd = view.findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(onClickAddListener);
    }


    private OnClickItem onClickItem = new OnClickItem() {
        @Override
        public void onClick(View view, final int position) {
            switch (view.getId()) {
                case R.id.item_clock:
                    dialog.show(getFragmentManager(), "timer dialog");
                    dialog.setKey(position);
                    dialog.setCancelable(false);
                    break;
                case R.id.linear_click:
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle(R.string.delete_time);
                    builder.setMessage(R.string.delete_alarm);
                    builder.setCancelable(false);
                    builder.setPositiveButton(R.string.exit, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    builder.setNegativeButton(R.string.btn_agree, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MyTimer timer = mListTimer.get(position);
                            mDatabase.getDaoTimer().deleteClock(timer);
                            updateData();
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    break;
                case R.id.sw_timer:

                    if (((Switch) view).isChecked()) {

                        AlarmUtils.insertAlarm(getActivity(), Integer.parseInt(mListTimer.get(position).getHour()),
                                Integer.parseInt(mListTimer.get(position).getMinute()),mListTimer.get(position).getId(),
                                "Đến giờ học rồi bạn ơi !");
//
                    } else {
                        AlarmUtils.cancelAlarm(getActivity(), mListTimer.get(position).getId());
//
                    }
//                    SharedPreferences settings = getActivity().getSharedPreferences("data", 0);
//                    SharedPreferences.Editor editor = settings.edit();
//                    editor.putBoolean("switchkey", ((Switch) view).isChecked());
//                    editor.commit();
                    break;
            }
        }

        private void updateData() {
            mListTimer.clear();
            mListTimer.addAll(mDatabase.getDaoTimer().getMyTimerList());
            mTimerAdapter.notifyDataSetChanged();
        }
    };


    @Override
    public void sendData(MyTimer myTimer, int key) {
        if (key == -1) {
            myTimer = new MyTimer(myTimer.getHour(), myTimer.getMinute());
            mListTimer.add(myTimer);

        } else {
            mListTimer.set(key, myTimer);
        }
        mDatabase.getDaoTimer().insertClock(myTimer);
        mTimerAdapter.notifyDataSetChanged();

    }


    private void getDataRoomData() {
        if (mDatabase.getDaoTimer().getMyTimerList() != null) {
            mListTimer.clear();
            mListTimer.addAll(mDatabase.getDaoTimer().getMyTimerList());
            mTimerAdapter = new TimerAdapter(getContext(), mListTimer, onClickItem);
            mListView.setAdapter(mTimerAdapter);

        }
    }


}
