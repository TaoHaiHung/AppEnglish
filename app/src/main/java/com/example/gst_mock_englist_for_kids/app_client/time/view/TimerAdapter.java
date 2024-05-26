package com.example.gst_mock_englist_for_kids.app_client.time.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.callback.OnClickItem;
import com.example.gst_mock_englist_for_kids.app_client.time.model.MyTimer;

import java.util.List;

public class TimerAdapter extends BaseAdapter {

    private final Context mContext;

    private  List<MyTimer> myTimerList;

    private OnClickItem listener;

    public TimerAdapter(Context mContext, List<MyTimer> myTimerList, OnClickItem listener) {
        this.mContext = mContext;
        this.myTimerList = myTimerList;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return myTimerList.isEmpty() ? 0 : myTimerList.size();
    }

    @Override
    public Object getItem(int position) {
        return myTimerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {

        private TextView txtHour, txtMinute;
        private LinearLayout layout, linearLayoutItemClick;
        private Switch mSwitchTimer;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_timer, parent, false);
            holder = new ViewHolder();
            holder.txtHour = convertView.findViewById(R.id.tv_timer);
            holder.txtMinute = convertView.findViewById(R.id.tv_minute);
            holder.mSwitchTimer = convertView.findViewById(R.id.sw_timer);
            holder.layout = convertView.findViewById(R.id.item_clock);
            holder.linearLayoutItemClick = convertView.findViewById(R.id.linear_click);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        MyTimer timer = myTimerList.get(position);
        holder.txtHour.setText(timer.getHour());
        holder.txtMinute.setText(timer.getMinute());
        holder.mSwitchTimer.setChecked(timer.getSwitchTime());

//        SharedPreferences settings = mContext.getSharedPreferences("data",0);
//        boolean silent = settings.getBoolean("switchkey", false);
//        holder.mSwitchTimer.setChecked(silent);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(holder.layout, position);
            }
        });
        holder.mSwitchTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(holder.mSwitchTimer, position);
            }
        });
        holder.linearLayoutItemClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (listener != null){
                    listener.onClick(holder.linearLayoutItemClick, position);
                }
                return true;
            }
        });
        return convertView;
    }
}
