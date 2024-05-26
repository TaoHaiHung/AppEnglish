package com.example.gst_mock_englist_for_kids.app_client.time.model;



import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "MyTimer")
public class MyTimer implements Serializable {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Hour")
    private String mHour;

    @ColumnInfo(name = "Minute")
    private String mMinute;

    @Ignore
    private boolean mSwitchTime;


    public MyTimer() {
    }

    @Ignore
    public MyTimer(String mHour, String mMinute) {
        this.mHour = mHour;
        this.mMinute = mMinute;
        this.mSwitchTime = mSwitchTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHour() {
        return mHour;
    }

    public void setHour(String mHour) {
        this.mHour = mHour;
    }

    public String getMinute() {
        return mMinute;
    }

    public void setMinute(String mMinute) {
        this.mMinute = mMinute;
    }

    public boolean getSwitchTime() {
        return mSwitchTime;
    }

    public void setSwitchTime(boolean mSwitchTime) {
        this.mSwitchTime = mSwitchTime;
    }
}
