package com.carlomatulessy.demobankapp.cucumber.gluecode;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.test.ActivityInstrumentationTestCase2;

import com.carlomatulessy.demobankapp.MainActivity;
import com.carlomatulessy.demobankapp.R;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

/**
 * Created by CarloMatulessy on 01/08/16.
 */
public class StepDefinitions extends ActivityInstrumentationTestCase2<MainActivity> {

    final int ID_PAYMENT_BUTTON = R.id.payment_button;
    final int ID_MUTATION_TRANSFER_BUTTON = R.id.mutation_transfer_button;
    final int ID_NEXT_BUTTON = R.id.payment_button;
    final int ID_AMOUNT_FIELD = R.id.transfer_amount_edittext;
    final int ID_BENEFICIARY_FIELD = R.id.transfer_beneficiary_edittext;
    final int ID_ACCOUNTNUMBER_FIELD = R.id.transfer_accountnumber_edittext;

    final int[] SCREEN_TRANSFER = {
            R.id.transfer_acceptgiro_edittext,
            R.id.transfer_accountnumber_edittext,
            R.id.transfer_amount_edittext,
            R.id.transfer_beneficiary_edittext,
            R.id.transfer_paymentdescription_edittext,
            R.id.payment_button
    };
    final int[] SCREEN_SUMMARY = {
            R.id.summary_accountAmount,
            R.id.summary_accountIban,
            R.id.summary_accountIcon,
            R.id.summary_accountName,
            R.id.summary_paymentToHeader,
            R.id.payment_button
    };
    final int[] SCREEN_DASHBOARD = {
            R.id.mutation_list
    };


    final String PAYMENT_BUTTON = "transfer";
    final String MUTATION_TRANSFER_BUTTON = "transfer in mutation info";
    final String NEXT_BUTTON = "next";
    final String AMOUNT_FIELD = "amount";
    final String BENEFICIARY_FIELD = "beneficiary";
    final String ACCOUNTNUMBER_FIELD = "accountnumber";

    final String featureTitle = "Feature Payments";
    final String scenarioTitle = "Scenario Outline As a user I want to make a payment";

    private Activity currentActivity;

    public StepDefinitions() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();

        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        getActivity();
        assertNotNull(getActivity());
        currentActivity = getActivity();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @When("^I tap on button (transfer|next|transfer in mutation info)$")
    public void iTapOnButton(String buttonName) throws Throwable {

        int buttonId = 0;
        switch(buttonName.toLowerCase()) {
            case PAYMENT_BUTTON :
                buttonId = ID_PAYMENT_BUTTON;
                break;
            case NEXT_BUTTON :
                buttonId = ID_NEXT_BUTTON;
                break;
            case MUTATION_TRANSFER_BUTTON :
                buttonId = ID_MUTATION_TRANSFER_BUTTON;
                break;
            default:
                buttonId = ID_PAYMENT_BUTTON;
                break;
        }

        onView(withId(buttonId)).perform(click());

    }

    @And("^I enter ([^\"]*) in the (amount|beneficiary|accountnumber) field$")
    public void iEnterInTheField(String value, String editTextName) throws Throwable {
        int editTextId;
        switch (editTextName) {
            case AMOUNT_FIELD :
                editTextId = ID_AMOUNT_FIELD;
                break;
            case BENEFICIARY_FIELD :
                editTextId = ID_BENEFICIARY_FIELD;
                break;
            case ACCOUNTNUMBER_FIELD :
                editTextId = ID_ACCOUNTNUMBER_FIELD;
                break;
            default:
                editTextId = ID_AMOUNT_FIELD;
                break;
        }

        onView(withId(editTextId)).perform(typeText(value));

        Espresso.closeSoftKeyboard();
    }

    @Given("^I tap on the first mutation item$")
    public void iTapOnMutationEvelien() throws Throwable {
        onData(anything()).inAdapterView(withId(R.id.mutation_list)).atPosition(0).perform(click());
    }
}
