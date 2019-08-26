package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private WebView mWebView;
    private Button mLaunchBrowser;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
                progressDialog.cancel();
            }
        };

        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 9000);

        mWebView = findViewById(R.id.webView);

//        getProgressDialog();



        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("https://starthub.com.ng");

    }
}

//        mLaunchBrowser = findViewById(R.id.Launch_Button);
//
//        mLaunchBrowser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mWebView = findViewById(R.id.webView);
//
//                WebSettings webSettings = mWebView.getSettings();
//                webSettings.setJavaScriptEnabled(true);
//                mWebView.loadUrl("https://starthub.com.ng");
//                mLaunchBrowser.setVisibility(View.INVISIBLE);
//            }
//        });
//    }
//
//    public ProgressDialog getProgressDialog() {
//        progressDialog = new ProgressDialog(MainActivity.this);
//        progressDialog.setMessage("Loading...");
//        progressDialog.show();
//        return progressDialog;


