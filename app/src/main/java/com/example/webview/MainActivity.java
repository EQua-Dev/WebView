package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
//        we ensure that the JS functionality in the website are also applied in the app
        webSettings.setJavaScriptEnabled(true);
//        the website to be loaded is input here
        mWebView.loadUrl("https://starthub.com.ng");
//        we ensure that web pages clicked on the website does not  open in a phone browser
        mWebView.setWebViewClient(new WebViewClient());

    }

//    we override this method to ensure that the app is not closed when the back button is pressed
    @Override
    public void onBackPressed() {
//        if the website can go back (ie; has a previous page)
        if (mWebView.canGoBack()){
//            the app goes back to the previous web page
            mWebView.goBack();
        }else {
//            else the app is closed
            super.onBackPressed();
        }
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


