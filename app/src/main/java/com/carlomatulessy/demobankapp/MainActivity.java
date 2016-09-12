package com.carlomatulessy.demobankapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView mutationList;
    public static TextView accountAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Espresso Bank");

        //Button transferBtn = (Button) findViewById(R.id.payment_button);
        mutationList = (ListView) findViewById(R.id.mutation_list);

        if(DataBuilder.freshStart) {
            DataBuilder.freshStart = false;
            DataBuilder.createAccounts();
            DataBuilder.createUser();
        }

        TextView accountName = (TextView) findViewById(R.id.account_name);
        TextView accountIban = (TextView) findViewById(R.id.account_iban);
        accountAmount = (TextView) findViewById(R.id.account_amount);
        ImageView accountIcon = (ImageView) findViewById(R.id.account_icon);

        accountName.setText(DataBuilder.getUser().getName());
        accountIban.setText(DataBuilder.getUser().getIban());
        accountAmount.setText( "€ "+ String.format("%.2f",DataBuilder.getUser().getAmount()));

        Drawable userIcon = ResourcesCompat.getDrawable(getResources(), R.drawable.carlo, null);
        accountIcon.setImageDrawable(userIcon);
        
        mutationList.setAdapter(new MutationListAdapter(this, R.layout.dashboard_mutationlist, DataBuilder.getAccounts()));
    }

    public void startTransfer(View view) {
        Intent intent = new Intent(this, TransferActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();

        if(DataBuilder.recreateDashboard) {
            DataBuilder.recreateDashboard = false;
            super.recreate();
        }
    }
}
