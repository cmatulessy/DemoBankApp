package com.soa.framework.core.actors;

import java.util.HashMap;

/**
 * Created by Carlo Matulessy on 5-7-17.
 */

public class ActorManager {

    private static ActorManager instance = null;

    private HashMap<String, Actor> actorsList;

    private ActorManager() {
        ActorsLoader actorsLoader = new ActorsLoader();
        actorsList = actorsLoader.getAllActors();
    }

    public static ActorManager getInstance() {
        if(instance == null) {
            instance = new ActorManager();
        }

        return instance;
    }

    public Actor getSelectedActorByName(String name) {
        return actorsList.get(name);
    }
}
