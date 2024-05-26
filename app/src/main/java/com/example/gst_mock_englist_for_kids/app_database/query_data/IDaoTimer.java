package com.example.gst_mock_englist_for_kids.app_database.query_data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gst_mock_englist_for_kids.app_client.time.model.MyTimer;

import java.util.List;

@Dao
public interface IDaoTimer {

   //  get clock
    @Query("SELECT * FROM MyTimer ORDER BY id ASC")
    List<MyTimer> getMyTimerList();

   //  insert clock
    @Insert
    void insertClock(MyTimer... timers);

    @Delete
    void deleteClock(MyTimer... timer);

    @Update
    void updateAlarm(MyTimer... timer);

}
