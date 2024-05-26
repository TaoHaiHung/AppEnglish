package com.example.gst_mock_englist_for_kids.app_client.time.view;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.provider.Settings;
import android.widget.RemoteViews;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.app_client.splash.MainActivity;

import static android.app.NotificationManager.IMPORTANCE_DEFAULT;

public class NotificationListener extends BroadcastReceiver {

    private static final String CHANNEL_ID = "Channel";

    @Override
    public void onReceive(Context context, Intent intent) {

        MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.start();

        Intent intentMain = new Intent(context, MainActivity.class);

        String content = intent.getStringExtra("Content");
        RemoteViews contentView = new RemoteViews(context.getPackageName(), R.layout.layout_notification);
        contentView.setTextViewText(R.id.txtNoiDungThongBao, content);

        contentView.setOnClickPendingIntent(R.id.lnNotification, PendingIntent.getActivity(context, 100, intentMain, 0));

        Notification.Builder builder = new Notification.Builder(context);
        Notification notification = builder.setContentTitle(context.getString(R.string.app_name))
                .setContentText(context.getResources().getString(R.string.action_check))
                .setSmallIcon(R.drawable.ic_timer)
                .setAutoCancel(true).setDefaults(0).setOngoing(false)
                .setContent(contentView)
                .build();

        if (android.os.Build.VERSION.SDK_INT >= 23) {
            notification.bigContentView = contentView;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId(CHANNEL_ID);
        }

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    context.getString(R.string.app_name),
                    IMPORTANCE_DEFAULT
            );
            channel.setDescription("no sound");
            channel.setSound(null, null);
            channel.enableLights(false);
            channel.setLightColor(Color.BLUE);
            channel.enableVibration(false);
            notificationManager.createNotificationChannel(channel);

        }
        notificationManager.notify(999, notification);
    }
}
