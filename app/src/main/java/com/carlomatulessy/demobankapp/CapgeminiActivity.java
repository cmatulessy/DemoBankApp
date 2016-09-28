package com.carlomatulessy.demobankapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class CapgeminiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capgemini);

        getSupportActionBar().setTitle(getResources().getString(R.string.capgemini_title));

        WebView webView = (WebView) findViewById(R.id.capgemini_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.nl.capgemini.com/carriere");
    }
}
