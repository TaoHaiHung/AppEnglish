package com.example.gst_mock_englist_for_kids.app_client.work_book.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.gst_mock_englist_for_kids.R;
import com.github.barteksc.pdfviewer.PDFView;

public class WorkBookDetailActivity extends AppCompatActivity {
private PDFView mEBookPdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_book_detail);


        initView();
        Intent intent = getIntent();

        if (intent != null) {
            String itemPDFWorkBook = intent.getStringExtra("work book");


            if (itemPDFWorkBook.equalsIgnoreCase("Family and Friend 1")) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEBookPdf.fromAsset("e_books/work_book/family_and_friend_1.pdf").load();
                    }
                });
            }

            if (itemPDFWorkBook.equalsIgnoreCase("Family and Friend 2")) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEBookPdf.fromAsset("e_books/work_book/family_and_friend_2.pdf").load();
                    }
                });
            }

            if (itemPDFWorkBook.equalsIgnoreCase("Family and Friend 3")) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEBookPdf.fromAsset("e_books/work_book/family_and_friend_3.pdf").load();
                    }
                });
            }

            if (itemPDFWorkBook.equalsIgnoreCase("Family and Friend 4")) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEBookPdf.fromAsset("e_books/work_book/family_and_friend_4.pdf").load();
                    }
                });
            }

            if (itemPDFWorkBook.equalsIgnoreCase("Family and Friend 5")) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEBookPdf.fromAsset("e_books/work_book/family_and_friend_5.pdf").load();
                    }
                });
            }

            if (itemPDFWorkBook.equalsIgnoreCase("Family and Friend 6")) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEBookPdf.fromAsset("e_books/work_book/family_and_friend_6.pdf").load();
                    }
                });
            }
        }
    }

    private void initView() {
        mEBookPdf = findViewById(R.id.pdfViewWB);

    }
}
