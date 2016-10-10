package com.carlomatulessy.demobankapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CarloMatulessy on 31/07/16.
 */
public class MutationListAdapter extends ArrayAdapter {

    private final Context context;
    private List<Account> accounts;

    public MutationListAdapter(Context context, int textViewResourceId, List<Account> accounts) {
        super(context, textViewResourceId, accounts);

        this.context = context;
        this.accounts = accounts;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.dashboard_mutationlist, parent, false);
        ImageView accountIcon = (ImageView) rowView.findViewById(R.id.account_icon);
        TextView accountName = (TextView) rowView.findViewById(R.id.account_name);
        TextView accountIban = (TextView) rowView.findViewById(R.id.account_iban);
        TextView accountAmount = (TextView) rowView.findViewById(R.id.account_amount);

        Drawable iconDrawable;
        if(accounts.get(position).getGender()) {
            iconDrawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.signup_female, null);
        } else {
            iconDrawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.signup_male, null);
        }

        accountIcon.setImageDrawable(iconDrawable);

        accountName.setText(accounts.get(position).getName());
        accountIban.setText(accounts.get(position).getIban());
        accountAmount.setText("- € "+ String.format("%.2f",accounts.get(position).getAmount()));

        return rowView;

    }
}
