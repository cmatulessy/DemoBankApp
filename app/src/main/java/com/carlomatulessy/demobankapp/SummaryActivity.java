package com.carlomatulessy.demobankapp;

import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        getSupportActionBar().setTitle("Transfer");
        getSupportActionBar().setSubtitle("Summary");

        TextView accountName = (TextView) findViewById(R.id.account_name);
        TextView accountIban = (TextView) findViewById(R.id.account_iban);
        TextView accountAmount = (TextView) findViewById(R.id.account_amount);
        ImageView accountIcon = (ImageView) findViewById(R.id.account_icon);

        accountName.setText(DataBuilder.getUser().getName());
        accountIban.setText(DataBuilder.getUser().getIban());
        accountAmount.setText( "€ "+ String.format("%.2f",DataBuilder.getUser().getAmount()));

        Drawable userIcon = ResourcesCompat.getDrawable(getResources(), R.drawable.carlo, null);
        accountIcon.setImageDrawable(userIcon);

        TextView inputAccountName = (TextView) findViewById(R.id.summary_accountName);
        TextView inputAccountIban = (TextView) findViewById(R.id.summary_accountIban);
        TextView inputAccountAmount = (TextView) findViewById(R.id.summary_accountAmount);

        inputAccountName.setText(DataBuilder.getInputAccount().getName());
        inputAccountIban.setText(DataBuilder.getInputAccount().getIban());
        inputAccountAmount.setText("- € "+ String.format("%.2f",DataBuilder.getInputAccount().getAmount()));

    }

    public void doPayment(View view) {
        DataBuilder.addNewMutationToDashboardList(DataBuilder.getInputAccount());
        DataBuilder.updateUserAmount();
        DataBuilder.recreateDashboard = true;
        finish();
    }
}
