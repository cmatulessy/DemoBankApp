package com.carlomatulessy.demobankapp.cucumber.gluecode;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;

import com.carlomatulessy.demobankapp.MainActivity;

import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by CarloMatulessy on 01/08/16.
 */
public class StepDefinitions extends ActivityInstrumentationTestCase2<MainActivity> {

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
}
