package com.carlomatulessy.demobankapp.cucumber.gluecode;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.test.ActivityInstrumentationTestCase2;

import com.carlomatulessy.demobankapp.MainActivity;
import com.carlomatulessy.demobankapp.cucumber.resources.ResourceManager;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by CarloMatulessy on 01/08/16.
 */
public class StepDefinitions extends ActivityInstrumentationTestCase2<MainActivity> {

    final String featureTitle = "Feature Payments";
    final String scenarioTitle = "Scenario Outline As a user I want to make a payment";

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
    public void iTapOnButton(String resourceObjectKey) throws Throwable {
        onView(withId(ResourceManager.getResourceManager().getResourceIdFromUIElement(resourceObjectKey.toLowerCase()))).perform(click());
    }

    @And("^I see the screen \"([^\"]*)\"$")
    public void iSeeTheScreen(String screenName) throws Throwable {
        //Spoon.screenshot(getActivity(), screenTitle, featureTitle, scenarioTitle);

        for(int id : ResourceManager.getResourceManager().getResourceIdsFromScreen(screenName.toLowerCase())) {
            onView(withId(id)).check(matches(isDisplayed()));
        }
    }

    @And("^I enter \"([^\"]*)\" in the \"([^\"]*)\" field$")
    public void iEnterInTheField(String value, String resourceObjectKey) throws Throwable {
        onView(withId(ResourceManager.getResourceManager().getResourceIdFromUIElement(resourceObjectKey.toLowerCase()))).perform(typeText(value));
        Espresso.closeSoftKeyboard();
    }

    @Then("^my test has passed$")
    public void myTestHasPassed() throws Throwable {
        assertTrue(true);
    }
}
