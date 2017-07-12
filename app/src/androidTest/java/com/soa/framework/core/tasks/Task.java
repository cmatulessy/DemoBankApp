package com.soa.framework.core.tasks;

import com.soa.framework.core.interactions.Interaction;

/**
 * Created by Carlo Matulessy on 11-7-17.
 */
 public class Task {
    String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void attemptsTo(Interaction interaction) {

    }
}
