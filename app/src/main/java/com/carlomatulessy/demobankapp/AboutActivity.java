package com.carlomatulessy.demobankapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setTitle(getResources().getString(R.string.about_title));
    }

    public void openTestNet(View view) {
        goToWebsite(getResources().getString(R.string.url_testnet));
    }

    public void openGithub(View view) {
        goToWebsite(getResources().getString(R.string.url_github));
    }

    public void openCarloMatulessy(View view) {
        goToWebsite(getResources().getString(R.string.url_carlo));
    }

    public void openCapgemini(View view) {
        goToWebsite(getResources().getString(R.string.url_capgemini));
    }

    private void goToWebsite(String url) {
        Intent openWebbrowser = new Intent(Intent.ACTION_VIEW);
        openWebbrowser.setData(Uri.parse(url));
        startActivity(openWebbrowser);
    }
}
