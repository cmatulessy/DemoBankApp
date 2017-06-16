package com.carlomatulessy.demobankapp.cucumber.gluecode;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.test.ActivityInstrumentationTestCase2;

import com.carlomatulessy.demobankapp.DataBuilder;
import com.carlomatulessy.demobankapp.MainActivity;
import com.carlomatulessy.demobankapp.R;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by CarloMatulessy on 01/08/16.
 */
public class StepDefinitions extends ActivityInstrumentationTestCase2<MainActivity> {

    public StepDefinitions() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();

        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        assertNotNull(getActivity());
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Given("^the user ([^\"]*)$")
    public void theUserRecipientBankName(String name) throws Throwable {
        Espresso.onView(allOf(withId(R.id.payment_button), withText("Transfer"))).perform(click());
        Espresso.onView(withId(R.id.transfer_beneficiary_edittext)).perform(typeText(name));

    }

    @When("^I create a payment with ([^\"]*)$")
    public void iCreateAPaymentWithAmount(String paymentAmount ) throws Throwable {
        Espresso.onView(allOf(withId(R.id.payment_button), withText(""))).perform(click());
        Espresso.onView(withId(R.id.transfer_beneficiary_edittext)).perform(typeText(paymentAmount));
    }

    @Then("^the customer is charged with ([^\"]*)$")
    public void theCustomerIsChargedWithFee(String fee) throws Throwable {
        Espresso.onView(allOf(withId(R.id.payment_button), withText(""))).perform(click());
        Espresso.onView(withId(R.id.transfer_beneficiary_edittext)).perform(typeText(fee));

    }

}