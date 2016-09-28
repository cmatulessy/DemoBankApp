package com.carlomatulessy.demobankapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_reset :
                resetTransferData();
                break;
        }

        return true;
    }

    @Override
    public void onResume() {
        super.onResume();

        if(DataBuilder.recreateDashboard) {
            DataBuilder.recreateDashboard = false;
            super.recreate();
        }
    }

    private void resetTransferData() {
        DataBuilder.resetTestData();
        mlAdapt.notifyDataSetChanged();
    }

    private void showAccountDetails(int position) {
        final Account selectedAccount = DataBuilder.getAccounts().get(position);

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_mutation_info);

        TextView accountName = (TextView) dialog.findViewById(R.id.mutation_account_name);
        TextView accountIban = (TextView) dialog.findViewById(R.id.mutation_account_iban);
        TextView accountAmount = (TextView) dialog.findViewById(R.id.mutation_account_amount);

        Button mutationDeleteButton = (Button) dialog.findViewById(R.id.mutation_delete_button);
        Button mutationTransferButton = (Button) dialog.findViewById(R.id.mutation_transfer_button);

        accountName.setText(selectedAccount.getName());
        accountIban.setText(selectedAccount.getIban());
        accountAmount.setText( "- € "+ String.format("%.2f",selectedAccount.getAmount()));

        mutationDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferDialogDelete(selectedAccount);
                dialog.dismiss();
            }
        });

        mutationTransferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                transferDialogNewTransfer(selectedAccount);
            }
        });

        dialog.show();

    }

    private void transferDialogNewTransfer(Account selectedAccount) {
        TransferActivity.selectedAccount = selectedAccount;
        Intent intent = new Intent(this, TransferActivity.class);
        startActivity(intent);
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


}
