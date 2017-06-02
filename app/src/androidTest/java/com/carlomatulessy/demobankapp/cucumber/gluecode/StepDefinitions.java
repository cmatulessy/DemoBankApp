package com.carlomatulessy.demobankapp.cucumber.gluecode;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;

import com.carlomatulessy.demobankapp.DataBuilder;
import com.carlomatulessy.demobankapp.MainActivity;
import com.carlomatulessy.demobankapp.R;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by CarloMatulessy on 01/08/16.
 */
public class StepDefinitions extends ActivityInstrumentationTestCase2<MainActivity> {

    private Activity currentActivity;

    public StepDefinitions() {
        super(MainActivity.class);
    }


