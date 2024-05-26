package com.example.gst_mock_englist_for_kids.app_database.create_database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.gst_mock_englist_for_kids.app_client.look_and_choose.model.ImageAnswer;
import com.example.gst_mock_englist_for_kids.app_client.listen_and_guess.model.ListenAnswer;
import com.example.gst_mock_englist_for_kids.app_client.time.model.MyTimer;
import com.example.gst_mock_englist_for_kids.app_client.topic.model.Topic;
import com.example.gst_mock_englist_for_kids.app_client.topic_detail.model.TopicDetails;
import com.example.gst_mock_englist_for_kids.app_database.query_data.IDao;
import com.example.gst_mock_englist_for_kids.app_database.query_data.IDaoTimer;
import com.example.gst_mock_englist_for_kids.app_client.common.Constants;


@androidx.room.Database(entities = {Topic.class, TopicDetails.class, ImageAnswer.class, ListenAnswer.class,MyTimer.class}, exportSchema = false, version = 2)
public abstract class Database extends RoomDatabase {
    private static final String DB_NAME = Constants.DATABASE_NAME;
    private static Database sInstance;

    public static synchronized Database getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(), Database.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }

    public abstract IDao iTopicDao();
    public abstract IDaoTimer getDaoTimer();

}
