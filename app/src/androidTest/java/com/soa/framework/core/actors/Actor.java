package com.soa.framework.core.actors;

import com.soa.framework.core.tasks.Task;

/**
 * Created by Carlo Matulessy on 5-7-17.
 */

public class Actor extends Task{

    private String name;
    private String iban;

    public Actor(String name, String iban) {
        setName(name);
        setIban(iban);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setIban(String iban) { this.iban = iban; }

    public String getName() {
        return this.name;
    }

    public String getIban() { return this.iban; }
}
