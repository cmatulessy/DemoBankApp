package com.carlomatulessy.demobankapp.cucumber.gluecode;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitor;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.util.Log;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by CarloMatulessy on 10/04/2017.
 */

public final class ActivityFinisher implements Runnable {

    private final ActivityLifecycleMonitor activityLifecycleMonitor;

    private ActivityFinisher() {
        this.activityLifecycleMonitor = ActivityLifecycleMonitorRegistry.getInstance();
    }

    public static void finishOpenActivities() {
        new Handler(Looper.getMainLooper()).post(new ActivityFinisher());
    }

    @Override
    public void run() {
        final List<Activity> activities = new ArrayList<>();

        for (final Stage stage : EnumSet.range(Stage.CREATED, Stage.STOPPED)) {
            activities.addAll(activityLifecycleMonitor.getActivitiesInStage(stage));
        }

        for (final Activity activity : activities) {
            Log.d("Mob", activity.toString());
            Log.d("Mob", activity.toString());
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
