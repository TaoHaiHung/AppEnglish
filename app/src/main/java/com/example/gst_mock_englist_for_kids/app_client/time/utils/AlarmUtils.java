package com.example.gst_mock_englist_for_kids.app_client.time.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.example.gst_mock_englist_for_kids.app_client.time.view.NotificationListener;

import java.util.Calendar;
import java.util.Date;

import static android.content.Context.ALARM_SERVICE;

public class AlarmUtils {
    public static void insertAlarm(Context context,int hou,int mi,int flag,String content){
        PendingIntent pendingIntent;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent iAlarm = new Intent(context, NotificationListener.class);
        iAlarm.putExtra("Content",content);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,hou);
        calendar.set(Calendar.MINUTE,mi);

        pendingIntent = PendingIntent.getBroadcast(context,flag,iAlarm,PendingIntent.FLAG_UPDATE_CURRENT);
        if(calendar.getTime().compareTo(new Date())<0)
            calendar.add(Calendar.DAY_OF_MONTH,1);

        alarmManager.setRepeating(AlarmManager.RTC,
                calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
    }
    public static void cancelAlarm(Context context, int flag) {
        PendingIntent pendingIntent;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        Intent iAlarm;
        iAlarm = new Intent(context, NotificationListener.class);
        iAlarm.putExtra("extra", "on");
        pendingIntent = PendingIntent.getBroadcast(context, flag, iAlarm, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.cancel(pendingIntent);
    }

}

