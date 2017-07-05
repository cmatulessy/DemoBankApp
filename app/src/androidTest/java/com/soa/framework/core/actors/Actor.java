package com.soa.framework.core.actors;

/**
 * Created by Carlo Matulessy on 5-7-17.
 */

public class Actor {

    private String name;

    public Actor(String name) {
        setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
