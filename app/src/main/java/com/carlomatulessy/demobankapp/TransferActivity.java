package com.carlomatulessy.demobankapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TransferActivity extends AppCompatActivity {

    EditText inputAmount, inputBeneficiary, inputIban, inputAcceptGiro, inputPaymentDescription;
    public static Account selectedAccount = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        getSupportActionBar().setTitle("Transfer");
        getSupportActionBar().setSubtitle("Make a payment");

        TextView accountName = (TextView) findViewById(R.id.account_name);
        TextView accountIban = (TextView) findViewById(R.id.account_iban);
        TextView accountAmount = (TextView) findViewById(R.id.account_amount);
        ImageView accountIcon = (ImageView) findViewById(R.id.account_icon);

        accountName.setText(DataBuilder.getUser().getName());
        accountIban.setText(DataBuilder.getUser().getIban());
        accountAmount.setText( "€ "+ String.format("%.2f", DataBuilder.getUser().getAmount()));


        Drawable userIcon = ResourcesCompat.getDrawable(getResources(), R.drawable.carlo, null);
        accountIcon.setImageDrawable(userIcon);

        inputAmount = (EditText) findViewById(R.id.transfer_amount_edittext);
        inputBeneficiary = (EditText) findViewById(R.id.transfer_beneficiary_edittext);
        inputIban = (EditText) findViewById(R.id.transfer_accountnumber_edittext);
        inputAcceptGiro = (EditText) findViewById(R.id.transfer_acceptgiro_edittext);
        inputPaymentDescription = (EditText) findViewById(R.id.transfer_paymentdescription_edittext);

        if(selectedAccount != null) {
            inputBeneficiary.setText(selectedAccount.getName());
            inputIban.setText(selectedAccount.getIban());
        }

    }

    public void goToSummaryScreen(View view) {
        try {
            Account account = new Account();
            account.setGender(true);
            account.setAmount(Double.parseDouble(inputAmount.getText().toString()));
            account.setName(inputBeneficiary.getText().toString());
            account.setIban(inputIban.getText().toString());
            account.setAcceptgiro(inputAcceptGiro.getText().toString());
            account.setPaymentDescription(inputPaymentDescription.getText().toString());

            DataBuilder.saveInputAccount(account);

            Intent summaryIntent = new Intent(this, SummaryActivity.class);
            startActivity(summaryIntent);
            finish();
        } catch (Exception ex) {
            Toast toast = Toast.makeText(this, "Please fill in all fields before proceeding...", Toast.LENGTH_SHORT);
            toast.show();

            ex.printStackTrace();
        }
    }
}
