package com.example.gst_mock_englist_for_kids.app_client.video.model;

import java.io.Serializable;

public class VideoEnglish implements Serializable {

    private final String mTitle;

    private final String mIdVideo;

    private final String mThumbnail;

    private final String mDescription;

    public VideoEnglish(String mTitle, String mDescription, String mIdVideo, String mThumbnail) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mIdVideo = mIdVideo;
        this.mThumbnail = mThumbnail;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getIdVideo() {
        return mIdVideo;
    }

    public String getThumbnail() {
        return mThumbnail;
    }
}
