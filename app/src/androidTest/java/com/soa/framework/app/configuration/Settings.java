package com.soa.framework.app.configuration;

import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;

import com.carlomatulessy.demobankapp.MainActivity;

import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by Carlo Matulessy on 5-7-17.
 */

public class Settings extends ActivityInstrumentationTestCase2<MainActivity> {

    public Settings() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();

        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

}
