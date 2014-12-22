package com.devro.christmas.creator;

import java.util.HashMap;

/**
 * Programmed by DevRo_ on 22/12/14.
 */
public class ChristmasCreator {

    private static ChristmasCreator instance;

    private HashMap<Class<?>, ChristmasSpawner> spawnerHashMap = new HashMap<>();

    public static ChristmasCreator getInstance() {
        if (instance == null) {
            instance = new ChristmasCreator();
        }

        return instance;
    }

    public void start() {
        //TODO iterate through all ChristmasSpawners and load it up if the one before it has finished.
    }

    public void registerPhase(ChristmasSpawner spawner) {
        if (spawnerHashMap.containsKey(spawner.getClass())) {
            return;
        }

        spawnerHashMap.put(spawner.getClass(), spawner);
    }

    public <T extends ChristmasSpawner> T getSpawner(Class<T> clazz) {
        return (T) spawnerHashMap.get(clazz);
    }
}
