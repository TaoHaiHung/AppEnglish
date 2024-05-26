package com.example.gst_mock_englist_for_kids.app_client.ebook.model;

public class EBook {

    private String mNameBook;

    private int mBookImage;

    private String mLink;



    public EBook(String mNameBook, int mBookImage) {
        this.mNameBook = mNameBook;
        this.mBookImage = mBookImage;
    }



    public String getmNameBook() {
        return mNameBook;
    }



    public int getmBookImage() {
        return mBookImage;
    }


}
