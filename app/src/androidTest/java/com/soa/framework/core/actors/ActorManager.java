package com.soa.framework.core.actors;

/**
 * Created by Carlo Matulessy on 5-7-17.
 */

public class ActorManager {

    private static ActorManager instance = null;

    private ActorManager() {

    }

    public static ActorManager getInstance() {
        if(instance == null) {
            instance = new ActorManager();
        }

        return instance;
    }
}
