package com.devro.christmas.creator;

import org.bukkit.Location;

/**
 * Programmed by DevRo_ on 22/12/14.
 */
public abstract class ChristmasSpawner {

    private String name;
    private int phase;

    public ChristmasSpawner(String name, int phase) {
        this.name = name;
        this.phase = phase;
    }

    public abstract void spawn(Location location);

    public String getName() {
        return name;
    }

    public int getPhase() {
        return phase;
    }
}
