package com.example.gst_mock_englist_for_kids.app_client.classone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.gst_mock_englist_for_kids.R;

public class SGKActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_g_k);

        Intent intent = getIntent();
        String url = intent.getStringExtra("SGK1");
        String url2 = intent.getStringExtra("SGK2");
        String url3 = intent.getStringExtra("SGK3");
        String url4 = intent.getStringExtra("SGK4");
        String url5 = intent.getStringExtra("SGK5");

        if (url != null && url.equalsIgnoreCase("https://drive.google.com/file/d/13BFVyYi1NYRUfOwDMWQQ-Nsj_esBKwRG/view")) {
            loaderData(url);
        }
        if (url2 != null && url2.equalsIgnoreCase("https://drive.google.com/file/d/1ABzUgjJZnwVsO7qZfurnLVR6ZbiCU828/view")) {
            loaderData(url2);
        }
        if (url3 != null && url3.equalsIgnoreCase("https://drive.google.com/file/d/1aKUZPLCrltwy3AOstnQFkYqudJRD7LSY/view")) {
            loaderData(url3);
        }
        if (url4 != null && url4.equalsIgnoreCase("https://drive.google.com/file/d/1d1sVJxxBiSl0mqHsPBSdyxzHbhUEUNKQ/view")) {
            loaderData(url4);
        }
        if (url5 != null && url5.equalsIgnoreCase("https://drive.google.com/file/d/1K_3vFxQCeB3E-KKiZ7DV7YcHlS3_EWkj/view?usp=sharing")) {
            loaderData(url5);
        }

    }

    private void loaderData(String url) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.setCancelable(false);
        WebView web_view = findViewById(R.id.wvLoader);
        web_view.requestFocus();
        web_view.getSettings().setJavaScriptEnabled(true);
//        String myPdfUrl = "gymnasium-wandlitz.de/vplan/vplan.pdf";
//        String url = "https://docs.google.com/viewer?embedded = true&url = "+myPdfUrl;
        web_view.loadUrl(url);
        web_view.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        web_view.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100) {
                    progressDialog.show();
                }
                if (progress == 100) {
                    progressDialog.dismiss();
                }
            }
        });
    }
}