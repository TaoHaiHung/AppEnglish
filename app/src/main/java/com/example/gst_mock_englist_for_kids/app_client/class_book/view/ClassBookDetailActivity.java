package com.example.gst_mock_englist_for_kids.app_client.class_book.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.gst_mock_englist_for_kids.R;
import com.github.barteksc.pdfviewer.PDFView;

public class ClassBookDetailActivity extends AppCompatActivity {

    private PDFView mEBookPdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_book_detail);

        initView();
        Intent intent = getIntent();

        if (intent != null) {
            String itemPDF = intent.getStringExtra("pdf");


            if (itemPDF.equalsIgnoreCase("Family and Friend 1")) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEBookPdf.fromAsset("e_books/class_book/family_and_friends_1.pdf").load();
                    }
                });
            }

            if (itemPDF.equalsIgnoreCase("Family and Friend 2")) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEBookPdf.fromAsset("e_books/class_book/family_and_friends_2.pdf").load();
                    }
                });
            }

            if (itemPDF.equalsIgnoreCase("Family and Friend 3")) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEBookPdf.fromAsset("e_books/class_book/family_and_friends_3.pdf").load();
                    }
                });
            }

            if (itemPDF.equalsIgnoreCase("Family and Friend 4")) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEBookPdf.fromAsset("e_books/class_book/family_and_friends_4.pdf").load();
                    }
                });
            }

            if (itemPDF.equalsIgnoreCase("Family and Friend 5")) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEBookPdf.fromAsset("e_books/class_book/family_and_friends_5.pdf").load();
                    }
                });
            }

            if (itemPDF.equalsIgnoreCase("Family and Friend 6")) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mEBookPdf.fromAsset("e_books/class_book/family_and_friends_6.pdf").load();
                    }
                });
            }

        }
    }
    private void initView() {
        mEBookPdf = findViewById(R.id.pdfView);
    }
}

