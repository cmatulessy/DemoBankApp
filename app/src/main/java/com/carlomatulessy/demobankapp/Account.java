package com.carlomatulessy.demobankapp;

/**
 * Created by CarloMatulessy on 31/07/16.
 */
public class Account {

    private String name;
    private String iban;
    private int amount;
    private boolean gender;

    private String acceptgiro;
    private String paymentDescription;

    public String getAcceptgiro() {
        return acceptgiro;
    }

    public void setAcceptgiro(String acceptgiro) {
        this.acceptgiro = acceptgiro;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
