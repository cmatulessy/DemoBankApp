package com.carlomatulessy.demobankapp.cucumber.spoon;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.espresso.core.deps.guava.collect.Iterables;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.test.InstrumentationTestCase;
import android.util.Log;

/**
 * Created by CarloMatulessy on 27/01/2017.
 */

public class BaseTestCase {

    private Instrumentation instrumentation;
    private InstrumentationTestCase instrumentationTestCase;

    public BaseTestCase(InstrumentationTestCase testClass, Instrumentation instrumentation){
        this.instrumentationTestCase = testClass;
        this.instrumentation = instrumentation;
    }

    public Activity getCurrentActivity() {
        instrumentation.waitForIdleSync();
        final Activity[] activity = new Activity[1];

        try {
            instrumentationTestCase.runTestOnUiThread(new Runnable() {
                @Override
                public void run() {
                    java.util.Collection<Activity> activites = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                    activity[0] = Iterables.getOnlyElement(activites);
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        Log.d("[Current activity]", activity[0].toString());
        return activity[0];
    }
}
