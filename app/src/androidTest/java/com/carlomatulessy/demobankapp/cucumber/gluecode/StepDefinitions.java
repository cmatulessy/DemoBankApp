package com.carlomatulessy.demobankapp.cucumber.gluecode;

import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;

import com.carlomatulessy.demobankapp.MainActivity;
import com.carlomatulessy.demobankapp.R;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by CarloMatulessy on 01/08/16.
 */
public class StepDefinitions extends ActivityInstrumentationTestCase2<MainActivity> {

    final int ID_PAYMENT_BUTTON = R.id.payment_button;
    final int ID_NEXT_BUTTON = R.id.payment_button;
    final String PAYMENT_BUTTON = "transfer";
    final String NEXT_BUTTON = "next";

    public StepDefinitions() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();

        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        getActivity();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Given("^I am on the dashboard$")
    public void iAmOnTheDashboard() throws Throwable {
        assertNotNull(getActivity());
    }

    @When("^I tap on button \"([^\"]*)\"$")
    public void iTapOnButton(String buttonName) throws Throwable {

        int buttonId;
        switch(buttonName) {
            case PAYMENT_BUTTON :
                buttonId = ID_PAYMENT_BUTTON;
                break;
            case NEXT_BUTTON :
                buttonId = ID_NEXT_BUTTON;
                break;
            default:
                buttonId = ID_PAYMENT_BUTTON;
        }


        onView(withId(buttonId)).perform(click());

    }

    @And("^I see the screen \"([^\"]*)\"$")
    public void iSeeTheScreen(String screenTitle) throws Throwable {

    }

    @And("^I enter \"([^\"]*)\" in the \"([^\"]*)\" field$")
    public void iEnterInTheField(String value, String editTextName) throws Throwable {

    }

    @Then("^my test has passed$")
    public void myTestHasPassed() throws Throwable {
        assertTrue(true);
    }
}
