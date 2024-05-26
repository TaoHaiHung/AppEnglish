package com.example.gst_mock_englist_for_kids.app_client.callback;

import com.example.gst_mock_englist_for_kids.app_client.time.model.MyTimer;

public interface TimerListener {
    void sendData(MyTimer myTimer,int key);
}
