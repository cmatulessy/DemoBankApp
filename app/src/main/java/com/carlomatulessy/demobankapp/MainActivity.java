package com.carlomatulessy.demobankapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private ListView mutationList;
    public static TextView accountAmount;
    private MutationListAdapter mlAdapt;

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

        mlAdapt = new MutationListAdapter(this, R.layout.dashboard_mutationlist, DataBuilder.getAccounts());
        mutationList.setAdapter(mlAdapt);

        mutationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showAccountDetails(position);
            }
        });
    }

    private void showAccountDetails(int position) {
        final Account selectedAccount = DataBuilder.getAccounts().get(position);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Mutation info");
        alertDialogBuilder
                .setMessage(selectedAccount.getName() + " - " + "€ "+ String.format("%.2f",selectedAccount.getAmount()))
                .setCancelable(false)
                .setPositiveButton("Transfer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        transferDialogTransfer();
                    }
                })
                .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        transferDialogDelete(selectedAccount);
                    }
                });

        AlertDialog transferDialog = alertDialogBuilder.create();
        transferDialog.show();
    }

    private void transferDialogTransfer() {

    }

    private void transferDialogDelete(Account accountDelete) {
        for(Iterator<Account> iteratorAccounts = DataBuilder.getAccounts().iterator(); iteratorAccounts.hasNext(); ) {
            Account account = iteratorAccounts.next();
            if (account.getName() == accountDelete.getName() && account.getAmount() == accountDelete.getAmount() && account.getIban() == accountDelete.getIban()) {
                iteratorAccounts.remove();
                break;
            }
        }

        mlAdapt.notifyDataSetChanged();
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
